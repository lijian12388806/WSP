package com.liveneo.plat.web.report;

import com.liveneo.plat.web.form.base.BaseForm;

public class AgentKpiReportForm extends BaseForm {

	
	private java.lang.String statTime;
	private java.lang.String skillId;
	private java.math.BigDecimal onlineTime;
	private java.math.BigDecimal taikingTime;
	private java.math.BigDecimal wrapupTime;
	private java.math.BigDecimal idleTime;
	private java.math.BigDecimal restTime;
	private java.math.BigDecimal otherTime;
	private java.math.BigDecimal agentWorkRate;
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
	public java.math.BigDecimal getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(java.math.BigDecimal onlineTime) {
		this.onlineTime = onlineTime;
	}
	public java.math.BigDecimal getTaikingTime() {
		return taikingTime;
	}
	public void setTaikingTime(java.math.BigDecimal taikingTime) {
		this.taikingTime = taikingTime;
	}
	public java.math.BigDecimal getWrapupTime() {
		return wrapupTime;
	}
	public void setWrapupTime(java.math.BigDecimal wrapupTime) {
		this.wrapupTime = wrapupTime;
	}
	public java.math.BigDecimal getIdleTime() {
		return idleTime;
	}
	public void setIdleTime(java.math.BigDecimal idleTime) {
		this.idleTime = idleTime;
	}
	public java.math.BigDecimal getRestTime() {
		return restTime;
	}
	public void setRestTime(java.math.BigDecimal restTime) {
		this.restTime = restTime;
	}
	public java.math.BigDecimal getOtherTime() {
		return otherTime;
	}
	public void setOtherTime(java.math.BigDecimal otherTime) {
		this.otherTime = otherTime;
	}
	public java.math.BigDecimal getAgentWorkRate() {
		return agentWorkRate;
	}
	public void setAgentWorkRate(java.math.BigDecimal agentWorkRate) {
		this.agentWorkRate = agentWorkRate;
	}
}
