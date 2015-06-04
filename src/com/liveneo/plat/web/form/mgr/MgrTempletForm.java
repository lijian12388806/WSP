package com.liveneo.plat.web.form.mgr;

import com.liveneo.plat.web.form.base.BaseForm;

public class MgrTempletForm extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String tmpCode;
	private String tmpName;
	private String tmpType;
	private String tmpStatus;
	private String tmpBtn;
	private String tmpListdata;
	private String tmpRelated;
	
	public String getTmpRelated() {
		return tmpRelated;
	}
	public void setTmpRelated(String tmpRelated) {
		this.tmpRelated = tmpRelated;
	}
	public java.lang.String getTmpCode() {
		return tmpCode;
	}
	public void setTmpCode(java.lang.String tmpCode) {
		this.tmpCode = tmpCode;
	}
	public java.lang.String getTmpName() {
		return tmpName;
	}
	public void setTmpName(java.lang.String tmpName) {
		this.tmpName = tmpName;
	}
	public java.lang.String getTmpType() {
		return tmpType;
	}
	public void setTmpType(java.lang.String tmpType) {
		this.tmpType = tmpType;
	}
	public java.lang.String getTmpStatus() {
		return tmpStatus;
	}
	public void setTmpStatus(java.lang.String tmpStatus) {
		this.tmpStatus = tmpStatus;
	}
	public String getTmpBtn() {
		return tmpBtn;
	}
	public void setTmpBtn(String tmpBtn) {
		this.tmpBtn = tmpBtn;
	}
	public String getTmpListdata() {
		return tmpListdata;
	}
	public void setTmpListdata(String tmpListdata) {
		this.tmpListdata = tmpListdata;
	}
}
