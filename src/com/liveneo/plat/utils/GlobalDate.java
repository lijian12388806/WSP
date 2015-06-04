package com.liveneo.plat.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class GlobalDate
{


	
	/**
	 * ��ݴ���ĸ�ʽ�����ڽ��и�ʽ��
	 * @param date ��ʽ
	 * @return ��ʽ��������
	 */
	public static String formatdate(String date)
	{
		Date datenow = new Date();
		SimpleDateFormat sdfnow = new SimpleDateFormat(date);
		String day = sdfnow.format(datenow);
		return day;
	}
	
	

	/**
	 * ȡ��ǰһ�������
	 * @since 2008-07-02
	 * @return ���������
	 */
	public static String beforeDate()
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyyMMdd");
		String day = sdfnow.format(datenow);
		return day;
	}

	/**
	 * ȡ��}��ǰ������
	 * @since 2008-07-02
	 * @return ���������
	 */
	public static String beforeDateTwo()
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 2);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyyMMdd");
		String day = sdfnow.format(datenow);
		return day;
	}

	/**
	 * ȡ��}��ǰ������
	 * @since 2008-07-02
	 * @return ���������
	 */
	public static String beforeDateEvery(int dd)
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - dd);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyyMMdd");
		String day = sdfnow.format(datenow);
		return day;
	}

	/**
	 * ȡ��ǰһ���µ�����
	 * @since 2008-07-02
	 * @return �ϸ��µ�����
	 */
	public static String beforeDateMonth()
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyyMM");
		String day = sdfnow.format(datenow);
		return day;
	}

	/**
	 * ȡ��ǰn���µ�����
	 * @since 2008-07-02
	 * @param a
	 *            ǰ�Ƶ���
	 * @return �µ�����
	 */
	public static String beforeDateMonthEvery(int a)
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - a);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyyMM");
		String day = sdfnow.format(datenow);
		return day;
	}

	/**
	 * ȡ��ǰn���µ�����
	 * @since 2008-07-02
	 * @param a
	 *            ǰ�Ƶ���
	 * @return �µ�����
	 */
	public static String beforeDateMonthEveryM(int a)
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - a);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("MM");
		String day = sdfnow.format(datenow);
		if (day.indexOf("0") == 0)
		{
			day = day.substring(1);
		}
		return day;
	}

	/**
	 * ȡ��ǰn�������
	 * @since 2008-07-02
	 * @param a
	 *            ǰ�Ƶ���
	 * @return �������
	 */

	public static String beforeDateYearEvery(int a)
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - a);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyy");
		String day = sdfnow.format(datenow);
		return day;
	}

	/**
	 * ȡ��ǰ�������
	 * @since 2008-07-02
	 * @return ȥ�������
	 */
	public static String beforeDateYear()
	{
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyy");
		String day = sdfnow.format(datenow);
		return day;
	}

	
	/**
	 * ����ת��ǰ�Ƽ���
	 * @since 2008-07-02
	 * @param day ����
	 * @return ������ǰ������
	 */
	public synchronized static String DateTranslate(int day){
		String v = "";
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
		Date datenow = calendar.getTime();
		SimpleDateFormat sdfnow = new SimpleDateFormat("yyyyMMdd");
		v = sdfnow.format(datenow);
		return v;
	}
	

}
