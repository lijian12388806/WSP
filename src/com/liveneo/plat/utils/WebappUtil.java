package com.liveneo.plat.utils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

/**
 * 描述：web应用数据转换器
 * @author chenzw (2007.9.3)
 * 修改记录
 * 
 */
public class WebappUtil {

	/**
	 * <p>Copies properties from orig bean to dest for each case where property names are the same.
	 * Uses CommonConverter with appropriate locale stored in session to correctly convert date to string and vice versa.
	 * </p>
	 * <p>This method is synchronized, so it guarantees, that correct converters will be set for each request
	 * </p>
	 *
	 * @param dest    Destination bean to copy properties to
	 * @param orig    Original bean to copy properties from
	 * @param request Http servlet request we are processing
	 * @param hhmmss  show date time style
	 * @see com.blandware.atleap.common.util.CommonConverter#CommonConverter(java.util.Locale)
	 */
	public static synchronized void copyProperties(Object dest, Object orig, HttpServletRequest request,String hhmmss) throws IllegalAccessException, InvocationTargetException {

		boolean requestSpecified = request != null;

		CommonConverter converter = new CommonConverter();

//		if ( requestSpecified && hhmmss != null && (!hhmmss.equalsIgnoreCase("0"))) {
//			Locale locale = RequestUtils.getUserLocale(request, null);
//			converter = new CommonConverter(locale,hhmmss);
//		}else if(requestSpecified && hhmmss.equalsIgnoreCase("0")){
//			Locale locale = RequestUtils.getUserLocale(request, null);
//			converter = new CommonConverter(locale);
//		}

		ConvertUtils.register(converter, Date.class);
		ConvertUtils.register(converter, String.class);
		ConvertUtils.register(converter, BigDecimal.class);
		BeanUtils.copyProperties(dest, orig);
		if ( requestSpecified ) {
			// Register default converters
			ConvertUtils.register(new CommonConverter(), String.class);
			ConvertUtils.register(new CommonConverter(), Date.class);
			ConvertUtils.register(new CommonConverter(),BigDecimal.class);
		}

	}

	/**
	 * <p>Copies properties from orig bean to dest for each case where property names are the same.
	 * Uses CommonConverter with default locale to convert date to string and vice versa.
	 * </p>
	 * <p>This method is synchronized, so it guarantees, that correct converters will be set for each request
	 * </p>
	 *
	 * @param dest Destination bean to copy properties to
	 * @param orig Original bean to copy properties from
	 * @see com.blandware.atleap.common.util.CommonConverter#CommonConverter()
	 */
	public static synchronized void copyProperties(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException {
		copyProperties(dest, orig, null,"0");
	}
	public static synchronized void copyProperties(Object dest, Object orig,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		copyProperties(dest, orig, request,"0");
	}
}
