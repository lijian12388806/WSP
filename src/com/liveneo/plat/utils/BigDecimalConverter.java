package com.liveneo.plat.utils;

import java.math.BigDecimal;

import org.apache.commons.beanutils.Converter;

public class BigDecimalConverter implements Converter {

	public Object convert(Class type, Object value) {
		if( value instanceof BigDecimal) {
			return (BigDecimal)value;
		}else if( value instanceof String) {
			if("".equals(value.toString().trim())){
				return null;
			}else{
				return new BigDecimal(value.toString().trim());
			}
		}else {
			return null;
		}
	}

}
