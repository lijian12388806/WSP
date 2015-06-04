package com.liveneo.plat.web.action.kbms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.KbmsClass;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.impl.kbms.KbmsClassService;
import com.liveneo.plat.service.impl.mgr.MgrService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.kbms.KbmsClassForm;

public class KbmsClassAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//service
	private KbmsClassService kbmsClassService;
	private MgrService mgrService;
	//form
	private KbmsClassForm kbmsClassForm;
	//key
	private String kbmsClassKey;
	private String operate;
	//查询
	private String query;
	private String from;
	public String execute() {
		return SUCCESS;
	}
	/**
	 * 工单模板配置 -添加
	 */
	public String addKbmsClass(){
		kbmsClassForm = new KbmsClassForm();
		kbmsClassKey = this.getRequest().getParameter("kbmsClassKey");
		operate = this.getRequest().getParameter("operate");
		return SUCCESS;
	}
	/**
	 * 工单模板配置 -保存
	 */
	public String saveKbmsClass(){
		try {
			operate = this.getRequest().getParameter("operate");
			System.out.println(operate);
			System.out.println(kbmsClassKey);
			KbmsClass bean = new KbmsClass();
			if (StringUtils.isNotEmpty(kbmsClassKey)) {
				if(StringUtils.equalsIgnoreCase(operate, "add")){
					WebappUtil.copyProperties(bean, kbmsClassForm);
					bean.setPid(kbmsClassKey);
					this.kbmsClassService.addKbmsClass(bean);
				}else{
					bean = this.kbmsClassService.getKbmsClassByKey(IntegerUtil.converStrToInteger(kbmsClassKey));
					WebappUtil.copyProperties(bean, kbmsClassForm);
					this.kbmsClassService.updateKbmsClass(bean);
				}
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", bean.toString(), KbmsClass.REF);
			} else {
				WebappUtil.copyProperties(bean, kbmsClassForm);
				this.kbmsClassService.addKbmsClass(bean);
				bean.setPid("0");
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", bean.toString(), KbmsClass.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}
	/**
	 * 工单模板配置 -编辑
	 */
	public String editKbmsClass() {
		try {
			KbmsClass bean = new KbmsClass();
			kbmsClassForm = new KbmsClassForm();
			HttpServletRequest req = this.getRequest();
			if (StringUtils.isNotEmpty(kbmsClassKey)) {
				bean = this.kbmsClassService.getKbmsClassByKey(IntegerUtil
						.converStrToInteger(kbmsClassKey));
			} else {
				return ajaxForwardError("主键丢失!");
			}// 返回list
			WebappUtil.copyProperties(kbmsClassForm,bean);
			req.setAttribute("kbmsClassForm",kbmsClassForm);
			return AbstractActionSupport.EDIT;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("编辑错误!");
		}
	}
	/**
	 * 工单模板配置 -删除
	 */
	public String delKbmsClass() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					this.kbmsClassService.delKbmsClassCson(key);
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					 "LOGTYPE-SC", "delete:" + selectIDS.toString(), KbmsClass.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("删除错误！");
		}
	}
	/**
	 * 工单模板配置 -列表
	 */
	public String listKbmsClass() {
		try {
			from = this.getRequest().getParameter("from");
			HttpSession se = this.getSession();
			int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
					.converStrToInteger(this.getPageNum()) - 1: 0;
			int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
			int startIndex = pageNum
					* IntegerUtil.converStrToInteger(getNumPerPage());
			String search = this.getRequest().getParameter("search");
			if (StringUtils.equalsIgnoreCase(search, "true")) {
				startIndex = 0 * IntegerUtil.converStrToInteger(getNumPerPage());
			}
			String check_changeUrl = this.getRequest()
					.getParameter("changeUrl");
			if (StringUtils.isNotEmpty(check_changeUrl)) {
				this.setQuery("");
			}
			List<KbmsClass> l = this.kbmsClassService.findKbmsClassBySql(this.getSql(startIndex, numPerPage,from));
			se.setAttribute("KbmsClass_list", l);
			if(StringUtils.equalsIgnoreCase(from,"class")){
				se.setAttribute("KbmsClass_map",getTreeMap(l));
			}else{
				se.setAttribute("KbmsClass_map",getTreeMap_l(l));
			}
			int i = 0;
			i = this.kbmsClassService.queryCountKbmsClass(this.getDetachedCriteria());
			this.setTotalCount(i);
			se.setAttribute("totalCount", i);
			return AbstractActionSupport.LIST;
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("获取信息错误!");
		}
	}
	private String getSql(int startIndex, int pageNum,String from) {
		String sql = "select * from Kbms_Class  where Id >0 and Pid = '0' order by ID desc";
		if(StringUtils.equalsIgnoreCase(from,"class")){
			sql += "  LIMIT " + startIndex + "," + pageNum;
		}
		return sql;
	}
	//首字母转大写
	public String toUpperCaseFirstOne(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}
	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(KbmsClass.class);
		detachedCriteria.add(Restrictions.eq(KbmsClass.PROP_PID, "0"));
		return detachedCriteria;
	}
	//构建树-查看
	public Map<Integer,String> getTreeMap_l(List<KbmsClass> list){
		Map<Integer,String> map = new HashMap<Integer,String>();
		if(null!=list&&list.size()>0){
			for(KbmsClass k:list){
				//子节点
				List<KbmsClass> son = this.kbmsClassService.findKbmsClassSon(k.getId());
				StringBuffer sbs = new StringBuffer();
				if(null!=son&&son.size()>0){
					for(KbmsClass ss:son){
						sbs.append(ss.getId());
						sbs.append(",");
					}
				}
				String ss = StringUtils.substringBeforeLast(sbs.toString(), ",");
				if(StringUtils.isEmpty(ss)){
					ss = "9999999999";
				}
				StringBuffer sb = new StringBuffer();
				sb.append("<ul class=\"tree\" >");
					sb.append("<li>");
						sb.append("<a href=\"#\" onclick=\"kbmsklp_list('"+ss+"')\">");
						sb.append(k.getTitle()+"&nbsp;&nbsp;&nbsp;");
						sb.append("</a>");
					sb.append("<ul>");
						if(null!=son&&son.size()>0){
							for(KbmsClass s:son){
								sb.append("<li>");
								sb.append("<a href=\"#\" onclick=\"kbmsklp_list('"+s.getId()+",000000000')\">");
								sb.append(s.getTitle()+"&nbsp;&nbsp;&nbsp;");
								sb.append("</a>");
								sb.append("</li>");
							}
						}
					sb.append("</ul>");
					sb.append("</li>");
				sb.append("</ul>");
				map.put(k.getId(),sb.toString());
			}
		}
		return map;
	}
	//构建树-管理员
	public Map<Integer,String> getTreeMap(List<KbmsClass> list){
		Map<Integer,String> map = new HashMap<Integer,String>();
		if(null!=list&&list.size()>0){
			for(KbmsClass k:list){
				//子节点
				List<KbmsClass> son = this.kbmsClassService.findKbmsClassSon(k.getId());
				StringBuffer sbs = new StringBuffer();
				if(null!=son&&son.size()>0){
					for(KbmsClass ss:son){
						sbs.append(ss.getId());
						sbs.append(",");
					}
				}
				String ss = StringUtils.substringBeforeLast(sbs.toString(), ",");
				if(StringUtils.isEmpty(ss)){
					ss = "9999999999";
				}
				StringBuffer sb = new StringBuffer();
				sb.append("<ul class=\"tree collapse\" >");
					sb.append("<li>");
						sb.append("<a href=\"#\" onclick=\"kbmsklp_list('"+ss+"')\">");
						sb.append(k.getTitle()+"&nbsp;&nbsp;&nbsp;");
						//添加
						sb.append(getBut(k.getId(),"add"));
						sb.append("&nbsp;&nbsp;&nbsp;");
						//修改
						sb.append(getBut(k.getId(),"edit"));
						sb.append("&nbsp;&nbsp;&nbsp;");
						//删除
						sb.append(getBut(k.getId(),"del"));
						sb.append("</a>");
					sb.append("<ul>");
						if(null!=son&&son.size()>0){
							for(KbmsClass s:son){
								sb.append("<li>");
								sb.append("<a href=\"#\" onclick=\"kbmsklp_list('"+s.getId()+",000000000')\">");
								sb.append(s.getTitle()+"&nbsp;&nbsp;&nbsp;");
								//修改
								sb.append(getBut(s.getId(),"edit"));
								sb.append("&nbsp;&nbsp;&nbsp;");
								//删除
								sb.append(getBut(s.getId(),"del"));
								//添加知识点
//								sb.append("&nbsp;&nbsp;&nbsp;");
//								sb.append(getBut(s.getId(),"addk"));
								sb.append("</a>");
								sb.append("</li>");
							}
						}
					sb.append("</ul>");
					sb.append("</li>");
				sb.append("</ul>");
				map.put(k.getId(),sb.toString());
			}
		}
		return map;
	}
	public String getBut(int key,String operate){
		String add = "<button class=\"btn btn-mini\" type=\"button\" onclick=\"operateTree('"+key+"','add');\"><i class=\"icon-plus\"></i>添加</button>";
		String edit = "<button class=\"btn btn-mini\" type=\"button\" onclick=\"operateTree('"+key+"','edit');\"><i class=\"icon-edit\"></i>修改</button>";
		String del = "<button class=\"btn btn-mini\" type=\"button\" onclick=\"operateTree('"+key+"','del');\"><i class=\"icon-remove-sign\"></i>删除</button>";
		String addk = "<button class=\"btn btn-mini\" type=\"button\" onclick=\"operateTree('"+key+"','del');\"><i class=\"icon-remove-sign\"></i>添加知识点</button>";
		if(StringUtils.equalsIgnoreCase(operate, "add")){
			return add;
		}else if(StringUtils.equalsIgnoreCase(operate, "edit")){
			return edit;
		}else if(StringUtils.equalsIgnoreCase(operate, "addk")){
			return addk;
		}else{
			return del;
		}
	}
	/**
	 * get/set
	 * @return
	 */
	public KbmsClassService getKbmsClassService() {
		return kbmsClassService;
	}
	public void setKbmsClassService(KbmsClassService kbmsClassService) {
		this.kbmsClassService = kbmsClassService;
	}
	public MgrService getMgrService() {
		return mgrService;
	}
	public void setMgrService(MgrService mgrService) {
		this.mgrService = mgrService;
	}
	public KbmsClassForm getKbmsClassForm() {
		return kbmsClassForm;
	}
	public void setKbmsClassForm(KbmsClassForm kbmsClassForm) {
		this.kbmsClassForm = kbmsClassForm;
	}
	public String getKbmsClassKey() {
		return kbmsClassKey;
	}
	public void setKbmsClassKey(String kbmsClassKey) {
		this.kbmsClassKey = kbmsClassKey;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
}
