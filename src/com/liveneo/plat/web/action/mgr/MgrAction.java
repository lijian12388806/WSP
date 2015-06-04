package com.liveneo.plat.web.action.mgr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.BdDictdetail;
import com.liveneo.plat.hibernate.dao.MgrTemplet;
import com.liveneo.plat.hibernate.dao.MgrWoDefine;
import com.liveneo.plat.service.impl.BdDictService;
import com.liveneo.plat.service.impl.mgr.MgrService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.mgr.MgrTempletForm;
import com.liveneo.plat.web.form.mgr.MgrWoDefineForm;

public class MgrAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//service
	private MgrService mgrService;
	private BdDictService bdDictService;
	//form
	private MgrTempletForm mgrTempletForm;
	private MgrWoDefineForm mgrWoDefineForm;
	//key
	private String mgrTempletKey;
	private String mgrWoDefineKey;
	//param
	private String coltype;
	
	public String execute() {
		return SUCCESS;
	}
	/**
	 * 工单模板配置 -添加
	 */
	public String addMgrTemplet(){
		mgrTempletForm = new MgrTempletForm();
		mgrTempletKey = "";
		mgrTempletForm.setTmpStatus("Y");
		return SUCCESS;
	}
	/**
	 * 工单模板配置 -编辑
	 */
	public String editMgrTemplet() {
		try {
			MgrTemplet bean = new MgrTemplet();
			mgrTempletForm = new MgrTempletForm();
			HttpServletRequest req = this.getRequest();
			if (StringUtils.isNotEmpty(mgrTempletKey)) {
				bean = this.mgrService.getMgrTemplet(IntegerUtil
						.converStrToInteger(mgrTempletKey));
			} else {
				return ajaxForwardError("主键丢失!");
			}// 返回list
			WebappUtil.copyProperties(mgrTempletForm, bean);
			req.setAttribute("mgrTempletForm", mgrTempletForm);
			return AbstractActionSupport.EDIT;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("编辑错误!");
		}
	}
	/**
	 * 工单模板配置 -保存
	 */
	public String saveMgrTemplet() {
		try {
			MgrTemplet bean = new MgrTemplet();
			if (StringUtils.isNotEmpty(mgrTempletKey)) {
				bean = this.mgrService.getMgrTemplet(IntegerUtil
						.converStrToInteger(mgrTempletKey));
				WebappUtil.copyProperties(bean, mgrTempletForm);
				this.mgrService.updateMgrTemplet(bean);
			} else {
				WebappUtil.copyProperties(bean, mgrTempletForm);
				this.mgrService.addMgrTemplet(bean);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}
	/**
	 * 工单模板配置 -删除
	 */
	public String delMgrTemplet() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					this.mgrService.delMgrTemplet(key);
				}
			}
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
	public String listMgrTemplet() {
		try {
			int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
					.converStrToInteger(this.getPageNum()) - 1
					: 0;
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
			}
			List<MgrTemplet> l = this.mgrService.findMgrTempletBySql(this.getSql(startIndex, numPerPage));
			this.getSession().setAttribute("mgr_templet_list", l);
			int i = 0;
			i = this.mgrService.queryCountMgrTemplet(this.getDetachedCriteria());
			this.setTotalCount(i);
			this.getSession().setAttribute("totalCount", i);
			return AbstractActionSupport.LIST;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	private String getSql(int startIndex, int pageNum) {
		String hql = "select * from mgr_templet  where ID >0 ";
		hql += "LIMIT " + startIndex + "," + pageNum;
		return hql;
	}
	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(MgrTemplet.class);
		return detachedCriteria;
	}
	/**
	 * 工单模板配置 -复制
	 */
	public String addcloneMgrTemplet(){
		if(StringUtils.isNotEmpty(mgrTempletKey)){
			try {
				this.mgrService.addCloneMgrTempletAll(IntegerUtil.converStrToInteger(mgrTempletKey));
			} catch (Exception e) {
				e.printStackTrace();
				return ajaxForwardError("操作错误!");
			}
		}else{
			return ajaxForwardError("主键丢失!");
		}
		return ajaxForwardSuccess("复制成功!");
	}
	/**
	 * 工单模板配置 -复制
	 */
	public String getMgrTempletUrl(){
		HttpServletRequest req = this.getRequest();
		String tmpCode = req.getParameter("tmpCode");
		String tmpType = req.getParameter("tmpType");
		String url = "";
		List<BdDictdetail> list = this.bdDictService.queryBdDictdetail("MGR_TYPE","Y");
		if(null!=list&&list.size()>0){
			for(BdDictdetail b:list){
				if(StringUtils.equals(b.getCode(),tmpType)){
					url = b.getRemark()+tmpCode;
				}
			}
		}
		this.getRequest().setAttribute("tmp_url",url);
		return SUCCESS;
	}
	
	/**
	 * 工单字段配置 -添加
	 */
	public String addMgrWoDefine(){
		HttpServletRequest req = this.getRequest();
		//类型
		coltype = req.getParameter("coltype");
		mgrTempletKey = req.getParameter("mgrTempletKey");
		mgrWoDefineForm = new MgrWoDefineForm();
		mgrWoDefineKey = "";
		mgrWoDefineForm.setDefColLmin("0");
		mgrWoDefineForm.setDefColLmax("20");
		mgrWoDefineForm.setDefCanedit("Y");
		return SUCCESS;
	}
	/**
	 * 工单字段配置 -编辑
	 */
	public String editMgrWoDefine() {
		try {
			MgrWoDefine bean = new MgrWoDefine();
			mgrWoDefineForm = new MgrWoDefineForm();
			HttpServletRequest req = this.getRequest();
			coltype = req.getParameter("coltype");
			mgrTempletKey = req.getParameter("mgrTempletKey");
			if (StringUtils.isNotEmpty(mgrWoDefineKey)) {
				bean = this.mgrService.getMgrWoDefine(IntegerUtil
						.converStrToInteger(mgrWoDefineKey));
			} else {
				return ajaxForwardError("主键丢失!");
			}// 返回list
			WebappUtil.copyProperties(mgrWoDefineForm, bean);
			req.setAttribute("mgrWoDefineForm", mgrWoDefineForm);
			return AbstractActionSupport.EDIT;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("编辑错误!");
		}
	}
	/**
	 * 工单字段配置 -保存
	 */
	public String saveMgrWoDefine(){
		try {
			MgrWoDefine bean = new MgrWoDefine();
			if(mgrTempletKey == null){
				return ajaxForwardError("主键丢失！");
			}
			if(coltype == null){
				return ajaxForwardError("类型丢失！");
			}
			if (StringUtils.isNotEmpty(mgrWoDefineKey)) {
				bean = this.mgrService.getMgrWoDefine(IntegerUtil
						.converStrToInteger(mgrWoDefineKey));
				WebappUtil.copyProperties(bean, mgrWoDefineForm);
				bean.setDefType(coltype);
				this.mgrService.updateMgrWoDefine(bean);
			} else {
				WebappUtil.copyProperties(bean, mgrWoDefineForm);
				MgrTemplet bmt = this.mgrService.getMgrTemplet(IntegerUtil.converStrToInteger(mgrTempletKey));
				bean.setPkTemplet(bmt.getId());
				bean.setDefType(coltype);
				this.mgrService.addMgrWoDefine(bean);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}
	/**
	 * 工单字段配置 - 列表
	 */
	public String listMgrWoDefine() {
		try {
			HttpServletRequest req = this.getRequest();
			HttpSession se = this.getSession();
			mgrTempletKey = req.getParameter("mgrTempletKey");
			if(null==mgrTempletKey){
				return ajaxForwardError("主键丢失!");
			}
			//类型
			coltype = req.getParameter("coltype");
			if(null!=coltype){
				List<MgrWoDefine> l = this.mgrService.findMgrWoDefineByMgrTempletKey(IntegerUtil.converStrToInteger(mgrTempletKey),coltype);
				se.setAttribute("mgr_wodefine_need", l);
			}else{
				return ajaxForwardError("类型丢失!");
			}
			return SUCCESS;
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}
	/**
	 * 工单字段配置 -复制
	 */
	public String cloneMgrWoDefine() {
		try {
			HttpServletRequest req = this.getRequest();
			String copyTo = req.getParameter("copyTo");
			String selectIDS = req.getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				this.mgrService.excuteCopyTo(ids, copyTo);
			}
			return ajaxForwardSuccess(getText("复制成功！"));
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("复制错误！");
		}
	}
	/**
	 * 工单模板配置 -删除
	 */
	public String delMgrWoDefine() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					this.mgrService.delMgrWoDefine(key);
				}
			}
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("删除错误！");
		}
	}
	/**
	 * get/set
	 * @return
	 */
	public MgrService getMgrService() {
		return mgrService;
	}
	public void setMgrService(MgrService mgrService) {
		this.mgrService = mgrService;
	}
	public MgrTempletForm getMgrTempletForm() {
		return mgrTempletForm;
	}
	public void setMgrTempletForm(MgrTempletForm mgrTempletForm) {
		this.mgrTempletForm = mgrTempletForm;
	}
	public MgrWoDefineForm getMgrWoDefineForm() {
		return mgrWoDefineForm;
	}
	public void setMgrWoDefineForm(MgrWoDefineForm mgrWoDefineForm) {
		this.mgrWoDefineForm = mgrWoDefineForm;
	}
	public String getMgrTempletKey() {
		return mgrTempletKey;
	}
	public void setMgrTempletKey(String mgrTempletKey) {
		this.mgrTempletKey = mgrTempletKey;
	}
	public String getMgrWoDefineKey() {
		return mgrWoDefineKey;
	}
	public void setMgrWoDefineKey(String mgrWoDefineKey) {
		this.mgrWoDefineKey = mgrWoDefineKey;
	}
	public String getColtype() {
		return coltype;
	}
	public void setColtype(String coltype) {
		this.coltype = coltype;
	}
	public BdDictService getBdDictService() {
		return bdDictService;
	}
	public void setBdDictService(BdDictService bdDictService) {
		this.bdDictService = bdDictService;
	}
}
