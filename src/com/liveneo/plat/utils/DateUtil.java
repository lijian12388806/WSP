package com.liveneo.plat.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import sun.util.resources.LocaleData;

/**
 * 描述：日期数据转换器
 * 
 * @author chenzw (2007.9.13) 修改记录
 * 
 */
public class DateUtil {
	// ~ Static fields/initializers
	// =============================================

	protected static String datePattern = "MM/dd/yyyy";

	protected static HashMap patterns = new HashMap();

	// ~ Methods
	// ================================================================

	/**
	 * Formats given date according to specified locale and date style
	 * 
	 * @param date
	 *            Date to convert
	 * @param locale
	 *            Locale to use for formatting date
	 * @param dateStyle
	 *            Date style
	 * @return String representation of date according to given locale and date
	 *         style
	 * @see java.text.DateFormat
	 */
	public static final String formatDate(Date date, Locale locale,
			int dateStyle) {
		DateFormat formatter = DateFormat.getDateInstance(dateStyle, locale);
		return formatter.format(date);
	}

	/**
	 * Formats given date according to specified locale and
	 * <code>DateFormat.MEDIUM</code> style
	 * 
	 * @param date
	 *            Date to convert
	 * @param locale
	 *            Locale to use for formatting date
	 * @return String representation of date according to given locale and
	 *         <code>DateFormat.MEDIUM</code> style
	 * @see java.text.DateFormat
	 * @see java.text.DateFormat#MEDIUM
	 */
	public static final String formatDate(Date date, Locale locale) {
		return formatDate(date, locale, DateFormat.MEDIUM);
	}

	/**
	 * Parses given string according to specified locale and date style
	 * 
	 * @param source
	 *            Source string to parse date from
	 * @param locale
	 *            Locale to use for parsing date
	 * @param dateStyle
	 *            Date style
	 * @return Date object corresponding to representation given in source
	 *         string
	 * @throws ParseException
	 *             if given string could not be properly parsed according to
	 *             given locale and style
	 * @see java.text.DateFormat
	 */
	public static final Date parseDate(String source, Locale locale,
			int dateStyle) throws ParseException {
		DateFormat formatter = DateFormat.getDateInstance(dateStyle, locale);
		return formatter.parse(source);
	}

	/**
	 * Parses given string according to specified locale and
	 * <code>DateFormat.MEDIUM</code> style
	 * 
	 * @param source
	 *            Source string to parse date from
	 * @param locale
	 *            Locale to use for parsing date
	 * @return Date object corresponding to representation given in source
	 *         string
	 * @throws ParseException
	 *             if given string could not be properly parsed according to
	 *             given locale and <code>DateFormat.MEDIUM</code> style
	 * @see java.text.DateFormat
	 * @see java.text.DateFormat#MEDIUM
	 */
	public static final Date parseDate(String source, Locale locale)
			throws ParseException {
		return parseDate(source, locale, DateFormat.MEDIUM);
	}

	/**
	 * Formats given time according to specified locale and time style
	 * 
	 * @param time
	 *            Time to convert
	 * @param locale
	 *            Locale to use for formatting time
	 * @param timeStyle
	 *            Time style
	 * @return String representation of time according to given locale and time
	 *         style
	 * @see java.text.DateFormat
	 */
	public static final String formatTime(Date time, Locale locale,
			int timeStyle) {
		DateFormat formatter = DateFormat.getTimeInstance(timeStyle, locale);
		return formatter.format(time);
	}

	/**
	 * Formats given time according to specified locale and
	 * <code>DateFormat.MEDIUM</code> style
	 * 
	 * @param time
	 *            Time to convert
	 * @param locale
	 *            Locale to use for formatting time
	 * @return String representation of time according to given locale and
	 *         <code>DateFormat.MEDIUM</code> style
	 * @see java.text.DateFormat
	 * @see java.text.DateFormat#MEDIUM
	 */
	public static final String formatTime(Date time, Locale locale) {
		return formatTime(time, locale, DateFormat.MEDIUM);
	}

