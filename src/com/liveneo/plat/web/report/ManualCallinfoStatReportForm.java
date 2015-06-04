package com.liveneo.plat.web.report;

import com.liveneo.plat.web.form.base.BaseForm;

public class ManualCallinfoStatReportForm extends BaseForm {


	private java.lang.String statTime;
	private java.lang.String time;
	private java.lang.String skillId;
	private java.math.BigDecimal ivrTransfNum;
	private java.math.BigDecimal answerNum;
	private java.math.BigDecimal answerRate;
	private java.math.BigDecimal avgsuccWaitTime;
	private java.math.BigDecimal avgTalkingTime;
	public java.lang.String getSkillId() {
		return skillId;
	}
	public void setSkillId(java.lang.String skillId) {
		this.skillId = skillId;
	}
	public java.lang.String getStatTime() {
		return statTime;
	}
	public void setStatTime(java.lang.String statTime) {
		this.statTime = statTime;
	}
	public java.lang.String getTime() {
		return time;
	}
	public void setTime(java.lang.String time) {
		this.time = time;
	}
	public java.math.BigDecimal getIvrTransfNum() {
		return ivrTransfNum;
	}
	public void setIvrTransfNum(java.math.BigDecimal ivrTransfNum) {
		this.ivrTransfNum = ivrTransfNum;
	}
	public java.math.BigDecimal getAnswerNum() {
		return answerNum;
	}
	public void setAnswerNum(java.math.BigDecimal answerNum) {
		this.answerNum = answerNum;
	}
	public java.math.BigDecimal getAnswerRate() {
		return answerRate;
	}
	public void setAnswerRate(java.math.BigDecimal answerRate) {
		this.answerRate = answerRate;
	}
	public java.math.BigDecimal getAvgsuccWaitTime() {
		return avgsuccWaitTime;
	}
	public void setAvgsuccWaitTime(java.math.BigDecimal avgsuccWaitTime) {
		this.avgsuccWaitTime = avgsuccWaitTime;
	}
	public java.math.BigDecimal getAvgTalkingTime() {
		return avgTalkingTime;
	}
	public void setAvgTalkingTime(java.math.BigDecimal avgTalkingTime) {
		this.avgTalkingTime = avgTalkingTime;
	}
	
}
