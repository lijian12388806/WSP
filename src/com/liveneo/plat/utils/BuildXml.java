package com.liveneo.plat.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.liveneo.plat.constants.GlobalConstants;
import com.liveneo.plat.hibernate.dao.Userinfo;

public class BuildXml {

	public static String usrdir = "/usr/local/freeswitch/conf/directory/default/";

	public static String batchusrCmd = "sh /usr/local/freeswitch/conf/directory/default/adduserpl.sh";

	public static String gatewaydir = "/usr/local/freeswitch/conf/sip_profiles/external/";

	public static String eonedir = "/usr/local/freeswitch/conf/freetdm.conf";

	// public static String dialplandir =
	// "/usr/local/freeswitch/conf/dialplan/CallRoute/";
	public static String dialplandir = "D:/test/";

	public static String outbounddir = "/usr/local/freeswitch/conf/dialplan/Outbound/";
	// public static String outbounddir = "D:/test/";

	public static String timeruledir = "/usr/local/freeswitch/conf/dialplan/TimeRule/";

	public static String meetroomdir = "/usr/local/freeswitch/conf/dialplan/Meeting/";

	public static String ivrdir = "/usr/local/freeswitch/conf/ivr_menus/";

	public static String reloadCmd = " fs_cli -x reloadxml";

	public static String reloadList = "fs_cli -x \"blacklist reload\"";
	public static String reloadGateway = "sofia profile external rescan reloadxml";

	public static String removefileCmd = "rm -rf ";

	public static void createXmlFile(String fileName, Document doc) {
		try {
			File testfile = new File("fileName");
			if (testfile.exists()) {
				testfile.delete();
			}
			FileWriter fileWriter = new FileWriter(fileName);
			OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
			// xmlFormat.setEncoding("GBK");
			xmlFormat.setSuppressDeclaration(true);
			xmlFormat.setExpandEmptyElements(false);
			XMLWriter xmlWriter = new XMLWriter(fileWriter, xmlFormat);
			xmlWriter.write(doc);
			xmlWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void deleteXmlFile(String fileName) {
		try {
			File testfile = new File(fileName);
			if (testfile.exists()) {
				testfile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getFileName(String dir, String name) {
		String filename = "";
		filename = dir + name + ".xml";
		return filename;
	}

	/**
	 * 修改linux系统时间
	 * 
	 * 问题已解决。大概原因好像是因为linux下执行带参数的命令，用上面的方式会出错。
	 * 用Process对象的getErrorStream()可以看到错误如下： the argument “10:09:08'” lacks a
	 * leading `+'; 目前解决方式是用exec(String[] cmdarray) String cmd =
	 * "/bin/date -s '2012-08-23 10:17:12'" String[] comands = new String[] {
	 * "/bin/sh", "-c", cmd }; Process p = Runtime.getRuntime().exec(comands);
	 * 数组的前两个字符串好像是固定写法。后面是带参数的linux执行命令。
	 * 
	 * 
	 * **/

	public static void excCmdChangeDate(String cmd) {
		String[] comands = new String[] { "/bin/sh", "-c", cmd };
		Runtime rt = Runtime.getRuntime();
		Process ppp;
		try {
			ppp = rt.exec(comands);
			BufferedInputStream in = new BufferedInputStream(ppp
					.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = inBr.readLine()) != null)
				// 获得命令执行后在控制台的输出信息
				System.out.println(lineStr);
			// 检查命令是否执行失败。
			try {
				if (ppp.waitFor() != 0) {
					if (ppp.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
						System.err.println("命令执行失败!");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inBr.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void excCmd(String cmd) {
		Runtime rt = Runtime.getRuntime();
		Process ppp;
		try {
			ppp = rt.exec(cmd);
			BufferedInputStream in = new BufferedInputStream(ppp
					.getInputStream());
			BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
			String lineStr;
			while ((lineStr = inBr.readLine()) != null)
				// 获得命令执行后在控制台的输出信息
				System.out.println(lineStr);
			// 检查命令是否执行失败。
			try {
				if (ppp.waitFor() != 0) {
					if (ppp.exitValue() == 1)// p.exitValue()==0表示正常结束，1：非正常结束
						System.err.println("命令执行失败!");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inBr.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Userinfo userinfo = new Userinfo();
		// userinfo.setExtenpwd("1");
		// userinfo.setExtension("1234");
		// userinfo.setExtnlimit("");
		// userinfo.setHavaattachment("true");
		// userinfo.setMailaddress("www.adaf.com");
		// userinfo.setOnenumber("");
		// userinfo.setOpenvoicemail("true");
		// userinfo.setOutdisplayno("1234");
		// userinfo.setSavaattachment("sadf");
		// userinfo.setVoicemailpwd("12");
		// userinfo.setUsername("Hahaha");
		// String fileName =
		// "/usr/local/freeswitch/conf/directory/default/student.xml";
		// fileName = "d:/123.xml";
		// BuildXml.createXmlFile(fileName, BuildXml.initUserxml(userinfo));
		// BuildXml.deleteXmlFile("D:/one2000.xml");
		FileUtil.deleteFile("D:/one2000.xml");
	}

}
