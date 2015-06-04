package com.liveneo.plat.web.task;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.scheduling.quartz.CronTriggerBean;

import com.liveneo.plat.constants.GlobalConstants;
import com.liveneo.plat.hibernate.dao.BdJobmsg;
import com.liveneo.plat.service.iface.JobmsgServiceIface;


public class InitializingCronTrigger extends CronTriggerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private JobmsgServiceIface jobmsgService;
	private String jobBeanName;

	public InitializingCronTrigger(String jobBeanName) {
		this.jobBeanName = jobBeanName;
	}
	private String getCronExpressionFromDB() {
		System.out.println("定时器启动...");
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BdJobmsg.class);
		detachedCriteria.add(Restrictions.eq(BdJobmsg.PROP_JOB_BEANNAME, getJobBeanName()));
		System.out.println("jobname:"+getJobBeanName());
		List<BdJobmsg> jobInfoList = jobmsgService.queryJobmsg(detachedCriteria);
		BdJobmsg jobInfo = new BdJobmsg();
		String dbCronExpression = "";
		if(jobInfoList.size() > 0){
			jobInfo = jobInfoList.get(0);
			dbCronExpression = jobInfo.getCronExpression();
			if(jobInfo.getJobState().equals(GlobalConstants.JOBSTATUS_VALUE_CLOSE)){
				dbCronExpression = "* * * * * ? 2099";
			}
		}else{
			dbCronExpression = "* * * * * ? 2099";
		}
		return dbCronExpression;
	}
	// 设值注入，通过setter方法传入被调用者的实例scheduleInfoManager，不用默认的setter
	public void setJobmsgService(JobmsgServiceIface jobDetailService)
			throws ParseException {
		this.jobmsgService = jobDetailService;
		// 因为在getCronExpressionFromDB使用到了scheduleInfoManager，所以
		// 必须上一行代码设置scheduleInfoManager后进行getCronExpressionFromDB
		String cronExpression = getCronExpressionFromDB();
		// 调用父类方法初始化cronExpression
		setCronExpression(cronExpression);
	}
	public String getJobBeanName() {
		return jobBeanName;
	}
	public JobmsgServiceIface getJobmsgService() {
		return jobmsgService;
	}
	
	
}
