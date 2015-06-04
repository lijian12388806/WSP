package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;


public class LicenseForm extends BaseForm{
	private String product_version;
	private String feature_name;
	private String license_count;
	private String license_type;
	private String expired_day;
	public String getProduct_version() {
		return product_version;
	}
	public void setProduct_version(String productVersion) {
		product_version = productVersion;
	}
	public String getFeature_name() {
		return feature_name;
	}
	public void setFeature_name(String featureName) {
		feature_name = featureName;
	}
	public String getLicense_count() {
		return license_count;
	}
	public void setLicense_count(String licenseCount) {
		license_count = licenseCount;
	}
	public String getLicense_type() {
		return license_type;
	}
	public void setLicense_type(String licenseType) {
		license_type = licenseType;
	}
	public String getExpired_day() {
		return expired_day;
	}
	public void setExpired_day(String expiredDay) {
		expired_day = expiredDay;
	}
}
