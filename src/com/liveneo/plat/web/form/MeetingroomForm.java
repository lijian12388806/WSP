package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class MeetingroomForm extends BaseForm {

	private static final long serialVersionUID = 1L;

	private java.lang.String roomname;
	private java.lang.String accessnumber;
	private java.lang.String participatepwd;
	private java.lang.String adminpwd;
	private java.lang.String status;
	private java.lang.String describ;
	private java.lang.String filename;
	public java.lang.String getAccessnumber() {
		return accessnumber;
	}
	public void setAccessnumber(java.lang.String accessnumber) {
		this.accessnumber = accessnumber;
	}
	public java.lang.String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(java.lang.String adminpwd) {
		this.adminpwd = adminpwd;
	}
	public java.lang.String getDescrib() {
		return describ;
	}
	public void setDescrib(java.lang.String describ) {
		this.describ = describ;
	}
	public java.lang.String getFilename() {
		return filename;
	}
	public void setFilename(java.lang.String filename) {
		this.filename = filename;
	}
	public java.lang.String getParticipatepwd() {
		return participatepwd;
	}
	public void setParticipatepwd(java.lang.String participatepwd) {
		this.participatepwd = participatepwd;
	}
	public java.lang.String getRoomname() {
		return roomname;
	}
	public void setRoomname(java.lang.String roomname) {
		this.roomname = roomname;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
}