	/**
	 * Parses given string according to specified locale and time style
	 * 
	 * @param source
	 *            Source string to parse time from
	 * @param locale
	 *            Locale to use for parsing time
	 * @param timeStyle
	 *            Time style
	 * @return Time object corresponding to representation given in source
	 *         string
	 * @throws ParseException
	 *             if given string could not be properly parsed according to
	 *             given locale and style
	 * @see java.text.DateFormat
	 */
	public static final Date parseTime(String source, Locale locale,
			int timeStyle) throws ParseException {
		DateFormat formatter = DateFormat.getTimeInstance(timeStyle, locale);
		return formatter.parse(source);
	}

	/**
	 * Parses given string according to specified locale and
	 * <code>DateFormat.MEDIUM</code> style
	 * 
	 * @param source
	 *            Source string to parse time from
	 * @param locale
	 *            Locale to use for parsing time
	 * @return Time object corresponding to representation given in source
	 *         string
	 * @throws ParseException
	 *             if given string could not be properly parsed according to
	 *             given locale and <code>DateFormat.MEDIUM</code> style
	 * @see java.text.DateFormat
	 * @see java.text.DateFormat#MEDIUM
	 */
	public static final Date parseTime(String source, Locale locale)
			throws ParseException {
		return parseTime(source, locale, DateFormat.MEDIUM);
	}

	/**
	 * Formats given date and time according to specified locale and date style
	 * 
	 * @param date
	 *            Date object to convert
	 * @param locale
	 *            Locale to use for formatting date and time
	 * @param dateStyle
	 *            Date style
	 * @param timeStyle
	 *            Time style
	 * @return String representation of date and time according to given locale
	 *         and date style
	 * @see java.text.DateFormat
	 */
	public static final String formatDateTime(Date date, Locale locale,
			int dateStyle, int timeStyle) {
		DateFormat formatter = DateFormat.getDateTimeInstance(dateStyle,
				timeStyle, locale);
		return formatter.format(date);
	}

	/**
	 * Formats given date and time according to specified locale and
	 * <code>DateFormat.MEDIUM</code> style
	 * 
	 * @param date
	 *            Date object to convert
	 * @param locale
	 *            Locale to use for formatting date and time
	 * @return String representation of date and time according to given locale
	 *         and <code>DateFormat.MEDIUM</code> style
	 * @see java.text.DateFormat
	 * @see java.text.DateFormat#MEDIUM
	 */
	public static final String formatDateTime(Date date, Locale locale) {
		return formatDateTime(date, locale, DateFormat.MEDIUM,
				DateFormat.MEDIUM);
	}

	/**
	 * Parses given string according to specified locale and date and time
	 * styles
	 * 
	 * @param source
	 *            Source string to parse date and time from
	 * @param locale
	 *            Locale to use for parsing date and time
	 * @param dateStyle
	 *            Date style
	 * @param timeStyle
	 *            Time style
	 * @return Date object corresponding to representation given in source
	 *         string
	 * @throws ParseException
	 *             if given string could not be properly parsed according to
	 *             given locale and style
	 * @see java.text.DateFormat
	 */
	public static final Date parseDateTime(String source, Locale locale,
			int dateStyle, int timeStyle) throws ParseException {
		DateFormat formatter = DateFormat.getDateTimeInstance(dateStyle,
				timeStyle, locale);
		return formatter.parse(source);
	}

	/**
	 * Parses given string according to specified locale and
	 * <code>DateFormat.MEDIUM</code> style
	 * 
	 * @param source
	 *            Source string to parse date and time from
	 * @param locale
	 *            Locale to use for parsing date and time
	 * @return Date object corresponding to representation given in source
	 *         string
	 * @throws ParseException
	 *             if given string could not be properly parsed according to
	 *             given locale and <code>DateFormat.MEDIUM</code> style
	 * @see java.text.DateFormat
	 * @see java.text.DateFormat#MEDIUM
	 */
	public static final Date parseDateTime(String source, Locale locale)
			throws ParseException {
		return parseDateTime(source, locale, DateFormat.MEDIUM,
				DateFormat.MEDIUM);
	}

