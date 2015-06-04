package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class OrderProductFeaturesForm extends BaseForm {

	private static final long serialVersionUID = 1L;
	private java.lang.String pkOrderproduct;
	private java.lang.String pkFeature;
	private java.lang.String authorizednumber;
	private java.lang.String expirationDate;
	private java.lang.String remark;
	public java.lang.String getAuthorizednumber() {
		return authorizednumber;
	}
	public void setAuthorizednumber(java.lang.String authorizednumber) {
		this.authorizednumber = authorizednumber;
	}
	public java.lang.String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(java.lang.String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public java.lang.String getPkFeature() {
		return pkFeature;
	}
	public void setPkFeature(java.lang.String pkFeature) {
		this.pkFeature = pkFeature;
	}
	public java.lang.String getPkOrderproduct() {
		return pkOrderproduct;
	}
	public void setPkOrderproduct(java.lang.String pkOrderproduct) {
		this.pkOrderproduct = pkOrderproduct;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

}
