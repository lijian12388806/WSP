package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.BdDict;
import com.liveneo.plat.hibernate.dao.BdDictdetail;
import com.liveneo.plat.service.impl.BdDictService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.BdDictForm;

public class BdDictAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BdDictService bdDictService;
	private String bdDictKey;
	private String bdDictdetailKey;
	private BdDictForm bdDictForm;
	private String queryDictCode;
	private String queryDictTitle;

	private String code;


	public String execute() {
		return SUCCESS;
	}
	
	public String addBdDict() {
		bdDictForm = new BdDictForm();
		bdDictKey = "";
		bdDictForm.setIsvalid("Y");
		this.getSession().setAttribute("bdDictdetailList", null);
		return AbstractActionSupport.EDIT;
	}

	public String editBdDict() {
		try {
			bdDictForm = new BdDictForm();
			BdDict bdDict = new BdDict();
			if (StringUtils.isNotEmpty(bdDictKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("bdDictKey")))
					bdDictKey = (String) this.getSession().getAttribute(
							"bdDictKey");
				else
					return AbstractActionSupport.EDIT;// 返回list
			}
			bdDict = this.bdDictService.getBdDict(IntegerUtil
					.converStrToInteger(bdDictKey));
			List<BdDictdetail> bdDictdetailList = new ArrayList<BdDictdetail>();
			bdDictdetailList = this.bdDictService.queryBdDictdetail(bdDict
					.getDictcode(), "");
			this.getSession()
					.setAttribute("bdDictdetailList", bdDictdetailList);
			WebappUtil.copyProperties(bdDictForm, bdDict);
			this.getSession().setAttribute("bdDictForm", bdDictForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveBdDict() {
		try {
			BdDict bdDict = new BdDict();
			System.out.println(bdDictKey);
			if (StringUtils.isNotEmpty(bdDictKey)) {
				bdDict = this.bdDictService.getBdDict(IntegerUtil
						.converStrToInteger(bdDictKey));
				WebappUtil.copyProperties(bdDict, bdDictForm);
				this.bdDictService.updateBdDict(bdDict);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", bdDict.toString(), BdDict.REF);
			} else {
				WebappUtil.copyProperties(bdDict, bdDictForm);
				int i = -1 ;
				i = this.bdDictService.addBdDict(bdDict);
				if(i == 0 || i == -1){
					return ajaxForwardError("业务编号重复！");
				}
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", bdDict.toString(), BdDict.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");

			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listBdDict() {
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
				this.setQueryDictCode("");
				this.setQueryDictTitle("");
			}
			String onduty = "false";
			onduty=this.getRequest().getParameter("onduty");
			List<BdDict> l = this.bdDictService.findBdDictByHql(this.getHql(startIndex, numPerPage,onduty));

			this.getSession().setAttribute("bdDictList", l);
			int i = 0;
			i = this.bdDictService.queryCountBdDict(this.getDetachedCriteria(onduty));
			this.setTotalCount(i);
			this.getSession().setAttribute("totalCount", i);

			return AbstractActionSupport.LIST;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}

	}

	private String getHql(int startIndex, int pageNum,String onduty) {
		String hql = "select * from Bd_Dict  where pk_dict >0 ";

		if (StringUtils.isNotEmpty(queryDictCode)) {
			hql += " and dictcode like '%" + queryDictCode + "%'";
		}
		if (StringUtils.isNotEmpty(queryDictTitle)) {
			hql += " and dicttitle like '%" + queryDictTitle + "%'";
		}
		if(StringUtils.equals(onduty, "true")){
			hql += " and dicttype = 'OnDuty'";
		}
		hql += "order by pk_dict desc LIMIT " + startIndex + "," + pageNum;
		return hql;
	}

	private DetachedCriteria getDetachedCriteria(String onduty) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BdDict.class);
		// detachedCriteria.addOrder(Order.asc(BdDict.PROP_DICTCODE));
		if(StringUtils.equals(onduty, "true")){
			detachedCriteria.add(Restrictions.eq(BdDict.PROP_DICTTYPE,"OnDuty"));
		}
		if (StringUtils.isNotEmpty(queryDictCode)) {
			detachedCriteria.add(Restrictions.ilike(BdDict.PROP_DICTCODE,
					queryDictCode, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryDictTitle)) {
			detachedCriteria.add(Restrictions.ilike(BdDict.PROP_DICTTITLE,
					queryDictTitle, MatchMode.ANYWHERE));
		}
		return detachedCriteria;
	}

	public String deleteBdDict() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				List<String> keyList = new ArrayList<String>();
				keyList = ListUtil.ConvertArrayToStringList(StringUtils.split(
						selectIDS, ','), "String");
				if (keyList != null) {
					for (String key : keyList) {
						this.bdDictService.delBdDict(IntegerUtil
								.converStrToInteger(key));
					}
				}
			}
			String navTabId = "dictLiNav";
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-XC", "delete：" + selectIDS, BdDict.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}

	public String addBdDictdetail() {
		bdDictdetailKey = "";
		bdDictForm = new BdDictForm();
		bdDictForm.setDetailisvalid("Y");
		return AbstractActionSupport.EDIT;
	}

	public String editBdDictdetail() {
		try {
			bdDictForm = (BdDictForm) this.getSession().getAttribute(
					"bdDictForm");
			BdDictdetail bdDictdetail = new BdDictdetail();
			if (StringUtils.isNotEmpty(bdDictdetailKey)) {
				bdDictdetail = this.bdDictService.getBdDictdetail(IntegerUtil
						.converStrToInteger(bdDictdetailKey));
			} else {
				return AbstractActionSupport.EDIT;// 返回list
			}
			WebappUtil.copyProperties(bdDictForm, bdDictdetail);
			bdDictForm.setDetailisvalid(bdDictdetail.getIsvalid());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveBdDictdetail() {
		try {
			BdDictdetail bdDictdetail = new BdDictdetail();
			BdDict bdDict = new BdDict();
			if (StringUtils.isNotEmpty(bdDictKey)) {
				bdDict = this.bdDictService.getBdDict(IntegerUtil
						.converStrToInteger(bdDictKey));
			} else {
				String msgkey = getText("dict.misskey");
				return ajaxForwardError(msgkey);
			}
			if (StringUtils.isNotEmpty(bdDictdetailKey)) {
				bdDictdetail = this.bdDictService.getBdDictdetail(IntegerUtil
						.converStrToInteger(bdDictdetailKey));
				WebappUtil.copyProperties(bdDictdetail, bdDictForm);
				bdDictdetail.setIsvalid(bdDictForm.getDetailisvalid());
				this.bdDictService.updateBdDictdetail(bdDictdetail);
				//更新值班人/电话
//				this.bdDictService.setDictRemark(bdDict);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", bdDictdetail.toString(), BdDict.REF);
			} else {
				WebappUtil.copyProperties(bdDictdetail, bdDictForm);
				bdDictdetail.setIsvalid(bdDictForm.getDetailisvalid());
				bdDictdetail.setPkDict(bdDict);
				this.bdDictService.addBdDictdetail(bdDictdetail);
				//更新值班人/电话
//				this.bdDictService.setDictRemark(bdDict);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", bdDictdetail.toString(), BdDict.REF);
			}
			this.getSession().setAttribute("bdDictKey", bdDictKey);
			return ajaxForwardSuccess(getText("dict.addsuccess"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}
	

	public String deleteBdDictdetail() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				this.bdDictService.deleteBdDictdetailByIds(StringUtils.split(
						selectIDS, ','));
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete:" + selectIDS.toString(), BdDict.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}
	/**
	 * get/set
	 * @return
	 */
	public String getBdDictdetailKey() {
		return bdDictdetailKey;
	}

	public void setBdDictdetailKey(String bdDictdetailKey) {
		this.bdDictdetailKey = bdDictdetailKey;
	}

	public BdDictForm getBdDictForm() {
		return bdDictForm;
	}

	public void setBdDictForm(BdDictForm bdDictForm) {
		this.bdDictForm = bdDictForm;
	}

	public String getBdDictKey() {
		return bdDictKey;
	}

	public void setBdDictKey(String bdDictKey) {
		this.bdDictKey = bdDictKey;
	}

	public BdDictService getBdDictService() {
		return bdDictService;
	}

	public void setBdDictService(BdDictService bdDictService) {
		this.bdDictService = bdDictService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getQueryDictCode() {
		return queryDictCode;
	}

	public void setQueryDictCode(String queryDictCode) {
		this.queryDictCode = queryDictCode;
	}

	public String getQueryDictTitle() {
		return queryDictTitle;
	}

	public void setQueryDictTitle(String queryDictTitle) {
		this.queryDictTitle = queryDictTitle;
	}

}
