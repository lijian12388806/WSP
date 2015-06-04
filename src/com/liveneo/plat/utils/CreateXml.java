package com.liveneo.plat.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.liveneo.plat.hibernate.dao.BdDictdetail;
import com.liveneo.plat.hibernate.dao.Userinfo;

public class CreateXml {

	public static String network = "/etc/sysconfig/network-scripts/ifcfg-eth0";
	public static String startEth0 = "ifup eth0";
	public static String stopEth0 = "ifdown eth0";
	public static String timeconf = "/bin/date -s ";
	// 系统还原备份conf
	public static String deletefilecmd = "rm -rf ";
	public static String backupsource = "/usr/local/freeswitch/conf/";
	public static String backupconf = "/usr/local/freeswitch/conf";
	// public static String backupconf="/tmp/conf";
	public static String backuptarget = "/tmp/backup/";
	public static String zip = "zip -r ";
	// 数据库还原备份db
	public static String sudo = "sudo chmod +s /bin/date";
	public static String unzippath = "unzip -o /tmp/backup/";

	public static String unzipto = "-d /";
	// 广播寻呼
	public static String featurecodesdir = "/usr/local/freeswitch/conf/dialplan/Advanced/";
	public static String radiopagingdir = "/usr/local/freeswitch/conf/dialplan/Advanced/";
	public static String recordingdir = "/usr/local/freeswitch/conf/dialplan/Advanced/";
	public static String recordingsdir = "/usr/local/freeswitch/recordings/";
	public static String featuresxml = "/usr/local/freeswitch/conf/dialplan/features.xml";

	public static String callforwarddir = "/usr/local/freeswitch/conf/dialplan/CallRoute/";
	public static String varsdir = "/usr/local/freeswitch/conf/vars.xml";
	// 振铃组
	public static String ringgroupdir = "/usr/local/freeswitch/conf/dialplan/Groups/";
	public static String ringpublicxml = "/usr/local/freeswitch/conf/directory/default.xml";
	// 上传文件路径
	public static String uploadvoicefile = "/tmp/sounds";
	// 系统状态
	public static String regstatus = "fs_cli -x \"sofia status profile internal reg\"";
	public static String syslog = "/usr/local/freeswitch/log/freeswitch.log";
	public static String e1status = "fs_cli -x \"ftdm list\"";
	public static String gatewaystatus = "fs_cli -x \"sofia status gateway\"";
	public static String callreportdir = "perl /usr/local/freeswitch/log/cdr-csv/fs-load-cdr-mysql.pl";
	public static String callreportpath = "/usr/local/freeswitch/log/cdr-csv/fs-load-cdr-mysql.pl";
	// 黑白名单
	public static String blackwhitedir = "/usr/local/freeswitch/conf/dialplan/Advanced/";
	public static String blacklistsdir = "/usr/local/freeswitch/blacklists/";
	public static String blacklistconf = "/usr/local/freeswitch/conf/autoload_configs/blacklist.conf.xml";
	public static String addblacklist = "fs_cli -x \"blacklist add ";
	public static String saveblacklist = "fs_cli -x \"blacklist save ";

	// 一号通
	public static String onenumberdir = "/usr/local/freeswitch/conf/dialplan/Advanced/";
	// 语音邮箱
	public static String voicemailconfdir = "/usr/local/freeswitch/conf/autoload_configs/voicemail.conf.xml";
	public static String ssmtpdir = "/etc/ssmtp/ssmtp.conf";
	// 系统服务
	public static String restartFreeswitch = "";
	public static String restartLinux = "reboot";
	// 中继
	public static String liste1 = "dahdi_scan";
	public static String freetdmconf = "/usr/local/freeswitch/conf/freetdm.conf";
	// freeswitch状态
	public static String freeswitchstatus = "fs_cli -x \"status\"";
	// 查看硬盘的指令
	public static String harddisk = "df -lh";
	// 内存使用情况
	public static String memory = "free";
	// 主机名
	public static String hostname = "hostname";
	// linux指令删除文件
	public static String delfile = "rm -rf ";

