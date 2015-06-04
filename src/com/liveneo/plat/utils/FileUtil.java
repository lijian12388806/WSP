package com.liveneo.plat.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.liveneo.plat.web.form.CountRatioForm;
import com.liveneo.plat.web.form.SubtotalsForm;


public class FileUtil {	
	public static File dirFrom;
	public static File dirTo;

	public static Boolean ifexist(String filepath) {
		Boolean b = true;
		if (!new File(filepath).exists()) {
			b = false;
		}
		return b;
	}

	public void listFileInDir(File file) {

		File[] files = file.listFiles();
		for (File f : files) {
			String tempfrom = f.getAbsolutePath();
			String tempto = tempfrom.replace(dirFrom.getAbsolutePath(), dirTo
					.getAbsolutePath()); // 后面的路径 替换前面的路径名
			if (f.isDirectory()) {
				File tempFile = new File(tempto);
				tempFile.mkdirs();
				listFileInDir(f);
			} else {
				System.out.println("源文件:" + f.getAbsolutePath());
				//   
				int endindex = tempto.lastIndexOf("\\");// 找到"/"所在的位置
				String mkdirPath = tempto.substring(0, endindex);
				File tempFile = new File(mkdirPath);
				tempFile.mkdirs();// 创建立文件夹
				System.out.println("目标点:" + tempto);
				copy(tempfrom, tempto);
			}
		}
	}

	/**
	 * 封装好的文件拷贝方法
	 */
	public void copy(String from, String to) {
		try {
			InputStream in = new FileInputStream(from);
			OutputStream out = new FileOutputStream(to);

			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFile(File source, File target) {
		FileUtil.dirFrom = source;
		FileUtil.dirTo = target;
		FileUtil copy = new FileUtil();
		copy.listFileInDir(source);
	}

	// 上传文件

	public static void upLoadFile(File source, File target) {
		int FILE_SIZE = (int) source.length();
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

	// 清空文件夹
	public static void clearFile(String dir) {
		File delfolder = new File(dir);
		File oldFile[] = delfolder.listFiles();
		try {
			for (int i = 0; i < oldFile.length; i++) {
				if (oldFile[i].isDirectory()) {
					clearFile(dir + oldFile[i].getName() + "//"); // 递归清空子文件夹
				}
				oldFile[i].delete();
			}
		} catch (Exception e) {
			System.out.println("清空文件夹操作出错!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @author XWZ 2007-11-27 删除文件或目录
	 */
	/**
	 * 删除文件，可以是单个文件或文件夹
	 * 
	 * @param fileName
	 *            待删除的文件名
	 * @return 文件删除成功返回true,否则返回false
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("删除文件失败：" + fileName + "文件不存在");
			return false;
		} else {
			if (file.isFile()) {
				return deleteFile(fileName);
			} else {
				return deleteDirectory(fileName);
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true,否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			// System.out.println("删除单个文件"+fileName+"成功！");
			return true;
		} else {
			// System.out.println("删除单个文件"+fileName+"失败！");
			return false;
		}
	}

	/**
	 * 删除目录（文件夹）以及目录下的文件
	 * 
	 * @param dir
	 *            被删除目录的文件路径
	 * @return 目录删除成功返回true,否则返回false
	 */
	public static boolean deleteDirectory(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator)) {
			dir = dir + File.separator;
		}
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			// System.out.println("删除目录失败"+dir+"目录不存在！");
			return false;
		}
		boolean flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
			// 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag) {
					break;
				}
			}
		}

		if (!flag) {
			// System.out.println("删除目录失败");
			return false;
		}

		// 删除当前目录
		if (dirFile.delete()) {
			// System.out.println("删除目录"+dir+"成功！");
			return true;
		} else {
			// System.out.println("删除目录"+dir+"失败！");
			return false;
		}
	}

