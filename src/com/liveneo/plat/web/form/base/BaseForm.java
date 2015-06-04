package com.liveneo.plat.web.form.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BaseForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String returnUrl;
	private List attas;

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	private Map paramap = new HashMap<String,Object>();

	

	@SuppressWarnings("unchecked")
	public void setAttribute(String attributeKey, Object attributeValue) {

		paramap.put(attributeKey, attributeValue);
	}

	public Object getAttribute(String attributeKey) {
		Object keyValue = paramap.get(attributeKey);
		return keyValue;
	}

	public Map getParamap() {
		return paramap;
	}

	public void setParamap(Map paramap) {
		this.paramap = paramap;
	}

	public List getAttas() {
		return attas;
	}

	public void setAttas(List attas) {
		this.attas = attas;
	}
}
