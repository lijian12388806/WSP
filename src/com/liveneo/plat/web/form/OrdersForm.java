package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class OrdersForm extends BaseForm {

	private static final long serialVersionUID = 1L;
	private java.lang.String pkCustomer;
	private java.lang.String orderno;
	private java.lang.String orderdesc;
	private java.lang.String orderstatus;
	private java.lang.String remark;
	public java.lang.String getOrderdesc() {
		return orderdesc;
	}
	public void setOrderdesc(java.lang.String orderdesc) {
		this.orderdesc = orderdesc;
	}
	public java.lang.String getOrderno() {
		return orderno;
	}
	public void setOrderno(java.lang.String orderno) {
		this.orderno = orderno;
	}
	public java.lang.String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(java.lang.String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public java.lang.String getPkCustomer() {
		return pkCustomer;
	}
	public void setPkCustomer(java.lang.String pkCustomer) {
		this.pkCustomer = pkCustomer;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

}
