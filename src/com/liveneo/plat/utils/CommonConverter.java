package com.liveneo.plat.utils;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 描述：通用数据转换器
 * 
 * @author chenzw (2007.9.13) 修改记录
 * 
 */
public class CommonConverter implements Converter {

	protected Locale locale;

	protected DateFormat formatter;

	/**
	 * Creates new instance of CommonConverter with default locale
	 */
	public CommonConverter() {
		this(Locale.getDefault());
	}

	/**
	 * Creates new instance of Common converter with specified locale
	 * 
	 * @param locale
	 *            Locale to use
	 */
	public CommonConverter(Locale locale) {
		this.locale = locale;
		this.formatter = new SimpleDateFormat(DateUtil.getDateTimePattern(locale,""),
				locale);
	}

	/**
	 * Creates new instance of Common converter with specified locale
	 * 
	 * @param locale
	 *            Locale to use
	 */
	public CommonConverter(Locale locale, String hhmmss) {
		this.locale = locale;
		this.formatter = new SimpleDateFormat(DateUtil.getDateTimePattern(
				locale, hhmmss), locale);
	}

	/**
	 * Converts an object to specified class (<code>Date</code>,
	 * <code>String</code> or <code>Object</code>). In all other cases a
	 * <code>ConversionException</code> will be thrown. The only exception is
	 * <code>null</code> value: it will give <code>null</code> regardless of
	 * <code>type</code>.
	 * 
	 * @param type
	 *            the class to which the object need to be converted (this can
	 *            be <code>Date</code>, <code>String</code> or
	 *            <code>Object</code>)
	 * @param value
	 *            the object that need to be converted
	 * @return converted object
	 */
	public Object convert(Class type, Object value) {
		if (value == null) {
			return null;
		} else if (type == Date.class) {
			return convertToDate(type, value);
		} else if (type == String.class) {
			return convertToString(type, value);
		} else if (type == BigDecimal.class) {
			return convertToBigDecimal(type, value);
		} else if (type == Object.class) {
			return convertToObject(type, value);
		}

		throw new ConversionException("Could not convert "
				+ value.getClass().getName() + " to " + type.getName());
	}

	/**
	 * Converts specified object to <code>Date</code>
	 * 
	 * @param type
	 *            the class to which the object need to be converted
	 * @param value
	 *            the object that need to be converted
	 * @return converted object
	 */
	protected Object convertToDate(Class type, Object value) {
		if (value instanceof Date) {
			return value;
		}

		if (value instanceof String) {
			try {
				if (StringUtils.isEmpty(value.toString())) {
					return null;
				}

				return formatter.parse((String) value);
			} catch (Exception pe) {
				throw new ConversionException("Error converting String to Date");
			}
		}

		throw new ConversionException("Could not convert "
				+ value.getClass().getName() + " to " + type.getName());
	}

	/**
	 * Converts specified object to <code>String</code>
	 * 
	 * @param type
	 *            the class to which the object need to be converted
	 * @param value
	 *            the object that need to be converted
	 * @return converted object
	 */
	protected Object convertToString(Class type, Object value) {
		if (value instanceof Date) {
			try {
				return formatter.format(value);
			} catch (Exception e) {
				throw new ConversionException("Error converting Date to String");
			}
		}

		return value.toString();
	}

	/**
	 * Converts specified object to <code>Object</code>
	 * 
	 * @param type
	 *            the class to which the object need to be converted
	 * @param value
	 *            the object that need to be converted
	 * @return converted object
	 */
	protected Object convertToObject(Class type, Object value) {
		return value;
	}

	// ---------------------------------------------------
	/**
	 * sunxiucheng add a methosd Converts specified object to
	 * <code>Object</code>
	 * 
	 * @param type
	 *            the class to which the object need to be converted
	 * @param value
	 *            the object that need to be converted
	 * @return converted object
	 */
	protected BigDecimal convertToBigDecimal(Class type, Object value) {
		if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		} else if (value instanceof String) {
			if ("".equals(value.toString().trim())) {
				return null;
			} else {
				try {
					return new BigDecimal(value.toString().trim());
				} catch (Exception ex) {
					return null;
				}
			}
		} else {
			return null;
		}
	}
}
