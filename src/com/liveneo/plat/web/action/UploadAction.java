package com.liveneo.plat.web.action;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.liveneo.plat.hibernate.dao.Uploadfile;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.impl.UploadService;
import com.liveneo.plat.utils.BuildXml;
import com.liveneo.plat.utils.CreateXml;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.FileUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.UploadForm;
import com.liveneo.plat.web.form.UserinfoForm;

public class UploadAction extends AbstractActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UploadForm uploadForm;
	private UploadService uploadService;
	
	private String fileKey;
	private File upload;
    private String uploadFileName;
    private String uploadContentType;
	private String queryfilename;
	
	private String holdmusicpath;
	
	public String selectholdmusic(){
		try{
		List<Uploadfile> existlist=new ArrayList<Uploadfile>();
		List<Uploadfile>  listfile=this.uploadService.queryHoldmusic();
		for(Uploadfile u:listfile){
			File file=new File(u.getFilepath());
			if(file.exists()){
				existlist.add(u);
			}else{
				this.uploadService.delfile(u.getId());
			}
		}
		this.getSession().setAttribute("listfile",existlist);
//		System.out.println("holdmusic:"+FileUtil.getHoldmusic(CreateXml.varsdir));
//		Uploadfile uploadfile=this.uploadService.queryHoldmusicname(Uploadfile.PROP_FILEPATH, FileUtil.getHoldmusic(CreateXml.varsdir));
		this.getSession().setAttribute("holdmusic",FileUtil.getHoldmusic(CreateXml.varsdir));
		return SUCCESS;
		}catch(Exception e){
			e.getStackTrace();
			return ajaxForwardError(getText(e.getMessage()));
		}
		
	}
	public String saveholdmusic(){
//		File file=new File(holdmusicpath);
//		if(!file.exists()){
//			return ajaxForwardError(getText("该文件不存在！"));
//		}
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
    				if(StringUtils.isNotEmpty(holdmusicpath)){
    					element.setAttribute("data", "hold_music="+holdmusicpath);
    				}else{
    					element.setAttribute("data", "hold_music=local_stream://moh");
    				}
    				
    				break;
    			}
            	}
		//保存xml文件
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
        DOMSource domSource=new DOMSource(doc);
        //设置编码类型
        transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
        StreamResult result=new StreamResult(new FileOutputStream(CreateXml.varsdir));
        //把DOM树转换为xml文件
        transformer.transform(domSource, result);
        String liststr=CreateXml.stringbackfromfile(CreateXml.varsdir,"ISO8859-1");
		if(StringUtils.isNotEmpty(liststr) && StringUtils.contains(liststr, "?>")){
			FileUtil.string2File(StringUtils.substringAfter(liststr, "?>"), CreateXml.varsdir);
		}
		BuildXml.excCmd(BuildXml.reloadCmd);
		return ajaxForwardSuccess(getText("common.saveok"));
		}catch(Exception e){
			e.getStackTrace();
			return ajaxForwardError(getText(e.getMessage()));
		}
	}
	
	public String addfile() {
		uploadForm = new UploadForm();
		fileKey = "";
		return SUCCESS;
	}

	public String savefile() {
		try {
			Uploadfile file=new Uploadfile();
				WebappUtil.copyProperties(file, uploadForm);
				if(!StringUtils.substringAfter(uploadFileName, ".").equals("wav")){
					return ajaxForwardError(getText("upload.wav"));
				}
				file.setCreatetime(new Date());
				String filename=DateUtil.formatDateByFormat(new Date(),"yyyy-MM-dd-HH-mm")+"_"+uploadFileName;
				file.setFilename(filename);
				File ifexsit=new File(CreateXml.uploadvoicefile+"/"+file.getFiletype()+"/");
				if(!ifexsit.exists()){
					ifexsit.mkdir();
				}
				file.setFilepath(CreateXml.uploadvoicefile+"/"+file.getFiletype()+"/"+filename);		
				FileUtil.upLoadFile(upload, new File(CreateXml.uploadvoicefile+"/"+file.getFiletype()+"/"+filename));
				this.uploadService.add(file);
				this.logService(getRequest()).addLog(this.getRequest(), "LOGTYPE-XZ", file.toString(), Uploadfile.REF);
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}
	public String listfile() {
		int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil.converStrToInteger(this.getPageNum())-1 : 0;
		int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
		int startIndex = pageNum * IntegerUtil.converStrToInteger(getNumPerPage());
		
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryfilename("");
		}
		List<Uploadfile> l = this.uploadService.findfileBySql(this.getHql(startIndex,numPerPage));
		
		this.getSession().setAttribute("uploadList", l);
		int i = 0;
		i = this.uploadService.queryCountFile(this.getDetachedCriteria());
		
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
			return AbstractActionSupport.LIST;
	}
	private String getHql(int startIndex,int pageNum){
		String hql="select * from Uploadfile where PK_UPFILE >0 ";
		
		if (StringUtils.isNotEmpty(queryfilename)) {
			hql += " and Filename like '%"+queryfilename+"%'";
		}
		hql += "LIMIT "+startIndex+","+pageNum;
		return hql;
	}
	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Uploadfile.class);
		detachedCriteria.addOrder(Order.asc(Uploadfile.PROP_ID));
		if (StringUtils.isNotEmpty(queryfilename)) {
			detachedCriteria.add(Restrictions.ilike(Uploadfile.PROP_FILENAME,queryfilename,MatchMode.ANYWHERE));
		}
		return detachedCriteria;
	}

	public String deletefile() {
		try{
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if(StringUtils.isNotEmpty(selectIDS)){
				List<String> keyList = new ArrayList<String>();
				keyList = ListUtil.ConvertArrayToStringList(StringUtils.split(selectIDS,','), "String");
				if (keyList != null) {
					for (String key : keyList) {
						this.uploadService.delfile(IntegerUtil.converStrToInteger(key));
//						Uploadfile uploadfile=this.uploadService.queryFileById(IntegerUtil.converStrToInteger(key));
//						String str=FileUtil.getHoldmusic(CreateXml.varsdir);
//						if(StringUtils.equals(uploadfile.getFilepath(), str)){
//							backholdmusic();
//						}
					}
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(), "LOGTYPE-SC", "delete："+selectIDS.toString(), Uploadfile.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		}catch(Exception ex){
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}
	public UploadForm getUploadForm() {
		return uploadForm;
	}

	public void setUploadForm(UploadForm uploadForm) {
		this.uploadForm = uploadForm;
	}

	public UploadService getUploadService() {
		return uploadService;
	}

	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public String getQueryfilename() {
		return queryfilename;
	}

	public void setQueryfilename(String queryfilename) {
		this.queryfilename = queryfilename;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public String getHoldmusicpath() {
		return holdmusicpath;
	}


	public void setHoldmusicpath(String holdmusicpath) {
		this.holdmusicpath = holdmusicpath;
	}

}
