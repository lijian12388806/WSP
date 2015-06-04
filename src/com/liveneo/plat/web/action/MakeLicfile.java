package com.liveneo.plat.web.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.liveneo.plat.web.form.FeatureForm;
import com.liveneo.plat.web.form.LicForm;

public class MakeLicfile {

	public static String licdir = "/usr/local/freeswitch/conf/directory/default/";

	public static void createXmlFile(String fileName, Document doc) {
		try {
			File testfile = new File("fileName");
			if (testfile.exists()) {
				testfile.delete();
			}
			FileWriter fileWriter = new FileWriter(fileName);
			OutputFormat xmlFormat = OutputFormat.createPrettyPrint();
			xmlFormat.setEncoding("UTF-8");
			xmlFormat.setSuppressDeclaration(false);
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
	
	public static Document initLicFile(LicForm licForm) {
		Document doc = DocumentHelper.createDocument();
		Element corporationEle = doc.addElement("Liveneo");
		corporationEle.addAttribute("platformType", licForm.getPlatformType());
		corporationEle.addAttribute("sid", licForm.getSid());
		corporationEle.addAttribute("version", licForm.getF_version());
		
		Element licElement = corporationEle.addElement("License");
		licElement.addAttribute("genDate", licForm.getGenDate());
		licElement.addAttribute("genTime", licForm.getGenTime());
		licElement.addAttribute("type", licForm.getType());
		licElement.addAttribute("version", licForm.getLic_version());
		
		Element hostidEle = licElement.addElement("HostID");
		hostidEle.setText(licForm.getHostID());
		
		Element notesEle = licElement.addElement("Notes");
		notesEle.setText(licForm.getNotes());
		
		Element productEle = licElement.addElement("Product");
		Element pdNameEle = productEle.addElement("Name");
		Element pdDispEle = productEle.addElement("DisplayName");
		Element pdVersion = productEle.addElement("Version");
		pdNameEle.setText(licForm.getProductName());
		pdDispEle.setText(licForm.getProductDisplayName());
		pdVersion.setText(licForm.getProductVersion());
		Element featuresEle = licElement.addElement("Features");
		if(null != licForm.getFeatureList()){
			for(FeatureForm ff : licForm.getFeatureList()){
				Element feaEle = featuresEle.addElement("Feature");
				feaEle.addAttribute("name", ff.getFeatureName());
				Element disnameEle = feaEle.addElement("DisplayName");
				disnameEle.setText(ff.getFeatureDisplayName());
				Element fvalueEle = feaEle.addElement("Value");
				fvalueEle.setText(ff.getFeatureValue());
				Element fexpEle = feaEle.addElement("ExpirationDate");
				fexpEle.setText(ff.getFeatureExpDate());
			}
		}
		Element signElement = corporationEle.addElement("Signature");
		signElement.setText(licForm.getSignature());
		return doc;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// fileName = "d:/123.xml";
		// BuildXml.createXmlFile(fileName, BuildXml.initUserxml(userinfo));
		// BuildXml.deleteXmlFile("D:/one2000.xml");
//		FileUtil.deleteFile("D:/one2000.xml");
	}

}
