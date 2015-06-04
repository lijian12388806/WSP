package com.liveneo.plat.utils;

public class IntegerUtil {
	public static Integer converStrToInteger(String value) {
		if (value == null || value.trim().equals("")) {
			return null;
		} else {
			String converValue = value.replace(",", "");
			if (converValue.indexOf(".") > 0) {
				converValue = converValue
						.substring(0, converValue.indexOf("."));
			}
			try {
				return Integer.parseInt(converValue);
			} catch (Exception ex) {
				return null;
			}
		}
	}

	public static String converIntegerToStr(Integer value) {
		if (value == null) {
			return null;
		} else {
			return value.toString();
		}
	}
}