	// 时间化分钟
	public static int changeMinute(String date) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat("MM-dd");
		String str = formatDate.format(date);
		Date d = formatDate.parse(str);
		int i = (int) d.getTime() / 60000;
		return i;
	}

	public static Document initPickupxml(BdDictdetail bean)
			throws ParseException {
		Document doc = DocumentHelper.createDocument();
		Element includeElement = doc.addElement("include");
		Element extElement = includeElement.addElement("extension");
		extElement.addAttribute("name", "group-intercept");
		Element conElement = extElement.addElement("condition");
		conElement.addAttribute("field", "destination_number");
		conElement.addAttribute("expression", "^\\" + bean.getValue() + "$");
		Element actElement1 = conElement.addElement("action");
		actElement1.addAttribute("application", "answer");
		Element actElement2 = conElement.addElement("action");
		actElement2.addAttribute("application", "intercept");
		actElement2
				.addAttribute("data", "${db(select/last_dial/${callgroup})}");
		Element actElement3 = conElement.addElement("action");
		actElement3.addAttribute("application", "sleep");
		actElement3.addAttribute("data", "2000");
		return doc;
	}

	public static Document initSpecialPickupxml(BdDictdetail bean)
			throws ParseException {
		Document doc = DocumentHelper.createDocument();
		Element includeElement = doc.addElement("include");
		Element extElement = includeElement.addElement("extension");
		extElement.addAttribute("name", "intercept-ext");
		Element conElement = extElement.addElement("condition");
		conElement.addAttribute("field", "destination_number");
		conElement.addAttribute("expression", "^\\" + bean.getValue()
				+ "(\\d+)$");
		Element actElement1 = conElement.addElement("action");
		actElement1.addAttribute("application", "answer");
		Element actElement2 = conElement.addElement("action");
		actElement2.addAttribute("application", "intercept");
		actElement2.addAttribute("data",
				"${hash(select/${domain_name}-last_dial_ext/$1)}");
		Element actElement3 = conElement.addElement("action");
		actElement3.addAttribute("application", "sleep");
		actElement3.addAttribute("data", "2000");
		return doc;
	}

	public static Document initTransferxml(BdDictdetail bean)
			throws ParseException {
		Document doc = DocumentHelper.createDocument();
		Element includeElement = doc.addElement("include");
		Element extElement = includeElement.addElement("extension");
		extElement.addAttribute("name", "zhuanjie");
		extElement.addAttribute("continue", "true");
		Element conElement = extElement.addElement("condition");
		conElement.addAttribute("field", "destination_number");
		conElement.addAttribute("expression", "^(\\d+)$");
		conElement.addAttribute("break", "never");
		Element actElement = conElement.addElement("action");
		actElement.addAttribute("application", "bind_meta_app");
		String str = bean.getValue().substring(1, bean.getValue().length());
		actElement.addAttribute("data", str + " "
				+ "b s execute_extension::attented_xfer XML features");
		return doc;
	}

	public static String featureString(String timeout, String discall) {
		StringBuffer sb = new StringBuffer();
		sb.append("<extension name=\"attented_xfer\">");
		sb
				.append("<condition field=\"destination_number\" expression=\"^attented_xfer$\">");
		sb.append("<action application=\"set\" data=\"call_timeout=" + timeout
				+ "\">");
		sb
				.append("<action application=\"read\" data=\"3 4 ivr/ivr-enter_ext.wav attxfer_callthis 30000 #\"/>");
		sb.append("<action application=\"set\" data=\"origination_cancel_key="
				+ discall + "\"/>");
		sb
				.append("<action application=\"att_xfer\" data=\"user/${attxfer_callthis}@${domain_name}\"/>");
		sb.append("</condition>");
		sb.append("</extension>");
		return backupsource;
	}

	public static Document initUvoicexml(BdDictdetail bean)
			throws ParseException {
		Document doc = DocumentHelper.createDocument();
		Element includeElement = doc.addElement("include");
		Element extElement = includeElement.addElement("extension");
		extElement.addAttribute("name", "yijianluyin");
		Element conElement = extElement.addElement("condition");
		conElement.addAttribute("field", "destination_number");
		conElement.addAttribute("expression", "^(\\d+)$");
		conElement.addAttribute("break", "never");
		Element actElement = conElement.addElement("action");
		actElement.addAttribute("application", "bind_meta_app");
		String str = bean.getValue().substring(1, bean.getValue().length());
		actElement
				.addAttribute(
						"data",
						str
								+ " "
								+ "b s record_session::$${recordings_dir}/${caller_id_number}.${strftime(%Y-%m-%d-%H-%M-%S)}.wav");
		return doc;
	}

	// 创建*.list文件
	public static void buildlistfile(String contact, String filePath) {
		FileUtil.string2File(contact, filePath);
	}

	// 初始化
	// 读取linux配置文件属性
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

	// apache 读取properties文件
	// 转移文件
	public static void upLoadFile(File source, File target) {
		final int FILE_SIZE = 1024 * 1024 * 1024;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(source), FILE_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(target),
					FILE_SIZE);
			byte[] image = new byte[FILE_SIZE];
			while (in.read(image) > 0) {
				out.write(image);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException ex) {

			}
		}
	}

	// 文件转换成List集合
	public static List<String> extcmdbackfromfile(String file, String encoding)
			throws IOException {
		// Process exec = Runtime.getRuntime().exec("ipconfig");
		//
		// InputStream inputStream = exec.getInputStream();
		List<String> list = new ArrayList<String>();
		InputStreamReader inputStreamReader = new InputStreamReader(
				new FileInputStream(file), encoding);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		try {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
			inputStreamReader.close();
			bufferedReader.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// 文件转换成字符串
	public static String stringbackfromfile(String file, String encoding)
			throws IOException {
		// Process exec = Runtime.getRuntime().exec("ipconfig");
		//
		// InputStream inputStream = exec.getInputStream();
		// List<String> list=new ArrayList<String>();
		InputStreamReader inputStreamReader = new InputStreamReader(
				new FileInputStream(file), encoding);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		try {
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append("\n");
				sb.append(line);
			}
			inputStreamReader.close();
			bufferedReader.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// linux命令结果返回list集合
	public static List<String> extcmdback(String cmd, String encoding)
			throws IOException {
		List<String> list = new ArrayList<String>();
		String[] comands = new String[] { "/bin/sh", "-c", cmd };
		Process exec = Runtime.getRuntime().exec(comands);
		InputStream inputStream = exec.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, encoding);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			list.add(line);
		}
		return list;
	}

	public static List<String> extcmdback2(String cmd, String encoding)
			throws IOException {
		List<String> list = new ArrayList<String>();
		Process exec = Runtime.getRuntime().exec(cmd);
		InputStream inputStream = exec.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, encoding);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			list.add(line);
		}
		return list;
	}

	// linux命令返回结果返回字符串
	public static String extcmdbackstring(String cmd, String encoding)
			throws IOException {
		String[] comands = new String[] { "/bin/sh", "-c", cmd };
		Process exec = Runtime.getRuntime().exec(comands);
		InputStream inputStream = exec.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, encoding);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append("\n");
			sb.append(line);
		}
		inputStreamReader.close();
		bufferedReader.close();
		return sb.toString();
	}

	public static String extcmdbackstring2(String cmd, String encoding)
			throws IOException {
		Process exec = Runtime.getRuntime().exec(cmd);
		InputStream inputStream = exec.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream, encoding);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println("line:" + line);
			sb.append("\n");
			sb.append(line);
		}
		inputStreamReader.close();
		bufferedReader.close();
		return sb.toString();
	}

	public static void extcmdback3() throws IOException {
		List<String> list = CreateXml.extcmdback("ipconfig", "GBK");
		System.out.println(list.get(4));
	}

	/***
	 * 
	 * 按空格差分字符串
	 * 
	 * */
	public static String[] splitStringBySpace(String str) {
		String[] b = str.split("\\s+(?=(zt|PRI_))");
		return b;
	}

	public static List<String> splitStringByCommonSpace(String str) {
		List<String> strs = new ArrayList<String>();
		String[] b = str.split("\\s");
		for (int i = 0; i < b.length; i++) {
			if (!StringUtils.equals(b[i], "")) {
				strs.add(b[i]);
			}
		}
		return strs;
	}

	public static String splitStringByMoreSpace(String str) {
		String b = str.replaceAll("{2,}", " ");
		return b;
	}

	/**
	 * list<String> 转换成字符串
	 * 
	 * **/
	public static String list2String(List<String> lists) {
		StringBuffer sb = new StringBuffer();
		if (lists.size() > 0) {

			for (String s : lists) {
				sb.append("\n");
				sb.append(s);
			}
		}
		return sb.toString();
	}

	/**
	 * list<String> 转换成字符串 每个String之间加字符
	 * 
	 * **/
	public static String list2StringStr(List<String> lists, String str) {
		StringBuffer sb = new StringBuffer();
		if (lists.size() > 0) {

			for (String s : lists) {
				sb.append(s);
				sb.append(str);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
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
		// CreateXml.saveProperties(CreateXml.readProperties(test), test);
		// CreateXml.readProperties("");

		// Variables v=new Variables();
		// v.setVarname("a");
		// v.setVarvalue("b");
		// v.setVarstyle("ss");
		// v.setDescription("test");
		// List<Variables> list=new ArrayList<Variables>();
		// list.add(v);
		// try {
		// BuildXml.createXmlFile("D:\\ttst.xml", CreateXml.initVarsxml(list));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		//		
		// String str="*aaa";
		// System.out.println(str.substring(1,str.length()));
		// List<String> strs=CreateXml.extcmdback2();
		// for(String s:strs){
		// if(StringUtils.contains(s, "=>") && StringUtils.substringBefore(s,
		// "=>").trim().equalsIgnoreCase("d-channel")){
		// System.out.println(s);
		// }
		// }
		// CreateXml.test();
		// String[] b=CreateXml.splitStringBySpace("[span zt PRI_1]");
		// for(int i=0;i<b.length;i++){
		// if(StringUtils.contains(b[i], "]")){
		// System.out.println(b[i]);
		// System.out.println(StringUtils.substringBefore(b[i], "]"));
		// System.out.println(StringUtils.substringAfter(StringUtils.
		// substringBefore(b[i], "]"), "_"));
		// }
		// }

		// List<String>
		// list=CreateXml.extcmdbackfromfile("D:/fs-load-cdr-mysql.pl",
		// "ISO8859-1");
		// for(String s:list){
		// if(StringUtils.substringBefore(s, "=").trim().equals("my $dbh")){
		// System.out.println(StringUtils.substringAfter(s, "="));
		// }
		// }
//		List<String> listm1 = CreateXml
//				.splitStringByCommonSpace("total      used       ree      shared        buffers      cached");
//		for (String s : listm1) {
//			System.out.println(s);
//		}
		
		Random r = new Random();
		r.nextInt(3+1);
		System.out.println(r.nextInt(3+1));
//		int x;
//		x=(int)(Math.random()*1);
//		System.out.println(x);
	}
}
