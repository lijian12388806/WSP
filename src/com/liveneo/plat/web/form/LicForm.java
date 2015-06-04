package com.liveneo.plat.web.form;

import java.util.List;

import com.liveneo.plat.web.form.base.BaseForm;

public class LicForm extends BaseForm {

	private static final long serialVersionUID = 1L;
	private java.lang.String orderno;
	private java.lang.String orderKey;
	private java.lang.String productKey;
	
	private java.lang.String platformType="VSS";
	private java.lang.String sid="1";
	private java.lang.String f_version="1.0";
	private java.lang.String genDate;
	private java.lang.String type = "enterprise";
	private java.lang.String lic_version = "1.0";
	private java.lang.String genTime;
	private java.lang.String hostID;
	private java.lang.String notes = "lic";
	private java.lang.String productName = "LCPV3";
	private java.lang.String productDisplayName = "Liveneo  Platform";
	private java.lang.String productVersion = "3.0.0";
	private List<FeatureForm> featureList;
	private java.lang.String signature;
	public java.lang.String getF_version() {
		return f_version;
	}
	public void setF_version(java.lang.String f_version) {
		this.f_version = f_version;
	}
	public java.lang.String getGenDate() {
		return genDate;
	}
	public void setGenDate(java.lang.String genDate) {
		this.genDate = genDate;
	}
	public java.lang.String getGenTime() {
		return genTime;
	}
	public void setGenTime(java.lang.String genTime) {
		this.genTime = genTime;
	}
	public java.lang.String getHostID() {
		return hostID;
	}
	public void setHostID(java.lang.String hostID) {
		this.hostID = hostID;
	}
	public java.lang.String getLic_version() {
		return lic_version;
	}
	public void setLic_version(java.lang.String lic_version) {
		this.lic_version = lic_version;
	}
	public java.lang.String getNotes() {
		return notes;
	}
	public void setNotes(java.lang.String notes) {
		this.notes = notes;
	}
	public java.lang.String getOrderKey() {
		return orderKey;
	}
	public void setOrderKey(java.lang.String orderKey) {
		this.orderKey = orderKey;
	}
	public java.lang.String getOrderno() {
		return orderno;
	}
	public void setOrderno(java.lang.String orderno) {
		this.orderno = orderno;
	}
	public java.lang.String getPlatformType() {
		return platformType;
	}
	public void setPlatformType(java.lang.String platformType) {
		this.platformType = platformType;
	}
	public java.lang.String getProductDisplayName() {
		return productDisplayName;
	}
	public void setProductDisplayName(java.lang.String productDisplayName) {
		this.productDisplayName = productDisplayName;
	}
	public java.lang.String getProductKey() {
		return productKey;
	}
	public void setProductKey(java.lang.String productKey) {
		this.productKey = productKey;
	}
	public java.lang.String getProductName() {
		return productName;
	}
	public void setProductName(java.lang.String productName) {
		this.productName = productName;
	}
	public java.lang.String getProductVersion() {
		return productVersion;
	}
	public void setProductVersion(java.lang.String productVersion) {
		this.productVersion = productVersion;
	}
	public java.lang.String getSid() {
		return sid;
	}
	public void setSid(java.lang.String sid) {
		this.sid = sid;
	}
	public java.lang.String getSignature() {
		return signature;
	}
	public void setSignature(java.lang.String signature) {
		this.signature = signature;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public List<FeatureForm> getFeatureList() {
		return featureList;
	}
	public void setFeatureList(List<FeatureForm> featureList) {
		this.featureList = featureList;
	}
	
}
