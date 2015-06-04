package com.liveneo.plat.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemParameterInfo {
//	参数键值map
	public Map parameterForKeyValue = new HashMap();
	//参数类型map
	public Map parameterForTypeMap = new HashMap();
	
	public String getParameterValueByCode(String parameterCode) {
		return (String)parameterForKeyValue.get(parameterCode);
	}
	public List getParameterListByType(String parameterType) {
		return (List)parameterForTypeMap.get(parameterType);
	}
	public Map getParameterForKeyValue() {
		return parameterForKeyValue;
	}
	public void setParameterForKeyValue(Map parameterForKeyValue) {
		this.parameterForKeyValue = parameterForKeyValue;
	}
	public Map getParameterForTypeMap() {
		return parameterForTypeMap;
	}
	public void setParameterForTypeMap(Map parameterForTypeMap) {
		this.parameterForTypeMap = parameterForTypeMap;
	}
	
}
