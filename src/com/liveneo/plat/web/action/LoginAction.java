package com.liveneo.plat.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.lm.utils.Base64Encode;
import com.liveneo.plat.hibernate.dao.BdRolemenu;
import com.liveneo.plat.hibernate.dao.BdUserinforole;
import com.liveneo.plat.hibernate.dao.Menuinfo;
import com.liveneo.plat.hibernate.dao.MgrTemplet;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.Workorder;
import com.liveneo.plat.service.impl.MenuinfoService;
import com.liveneo.plat.service.impl.RoleService;
import com.liveneo.plat.service.impl.UserinfoService;
import com.liveneo.plat.service.impl.WorkOrderService;
import com.liveneo.plat.service.impl.mgr.MgrService;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.SubtotalsForm;
import com.liveneo.plat.web.form.UserinfoForm;

public class LoginAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	//bean
	private UserinfoForm userinfoForm;
	private SubtotalsForm subtotalsForm;
	private Userinfo userinfo;
	//service
	private UserinfoService userinfoService;
	private MenuinfoService menuinfoService;
	private WorkOrderService workOrderService;
	private RoleService roleService;
	private MgrService mgrService;

	public String execute() {
		return SUCCESS;
	}

	public String login() {
		if(null != userinfoForm){
		}else{
			return "failed";
		}
		HttpSession se = this.getSession();
		HttpServletRequest req = this.getRequest();
		String msg = "";
		String longinname = userinfoForm.getUsername();
		String password = userinfoForm.getUserpwd();
		if (null == userinfoForm) {
			msg = "login.inputUserAndPwd";
			req.setAttribute("msg", msg);
			log.info("empty");
			return "failed";
		}
		if (StringUtils.isEmpty(longinname)) {
			msg = getText("login.userNotEmpty");
			req.setAttribute("msg", msg);
			log.info("username empty");
			return "failed";
		}
		if (StringUtils.isEmpty(password)) {
			msg = getText("login.pwdNotEmpty");
			req.setAttribute("msg", msg);
			log.info("password empty");
			return "failed";
		}
		Userinfo userinfoResult = new Userinfo();
		userinfoResult = this.userinfoService.queryuserinfoIndex(Userinfo.PROP_USERNAME,StringUtils.trim(longinname));
		if (userinfoResult == null) {
			msg = getText("login.nouser");
			req.setAttribute("msg", msg);
			log.info("NO USER");
			return "failed";
		}
		if (!StringUtils.equals(userinfoResult.getUserstatus(), "Y")) {
			msg = getText("该用户不可用！");
			req.setAttribute("msg", msg);
			log.info("USER DISABLE");
			return "failed";
		}
		Base64Encode base64 = new Base64Encode();
		if (!StringUtils.equals(base64.encode(password), userinfoResult
				.getUserpwd())) {
			msg = getText("login.pwderror");
			req.setAttribute("msg", msg);
			log.info("password error");
			return "failed";
		}
		userinfo = userinfoResult;
		//User  info
		se.setAttribute("userinfo", userinfo);
		//menu info
		String str = this.createHtmlMenu(userinfo);
		se.setAttribute("menu", str);
		// 首页统计数据
		this.listWorkorder(userinfo);
		this.getSubtotals();
		//软dianhua参数
		se.setAttribute("workNo", userinfo.getAgentno());
		se.setAttribute("ipaddr", userinfo.getCtiaddr());
		se.setAttribute("exten", userinfo.getExtno());
		se.setAttribute("skill", userinfo.getTemp2());
		//初始化呼入呼出弹屏
		se = this.initInOrOutBound(se);
		this.logService(getRequest()).addLog(this.getRequest(), "LOGTYPE-DL",
				"login", Userinfo.REF);
		return SUCCESS;
	}
	
	//初始化呼入呼出弹屏
	public HttpSession initInOrOutBound(HttpSession se){
		String inbound_tp = "N";
		String outbound_tp = "N";
		List<MgrTemplet> in = this.mgrService.findMgrTempletByMgrTempletCode("wo_inbound");
		if(null!=in&&in.size()>0){
			MgrTemplet m = in.get(0);
			if(StringUtils.equalsIgnoreCase(m.getTmpStatus(), "Y")){
				inbound_tp = "Y";
			}
		}
		List<MgrTemplet> out = this.mgrService.findMgrTempletByMgrTempletCode("wo_outbound");
		if(null!=out&&out.size()>0){
			MgrTemplet m = out.get(0);
			if(StringUtils.equalsIgnoreCase(m.getTmpStatus(), "Y")){
				outbound_tp = "Y";
			}
		}
		se.setAttribute("inbound_tp", inbound_tp);
		se.setAttribute("outbound_tp", outbound_tp);
		return se;
	}
	
	//ip address
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	// 首页统计数据
	private void listWorkorder(Userinfo user) {
		List<Workorder> l = this.workOrderService
				.queryWoByDetachedCriteria(this.getDetachedCriteria(user));
		this.getSession().setAttribute("workorderIndexList", l);
	}

	private DetachedCriteria getDetachedCriteria(Userinfo user) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
