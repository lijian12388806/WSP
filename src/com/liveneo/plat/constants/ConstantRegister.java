package com.liveneo.plat.constants;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weiyf  Constant values used throughout the application.
 * @version 1.0
 * @since 2009.07.20
 */

public class ConstantRegister {
	
	private static List<ConstantStruct> getConstantsList(String prefix) throws IllegalArgumentException, IllegalAccessException{
		Class globalConstantsClass = GlobalConstants.class;   
		java.lang.reflect.Field[] declaredfileds = globalConstantsClass.getDeclaredFields();   
		List<Field> constantsNameList = new ArrayList<Field>();
		List<Field> constantsValueList = new ArrayList<Field>();
		List<ConstantStruct> constantsList = new ArrayList<ConstantStruct>();
		
		for(int i = 0; i < declaredfileds.length; i++){
			if(declaredfileds[i].getName().toLowerCase().startsWith((prefix+"_NAME_").toLowerCase())){
				constantsNameList.add(declaredfileds[i]);
				continue;
			}
			if(declaredfileds[i].getName().toLowerCase().startsWith((prefix+"_VALUE_").toLowerCase())){
				constantsValueList.add(declaredfileds[i]);
				continue;
			}
		}
		sortList(constantsNameList);
		sortList(constantsValueList);
		for(int i = 0; i < constantsNameList.size(); i++){
			constantsList.add(new ConstantStruct((String)constantsValueList.get(i).get(globalConstantsClass), (String)constantsNameList.get(i).get(globalConstantsClass)));
		}
		return constantsList;
	}
	private static void sortList(List<java.lang.reflect.Field> result) {
		java.util.Collections.sort(result, new Comparator<Field>() {
			public int compare(Field a, Field b) {
				return a.getName().compareTo(b.getName());
			}
		});
	}
	@SuppressWarnings("unused")
	private static void listRegister(Map<String, List<ConstantStruct>> map,String applicationParaname,String prefix) throws IllegalArgumentException, IllegalAccessException{
		map.put(applicationParaname, getConstantsList(prefix));
	}
	@SuppressWarnings("unused")
	public static Map paraListRegister() throws IllegalArgumentException, IllegalAccessException{
		Class globalConstantsClass = GlobalConstants.class;   
		java.lang.reflect.Field[] declaredfileds = globalConstantsClass.getDeclaredFields();   
		List<Field> sysParaList = new ArrayList<Field>();
		List<Field> constantsValueList = new ArrayList<Field>();
		List<ConstantStruct> constantsList = new ArrayList<ConstantStruct>();
		
		for(int i = 0; i < declaredfileds.length; i++){
			if(declaredfileds[i].getName().toLowerCase().startsWith(("SYSPARA_").toLowerCase())){
				sysParaList.add(declaredfileds[i]);
				continue;
			}
		}
		Map<String, List<ConstantStruct>> regiterMap = new HashMap<String, List<ConstantStruct>>();
		for(Field sysPara : sysParaList){
			String paraFieldName = sysPara.getName();
			String paraName="";
			String prefix="";
			prefix=paraFieldName.substring(8, paraFieldName.length());
			paraName=(String) sysPara.get(GlobalConstants.class);
			listRegister(regiterMap, paraName, prefix);
		}
		return regiterMap;
	}
	public static void main(String[] args) {
		try {
//			List<ConstantStruct> list = getConstantsList("mEnu");
//			for(ConstantStruct constantStruct : list){
//				System.out.println("name:"+constantStruct.getConstantName()+";value:"+constantStruct.getConstantVaue());
//			}
			Map<String, List<ConstantStruct>> regiterMap = new HashMap<String, List<ConstantStruct>>();
			regiterMap=paraListRegister();
			System.out.println(regiterMap.get(GlobalConstants.SYSPARA_MENU));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
