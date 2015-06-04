package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.quartz.CronTriggerBean;

import com.liveneo.plat.constants.GlobalConstants;
import com.liveneo.plat.hibernate.dao.BdJobmsg;
import com.liveneo.plat.service.impl.JobmsgService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.JobmsgForm;


public class JobmsgAction extends AbstractActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JobmsgService jobmsgService;
	private JobmsgForm jobmsgForm;
	private Scheduler scheduler;
	private String jobmsgKey;
	private String queryjobname;
	private String queryjobstate;
	
	public String rule(){
		return SUCCESS;
	}
	public String addJobmsg() {
		jobmsgForm = new JobmsgForm();
		jobmsgKey = "";
		return SUCCESS;
	}
	public String editJobmsg() {
		try {
			jobmsgForm = new JobmsgForm();
			BdJobmsg bdJobmsg = new BdJobmsg();
			if (StringUtils.isNotEmpty(jobmsgKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("jobmsgKey")))
					jobmsgKey = (String) this.getSession().getAttribute(
							"jobmsgKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			bdJobmsg = this.jobmsgService.getBdJobmsg(IntegerUtil
					.converStrToInteger(jobmsgKey));
			WebappUtil.copyProperties(jobmsgForm, bdJobmsg);
			this.getSession().setAttribute("jobmsgForm", jobmsgForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}
	
	public String editBackupJob(){
		try {
			jobmsgForm = new JobmsgForm();
			BdJobmsg bdJobmsg = new BdJobmsg();
			bdJobmsg=this.jobmsgService.queryBdJobmsgByBeanname("backupTrigger");
			if (null == bdJobmsg) {
					return ajaxForwardError("系统错误！");
			}else{
				WebappUtil.copyProperties(jobmsgForm, bdJobmsg);
				this.getSession().setAttribute("jobmsgKey", bdJobmsg.getId());
				this.getSession().setAttribute("jobmsgForm", jobmsgForm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AbstractActionSupport.EDIT;
	}
	public String saveJobmsg() {
		Boolean c=true;
		String cronExpression="";
		try {
			BdJobmsg bdJobmsg = new BdJobmsg();
			if (StringUtils.isNotEmpty(jobmsgKey)) {
				bdJobmsg = this.jobmsgService.getBdJobmsg(IntegerUtil
						.converStrToInteger(jobmsgKey));
				//更新数据
				WebappUtil.copyProperties(bdJobmsg, jobmsgForm);
				bdJobmsg.setLastModifyTime(new Date());
				cronExpression=bdJobmsg.getJobSecond()+" "+bdJobmsg.getJobMinute()+" "+bdJobmsg.getJobHour()+" "+bdJobmsg.getJobDay()+" "+bdJobmsg.getJobMonth()+" "+bdJobmsg.getJobWeek()+" "+bdJobmsg.getJobYear();
				if(org.quartz.CronExpression.isValidExpression(cronExpression)){
					bdJobmsg.setCronExpression(cronExpression);
				}else{
					return ajaxForwardError(getText("执行时间设置错误！"));
				}
				
				c=this.jobmsgService.checkBeanname(bdJobmsg);
				if(!c){
					return ajaxForwardError(getText("Bean名称不能重复！"));
				}
				this.jobmsgService.update(bdJobmsg);
				//更新定时任务执行时间
				//实时刷新定时任务时间
				String jobBeanName = bdJobmsg.getJobBeanname();
				String dbCronexpression = "";
				if(bdJobmsg.getJobState().equals(GlobalConstants.JOBSTATUS_VALUE_OPEN)){
					dbCronexpression = bdJobmsg.getCronExpression();
				} else{
					dbCronexpression = "* * * * * ? 2099";
				}
				reScheduleJob(jobBeanName, dbCronexpression);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", bdJobmsg.toString(), bdJobmsg.REF);
			} else {
				WebappUtil.copyProperties(bdJobmsg, jobmsgForm);
				bdJobmsg.setCreateTime(new Date());
				cronExpression=bdJobmsg.getJobSecond()+" "+bdJobmsg.getJobMinute()+" "+bdJobmsg.getJobHour()+" "+bdJobmsg.getJobDay()+" "+bdJobmsg.getJobMonth()+" "+bdJobmsg.getJobWeek()+" "+bdJobmsg.getJobYear();
				if(org.quartz.CronExpression.isValidExpression(cronExpression)){
					bdJobmsg.setCronExpression(cronExpression);
				}else{
					return ajaxForwardError(getText("执行时间设置错误！"));
				}
				c=this.jobmsgService.checkBeanname(bdJobmsg);
				if(!c){
					return ajaxForwardError(getText("Bean名称不能重复！"));
				}
				this.jobmsgService.add(bdJobmsg);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", bdJobmsg.toString(), bdJobmsg.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}
	public void reScheduleJob(String jobBeanName,String dbCronexpression){
//		 运行时可通过动态注入的scheduler得到trigger
		CronTriggerBean trigger;
		try {
			scheduler=StdSchedulerFactory.getDefaultScheduler();
			trigger = (CronTriggerBean) scheduler.getTrigger(
			      jobBeanName, Scheduler.DEFAULT_GROUP);
			if(trigger != null){
				System.out.println("时间："+trigger.getCronExpression());
				trigger.setCronExpression(dbCronexpression);
		        scheduler.rescheduleJob(jobBeanName, Scheduler.DEFAULT_GROUP, trigger);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String listJobmsg() {
//		Map<String,String> map=(Map)this.getSession().getServletContext().getAttribute(GlobalConstants.SYSTEM_LICENSE_INFO);
		int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
				.converStrToInteger(this.getPageNum()) - 1
				: 0;
		int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
		int startIndex = pageNum
				* IntegerUtil.converStrToInteger(getNumPerPage());
		
		String search=this.getRequest().getParameter("search");
		if(StringUtils.equalsIgnoreCase(search, "true")){
			startIndex = 0
			* IntegerUtil.converStrToInteger(getNumPerPage());
		}
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryjobname("");
			this.setQueryjobstate("");
		}
		List<BdJobmsg> l = this.jobmsgService.findJobmsgBySql(getHql(
				startIndex, numPerPage));
		this.getSession().setAttribute("userinfoList", l);
		int i = 0;
		i = this.jobmsgService.queryCountJobmsg(this.getDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int numPerPage) {
		String hql = "select * from bd_jobmsg where Job_id >0 ";

		if (StringUtils.isNotEmpty(queryjobname)) {
			hql += " and Job_name like '%" + queryjobname + "%'";
		}
		if (StringUtils.isNotEmpty(queryjobstate)) {
			hql += " and Job_state = '" + queryjobstate + "'";
		}
		hql += " limit " + startIndex + "," + numPerPage;
		return hql;
	}

	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BdJobmsg.class);
		if (StringUtils.isNotEmpty(queryjobname)) {
			detachedCriteria.add(Restrictions.ilike(BdJobmsg.PROP_JOB_NAME,
					queryjobname, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryjobstate)) {
			detachedCriteria.add(Restrictions.eq(BdJobmsg.PROP_JOB_STATE,
					queryjobstate));
		}
		return detachedCriteria;
	}
	public String deleteJobmsg(){
		try{
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if(StringUtils.isNotEmpty(selectIDS)){
				List<String> keyList = new ArrayList<String>();
				keyList = ListUtil.ConvertArrayToStringList(StringUtils.split(selectIDS,','), "String");
				if (keyList != null) {
					for (String key : keyList) {
						this.jobmsgService.deleteJobmsg(IntegerUtil.converStrToInteger(key));
					}
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(), "LOGTYPE-SC", "delete jobmsg", BdJobmsg.REF);
			return ajaxForwardSuccess(getText("删除成功!"));
		}catch(Exception ex){
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}
	
	public JobmsgService getJobmsgService() {
		return jobmsgService;
	}
	public void setJobmsgService(JobmsgService jobmsgService) {
		this.jobmsgService = jobmsgService;
	}
	public JobmsgForm getJobmsgForm() {
		return jobmsgForm;
	}
	public void setJobmsgForm(JobmsgForm jobmsgForm) {
		this.jobmsgForm = jobmsgForm;
	}
	public String getJobmsgKey() {
		return jobmsgKey;
	}
	public void setJobmsgKey(String jobmsgKey) {
		this.jobmsgKey = jobmsgKey;
	}
	public String getQueryjobname() {
		return queryjobname;
	}
	public void setQueryjobname(String queryjobname) {
		this.queryjobname = queryjobname;
	}
	public String getQueryjobstate() {
		return queryjobstate;
	}
	public void setQueryjobstate(String queryjobstate) {
		this.queryjobstate = queryjobstate;
	}
	public Scheduler getScheduler() {
		return scheduler;
	}
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
	
}
