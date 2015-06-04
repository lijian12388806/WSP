package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class FeatureForm extends BaseForm {

	private static final long serialVersionUID = 1L;
	private java.lang.String featureName;
	private java.lang.String featureDisplayName;
	private java.lang.String featureValue;
	private java.lang.String featureExpDate;
	public java.lang.String getFeatureDisplayName() {
		return featureDisplayName;
	}
	public void setFeatureDisplayName(java.lang.String featureDisplayName) {
		this.featureDisplayName = featureDisplayName;
	}
	public java.lang.String getFeatureExpDate() {
		return featureExpDate;
	}
	public void setFeatureExpDate(java.lang.String featureExpDate) {
		this.featureExpDate = featureExpDate;
	}
	public java.lang.String getFeatureName() {
		return featureName;
	}
	public void setFeatureName(java.lang.String featureName) {
		this.featureName = featureName;
	}
	public java.lang.String getFeatureValue() {
		return featureValue;
	}
	public void setFeatureValue(java.lang.String featureValue) {
		this.featureValue = featureValue;
	}
}
