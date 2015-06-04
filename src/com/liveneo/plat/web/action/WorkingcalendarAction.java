package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Workingcalendar;
import com.liveneo.plat.service.impl.WorkingcalendarService;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.WorkingcalendarForm;



public class WorkingcalendarAction extends AbstractActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WorkingcalendarService workingcalendarService;
	private WorkingcalendarForm workingcalendarForm;
	
	private String workingcalendarKey;
	private String queryworkingdate;
	private String queryisvacation;
	public String execute() {
		return SUCCESS;
	}

	public String addWorkingcalendar() {
		workingcalendarForm = new WorkingcalendarForm();
		workingcalendarKey = "";
		return SUCCESS;
	}
	public String editWorkingcalendar(){
		try {
			workingcalendarForm = new WorkingcalendarForm();
			Workingcalendar bdDict = new Workingcalendar();
			if (StringUtils.isNotEmpty(workingcalendarKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("workingcalendarKey")))
					workingcalendarKey = (String) this.getSession().getAttribute(
							"workingcalendarKey");
				else
					return AbstractActionSupport.EDIT;// 返回list
			}
			bdDict = this.workingcalendarService.getWorkstation(IntegerUtil
					.converStrToInteger(workingcalendarKey));
			WebappUtil.copyProperties(workingcalendarForm, bdDict);
			workingcalendarForm.setWorkingdate(DateUtil.formatDateByFormat(DateUtil.parseFormatDate(workingcalendarForm.getWorkingdate(), "yyyyMMdd"), "yyyy-MM-dd"));
			this.getSession().setAttribute("workingcalendarForm", workingcalendarForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}
	public String saveWorkingcalendar() {
		try {
			if (StringUtils.isNotEmpty(workingcalendarKey)) {
				Workingcalendar workingcalendar = this.workingcalendarService.getWorkstation(IntegerUtil
						.converStrToInteger(workingcalendarKey));
				if(null != workingcalendar){
					WebappUtil.copyProperties(workingcalendar, workingcalendarForm);
					workingcalendar.setWorkingdate(StringUtils.replace(workingcalendarForm.getWorkingdate(), "-", ""));
					List<Workingcalendar> list = this.workingcalendarService.queryByWorkingdate(workingcalendar.getWorkingdate());
					if(null != list){
						list.remove(workingcalendar);
						if(list.size()>0){
							return ajaxForwardError(getText("日期重复！"));	
						}
					}
					this.workingcalendarService.update(workingcalendar);
				}
				return ajaxForwardSuccess(getText("common.saveok"));
			} else {
				int start=IntegerUtil.converStrToInteger(StringUtils.replace(workingcalendarForm.getStarttime(), "-", ""));
				int stop=IntegerUtil.converStrToInteger(StringUtils.replace(workingcalendarForm.getStoptime(), "-", ""));
				if( start > stop){
					return ajaxForwardError(getText("时间段设置错误！"));
				}
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				  Date d1 = sdf.parse(workingcalendarForm.getStarttime());
				  Date d2 = sdf.parse(workingcalendarForm.getStoptime());
				  Integer daysBetween=DateUtil.getIntervalDays(d1, d2);
				  String workingdate=null;
				for(int i=0;i<=daysBetween;i++){
					Workingcalendar workingcalendar = new Workingcalendar();
					workingdate=DateUtil.addDay(DateUtil.formatDateByFormat(d1, "yyyy-MM-dd"), i);
					List<Workingcalendar> list=this.workingcalendarService.queryByWorkingdate(StringUtils.replace(workingdate, "-", ""));
					if(list.size()>0){
						workingcalendar=list.get(0);
						workingcalendar.setReamrk(workingcalendarForm.getReamrk());
						workingcalendar.setIsvacation(workingcalendarForm.getIsvacation());
						workingcalendar.setN1(workingcalendarForm.getN1());
						workingcalendar.setN2(workingcalendarForm.getN2());
						this.workingcalendarService.update(workingcalendar);
					}else{
						workingcalendar.setReamrk(workingcalendarForm.getReamrk());
						workingcalendar.setWorkingdate(StringUtils.replace(workingdate, "-", ""));
						workingcalendar.setIsvacation(workingcalendarForm.getIsvacation());
						workingcalendar.setN1(workingcalendarForm.getN1());
						workingcalendar.setN2(workingcalendarForm.getN2());
						this.workingcalendarService.add(workingcalendar);
					}
				}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} 
			}catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listWorkingcalendar() {
		try{
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
		}
		List<Workingcalendar> l = this.workingcalendarService.findWorkstationBySql(getSql(startIndex, numPerPage));
		this.getSession().setAttribute("workingcalendarList", l);
		int i = 0;
		i = this.workingcalendarService.queryCountWorkstation(this.getCountDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
		}catch(Exception e){
			e.getMessage();
			return AbstractActionSupport.LIST;
		}
	}

	private DetachedCriteria getCountDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workingcalendar.class);
		
		if(StringUtils.isNotEmpty(queryworkingdate)){
			detachedCriteria.add(Restrictions.eq(Workingcalendar.PROP_WORKINGDATE,StringUtils.replace(queryworkingdate, "-", "")));
		}
		if(StringUtils.isNotEmpty(queryisvacation)){
			detachedCriteria.add(Restrictions.eq(Workingcalendar.PROP_ISVACATION,queryisvacation));
		}
		return detachedCriteria;
	}
	private String getSql(int startIndex, int numPerPage) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from workingcalendar where PK_WORKINGCALENDAR >0 ");
		if(StringUtils.isNotEmpty(queryworkingdate)){
			sql.append(" and  WORKINGDATE ='"+StringUtils.replace(queryworkingdate, "-", "")+"'");
		}
		if(StringUtils.isNotEmpty(queryisvacation)){
			sql.append(" and  ISVACATION ='"+queryisvacation+"'");
		}
		sql.append(" ORDER BY WORKINGDATE LIMIT " + startIndex + "," + numPerPage);
		return sql.toString();
	}
	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workingcalendar.class);
		detachedCriteria.addOrder(Order.asc(Workingcalendar.PROP_WORKINGDATE));
		if(StringUtils.isNotEmpty(queryworkingdate)){
			detachedCriteria.add(Restrictions.eq(Workingcalendar.PROP_WORKINGDATE,StringUtils.replace(queryworkingdate, "-", "")));
		}
		if(StringUtils.isNotEmpty(queryisvacation)){
			detachedCriteria.add(Restrictions.eq(Workingcalendar.PROP_ISVACATION,queryisvacation));
		}
		return detachedCriteria;
	}
	public String deleteWorkingcalendar() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					this.workingcalendarService.delWorkingcalendar(key);
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					 "LOGTYPE-SC", "delete:" + selectIDS.toString(), Workingcalendar.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}

	public WorkingcalendarService getWorkingcalendarService() {
		return workingcalendarService;
	}

	public void setWorkingcalendarService(
			WorkingcalendarService workingcalendarService) {
		this.workingcalendarService = workingcalendarService;
	}

	public WorkingcalendarForm getWorkingcalendarForm() {
		return workingcalendarForm;
	}

	public void setWorkingcalendarForm(WorkingcalendarForm workingcalendarForm) {
		this.workingcalendarForm = workingcalendarForm;
	}

	public String getWorkingcalendarKey() {
		return workingcalendarKey;
	}

	public void setWorkingcalendarKey(String workingcalendarKey) {
		this.workingcalendarKey = workingcalendarKey;
	}

	public String getQueryworkingdate() {
		return queryworkingdate;
	}

	public void setQueryworkingdate(String queryworkingdate) {
		this.queryworkingdate = queryworkingdate;
	}

	public String getQueryisvacation() {
		return queryisvacation;
	}

	public void setQueryisvacation(String queryisvacation) {
		this.queryisvacation = queryisvacation;
	}
	public static void main(String[] args) {
		System.out.println(DateUtil.formatDateByFormat(DateUtil.parseFormatDate("20140630", "yyyyMMdd"), "yyyy-MM-dd"));
	}
	
}
