package com.liveneo.plat.web.action.crm;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.CrmCust;
import com.liveneo.plat.hibernate.dao.CrmWo;
import com.liveneo.plat.hibernate.dao.MgrTemplet;
import com.liveneo.plat.hibernate.dao.MgrWoDefine;
import com.liveneo.plat.service.impl.crm.CrmCustService;
import com.liveneo.plat.service.impl.crm.CrmWoService;
import com.liveneo.plat.service.impl.mgr.MgrService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.crm.CrmWoForm;

public class CrmWoAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// service
	private CrmWoService crmWoService;
	private CrmCustService crmCustService;
	private MgrService mgrService;
	
	// form
	private CrmWoForm crmWoForm;
	// key
	private String crmWoKey;
	// 查询
	private String query;
	private String querydate;
	// param
	private String tmp_code;
	private String actFrom;
	private String callucid;
	private String his_wo;
	private String caller;

	public String execute() {
		return SUCCESS;
	}

	/**
	 * 工单 -弹屏
	 */
	public String addCallsWo(){
		try {
			crmWoForm = new CrmWoForm();
			crmWoKey = "";
			HttpServletRequest req = this.getRequest();
			String caller = req.getParameter("caller");// 来电号码/外呼号码
			String callmode = req.getParameter("callmode");// 工单类型
			String callucid = req.getParameter("callucid");// 电话UCID
			String agentid = req.getParameter("agentid");// 坐席工号
			his_wo = req.getParameter("his_wo");// 历史工单 天数
			tmp_code = req.getParameter("tmp_code");// 模板
			Date now = new Date();
			// 保存来电信息
			if (!StringUtils.equalsIgnoreCase(callmode, "manual")) {
				//查询客户信息
				List<CrmCust> listc = this.crmCustService.queryCrmCustByPhone(caller);
				req.setAttribute("wo_cust_list",listc);
				CrmWo bean = new CrmWo();
				bean.setWosCaller(caller);
				bean.setWosCallmode(callmode);
				bean.setWosCallucid(callucid);
				bean.setWosAgentid(agentid);
				bean.setWosStatus("btn_wcl");
				bean.setWosNo(this.crmWoService.getCrmWoNoByCreate());
				bean.setWosCreatetime(now);
				if(null!=listc&&listc.size()>0){
					bean.setWosPkcust(IntegerUtil.converIntegerToStr(listc.get(0).getId()));
				}
				this.crmWoService.addCrmWo(bean);
				// 页面 form
				WebappUtil.copyProperties(crmWoForm, bean);
				req.setAttribute("crmWoForm", crmWoForm);
			}
			//初始化页面模板
			initPage(req,tmp_code);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxForwardError("操作错误:" + e.getMessage());
		}
	}

	private void initPage(HttpServletRequest req, String tmp_code) {
		List<MgrTemplet> list = this.mgrService
				.findMgrTempletByMgrTempletCode(tmp_code);
		MgrTemplet mt = new MgrTemplet();
		if (null != list && list.size() > 0) {
			mt = list.get(0);
			List<MgrWoDefine> ll = this.mgrService
					.findMgrWoDefineByMgrTempletCode(tmp_code, "add");
			req.setAttribute("crmwo_init_add", ll);
			req.setAttribute("wo_btns", mt.getTmpBtn());
			req.setAttribute("wo_cust_related",mt.getTmpRelated());
		}
	}

	/**
	 * 工单 -添加
	 */

	/**
	 * 工单 -保存
	 */
	public String saveCrmWo() {
		try {
			CrmWo bean = new CrmWo();
			if (StringUtils.isNotEmpty(crmWoKey)) {
				bean = this.crmWoService.getCrmWoByKey(IntegerUtil
						.converStrToInteger(crmWoKey));
				WebappUtil.copyProperties(bean,crmWoForm);
				this.crmWoService.updateCrmWo(bean);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", bean.toString(), CrmWo.REF);
			} else {
				WebappUtil.copyProperties(bean,crmWoForm);
				this.crmWoService.addCrmWo(bean);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", bean.toString(), CrmWo.REF);
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
	public String editCrmWo() {
		try {
			CrmWo bean = new CrmWo();
			crmWoForm = new CrmWoForm();
			HttpServletRequest req = this.getRequest();
			tmp_code = req.getParameter("tmp_code");
			actFrom = req.getParameter("actFrom");
			if (StringUtils.isNotEmpty(crmWoKey)) {
				bean = this.crmWoService.getCrmWoByKey(IntegerUtil
						.converStrToInteger(crmWoKey));
			} else {
				return ajaxForwardError("主键丢失!");
			}// 返回list
			initPage(req, tmp_code);
			WebappUtil.copyProperties(crmWoForm, bean);
			req.setAttribute("crmWoForm", crmWoForm);
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
	public String delCrmWo() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					this.crmWoService.delCrmWo(key);
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete:" + selectIDS.toString(), CrmWo.REF);
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
	public String listCrmWo() {
		try {
			HttpServletRequest req = this.getRequest();
			tmp_code = req.getParameter("tmp_code");
			callucid = req.getParameter("callucid");
			his_wo = req.getParameter("his_wo");
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
			List<CrmWo> l = this.crmWoService.findCrmWoBySql(this.getSql(
					startIndex, numPerPage, mt.getTmpListdata() ,tmp_code,"Y"));
			se.setAttribute("crmwo_list", l);
			//excel导出
//			List<CrmWo> ll = this.crmWoService.findCrmWoBySql(this.getSql(
//					startIndex, numPerPage, mt.getTmpType(),tmp_code,"Y"));
//			se.setAttribute("wo_excel_data", ll);
			int i = 0;
			List<CrmWo> ll = this.crmWoService.findCrmWoBySql(this.getSql(
					startIndex, numPerPage, mt.getTmpListdata() ,tmp_code,null));
			i = ll.size();
			this.setTotalCount(i);
			se.setAttribute("totalCount",i);
			// 初始化页面信息
			se = this.getMgrWoDefineMap(se,tmp_code);
			if(StringUtils.isNotEmpty(his_wo)&&IntegerUtil.converStrToInteger(his_wo)>0){
				return "wo_his";
			}else{
				return AbstractActionSupport.LIST;
			}
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("获取信息错误!");
		}
	}

	private String getSql(int startIndex, int pageNum, String listdata,String tmp_code,String limit) {
		List<MgrWoDefine> list = this.mgrService.findMgrWoDefineByMgrTempletCode(tmp_code,"query");
		HttpServletRequest req = this.getRequest();
		String sql = "select * from Crm_Wo  where Id >0 ";
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
		if (StringUtils.isNotEmpty(listdata)) {
			sql += " and wos_status in(" + toMtypeIn(listdata) + ")";
		}else{
			sql += " and id < 0";
		}
		if(StringUtils.isNotEmpty(his_wo)){
			sql += " and (WOS_CREATETIME BETWEEN date_add(SYSDATE(), interval -"+his_wo+" day) and SYSDATE())";
		}
		if (StringUtils.isNotEmpty(caller)) {
			sql += " and WOS_CALLER = '"+caller+"'";
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

	// 查询
	public HttpSession getMgrWoDefineMap(HttpSession se, String tmp_code) {
		List<MgrWoDefine> list = this.mgrService
				.findMgrWoDefineByMgrTempletCode(tmp_code, "list");
		se.setAttribute("crmwo_init_list", list);
		List<MgrWoDefine> query = this.mgrService
				.findMgrWoDefineByMgrTempletCode(tmp_code, "query");
		se.setAttribute("crmwo_init_query", query);
		return se;
	}

	/**
	 * get/set
	 * 
	 * @return
	 */
	public CrmWoService getCrmWoService() {
		return crmWoService;
	}

	public void setCrmWoService(CrmWoService crmWoService) {
		this.crmWoService = crmWoService;
	}

	public CrmWoForm getCrmWoForm() {
		return crmWoForm;
	}

	public void setCrmWoForm(CrmWoForm crmWoForm) {
		this.crmWoForm = crmWoForm;
	}

	public String getCrmWoKey() {
		return crmWoKey;
	}

	public void setCrmWoKey(String crmWoKey) {
		this.crmWoKey = crmWoKey;
	}

	public MgrService getMgrService() {
		return mgrService;
	}

	public void setMgrService(MgrService mgrService) {
		this.mgrService = mgrService;
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
	public String getHis_wo() {
		return his_wo;
	}

	public void setHis_wo(String hisWo) {
		his_wo = hisWo;
	}
	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	public CrmCustService getCrmCustService() {
		return crmCustService;
	}

	public void setCrmCustService(CrmCustService crmCustService) {
		this.crmCustService = crmCustService;
	}
	public String getQuerydate() {
		return querydate;
	}
	public void setQuerydate(String querydate) {
		this.querydate = querydate;
	}
}
