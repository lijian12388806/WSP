package com.liveneo.plat.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.liveneo.plat.web.form.JsonForm;

public class ObjectUtil {
	public static void main(String[] args) throws IllegalArgumentException,
			Exception {
//		List<CustomerinfoExcel> list = new ArrayList<CustomerinfoExcel>();
//		CustomerinfoExcel o1 = new CustomerinfoExcel();
//		o1.setSalesname("我我我");
//		o1.setCustlinkman("你你你");
//		list.add(o1);
//		getFieldValue(list);
	}
	/**
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static List<List<String>> getFieldValue(List list) throws Exception, IllegalAccessException {
		List<List<String>> lists = new ArrayList<List<String>>();
		for (Object obj:list) {
			List<String> strs = new ArrayList<String>();
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field v : fields) {
				v.setAccessible(true);
				Object va = v.get(obj);
				if (va == null) {
					va = "";
				}
				strs.add(va.toString());
			}
			lists.add(strs);
		}
		return lists;
	}
}
 