	/**
	 * 文本文件转换为指定编码的字符串
	 * 
	 * @param file
	 *            文本文件
	 * @param encoding
	 *            编码类型
	 * @return 转换后的字符串
	 * @throws IOException
	 */
	public static String file2String(File file, String encoding) {
		InputStreamReader reader = null;
		StringWriter writer = new StringWriter();
		try {
			if (encoding == null || "".equals(encoding.trim())) {
				reader = new InputStreamReader(new FileInputStream(file),
						encoding);
			} else {
				reader = new InputStreamReader(new FileInputStream(file));
			}
			// 将输入流写入输出流
			char[] buffer = new char[(int) file.length()];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		// 返回转换结果
		if (writer != null)
			return writer.toString();
		else
			return null;
	}

	/**
	 * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
	 * 
	 * @param res
	 *            原字符串
	 * @param filePath
	 *            文件路径
	 * @return 成功标记
	 */
	public static boolean string2File(String res, String filePath) {
		boolean flag = true;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			File distFile = new File(filePath);
			if (!distFile.getParentFile().exists())
				distFile.getParentFile().mkdirs();
			bufferedReader = new BufferedReader(new StringReader(res));
			bufferedWriter = new BufferedWriter(new FileWriter(distFile));
			char buf[] = new char[1024]; // 字符缓冲区
			int len;
			while ((len = bufferedReader.read(buf)) != -1) {
				bufferedWriter.write(buf, 0, len);
			}
			bufferedWriter.flush();
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
			return flag;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	/**
	 * 将字符串写入指定文件(当指定的父路径中文件夹不存在时，会最大限度去创建，以保证保存成功！)
	 * 
	 * @param text
	 *            原字符串
	 * @param fileName
	 *            文件路径
	 * @return 成功标记
	 */
	// public static void stringToFile(String text,String fileName){
	// try {
	// Document doc = DocumentHelper.parseText(text);
	// BuildXml.createXmlFile(fileName, doc);
	// } catch (DocumentException e) {
	// e.printStackTrace();
	// }
	// }
	// 读取XML文件
	/**
	 * @param args
	 */

	static DocumentBuilderFactory factory = DocumentBuilderFactory
			.newInstance();
	static DocumentBuilder builder = null;

	public static List<Element> readXML(String filepath, String tagName) {
		List<Element> elements = new ArrayList<Element>();
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(filepath));
			Element rootElement = document.getDocumentElement();
			NodeList list = rootElement.getElementsByTagName(tagName);
			for (int i = 0; i < list.getLength(); i++) {
				Element element = (Element) list.item(i);
				elements.add(element);
			}
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("exception:" + e.getMessage());
		}
		return elements;

	}

