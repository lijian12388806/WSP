package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class OrderProductsForm extends BaseForm {

	private static final long serialVersionUID = 1L;
	private java.lang.String pkOrder;
	private java.lang.String pkProduct;
	private java.lang.String productlocate;
	private java.lang.String lictype;
	private java.lang.String applytime;
	private java.lang.String gentime;
	private java.lang.String licdays;
	private java.lang.String hostid;
	private java.lang.String licfile;
	private java.lang.String remark;
	public java.lang.String getApplytime() {
		return applytime;
	}
	public void setApplytime(java.lang.String applytime) {
		this.applytime = applytime;
	}
	public java.lang.String getGentime() {
		return gentime;
	}
	public void setGentime(java.lang.String gentime) {
		this.gentime = gentime;
	}
	public java.lang.String getHostid() {
		return hostid;
	}
	public void setHostid(java.lang.String hostid) {
		this.hostid = hostid;
	}
	public java.lang.String getLicdays() {
		return licdays;
	}
	public void setLicdays(java.lang.String licdays) {
		this.licdays = licdays;
	}
	public java.lang.String getLicfile() {
		return licfile;
	}
	public void setLicfile(java.lang.String licfile) {
		this.licfile = licfile;
	}
	public java.lang.String getLictype() {
		return lictype;
	}
	public void setLictype(java.lang.String lictype) {
		this.lictype = lictype;
	}
	public java.lang.String getPkOrder() {
		return pkOrder;
	}
	public void setPkOrder(java.lang.String pkOrder) {
		this.pkOrder = pkOrder;
	}
	public java.lang.String getPkProduct() {
		return pkProduct;
	}
	public void setPkProduct(java.lang.String pkProduct) {
		this.pkProduct = pkProduct;
	}
	public java.lang.String getProductlocate() {
		return productlocate;
	}
	public void setProductlocate(java.lang.String productlocate) {
		this.productlocate = productlocate;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

}
