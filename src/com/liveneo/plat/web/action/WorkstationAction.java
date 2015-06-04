package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Customerinfo;
import com.liveneo.plat.hibernate.dao.Orderdealinfo;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.Workstation;
import com.liveneo.plat.service.impl.CustomerinfoService;
import com.liveneo.plat.service.impl.UserinfoService;
import com.liveneo.plat.service.impl.WorkOrderService;
import com.liveneo.plat.service.impl.WorkstationService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.WorkstationForm;

public class WorkstationAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private WorkstationService workstationService;
	private CustomerinfoService customerinfoService;
	private UserinfoService userinfoService;
	private String workstationKey;
	private WorkstationForm workstationForm;
	//查询条件
	private String queryfactorynamecn;
	private String queryfactorynameen;
	private String querywslinkman;
	private String queryphoneno;

	public String execute() {
		return SUCCESS;
	}

	public String addWorkstation() {
		workstationForm = new WorkstationForm();
		workstationKey = "";
		return SUCCESS;
	}

//	public String batchUserinfo() {
//		userinfoForm = new UserinfoForm();
//		// userinfoKey = "";
//		return "returnToBatchUser";
//	}

	public String editWorkstation() {
		try {
			workstationForm = new WorkstationForm();
			Workstation workstation = new Workstation();
			if (StringUtils.isNotEmpty(workstationKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("workstationKey")))
					workstationKey = (String) this.getSession().getAttribute(
							"workstationKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			workstation = this.workstationService.getWorkstation(IntegerUtil
					.converStrToInteger(workstationKey));
			WebappUtil.copyProperties(workstationForm, workstation);
			this.getSession().setAttribute("workstationForm", workstationForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveWorkstation() {
		Boolean cn=true;
		Boolean en=true;
		try {
			Workstation workstation = new Workstation();
			if (StringUtils.isNotEmpty(workstationKey)) {
				workstation = this.workstationService.getWorkstation(IntegerUtil
						.converStrToInteger(workstationKey));
				WebappUtil.copyProperties(workstation, workstationForm);
				//坐席登陆是更新状态
				//用户名唯一
				cn=this.workstationService.checkFactorynamecn(workstation);
				en=this.workstationService.checkFactorynameen(workstation);
				if(!cn){
					return ajaxForwardError(getText("工厂名称重复！"));
				}
				if(!en){
					return ajaxForwardError(getText("工厂英文名称重复！"));
				}
				this.workstationService.update(workstation);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", workstation.toString(), Workstation.REF);
			} else {
				WebappUtil.copyProperties(workstation, workstationForm);
				cn=this.workstationService.checkFactorynamecn(workstation);
				en=this.workstationService.checkFactorynameen(workstation);
				if(!cn){
					return ajaxForwardError(getText("工厂名称重复！"));
				}
				if(!en){
					return ajaxForwardError(getText("工厂英文名称重复！"));
				}
				this.workstationService.add(workstation);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", workstation.toString(), Workstation.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listWorkstation() {
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
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryfactorynamecn("");
			this.setQueryfactorynameen("");
		}
		List<Workstation> l = this.workstationService.findWorkstationBySql(this.getDetachedCriteria(), startIndex, numPerPage);

		this.getSession().setAttribute("workstationList", l);
		int i = 0;
		i = this.workstationService.queryCountWorkstation(this.getDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

//	private String getHql(int startIndex, int pageNum) {
//		String hql = "select * from Userinfo where PK_USERINFO >0 ";
//
//		if (StringUtils.isNotEmpty(queryusername)) {
//			hql += " and UserName like '%" + queryusername + "%'";
//		}
//		if (StringUtils.isNotEmpty(queryextension)) {
//			hql += " and Extension like '%" + queryextension + "%'";
//		}
//		hql += " and Isadmin = 'false'";
//		// System.out.println("realOrderField:" + realOrderField());
//		if (StringUtils.isNotEmpty(realOrderField())) {
//			hql += " order by " + realOrderField();
//		} else {
//			hql += " order by Extension";
//		}
//		hql += " LIMIT " + startIndex + "," + pageNum;
//		return hql;
//	}

//	private String getHql() {
//		String hql = "from Userinfo where PK_USERINFO >0 ";
//
//		if (StringUtils.isNotEmpty(queryusername)) {
//			hql += " and UserName like '%" + queryusername + "%'";
//		}
//
//		
//
//		return hql;
//	}
//	private String querywslinkman;
//	private String queryphoneno;
	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workstation.class);
		// detachedCriteria.addOrder(Order.asc(Userinfo.PROP_ID));
		if (StringUtils.isNotEmpty(queryfactorynamecn)) {
			detachedCriteria.add(Restrictions.ilike(Workstation.PROP_FACTORYNAMECN,
					queryfactorynamecn, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryfactorynameen)) {
			detachedCriteria.add(Restrictions.ilike(Workstation.PROP_FACTORYNAMEEN,
					queryfactorynameen, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querywslinkman)) {
			detachedCriteria.add(Restrictions.ilike(Workstation.PROP_WSLINKMAN,
					querywslinkman, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryphoneno)) {
			detachedCriteria.add(Restrictions.ilike(Workstation.PROP_PHONENO,
					queryphoneno, MatchMode.ANYWHERE));
		}
		return detachedCriteria;
	}

	public String deleteWorkstation() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					List<Customerinfo> listCustomerinfo=this.customerinfoService.queryCustomerByWS(this.workstationService.getWorkstation(key));
					List<Userinfo> listUserinfo=this.userinfoService.queryUserinfoByWS(this.workstationService.getWorkstation(key));
					System.out.println(listCustomerinfo.size()+"---"+listUserinfo.size());
					if(listCustomerinfo.size()>0 || listUserinfo.size()>0){
						return ajaxForwardError(getText("该资源已被使用！"));
					}
					this.workstationService.delWorkstation(key);
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					 "LOGTYPE-SC", "delete:" + selectIDS.toString(), Workstation.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}
//	public String exceldialog() {
//		return SUCCESS;
//	}
	public WorkstationService getWorkstationService() {
		return workstationService;
	}

	public void setWorkstationService(WorkstationService workstationService) {
		this.workstationService = workstationService;
	}

	public String getWorkstationKey() {
		return workstationKey;
	}

	public void setWorkstationKey(String workstationKey) {
		this.workstationKey = workstationKey;
	}

	public WorkstationForm getWorkstationForm() {
		return workstationForm;
	}

	public void setWorkstationForm(WorkstationForm workstationForm) {
		this.workstationForm = workstationForm;
	}

	public String getQueryfactorynamecn() {
		return queryfactorynamecn;
	}

	public void setQueryfactorynamecn(String queryfactorynamecn) {
		this.queryfactorynamecn = queryfactorynamecn;
	}

	public String getQueryfactorynameen() {
		return queryfactorynameen;
	}

	public void setQueryfactorynameen(String queryfactorynameen) {
		this.queryfactorynameen = queryfactorynameen;
	}

	public String getQuerywslinkman() {
		return querywslinkman;
	}

	public void setQuerywslinkman(String querywslinkman) {
		this.querywslinkman = querywslinkman;
	}

	public String getQueryphoneno() {
		return queryphoneno;
	}

	public void setQueryphoneno(String queryphoneno) {
		this.queryphoneno = queryphoneno;
	}

	public CustomerinfoService getCustomerinfoService() {
		return customerinfoService;
	}

	public void setCustomerinfoService(CustomerinfoService customerinfoService) {
		this.customerinfoService = customerinfoService;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	
}
