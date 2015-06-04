package com.liveneo.plat.utils;

import java.lang.reflect.Method;

/**
 * 
 */
public class PrintPojoByReflect {
	/**
	 * print pojo
	 * @param qutBoundBean
	 */
	public static void printPojo(Object qutBoundBean){
		System.out.println("-- begin print pojo ");
		Class qutBoundBeanClass = qutBoundBean.getClass();   
//		java.lang.reflect.Field[] fileds = qutBoundBeanClass.getFields();   
		java.lang.reflect.Field[] fileds = qutBoundBeanClass.getDeclaredFields();   
		Method m[]= qutBoundBeanClass.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			if (m[i].toString().contains("get")) {
				if(fileds != null) {
						try {
							String s="null";
							if (m[i].invoke(qutBoundBean)!=null) {
								 s = m[i].invoke(qutBoundBean).toString();
							}
							for(int i1=0; i1<fileds.length;i1++){
								if (m[i].toString().toLowerCase().contains(fileds[i1].getName().toLowerCase())) {
									System.out.println(fileds[i1].getName()+" == "+s);
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						} 
				}
			}
		}
		System.out.println("-- end print pojo ");
	}

}
