package com.liveneo.plat.service.impl;

import java.io.FileOutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.liveneo.plat.hibernate.dao.Uploadfile;
import com.liveneo.plat.hibernate.dao.dao.iface.UploadfileDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.UploadServiceIface;
import com.liveneo.plat.utils.CreateXml;
import com.liveneo.plat.utils.FileUtil;

public class UploadService extends AbstractBaseService implements UploadServiceIface{

	private UploadfileDAO uploadfileDAO ;
	
	
	public List<Uploadfile> findfileBySql(String sql){
		return this.uploadfileDAO.findBySQL(sql);
	}

	
	public int queryCountFile(DetachedCriteria detachedCriteria){
		return this.uploadfileDAO.getCountByCriteria(detachedCriteria);
	}
	
	public Uploadfile queryFileById(int key){
		return this.uploadfileDAO.get(key);
		
		
	}
	public void add(Uploadfile uploadfile){
		this.uploadfileDAO.save(uploadfile);
	}
	
	public void update(Uploadfile uploadfile){
		this.uploadfileDAO.update(uploadfile);
	}
	public void delfile(int id){
		Uploadfile file=this.queryFileById(id);
		FileUtil.delete(CreateXml.uploadvoicefile+"/"+file.getFiletype()+"/"+file.getFilename());
		String holdmusicpath=FileUtil.getHoldmusic(CreateXml.varsdir);
		if(StringUtils.equals(holdmusicpath, file.getFilepath())){
			this.backholdmusic();
		}
		this.uploadfileDAO.delete(id);
	}
	
	
	//还原文件
	public void backholdmusic(){
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        // 2.从DOM工厂里获取DOM解析器
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        // 3.解析XML文档，得到document，即DOM树
	        Document doc = db.parse(CreateXml.varsdir);
	        NodeList x=doc.getElementsByTagName("X-PRE-PROCESS");
	       	 for(int i=0;i<x.getLength();i++){
	            	Element element=(Element) x.item(i);
	            	String data=element.getAttribute("data");
	    			if(StringUtils.substringBefore(data, "=").equals("hold_music")){
	    			element.setAttribute("data", "hold_music=local_stream://moh");
	    			break;
	    			}
	            }
			//保存xml文件
	        TransformerFactory transformerFactory=TransformerFactory.newInstance();
	        Transformer transformer=transformerFactory.newTransformer();
	        DOMSource domSource=new DOMSource(doc);
	        //设置编码类型
	        transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
	        StreamResult result=new StreamResult(new FileOutputStream(CreateXml.varsdir));
	        //把DOM树转换为xml文件
	        transformer.transform(domSource, result);
			}catch(Exception e){
				e.getStackTrace();
			}
	}
	public List<Uploadfile> queryAll(){
		return this.uploadfileDAO.findAll();
	}
	public List<Uploadfile> queryHoldmusic(){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Uploadfile.class);
		detachedCriteria.add(Restrictions.eq(Uploadfile.PROP_FILETYPE,"hold_music"));
		return this.uploadfileDAO.findByCriteria(detachedCriteria);
	}
	
	public List<Uploadfile> queryIvr(){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Uploadfile.class);
		detachedCriteria.add(Restrictions.eq(Uploadfile.PROP_FILETYPE,"announcement"));
		return this.uploadfileDAO.findByCriteria(detachedCriteria);
	}
	
	public Uploadfile queryHoldmusicname(String colname, String colvalue){
		return this.uploadfileDAO.getByUniqueIndex(colname, colvalue);
	}
	public UploadfileDAO getUploadfileDAO() {
		return uploadfileDAO;
	}


	public void setUploadfileDAO(UploadfileDAO uploadfileDAO) {
		this.uploadfileDAO = uploadfileDAO;
	}
	
	
	
	
}