	/**
	 * Formats given Date object according to specified locale and a given
	 * pattern.
	 * 
	 * @param date
	 *            Date object to convert
	 * @param locale
	 *            Locale to use for formatting
	 * @param pattern
	 *            Pattern to use
	 * @return String representation of date and time according to given locale
	 *         and <code>DateFormat.MEDIUM</code> style
	 * @see java.text.SimpleDateFormat
	 */
	public static String format(Date date, Locale locale, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
		return formatter.format(date);
	}

	/**
	 * Parses given string according to specified locale and a given pattern.
	 * 
	 * @param source
	 *            Source string to parse date and time from
	 * @param locale
	 *            Locale to use for parsing date and time
	 * @param pattern
	 *            Pattern to use
	 * @return Date object corresponding to representation given in source
	 *         string
	 * @throws ParseException
	 *             if given string could not be properly parsed according to
	 *             given locale and pattern
	 * @see java.text.SimpleDateFormat
	 */
	public static Date parse(String source, Locale locale, String pattern)
			throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
		return formatter.parse(source);
	}

	/**
	 * Returns default datePattern (MM/dd/yyyy)
	 * 
	 * @return a string representing the date pattern on the UI
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * Gets date pattern without time symbols according to given locale and date
	 * style
	 * 
	 * @param locale
	 *            Locale to searh pattern for
	 * @param dateStyle
	 *            Date style to search pattern by
	 * @return Date pattern without time symbols
	 */
	public static String getDatePattern(Locale locale, int dateStyle) {
		String[] dateTimePatterns = (String[]) patterns.get(locale);
		if (dateTimePatterns == null) {
			ResourceBundle r = LocaleData.getLocaleNames(locale);
			dateTimePatterns = r.getStringArray("DateTimePatterns");
			patterns.put(locale, dateTimePatterns);
		}
		return dateTimePatterns[dateStyle + 4];
	}

	/**
	 * Gets date pattern without time symbols according to given locale in
	 * MEDIUM style
	 * 
	 * @param locale
	 *            Locale to searh pattern for
	 * @return Date pattern without time symbols in medium format
	 * @see java.text.DateFormat#MEDIUM
	 */
	public static String getDatePattern(Locale locale) {
		return getDatePattern(locale, DateFormat.MEDIUM);
	}

	public static String getDateTimePattern(Locale locale, String hhmmss) {

		String returnString = "yyyy-MM-dd HH:mm:ss";
		if (StringUtils.isEmpty(hhmmss)) {
			return "yyyy-MM-dd";
		}
		if (hhmmss.equalsIgnoreCase("hhmm")) {
			returnString = "yyyy-MM-dd HH:mm";
		}
		if (hhmmss.equalsIgnoreCase("hh")) {
			returnString = "yyyy-MM-dd HH";
		}

		return returnString;
	}

	/**
	 * 按照格式返回日期
	 * 
	 * @param args
	 */
	public static Date parseFormatDate(String aDateStr) {
		String aDateFmtStr = "yyyy-MM-dd";
		return parseFormatDate(aDateStr, aDateFmtStr);
	}

	/**
	 * 按照格式返回日期
	 * 
	 * @param args
	 */
	public static Date parseFormatDate(String aDateStr, String aDateFmtStr) {
		SimpleDateFormat smt = new SimpleDateFormat(aDateFmtStr);
		Date ret;
		if (aDateStr == null || aDateStr.equals(""))
			return null;
		try {
			ret = smt.parse(aDateStr);
		} catch (ParseException e) {
			// System.out.println(e.getMessage());
			return null;
		}
		return ret;
	}

	/**
	 * 取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthBegin(String strdate) {
		java.util.Date date = parseFormatDate(strdate);
		return formatDateByFormat(date, "yyyy-MM") + "-01";
	}

	/**
	 * 取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String
	 * @return String
	 */
	public static String getMonthEnd(String strdate) {
		java.util.Date date = parseFormatDate(getMonthBegin(strdate));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 常用的格式化日期
	 * 
	 * @param date
	 *            Date
	 * @return String
	 */
	public static String formatDate(java.util.Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String formatDateByFormat(java.util.Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				// LOGGER.info("date:" + date);
				ex.printStackTrace();
			}
		}
		return result;
	}

	public static Date getLastMonth(java.util.Date date) {
		Calendar currentDate = Calendar.getInstance();
		currentDate.set(date.getYear(), date.getMonth(), date.getDay());
		currentDate.set(Calendar.DATE, 1);
		// 获得上月最后一天
		currentDate.add(Calendar.DATE, -1);
		return currentDate.getTime();
	}

	public static Integer getIntervalDays(Date startday, Date endday) {
		// 确保startday在endday之前
		Date newstartday = DateUtil.parseFormatDate(DateUtil
				.formatDate(startday));
		Date newsendday = DateUtil.parseFormatDate(DateUtil.formatDate(endday));
		if (newstartday.after(newsendday)) {
			Date cal = newstartday;
			newstartday = newsendday;
			newsendday = cal;
		}
		// 分别得到两个时间的毫秒数
		long sl = newstartday.getTime();
		long el = newsendday.getTime();

		long ei = el - sl;
		// 根据毫秒数计算间隔天数
		return (int) (ei / (1000 * 60 * 60 * 24));
	}

	public static Date addDaysToDate(Integer days, Date nowdate) {
		Calendar now = Calendar.getInstance();
		now.setTime(nowdate);
		now.add(Calendar.DAY_OF_YEAR, days);
		return parseFormatDate(formatDate(now.getTime()));
	}

	public static Date getQueryEndDate(String endstrDate) {
		Date endDate = parseFormatDate(endstrDate);
		if (endDate == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(endDate);
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);
		return now.getTime();
	}

	public static Date getQueryStartDate(String startstrDate) {
		Date startDate = parseFormatDate(startstrDate);
		if (startDate == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(startDate);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		return now.getTime();
	}

	/**
	 * 时间类型
	 */
	public static Date getQueryStartDate(Date startDate) {
		if (startDate == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(startDate);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		return now.getTime();
	}

	public static Date getQueryEndDate(Date endDate) {
		if (endDate == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(endDate);
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);
		return now.getTime();
	}

	/**
	 * 获得指定日期与该日期之前最近的周一相差的天数
	 * 
	 * @param cd
	 * @return
	 */
	public static int getMondayPlus(Calendar cd) {
		// Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期一是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return -6;
		} else {
			return 2 - dayOfWeek;
		}
	}

	/**
	 * 获得指定日期与该日期之后最近的周五相差的天数
	 * 
	 * @param cd
	 * @return
	 */
	public static int getFridayPlus(Calendar cd) {
		// Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期一是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == 1) {
			return 5;
		} else {
			return 6 - dayOfWeek;
		}
	}

	public static String whichDay_monday = "monday";

	public static String whichDay_friday = "friday";

	public static String whichWeek_current = "current";

	public static String whichWeek_pre = "pre";

	public static String whichWeek_next = "next";

	/**
	 * 获取指定日期所在周的本周、上周或下周的周一或周五
	 * 
	 * @param currentDate
	 * @return
	 */
	public static Date getMondayOrFriday(Calendar currentDate, String whichDay,
			String whichWeek) {
		int weeks = 0;
		if ("current".equals(whichWeek)) {
			weeks = 0;
		} else if ("pre".equals(whichWeek)) {
			weeks--;
		} else if ("next".equals(whichWeek)) {
			weeks++;
		}
		int dayPlus = 0;
		if ("monday".equals(whichDay)) {
			dayPlus = getMondayPlus(currentDate);
		}
		if ("friday".equals(whichDay)) {
			dayPlus = getFridayPlus(currentDate);
		}
		// GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, dayPlus + 7 * weeks);
		Date nowday = currentDate.getTime();
		System.out.println(nowday);
		// DateFormat df = DateFormat.getDateInstance();
		// String resultday = df.format(nowday);
		return nowday;
	}

	/**
	 * 某日期推迟几个工作日后的日期
	 * 
	 * @param cd
	 *            计算的当前日期
	 * @param i
	 *            推迟工作日
	 * @return
	 */
	public static Date getDelayDate(Calendar cd, Integer i) {
		if (i == 0) {
			return cd.getTime();
		}
		int shang = i / 5;
		int yu = i % 5;
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK);
		if (yu + dayOfWeek > 6) {
			yu = 1;
		} else {
			yu = 0;
		}
		cd.add(GregorianCalendar.DATE, (shang + yu) * 2 + i);
		cd.set(Calendar.HOUR_OF_DAY, 18);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		return cd.getTime();
	}

	/**
	 * 获得两个日期之前相差的月份<br>
	 * 
	 * @param start
	 * @param e
	 * @return
	 */

	public static int getMonth(Date start, Date end) {
		if (start.after(end)) {
			Date t = start;
			start = end;
			end = t;
		}
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR)
				- startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH)
				- startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}

	public static List<String> getYearMonth(Date start, Date end) {
		List<String> yearMonthList = new ArrayList<String>();
		int months = getMonth(start, end);
		Date temp = start;
		if (months == 0) {
			yearMonthList.add(formatDateByFormat(start, "yyyyMM"));

		} else {
			for (int i = 0; i < months; i++) {
				yearMonthList.add(formatDateByFormat(nMonthsNext(i, start),
						"yyyyMM"));

			}
		}
		return yearMonthList;
	}

	public static Date nMonthsNext(Integer n, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + n);
		return cal.getTime();
	}

	/**
	 * Date转换为Calendar
	 * **/
	public static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * 日期加N天
	 * **/
	public static String addDay(String s, int n) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar cd = Calendar.getInstance();
			cd.setTime(sdf.parse(s));
			cd.add(Calendar.DATE, n);// 增加一天
			// cd.add(Calendar.MONTH, n);//增加一个月

			return sdf.format(cd.getTime());

		} catch (Exception e) {
			return null;
		}
	}

	public static String secToTime(int time) {  
        String timeStr = null;  
        int hour = 0;  
        int minute = 0;  
        int second = 0;  
        if (time <= 0)  
            return "00:00";  
        else {  
            minute = time / 60;  
            if (minute < 60) {  
                second = time % 60;  
                timeStr = unitFormat(minute) + ":" + unitFormat(second);  
            } else {  
                hour = minute / 60;  
                if (hour > 99)  
                    return "99:59:59";  
                minute = minute % 60;  
                second = time - hour * 3600 - minute * 60;  
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);  
            }  
        }  
        return timeStr;  
    }
	
	public static String unitFormat(int i) {  
        String retStr = null;  
        if (i >= 0 && i < 10)  
            retStr = "0" + Integer.toString(i);  
        else  
            retStr = "" + i;  
        return retStr;  
    }
	public static void main(String[] args) {
		// System.out.println(DateUtil.getQueryEndDate("2009-09-21"));
		// System.out.println(DateUtil.getQueryStartDate("2009-09-21"));
		// System.out.println(DateUtil.getMondayOrFriday(Calendar.getInstance(),
		// whichDay_friday, whichWeek_current));
		// System.out.println(DateUtil.getMondayOrFriday(Calendar.getInstance(),
		// whichDay_friday, whichWeek_pre));
		// System.out.println(DateUtil.getMondayOrFriday(Calendar.getInstance(),
		// whichDay_friday, whichWeek_next));
		// System.out.println(getDelayDate(Calendar.getInstance(), 15));
//		System.out.println(DateUtil.getMonthEnd("2013-04"));
		System.out.println(DateUtil.secToTime(4980));
	}
}
