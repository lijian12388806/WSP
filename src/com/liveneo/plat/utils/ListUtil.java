package com.liveneo.plat.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	public static List<String> ConvertArrayToStringList(Object[] args,
			String type) {
		ArrayList<String> list = new ArrayList<String>();
		if (type.equalsIgnoreCase("String")) {
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					list.add((String) args[i]);
				}

			}
		} else {
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					list.add(((Integer) args[i]).toString());
				}

			}
		}
		return list;
	}

	public static List<Integer> ConvertArrayToIntegerList(Object[] args,
			String type) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (type.equalsIgnoreCase("String")) {
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					list.add(Integer.parseInt((String) args[i]));
				}

			}
		} else {
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					list.add(((Integer) args[i]));
				}

			}
		}
		return list;
	}

	public static String ConvertListToString(List list, String separator) {
		String ret = "";
		for (int i = 0; i < list.size(); i++) {
			String tempstr="";
			if(list.get(i) instanceof Integer){
				tempstr=((Integer)list.get(i)).toString();
			}
			if(list.get(i) instanceof String){
				tempstr=((String)list.get(i));
			}
			if(i==list.size()-1){
				ret+=tempstr;
			}else{
				ret+=tempstr+",";
			}
		}
		return ret;
	}
}
