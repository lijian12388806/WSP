package com.liveneo.plat.web.report;

import com.liveneo.plat.web.form.base.BaseForm;

public class CallinfoForm extends BaseForm {


//	座席签入ID--
	private java.lang.String agentLoginID;
//	、座席工号--
	private java.lang.String agentID;
//	、座席分机--;
	private java.lang.String agentDN;
	
//	联络ID--
	private java.lang.String contactID;
//	、主叫-
	private java.lang.String oriANI;
//	、被叫--
	private java.lang.String oriDNIS;
//	、呼叫方向（1呼 入2呼出）--
	private java.lang.String callDirection;
//	、呼叫类型（1外部呼叫2内部呼叫）--
	private java.lang.String callType;
//	、呼叫开始时间--
	private java.lang.String startTime;
//	、呼叫结束时间--
	private java.lang.String endTime;
//	、呼叫时长--
	private java.lang.String talkinglen;

	
	public java.lang.String getContactID() {
		return contactID;
	}
	public void setContactID(java.lang.String contactID) {
		this.contactID = contactID;
	}
	public java.lang.String getOriANI() {
		return oriANI;
	}
	public void setOriANI(java.lang.String oriANI) {
		this.oriANI = oriANI;
	}
	public java.lang.String getOriDNIS() {
		return oriDNIS;
	}
	public void setOriDNIS(java.lang.String oriDNIS) {
		this.oriDNIS = oriDNIS;
	}
	public java.lang.String getCallDirection() {
		return callDirection;
	}
	public void setCallDirection(java.lang.String callDirection) {
		this.callDirection = callDirection;
	}
	public java.lang.String getCallType() {
		return callType;
	}
	public void setCallType(java.lang.String callType) {
		this.callType = callType;
	}
	public java.lang.String getStartTime() {
		return startTime;
	}
	public void setStartTime(java.lang.String startTime) {
		this.startTime = startTime;
	}
	public java.lang.String getEndTime() {
		return endTime;
	}
	public void setEndTime(java.lang.String endTime) {
		this.endTime = endTime;
	}
	public java.lang.String getTalkinglen() {
		return talkinglen;
	}
	public void setTalkinglen(java.lang.String talkinglen) {
		this.talkinglen = talkinglen;
	}
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
	
	
}
