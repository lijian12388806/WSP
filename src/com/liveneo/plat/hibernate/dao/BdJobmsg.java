package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseBdJobmsg;



public class BdJobmsg extends BaseBdJobmsg {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdJobmsg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdJobmsg (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_JOB_NAME,this.getJobName())
					.append(this.PROP_CRON_EXPRESSION,this.getCronExpression())
					.append(this.PROP_JOB_STATE,this.getJobState())
					.append(this.PROP_CREATE_TIME,this.getCreateTime())
					.append(this.PROP_LAST_MODIFY_TIME,this.getLastModifyTime())
					.append(this.PROP_CREATE_OPER,this.getCreateOper())
					.append(this.PROP_JOB_YEAR,this.getJobYear())
					.append(this.PROP_JOB_MONTH,this.getJobMonth())
					.append(this.PROP_JOB_DAY,this.getJobDay())
					.append(this.PROP_JOB_WEEK,this.getJobWeek())
					.append(this.PROP_JOB_HOUR,this.getJobHour())
					.append(this.PROP_JOB_MINUTE,this.getJobMinute())
					.append(this.PROP_JOB_SECOND,this.getJobSecond())
					.append(this.PROP_JOB_BEANNAME,this.getJobBeanname())
					.append(this.PROP_REMARK,this.getRemark())
				 .toString();
	}
}