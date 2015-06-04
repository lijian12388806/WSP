package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the bd_jobmsg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_jobmsg"
 */

public abstract class BaseBdJobmsg  implements Serializable {

	public static String REF = "BdJobmsg";
	public static String PROP_JOB_SECOND = "JobSecond";
	public static String PROP_JOB_DAY = "JobDay";
	public static String PROP_REMARK = "Remark";
	public static String PROP_JOB_HOUR = "JobHour";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_CRON_EXPRESSION = "CronExpression";
	public static String PROP_JOB_WEEK = "JobWeek";
	public static String PROP_JOB_BEANNAME = "JobBeanname";
	public static String PROP_JOB_STATE = "JobState";
	public static String PROP_CREATE_OPER = "CreateOper";
	public static String PROP_JOB_MINUTE = "JobMinute";
	public static String PROP_JOB_NAME = "JobName";
	public static String PROP_LAST_MODIFY_TIME = "LastModifyTime";
	public static String PROP_JOB_MONTH = "JobMonth";
	public static String PROP_JOB_YEAR = "JobYear";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdJobmsg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdJobmsg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String jobName;
	private java.lang.String cronExpression;
	private java.lang.String jobState;
	private java.util.Date createTime;
	private java.util.Date lastModifyTime;
	private java.lang.String createOper;
	private java.lang.String jobYear;
	private java.lang.String jobMonth;
	private java.lang.String jobDay;
	private java.lang.String jobWeek;
	private java.lang.String jobHour;
	private java.lang.String jobMinute;
	private java.lang.String jobSecond;
	private java.lang.String jobBeanname;
	private java.lang.String remark;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="Job_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: Job_name
	 */
	public java.lang.String getJobName () {
		return jobName;
	}

	/**
	 * Set the value related to the column: Job_name
	 * @param jobName the Job_name value
	 */
	public void setJobName (java.lang.String jobName) {
		this.jobName = jobName;
	}



	/**
	 * Return the value associated with the column: CronExpression
	 */
	public java.lang.String getCronExpression () {
		return cronExpression;
	}

	/**
	 * Set the value related to the column: CronExpression
	 * @param cronExpression the CronExpression value
	 */
	public void setCronExpression (java.lang.String cronExpression) {
		this.cronExpression = cronExpression;
	}



	/**
	 * Return the value associated with the column: Job_state
	 */
	public java.lang.String getJobState () {
		return jobState;
	}

	/**
	 * Set the value related to the column: Job_state
	 * @param jobState the Job_state value
	 */
	public void setJobState (java.lang.String jobState) {
		this.jobState = jobState;
	}



	/**
	 * Return the value associated with the column: Create_time
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: Create_time
	 * @param createTime the Create_time value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: Last_modify_time
	 */
	public java.util.Date getLastModifyTime () {
		return lastModifyTime;
	}

	/**
	 * Set the value related to the column: Last_modify_time
	 * @param lastModifyTime the Last_modify_time value
	 */
	public void setLastModifyTime (java.util.Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}



	/**
	 * Return the value associated with the column: Create_oper
	 */
	public java.lang.String getCreateOper () {
		return createOper;
	}

	/**
	 * Set the value related to the column: Create_oper
	 * @param createOper the Create_oper value
	 */
	public void setCreateOper (java.lang.String createOper) {
		this.createOper = createOper;
	}



	/**
	 * Return the value associated with the column: Job_year
	 */
	public java.lang.String getJobYear () {
		return jobYear;
	}

	/**
	 * Set the value related to the column: Job_year
	 * @param jobYear the Job_year value
	 */
	public void setJobYear (java.lang.String jobYear) {
		this.jobYear = jobYear;
	}



	/**
	 * Return the value associated with the column: Job_month
	 */
	public java.lang.String getJobMonth () {
		return jobMonth;
	}

	/**
	 * Set the value related to the column: Job_month
	 * @param jobMonth the Job_month value
	 */
	public void setJobMonth (java.lang.String jobMonth) {
		this.jobMonth = jobMonth;
	}



	/**
	 * Return the value associated with the column: Job_day
	 */
	public java.lang.String getJobDay () {
		return jobDay;
	}

	/**
	 * Set the value related to the column: Job_day
	 * @param jobDay the Job_day value
	 */
	public void setJobDay (java.lang.String jobDay) {
		this.jobDay = jobDay;
	}



	/**
	 * Return the value associated with the column: Job_week
	 */
	public java.lang.String getJobWeek () {
		return jobWeek;
	}

	/**
	 * Set the value related to the column: Job_week
	 * @param jobWeek the Job_week value
	 */
	public void setJobWeek (java.lang.String jobWeek) {
		this.jobWeek = jobWeek;
	}



	/**
	 * Return the value associated with the column: Job_hour
	 */
	public java.lang.String getJobHour () {
		return jobHour;
	}

	/**
	 * Set the value related to the column: Job_hour
	 * @param jobHour the Job_hour value
	 */
	public void setJobHour (java.lang.String jobHour) {
		this.jobHour = jobHour;
	}



	/**
	 * Return the value associated with the column: Job_minute
	 */
	public java.lang.String getJobMinute () {
		return jobMinute;
	}

	/**
	 * Set the value related to the column: Job_minute
	 * @param jobMinute the Job_minute value
	 */
	public void setJobMinute (java.lang.String jobMinute) {
		this.jobMinute = jobMinute;
	}



	/**
	 * Return the value associated with the column: Job_second
	 */
	public java.lang.String getJobSecond () {
		return jobSecond;
	}

	/**
	 * Set the value related to the column: Job_second
	 * @param jobSecond the Job_second value
	 */
	public void setJobSecond (java.lang.String jobSecond) {
		this.jobSecond = jobSecond;
	}



	/**
	 * Return the value associated with the column: Job_beanName
	 */
	public java.lang.String getJobBeanname () {
		return jobBeanname;
	}

	/**
	 * Set the value related to the column: Job_beanName
	 * @param jobBeanname the Job_beanName value
	 */
	public void setJobBeanname (java.lang.String jobBeanname) {
		this.jobBeanname = jobBeanname;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.BdJobmsg)) return false;
		else {
			com.liveneo.plat.hibernate.dao.BdJobmsg bdJobmsg = (com.liveneo.plat.hibernate.dao.BdJobmsg) obj;
			if (null == this.getId() || null == bdJobmsg.getId()) return false;
			else return (this.getId().equals(bdJobmsg.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	 public String toString () {
		return super.toString();
	}



}