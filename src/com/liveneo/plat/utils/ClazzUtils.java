package com.liveneo.plat.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 类的常用处理方法
 * 
 */
public class ClazzUtils {
	/**
	 * 得到持久化类的名称。
	 * 
	 * @param entity
	 *            待处理的持久化类。
	 * @return 持久化类的名称。
	 * @since 0.0.1
	 */
	public static Class getEntityClass(Object entity) {
		if (entity.getClass().getName().contains("CGLIB")) {
			return entity.getClass().getSuperclass();
		}
		return entity.getClass();
	}

	/**
	 * 通过给定的类名来构造一个实体类.
	 * 
	 * @param clazzName
	 *            类名.
	 * @return 实体对象.
	 * @since 0.0.3
	 */
	public static Object newInstance(String clazzName) {
		try {
			return Class.forName(clazzName).newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void copyProperties(final Object orig, final Object dest)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		PropertyUtils.copyProperties(dest, orig);
	}

}