//		detachedCriteria.add(Restrictions.or(Restrictions.eq(
//				Workorder.PROP_WOSTATUS, "wcl"), Restrictions.or(Restrictions
//				.eq(Workorder.PROP_WOSTATUS, "dhxcl"), Restrictions.eq(
//				Workorder.PROP_WOSTATUS, "ywc"))));
		detachedCriteria.add(Restrictions.or(Restrictions.eq(
				Workorder.PROP_WOSTATUS, "dhxcl"), Restrictions.eq(
				Workorder.PROP_WOSTATUS, "ywc")));
		if (!StringUtils.equals(user.getIsadmin(), "true")) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO,
					user));
		}
		return detachedCriteria;
	}

	public List<Menuinfo> listUserMenu(Userinfo user) {
		Set<Menuinfo> setlist = new HashSet<Menuinfo>();
		List<Menuinfo> listmenu = new ArrayList<Menuinfo>();
		if (StringUtils.equals(user.getIsadmin(), "true")) {
			listmenu = this.menuinfoService.queryAll();
		}
		List<BdUserinforole> listUserrole = this.roleService
				.queryUserinforoleByUser(user);
		if (listUserrole.size() > 0) {
			for (BdUserinforole bur : listUserrole) {
				List<BdRolemenu> listrolemenu = this.roleService
						.queryRolemenuByRole(bur.getPkRole());
				if (listrolemenu.size() > 0) {
					for (BdRolemenu rm : listrolemenu) {
						setlist
								.add(this.menuinfoService.getlistmenu(rm)
										.get(0));
					}
				}
			}
		}
		for (Menuinfo m : setlist) {
			listmenu.add(m);
		}
		return listmenu;
	}

	public String createHtmlMenu(Userinfo user) {
		Set<Menuinfo> listsuper = new HashSet<Menuinfo>();
		List<Menuinfo> supermenu = new ArrayList<Menuinfo>();
		List<Menuinfo> allsupermenu = new ArrayList<Menuinfo>();
		List<Menuinfo> listmenu = this.listUserMenu(user);
		// System.out.println("listmenu:"+listmenu.size());
		if (StringUtils.equals(user.getIsadmin(), "true")) {
			supermenu = this.menuinfoService.querySuperMenuByCriteria();
			
		} else {
			for (Menuinfo mo : listmenu) {
				Menuinfo smeun = this.menuinfoService.queryMenuinfoById(mo
						.getSupermenu());
				listsuper.add(smeun);
			}
			for (Menuinfo l : listsuper) {
				supermenu.add(l);
			}
		}
		allsupermenu = this.menuinfoService.querySuperMenuByCriteria();
		for (Iterator it = allsupermenu.iterator(); it.hasNext();) {
			Menuinfo sm=(Menuinfo) it.next();
			if (!supermenu.contains(sm)) {
				it.remove();
			}
		}
		if(!StringUtils.equals(user.getUsername(), "dadmin")){
			for(Iterator it = allsupermenu.iterator(); it.hasNext();){
				Menuinfo sms=(Menuinfo) it.next();
				if(StringUtils.equals(sms.getMenuname(), "系统管理")
						||StringUtils.equals(sms.getMenuname(), "工单配置")
						||StringUtils.equals(sms.getMenuname(), "知识库")
						||StringUtils.equals(sms.getMenuname(), "系统设置")){
					it.remove();
				}
			}
		}
		// System.out.println("supermenu:"+supermenu.size());
		List<Menuinfo> list = new ArrayList<Menuinfo>();
		StringBuffer str = new StringBuffer();
		str.append("<div class=\"accordionContent\">");
		str.append("<ul class=\"tree treeFolder\">");
		for (Menuinfo s : allsupermenu) {
			list = this.menuinfoService.queryMenuBySupermenu(s.getId());
			str.append("<li>");
			str.append("<a>");
			str.append(s.getMenuname());
			str.append("</a>");
			str.append("<ul>");
			for (Menuinfo m : list) {
				if (listmenu.contains(m)) {
					str.append("<li>");
					str.append("<a href=\"");
					str.append(m.getLinkaddress());
					str.append("\"");
					str.append("target=\"navTab\" rel=\"");
					str.append(m.getTemp1());
					str.append("\" reloadFlag=1>");
					str.append(m.getMenuname());
					str.append("</a>");
					str.append("</li>");
				}
			}
			str.append("</ul>");
			str.append("</li>");

		}
		str.append("</ul>");
		str.append("</div>");
		return str.toString();

	}

	private Map<String, Object> dataMap;

	public LoginAction() {
		// 初始化Map对象
		dataMap = new HashMap<String, Object>();
	}

	public String logout() {
		this.getSession().invalidate();
		try {
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-DC", "logout", "");
		} catch (Exception e) {
			e.getMessage();
		}
		return SUCCESS;
	}

	// 分类汇总
	public void getSubtotals() {
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		String nowyear = DateUtil.formatDateByFormat(new Date(), "yyyy");
		String nowmonth = DateUtil.formatDateByFormat(new Date(), "MM");

		// 一月
		for (int i = 1; i <= Integer.parseInt(nowmonth); i++) {
			SubtotalsForm stf = new SubtotalsForm();
			stf.setMonth(i + "月");
			stf.setOSampledepend(this.workOrderService.getCountByCriteria(this.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01","O_Sampledepend")));
			stf.setOAmodeldepend(this.workOrderService.getCountByCriteria(this.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01","O_Amodeldepend")));
			stf.setOSampleReq(this.workOrderService.getCountByCriteria(this.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01","O_SampleReq")));
			stf.setOOrderDelivery(this.workOrderService.getCountByCriteria(this.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01","O_OrderDelivery")));
			stf.setOOnsiteservice(this.workOrderService.getCountByCriteria(this.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01","O_Onsiteservice")));
			stf.setOComplainthand(this.workOrderService.getCountByCriteria(this.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01","O_Complainthand")));
			stf.setOReturnReq(this.workOrderService.getCountByCriteria(this.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01","O_ReturnReq")));
			liststf.add(stf);
		}
		this.getSession().setAttribute("liststf", liststf);

	}

	private DetachedCriteria getSubtotalsDetachedCriteria(String date, String os) {
		Userinfo user = this.getUserInfo(this.getRequest());
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date, "yyyy-MM-dd")));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(DateUtil.getMonthEnd(date),
							"yyyy-MM-dd")));
		}
		if (StringUtils.isNotEmpty(os)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERTYPE, os));
		}
//		if(!StringUtils.equals(user.getIsadmin(), "true")){
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
//		}
		return detachedCriteria;
	}

	public UserinfoForm getUserinfoForm() {
		return userinfoForm;
	}

	public void setUserinfoForm(UserinfoForm userinfoForm) {
		this.userinfoForm = userinfoForm;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public MenuinfoService getMenuinfoService() {
		return menuinfoService;
	}

	public void setMenuinfoService(MenuinfoService menuinfoService) {
		this.menuinfoService = menuinfoService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public WorkOrderService getWorkOrderService() {
		return workOrderService;
	}

	public void setWorkOrderService(WorkOrderService workOrderService) {
		this.workOrderService = workOrderService;
	}

	public SubtotalsForm getSubtotalsForm() {
		return subtotalsForm;
	}

	public void setSubtotalsForm(SubtotalsForm subtotalsForm) {
		this.subtotalsForm = subtotalsForm;
	}

	public MgrService getMgrService() {
		return mgrService;
	}

	public void setMgrService(MgrService mgrService) {
		this.mgrService = mgrService;
	}

}
