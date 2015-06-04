package com.liveneo.plat.web.action.crm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.CrmCust;
import com.liveneo.plat.hibernate.dao.MgrTemplet;
import com.liveneo.plat.hibernate.dao.MgrWoDefine;
import com.liveneo.plat.service.impl.crm.CrmCustService;
import com.liveneo.plat.service.impl.mgr.MgrService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.crm.CrmCustForm;

public class CrmCustAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// service
	private CrmCustService crmCustService;
	private MgrService mgrService;
	// form
	private CrmCustForm crmCustForm;
	// key
	private String crmCustKey;
	// 查询
	private String query;
	// param
	private String tmp_code;
	private String actFrom;
	private String callucid;
	private String his_Cust;
	private String caller;

	public String execute() {
		return SUCCESS;
	}

	/**
	 * 添加
	 */
	public String addCrmCust() {
		try {
			crmCustForm = new CrmCustForm();
			crmCustKey = "";
			HttpServletRequest req = this.getRequest();
			//初始化页面模板
			initPage(req,tmp_code);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxForwardError("操作错误:" + e.getMessage());
		}
	}

	private void initPage(HttpServletRequest req, String tmp_code) {
		List<MgrTemplet> list = this.mgrService.findMgrTempletByMgrTempletCode(tmp_code);
		MgrTemplet mt = new MgrTemplet();
		if (null != list && list.size() > 0) {
			mt = list.get(0);
			List<MgrWoDefine> ll = this.mgrService
					.findMgrWoDefineByMgrTempletCode(tmp_code, "add");
			req.setAttribute("crmCust_init_add", ll);
			req.setAttribute("Cust_btns", mt.getTmpBtn());
			req.setAttribute("cust_wo_related",mt.getTmpRelated());
		}
	}

	/**
	 * 保存
	 */
	public String saveCrmCust() {
		try {
			CrmCust bean = new CrmCust();
			if (StringUtils.isNotEmpty(crmCustKey)) {
				bean = this.crmCustService.getCrmCustByKey(IntegerUtil
						.converStrToInteger(crmCustKey));
				WebappUtil.copyProperties(bean,crmCustForm);
				this.crmCustService.updateCrmCust(bean);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", bean.toString(), CrmCust.REF);
			} else {
				WebappUtil.copyProperties(bean, crmCustForm);
				this.crmCustService.addCrmCust(bean);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", bean.toString(), CrmCust.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	/**
	 * 工单-编辑
	 */
	public String editCrmCust() {
		try {
			CrmCust bean = new CrmCust();
			crmCustForm = new CrmCustForm();
			HttpServletRequest req = this.getRequest();
			tmp_code = req.getParameter("tmp_code");
			actFrom = req.getParameter("actFrom");
			if (StringUtils.isNotEmpty(crmCustKey)) {
				bean = this.crmCustService.getCrmCustByKey(IntegerUtil
						.converStrToInteger(crmCustKey));
			} else {
				return ajaxForwardError("主键丢失!");
			}// 返回list
			initPage(req, tmp_code);
			WebappUtil.copyProperties(crmCustForm, bean);
			req.setAttribute("crmCustForm", crmCustForm);
			return AbstractActionSupport.EDIT;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("编辑错误!");
		}
	}

	/**
	 * 工单-删除
	 */
	public String delCrmCust() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					this.crmCustService.delCrmCust(key);
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete:" + selectIDS.toString(), CrmCust.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("删除错误！");
		}
	}

	/**
	 * 工单 -列表
	 */
	public String listCrmCust() {
		try {
			HttpServletRequest req = this.getRequest();
			tmp_code = req.getParameter("tmp_code");
			HttpSession se = this.getSession();
			int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
					.converStrToInteger(this.getPageNum()) - 1
					: 0;
			int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
			int startIndex = pageNum
					* IntegerUtil.converStrToInteger(getNumPerPage());
			String search = this.getRequest().getParameter("search");
			if (StringUtils.equalsIgnoreCase(search, "true")) {
				startIndex = 0 * IntegerUtil
						.converStrToInteger(getNumPerPage());
			}
			String check_changeUrl = this.getRequest()
					.getParameter("changeUrl");
			if (StringUtils.isNotEmpty(check_changeUrl)) {
				this.setQuery("");
			}
			// 初始化模板
			MgrTemplet mt = this.mgrService
					.getMgrTempletByMgrTempletCode(tmp_code);
			//页面显示
			List<CrmCust> l = this.crmCustService.findCrmCustBySql(this.getSql(
					startIndex, numPerPage, mt.getTmpType(),tmp_code,"Y"));
			se.setAttribute("crmCust_list", l);
			int i = 0;
			i = this.crmCustService.queryCountCrmCust(this.getDetachedCriteria());
			this.setTotalCount(i);
			se.setAttribute("totalCount",i);
			// 初始化页面信息
			se = this.getMgrCustDefineMap(se,tmp_code);
			return AbstractActionSupport.LIST;
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("获取信息错误!");
		}
	}

	private String getSql(int startIndex, int pageNum, String mtype,String tmp_code,String limit) {
		String sql = "select * from Crm_Cust  where Id >0 ";
		List<MgrWoDefine> list = this.mgrService.findMgrWoDefineByMgrTempletCode(tmp_code,"query");
		HttpServletRequest req = this.getRequest();
		if(null!=list&&list.size()>0){
			String[] colval = null;
			for (MgrWoDefine mw:list) {
				String type = mw.getDefColType();
				String col = mw.getDefCol();
				colval = req.getParameterValues(col);
				col = toUpperCaseFirstOne(getColByFormCol(col));
				if(null != colval&&colval.length>0){
					if (StringUtils.equalsIgnoreCase(type,"input")||StringUtils.equalsIgnoreCase(type,"textarea")) {
						if(StringUtils.isNotEmpty(colval[0])){
							sql += " and "+col+" like '%"+ colval[0] + "%'";
						}
					}else if(StringUtils.equalsIgnoreCase(type,"select")){
						if(StringUtils.isNotEmpty(colval[0])){
							sql += " and "+col+" = '"+ colval[0] + "'";
						}
					}else if(StringUtils.equalsIgnoreCase(type,"date")){
						if(StringUtils.isNotEmpty(colval[0])){
							sql += " and "+col+" >= '"+ colval[0] + "'";
						}
						if(colval.length>1&&StringUtils.isNotEmpty(colval[1])){
							sql += " and "+col+" <= '"+ colval[1] + "'";
						}
					}
				}
				
			}
		}
		sql += " order by Id desc ";
		if(StringUtils.isNotEmpty(limit)){
			sql += "LIMIT " + startIndex + "," + pageNum;
		}
		return sql;
	}
	//col转换
	public static String getColByFormCol(String col){
		String wosA = StringUtils.substringAfter(col, "wos");
		StringBuffer sb = new StringBuffer();
		sb.append(StringUtils.upperCase("wos"));
		sb.append("_");
		sb.append(StringUtils.upperCase(wosA));
		return sb.toString();
	}
	// 数据状态in
	public String toMtypeIn(String mtype) {
		String[] str = StringUtils.split(mtype, ",");
		StringBuffer sb = new StringBuffer();
		if (null != str && str.length > 0) {
			for (String s : str) {
				sb.append("'" + StringUtils.trim(s) + "'");
				sb.append(",");
			}
		}
		return StringUtils.substringBeforeLast(sb.toString(), ",");
	}

	// 首字母转大写
	public String toUpperCaseFirstOne(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}

	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(CrmCust.class);
		return detachedCriteria;
	}

	// 查询
	public HttpSession getMgrCustDefineMap(HttpSession se, String tmp_code) {
		List<MgrWoDefine> list = this.mgrService
				.findMgrWoDefineByMgrTempletCode(tmp_code, "list");
		se.setAttribute("crmCust_init_list", list);
		List<MgrWoDefine> query = this.mgrService
				.findMgrWoDefineByMgrTempletCode(tmp_code, "query");
		se.setAttribute("crmCust_init_query", query);
		return se;
	}
	/**
	 * get/set
	 * 
	 * @return
	 */
	public CrmCustService getCrmCustService() {
		return crmCustService;
	}

	public void setCrmCustService(CrmCustService crmCustService) {
		this.crmCustService = crmCustService;
	}

	public MgrService getMgrService() {
		return mgrService;
	}

	public void setMgrService(MgrService mgrService) {
		this.mgrService = mgrService;
	}

	public CrmCustForm getCrmCustForm() {
		return crmCustForm;
	}

	public void setCrmCustForm(CrmCustForm crmCustForm) {
		this.crmCustForm = crmCustForm;
	}

	public String getCrmCustKey() {
		return crmCustKey;
	}

	public void setCrmCustKey(String crmCustKey) {
		this.crmCustKey = crmCustKey;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTmp_code() {
		return tmp_code;
	}

	public void setTmp_code(String tmpCode) {
		tmp_code = tmpCode;
	}

	public String getActFrom() {
		return actFrom;
	}

	public void setActFrom(String actFrom) {
		this.actFrom = actFrom;
	}

	public String getCallucid() {
		return callucid;
	}

	public void setCallucid(String callucid) {
		this.callucid = callucid;
	}

	public String getHis_Cust() {
		return his_Cust;
	}

	public void setHis_Cust(String hisCust) {
		his_Cust = hisCust;
	}

	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

}
