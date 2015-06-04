package com.liveneo.plat.web.report;

import com.liveneo.plat.web.form.base.BaseForm;

public class AgentinfoForm extends BaseForm {


//	座席签入ID--
	private java.lang.String agentLoginID;
//	、座席工号--
	private java.lang.String agentID;
//	、座席分机--;
	private java.lang.String agentDN;
//	、签入时间--
	private java.lang.String loginTime;
//	、签出时间--
	private java.lang.String logoutTime ;
//	签入时长（秒）--
	private java.lang.String loginlenth;
	public java.lang.String getAgentLoginID() {
		return agentLoginID;
	}
	public void setAgentLoginID(java.lang.String agentLoginID) {
		this.agentLoginID = agentLoginID;
	}
	public java.lang.String getAgentID() {
		return agentID;
	}
	public void setAgentID(java.lang.String agentID) {
		this.agentID = agentID;
	}
	public java.lang.String getAgentDN() {
		return agentDN;
	}
	public void setAgentDN(java.lang.String agentDN) {
		this.agentDN = agentDN;
	}
	public java.lang.String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(java.lang.String loginTime) {
		this.loginTime = loginTime;
	}
	public java.lang.String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(java.lang.String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public java.lang.String getLoginlenth() {
		return loginlenth;
	}
	public void setLoginlenth(java.lang.String loginlenth) {
		this.loginlenth = loginlenth;
	}
	
	
}
