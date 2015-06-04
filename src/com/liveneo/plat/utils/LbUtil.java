package com.liveneo.plat.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class LbUtil {
	/***
	 * 
	 * 字符串根据字符转换成list
	 * 
	 * */

	public static List<String> splitStringByCommonSeparator(String str,
			String separator) {
		List<String> strs = new ArrayList<String>();
		String[] b = str.split(separator);
		for (int i = 0; i < b.length; i++) {
			if (!StringUtils.equals(b[i], "")) {
				strs.add(b[i]);
			}
		}
		return strs;
	}

}