	public static void test1() {
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse("D:/features.xml");

			NodeList list = doc.getElementsByTagName("Brand");
			for (int i = 0; i < list.getLength(); i++) {
				Element brandElement = (Element) list.item(i);
				String brandName = brandElement.getAttribute("name");
				if (brandName.equals("苹果")) {
					// 属性修改
					brandElement.setAttribute("name", "Apple");
				}
			}

			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
			StreamResult result = new StreamResult(new FileOutputStream(
					"src/test.xml"));
			// 把DOM树转换为xml文件
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static Boolean checkAction(String filepath) {
		Boolean b = false;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			NodeList acts = doc.getElementsByTagName("action");
			for (int i = 0; i < acts.getLength(); i++) {
				Element act = (Element) acts.item(i);
				Element con = (Element) act.getParentNode();
				Element ext = (Element) con.getParentNode();
				if (ext.getAttribute("name").equals("att_xfer")
						&& StringUtils.substringBefore(
								act.getAttribute("data"), "=").equals(
								"call_timeout")) {
					b = true;
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return b;
	}

	// 修改节点属性
	public static void updateXmlAttribute(String filepath,
			String extensionname, String attribute, String updateval) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			NodeList actions = doc.getElementsByTagName("action");
			for (int j = 0; j < actions.getLength(); j++) {
				Element element = (Element) actions.item(j);
				Node node = element.getParentNode();
				Element ext = (Element) node.getParentNode();
				System.out.println(ext.getAttribute("name"));
				if (ext.getAttribute("name").equals(extensionname)) {
					if (StringUtils.substringBefore(
							element.getAttribute("data"), "=")
							.equals(attribute)) {
						element.setAttribute("data", attribute + "="
								+ updateval);
						break;
					}
				}
			}

			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
			StreamResult result = new StreamResult(new FileOutputStream(
					filepath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
			String liststr=CreateXml.stringbackfromfile(filepath,"ISO8859-1");
			if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), filepath);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 更改属性值
	public static void updateXmlAttribute(String filepath, String varname,
			String varvalue) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			NodeList x = doc.getElementsByTagName("X-PRE-PROCESS");
			System.out.println(x.getLength());
			for (int j = 0; j < x.getLength(); j++) {
				Element element = (Element) x.item(j);
				System.out.println(element.getAttribute("data"));
				String data = element.getAttribute("data");
				if (StringUtils.substringBefore(data, "=").equalsIgnoreCase(
						varname)) {
					element.setAttribute("data", varname + "=" + varvalue);
				}
			}

			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
			StreamResult result = new StreamResult(new FileOutputStream(
					filepath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
			String liststr=CreateXml.stringbackfromfile(filepath,"ISO8859-1");
			if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), filepath);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 更改属性值（中继）
	public static void updateXmlAttrByParentNode(String filepath,
			String parentvalue, String paramname, String paramelement,
			String paramvalue) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			NodeList x = doc.getElementsByTagName(paramname);
			System.out.println(x.getLength());
			for (int j = 0; j < x.getLength(); j++) {
				Element element = (Element) x.item(j);
				System.out.println(element.getAttribute("name"));
				String name = element.getAttribute("name");
				if (StringUtils.substringBefore(name, "=").equalsIgnoreCase(
						paramelement)) {
					Element span = (Element) element.getParentNode();
					String spanname = span.getAttribute("name");
					System.out.println("spanname:" + spanname);
					if (spanname.equalsIgnoreCase(parentvalue)) {
						element.setAttribute("value", paramvalue);
					}
				}
			}

			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
			StreamResult result = new StreamResult(new FileOutputStream(
					filepath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
			String liststr=CreateXml.stringbackfromfile(filepath,"ISO8859-1");
			if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), filepath);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 删除节点
	public static void removeXmlNode(String filepath, String groupname) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			NodeList groups = doc.getElementsByTagName("groups");
			NodeList group = doc.getElementsByTagName("group");
			if (groups.getLength() > 0 && group.getLength() > 0) {
				for (int i = 0; i < group.getLength(); i++) {
					Element element = (Element) group.item(i);
					if (element.getAttribute("name").equals(groupname)) {
						if ((element.getElementsByTagName("users").getLength()) > 0) {
							element.removeChild(element.getElementsByTagName(
									"users").item(0));
							Element elcon = (Element) groups.item(0);
							elcon.removeChild(elcon.getElementsByTagName(
									"group").item(i));
						}
						break;
					}
				}
			}

			// }

			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
			StreamResult result = new StreamResult(new FileOutputStream(
					filepath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
			String liststr=CreateXml.stringbackfromfile(filepath,"ISO8859-1");
			if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), filepath);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 添加子节点
	public static void addXmlAction(String filepath, String calltimeout) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			Element actElement = doc.createElement("action");
			actElement.setAttribute("application", "set");
			actElement.setAttribute("data", "call_timeout=" + calltimeout);

			NodeList condition = doc.getElementsByTagName("condition");

			for (int i = 0; i < condition.getLength(); i++) {
				Element conElement = (Element) condition.item(i);
				Element extension = (Element) conElement.getParentNode();
				if (extension.getAttribute("name").equals("att_xfer")) {
					conElement.appendChild(actElement);
					break;
				}
			}
			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
			StreamResult result = new StreamResult(new FileOutputStream(
					filepath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
			String liststr=CreateXml.stringbackfromfile(filepath,"ISO8859-1");
			if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), filepath);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 添加父节点和子节点
	public static void addXmlAttribute(String filepath, String calltimeout,
			String discall) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			Element extElement = doc.createElement("extension");
			extElement.setAttribute("name", "attented_xfer");
			Element conElement = doc.createElement("condition");
			conElement.setAttribute("field", "destination_number");
			conElement.setAttribute("expression", "^attented_xfer$");
			Element actElement1 = doc.createElement("action");
			actElement1.setAttribute("application", "set");
			actElement1.setAttribute("data", "continue_on_fail=true");
			Element actElement2 = doc.createElement("action");
			actElement2.setAttribute("application", "set");
			actElement2.setAttribute("data", "call_timeout=" + calltimeout);
			Element actElement3 = doc.createElement("action");
			actElement3.setAttribute("application", "read");
			actElement3.setAttribute("data",
					"3 4 ivr/ivr-enter_ext.wav attxfer_callthis 30000 #");
			Element actElement4 = doc.createElement("action");
			actElement4.setAttribute("application", "set");
			actElement4.setAttribute("data", "origination_cancel_key="
					+ discall);
			Element actElement5 = doc.createElement("action");
			actElement5.setAttribute("application", "att_xfer");
			actElement5.setAttribute("data",
					"user/${attxfer_callthis}@${domain_name}");
			extElement.appendChild(conElement);
			Element incElement = (Element) doc.getElementsByTagName("context")
					.item(0);
			incElement.appendChild(extElement);
			conElement.appendChild(actElement1);
			conElement.appendChild(actElement2);
			conElement.appendChild(actElement3);
			conElement.appendChild(actElement4);
			conElement.appendChild(actElement5);

			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
			StreamResult result = new StreamResult(new FileOutputStream(
					filepath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
			String liststr=CreateXml.stringbackfromfile(filepath,"ISO8859-1");
			if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), filepath);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 添加父节点和子节点
	public static void addXmlNode(String filepath, List<String> strs,
			String groupname) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			Element groElement = doc.createElement("group");
			groElement.setAttribute("name", groupname);
			Element userssElement = doc.createElement("users");
			Element incElement = (Element) doc.getElementsByTagName("groups")
					.item(0);
			incElement.appendChild(groElement);
			groElement.appendChild(userssElement);
			for (String r : strs) {
				Element userElement = doc.createElement("user");
				userElement.setAttribute("id", r);
				userElement.setAttribute("type", "pointer");
				userssElement.appendChild(userElement);
			}

			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
//			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO8859-1");
			StreamResult result = new StreamResult(new FileOutputStream(
					filepath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);
			String liststr=CreateXml.stringbackfromfile(filepath,"ISO8859-1");
			if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), filepath);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void writeXML(Document document, String filename) {
		try {
			builder = factory.newDocumentBuilder();
			// Document document = builder.parse(new
			// File("E:\\testFiles\\test.xml"));
			document.normalize();

			/** 将document中的内容写入文件中 */
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
//			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			// 编码
			DOMSource source = new DOMSource(document);
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename));
			StreamResult result = new StreamResult(pw);
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void updateXML() {
		try {
			// builder = factory.newDocumentBuilder();
			// Document document = builder.parse(new File(
			// "E:\\testFiles\\test.xml"));
			// Node root = document.getDocumentElement();
			// /** 如果root有子元素 */
			// if (root.hasChildNodes()) {
			// NodeList ftpnodes = root.getChildNodes();
			// /** 循环取得ftpnodes所有节点 */
			// for (int i = 0; i < ftpnodes.getLength(); i++) {
			// Node ftpList = ftpnodes.item(i);
			// System.out.println(ftpList.getTextContent());
			// }
			// for (int i = 0; i < ftpnodes.getLength(); i++) {
			// Node ftpList = ftpnodes.item(i);
			// ftpList
			// .setTextContent(ftpList.getTextContent()
			// + " update");
			// }
			// }
			// writeXML(document, "E:\\testFiles\\test2.xml");

			List<Element> list = FileUtil.readXML("D:\\vars.xml",
					"X-PRE-PROCESS");
			for (Element e : list) {
				e.setAttribute("default_password", "4567");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 读取文件夹
	public static String[] readFile(File file) {
		String[] names = file.list();
		return names;
	}

	

	/**
	 * 
	 * java Excel操作
	 * 
	 * */
	// 2007
	public static List<String> readExcelXSSF(File file) {
		List<String> liststr = new ArrayList<String>();
		try {
			FileInputStream is = new FileInputStream(file);
			XSSFWorkbook wbs = new XSSFWorkbook(is);
			XSSFSheet childSheet = wbs.getSheetAt(0);
//			System.out.println("row:" + childSheet.getLastRowNum());
			for (int i = 1; i <= childSheet.getLastRowNum(); i++) {
				XSSFRow row = childSheet.getRow(i);
				if (row != null) {
					int cols = row.getLastCellNum();
					for (int j = 0; j <= cols; j++) {
						if (row.getCell((short) j) != null) {
							liststr.add(getXSSFCellStringValue(row
									.getCell((short) j)));
						} else {
							liststr.add(" ");
						}
					}
				}

			}
			return liststr;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<String>();
		}
	}

	public static String getXSSFCellStringValue(XSSFCell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_STRING:// 字符串类型
			cellValue = cell.getStringCellValue();
			if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
				cellValue = " ";
			break;
		case XSSFCell.CELL_TYPE_NUMERIC: // 数值类型
			String str = String.valueOf(cell.getNumericCellValue());
			cellValue = StringUtils.substringBefore(str, ".");
			break;
		case XSSFCell.CELL_TYPE_FORMULA: // 公式
			cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
			cellValue = String.valueOf(cell.getNumericCellValue());

			break;
		case XSSFCell.CELL_TYPE_BLANK:
			cellValue = " ";
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case XSSFCell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}
		return cellValue;
	}

	// 2003
	public static List<String> readExcelHSSF(File file) {
		List<String> liststr = new ArrayList<String>();
		try {
			FileInputStream is = new FileInputStream(file);
			HSSFWorkbook wbs = new HSSFWorkbook(is);
			HSSFSheet childSheet = wbs.getSheetAt(0);
			for (int i = 1; i <= childSheet.getLastRowNum(); i++) {
				HSSFRow row = childSheet.getRow(i);
				if (row != null) {
					int cols = row.getLastCellNum();
					System.out.println(cols);
					for (int j = 0; j < cols; j++) {
						liststr.add(getHSSFCellStringValue(row.getCell(j)));
					}
				}

			}
			return liststr;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<String>();
		}
	}

	public static String getHSSFCellStringValue(HSSFCell cell) {
		String cellValue = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:// 字符串类型
			cellValue = cell.getStringCellValue();
			if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
				cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_NUMERIC: // 数值类型
			String str = String.valueOf(cell.getNumericCellValue());
			cellValue = StringUtils.substringBefore(str, ".");
			break;
		case HSSFCell.CELL_TYPE_FORMULA: // 公式
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cellValue = String.valueOf(cell.getNumericCellValue());

			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = " ";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}
		return cellValue;
	}

	public static String getHoldmusic(String filepath) {
		String str = "";
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(filepath);
			NodeList x = doc.getElementsByTagName("X-PRE-PROCESS");
			for (int i = 0; i < x.getLength(); i++) {
				Element element = (Element) x.item(i);
				String data = element.getAttribute("data");
				if (StringUtils.substringBefore(data, "=").equals("hold_music")) {
					str = StringUtils.substringAfter(data, "=");
					break;
				}
			}
			return str;
		} catch (Exception e) {
			e.getStackTrace();
			return "";
		}

	}

	public static List<String> listfilename(String filepath) {
		List<String> liststr = new ArrayList<String>();
		File file = new File(filepath);
		String listfile[];
		if (!file.exists()) {
			return liststr;
		}
		listfile = file.list();
		if (listfile.length > 0) {
			for (int i = 0; i < listfile.length; i++) {
					liststr.add(listfile[i]);
			}
		}
		return liststr;
	}


	/***
	 * 生成Excel文件
	 * 
	 * */

	public static void createExcel(String targetfile) {
		try {
			// 构建 Workbook 对象 , 只读 Workbook 对象
			// Method 1：创建可写入的 Excel 工作薄
			// jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new
			// File(
			// targetfile));
			// Method 2：将 WritableWorkbook 直接写入到输出流
			/*
			 * OutputStream os = new FileOutputStream(targetfile);
			 * jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(os);
			 */
			// jxl.write.WritableSheet ws = wwb.createSheet("通话记录报表", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	public static String listToString(List<String> list) {
		StringBuffer sb = new StringBuffer();
		for (String s : list) {
			sb.append(s);
			sb.append("\n");
		}
		return sb.toString();
	}
	/***
	 * 
	 * 读取配置文件中数据库用户名和密码
	 * */

	
//	public static List<String> readDbUsernameAndPwd(String filepath){
//		try {
//			// 1.得到DOM解析器的工厂实例
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//			// 2.从DOM工厂里获取DOM解析器
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			// 3.解析XML文档，得到document，即DOM树
//			Document doc = db.parse(filepath);
//			NodeList x = doc.getElementsByTagName("property");
//			NodeList d = doc.getElementsByTagName("driver-url");
//			List<String> strs=new ArrayList<String>();
//			String user="";
//			String pwd="";
//			String dbip="";
//			String database="";
//			for (int i = 0; i < x.getLength(); i++) {
//				Element element = (Element) x.item(i);
//				String name = element.getAttribute("name");
//				if (name.equals("user")) {
//					user=element.getAttribute("value");
//				}
//				if (name.equals("password")) {
//					pwd=element.getAttribute("value");
//				}
//			}
//			for(int j=0;j<d.getLength();j++){
//				Element elementd = (Element) d.item(j);
////				String url=elementd.getTextContent();
//				if(StringUtils.contains(url, "jdbc:")){
//					dbip=StringUtils.substringAfter(url, "://");
//					dbip=StringUtils.substringBefore(dbip, "/");
//					database=StringUtils.substringAfter(url, ""+dbip+"/");
//					database=StringUtils.substringBefore(database, "?");
//				}
//			}
//			strs.add("user="+user);
//			strs.add("pwd="+pwd);
//			strs.add("dbip="+dbip);
//			strs.add("database="+database);
//			return strs;
//		} catch (Exception e) {
//			e.getStackTrace();
//			return null;
//		}
//		
//	}
	public static String getListByVname(String vname){
		String vvalue="";
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(CreateXml.varsdir);

			NodeList list = doc.getElementsByTagName("X-PRE-PROCESS");
			for (int i = 0; i < list.getLength(); i++) {
				Element pElement = (Element) list.item(i);
				String pName = pElement.getAttribute("data");
				if (StringUtils.substringBefore(pName, "=").equals(vname)) {
					vvalue=StringUtils.substringAfter(pName, "=");
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return vvalue;
	}
	
	
	public static void updateTest() {
		try {
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(CreateXml.varsdir);
			// 保存xml文件
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			// 设置编码类型
			StreamResult result = new StreamResult(new FileOutputStream(
					CreateXml.varsdir));
			// 把DOM树转换为xml文件
			transformer.transform(domSource,result);
			String list=CreateXml.stringbackfromfile(CreateXml.varsdir,"ISO8859-1");
			if(StringUtils.isNotEmpty(list) && StringUtils.contains(list, "?>")){
				FileUtil.string2File(StringUtils.substringAfter(list, "?>"), CreateXml.varsdir);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public static Map<String,String> getDbinfo(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("1","2");
		return map;
	}
	/**
	 * 判断一个文件夹是否存在，不存在则创建
	 * **/
	
	public  static void createFileIfNot(String filepath){
		File file=new File(filepath);
		if  (!file .exists()  && !file .isDirectory())      
		{  
		    file .mkdir();    
		} else{
			System.out.println(filepath+":file does not exist!");
		}
	}
	
	// 生成Excel文件
	public static void createWclExcel(String fileName, List<SubtotalsForm> content,String title) {
//		System.out.println("content:"+content.size());
		WritableWorkbook wwb;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet(title, 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLUE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.CENTRE);
			ws.setRowView(1, 500);
			// 填充数据的内容
			SubtotalsForm[] p = new SubtotalsForm[content.size()];
			for (int i = 0; i < content.size(); i++) {
				p[i] = (SubtotalsForm) content.get(i);
				if (i == 0) {
					ws.addCell(new Label(0, 0, "统计时间", wcf));
					ws.addCell(new Label(1, 0, "客服专员", wcf));
					ws.addCell(new Label(2, 0, "未处理工单", wcf));
					ws.addCell(new Label(3, 0, "待处理工单", wcf));
					ws.addCell(new Label(4, 0, "已完成工单", wcf));
				}
				ws.addCell(new Label(0, i + 1, p[i].getSubdate(),
						new WritableCellFormat()));
				ws.addCell(new Label(1, i + 1, p[i].getWomaker(),
						new WritableCellFormat()));
				ws.addCell(new Label(2, i + 1, StringUtils.trim(p[i].getWclwo()+""), new WritableCellFormat()));
				ws.addCell(new Label(3, i + 1, StringUtils.trim(p[i].getDhxclwo()+""), new WritableCellFormat()));
				ws.addCell(new Label(4, i + 1, StringUtils.trim(p[i].getYwcwo()+""), new WritableCellFormat()));
			}

			wwb.write();
			wwb.close();
		} catch (Exception e) {
		}
	}
	public static void createStExcel(String fileName, List<SubtotalsForm> content,String title) {
//		System.out.println("content:"+content.size());
		WritableWorkbook wwb;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet(title, 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLUE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.CENTRE);
			ws.setRowView(1, 500);
			// 填充数据的内容 

			SubtotalsForm[] p = new SubtotalsForm[content.size()];
			for (int i = 0; i < content.size(); i++) {
				p[i] = (SubtotalsForm) content.get(i);
				if (i == 0) {
					ws.addCell(new Label(0, 0, "统计时间", wcf));
					ws.addCell(new Label(1, 0, "客服专员", wcf));
					ws.addCell(new Label(2, 0, "小样依赖", wcf));
					ws.addCell(new Label(3, 0, "样板依赖", wcf));
					ws.addCell(new Label(4, 0, "样板需求", wcf));
					ws.addCell(new Label(5, 0, "订单交货", wcf));
					ws.addCell(new Label(6, 0, "现场服务", wcf));
					ws.addCell(new Label(7, 0, "投诉受理", wcf));
					ws.addCell(new Label(8, 0, "退货申请", wcf));
				}
				ws.addCell(new Label(0, i + 1, p[i].getSubdate(),new WritableCellFormat()));
				ws.addCell(new Label(1, i + 1, p[i].getWomaker(),new WritableCellFormat()));
				ws.addCell(new Label(2, i + 1, StringUtils.trim(p[i].getOSampledepend()+""), new WritableCellFormat()));
				ws.addCell(new Label(3, i + 1, StringUtils.trim(p[i].getOAmodeldepend()+""), new WritableCellFormat()));
				ws.addCell(new Label(4, i + 1, StringUtils.trim(p[i].getOSampleReq()+""), new WritableCellFormat()));
				ws.addCell(new Label(5, i + 1, StringUtils.trim(p[i].getOOrderDelivery()+""), new WritableCellFormat()));
				ws.addCell(new Label(6, i + 1, StringUtils.trim(p[i].getOOnsiteservice()+""), new WritableCellFormat()));
				ws.addCell(new Label(7, i + 1, StringUtils.trim(p[i].getOComplainthand()+""), new WritableCellFormat()));
				ws.addCell(new Label(8, i + 1, StringUtils.trim(p[i].getOReturnReq()+""), new WritableCellFormat()));
			}

			wwb.write();
			wwb.close();
		} catch (Exception e) {
		}
	}
	public static void createCountExcel(String fileName, List<CountRatioForm> content,String title) {
//		System.out.println("content:"+content.size());
		WritableWorkbook wwb;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			wwb = Workbook.createWorkbook(fos);
			WritableSheet ws = wwb.createSheet(title, 0); // 创建一个工作表

			// 设置单元格的文字格式
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLUE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setAlignment(Alignment.CENTRE);
			ws.setRowView(1, 500);
			// 填充数据的内容 

			CountRatioForm[] p = new CountRatioForm[content.size()];
			for (int i = 0; i < content.size(); i++) {
				p[i] = (CountRatioForm) content.get(i);
				if (i == 0) {
					ws.addCell(new Label(0, 0, "坐席", wcf));
					ws.addCell(new Label(1, 0, "总单量", wcf));
					ws.addCell(new Label(2, 0, "结单量", wcf));
					ws.addCell(new Label(3, 0, "结单率", wcf));
					ws.addCell(new Label(4, 0, "总耗时", wcf));
					ws.addCell(new Label(5, 0, "平均耗时", wcf));
				}
				ws.addCell(new Label(0, i + 1, p[i].getUserName(),new WritableCellFormat()));
				ws.addCell(new Label(1, i + 1, p[i].getTotalCount(),new WritableCellFormat()));
				ws.addCell(new Label(2, i + 1, p[i].getCloseCount(), new WritableCellFormat()));
				ws.addCell(new Label(3, i + 1, p[i].getRatio(), new WritableCellFormat()));
				ws.addCell(new Label(4, i + 1, p[i].getTotalTime(), new WritableCellFormat()));
				ws.addCell(new Label(5, i + 1, p[i].getAveTime(), new WritableCellFormat()));
			}

			wwb.write();
			wwb.close();
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		// File fromfile = new File("D:\\test");// 源文件夹
		// File tofile = new File("D:\\targettest");// 目标
		// 
		// FileUtil copy = new FileUtil();
		// // 设置来源去向
		// copy.dirFrom = fromfile;
		// copy.dirTo = tofile;
		// copy.listFileInDir(fromfile);
		// File file=new File("D:\\vars.xml");
		// copy.stringToFile(copy.file2String(file, "UTF-8"),
		// "E:\\test\\vars.xml");
		// 读取XMl文件
		// copy.initVariables("E:\\vars.xml","X-PRE-PROCESS","data");
		// FileUtil.copyFile(new File("D:\\test"), new
		// File("E:\\test3\\test4"));
		// FileUtil.readFile(new File("E:\\test3"));
		// System.out.println(StringUtils.substringAfter("a=b", "="));
		// FileUtil.clearFile("D:\\test");
		// FileUtil.delete("D:/aaa.zip");
		// String str=FileUtil.file2String(new File("D:\\vars.xml"), "UTF-8");
		// String sss=str.replaceFirst(
		// "<X-PRE-PROCESS cmd=\"set\" data=\"zrtp_secure_media=true\"/>"
		// ,"<X-PRE-PROCESS cmd=\"set\" data=\"zrtp_secure_media=false\"/>" );
		// System.out.println(sss);
		// FileUtil.string2File(sss, "D:/vars.xml");
		// FileUtil.test();
		// FileUtil.readExcel(new File("D:/Book1.xlsx"));
		// System.out.println(FileUtil.file2String(new
		// File("D:/freeswitch.log"), "ISO8859-1"));
		// StringBuffer sb=new StringBuffer();
		// sb.append("1001");
		// sb.append("\n");
		// sb.append("1002");
		// sb.append("\n");
		// sb.append("1003");
		// FileUtil.string2File(sb.toString(), "D:/book.list");
		// String str=CnToSpell.getFullSpell("yige");
		// System.out.println(str);
		// List<String> list=FileUtil.listfilename("D:/");
		// for(String s:list){
		// System.out.println(s);
		// }
		// List<String> list=FileUtil.readExcelXSSF(new
		// File("D:/UserinfoTemplate.xlsx"));
		// for(String s:list){
		// System.out.println(s);
		// }

		// FileUtil.updateXmlAttrByParentNode("D:/aaa.xml", "PRI_2",
		// "param","context", "dailplan");
//		List<String> list=FileUtil.listfilename("D:/test1/");
//		List<String> strs=FileUtil.readDbUsernameAndPwd("D:/IPTservice/apache-tomcat-6.0.24/webapps/lcpmrg/src/proxool.xml");
//		for(String s:strs){
//			System.out.println(s);
//		}
//	FileUtil.updateTest();	
//		String s="Registered(UDP)(unknown) EXP(2012-10-25 11:44:42) EXPSECS(1222)";
//		s=StringUtils.substringAfter(s, "EXP(");
//		s=StringUtils.substringBefore(s, ") EXP");
//		System.out.println(s);
//		System.out.println(FileUtil.getDbinfo().get("1"));
//		List<String> list=FileUtil.readExcelXSSF(new File("D:/UserinfoTemplate.xlsx"));
//		System.out.println(list.size());
//		for(String s:list){
//			System.out.println(s);
//		}
//		String orderno="201203181000";
//		String date = DateUtil.formatDate(new Date());
//		int maxNo=Integer.parseInt(orderno.substring(8));
//		System.out.println(orderno.substring(8));
//		String result="";
//		if(maxNo<9){
//			result=date.replace("-", "")+"000"+(maxNo+1);
//		}else if(9<=maxNo && maxNo<99){
//			result=date.replace("-", "")+"00"+(maxNo+1);
//		}else if(99<=maxNo && maxNo<999){
//			result=date.replace("-", "")+"0"+(maxNo+1);
//		}else{
//			result=date.replace("-", "")+(maxNo+1);
//		}
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar calendar = Calendar.getInstance();
//        Date theDate = calendar.getTime();
//        String s = df.format(theDate);
//        StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
//        System.out.println(str.toString());
		System.out.println(DateUtil.formatDateByFormat(new Date(), "yyyy-MM"));
//		String nowmonth=DateUtil.formatDateByFormat(new Date(),"MM");
//		System.out.println(nowmonth);
	}
}
