package com.liveneo.plat.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

/**
 * 读取属性文件
 * 
 * @author liuning
 * 
 */
public class ReadConfUtil {

	/**
	 * 读取linux配置文件属性
	 * 
	 * @param path
	 * @return
	 */
	public static Properties readProperties(String path) {
		FileInputStream in = null;
		Properties p = null;
		try {
			// in = new BufferedInputStream(new FileInputStream(path));
			in = new FileInputStream(path);
			p = new Properties();
			p.load(in);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
	/**
	 * 系统内存中获取初始化的常量信息
	 * @param application
	 * @return
	 */
	public static Properties getPropertiesBySys(ServletContext application){
		return (Properties)application.getAttribute("ipccConstants");
	}
	public static void main(String[] args) {
		Properties p = ReadConfUtil.readProperties("WEB-INF/smtcc.conf");
		System.out.println(p.getProperty("dbhost"));
	}
}
