package com.liveneo.plat.web.action.kbms;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.KbmsKlp;
import com.liveneo.plat.service.impl.kbms.KbmsFileService;
import com.liveneo.plat.service.impl.kbms.KbmsKlpService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.kbms.KbmsKlpForm;

public class KbmsKlpAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// service
	private KbmsKlpService kbmsKlpService;
	private KbmsFileService kbmsFileService;
	// form
	private KbmsKlpForm kbmsKlpForm;
	// key
	private String kbmsKlpKey;
	// 查询
	private String kbmsClassKey;
	private String queryname;
	private String query;

	//文件上载
	private File uploadify;
	private String uploadifyFileName;
	private String uploadifyContentType;
	public String execute() {
		return SUCCESS;
	}

	/**
	 * 工单模板配置 -添加
	 */
	public String addKbmsKlp() {
		kbmsKlpForm = new KbmsKlpForm();
		kbmsClassKey = this.getRequest().getParameter("kbmsClassKey");
		kbmsKlpKey = "";
		return SUCCESS;
	}

	/**
	 * 工单模板配置 -保存
	 */
	public String saveKbmsKlp() {
		try {
			kbmsClassKey = this.getRequest().getParameter("kbmsClassKey");
			KbmsKlp bean = new KbmsKlp();
			if (StringUtils.isNotEmpty(kbmsKlpKey)) {
				bean = this.kbmsKlpService.getKbmsKlpByKey(IntegerUtil
						.converStrToInteger(kbmsKlpKey));
				WebappUtil.copyProperties(bean, kbmsKlpForm);
				bean.setModifydate(new Date());
				this.kbmsKlpService.updateKbmsKlp(bean);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", bean.toString(), KbmsKlp.REF);
			} else {
				if (StringUtils.isEmpty(kbmsClassKey)) {
					return ajaxForwardError("请选择子类别!");
				}
				WebappUtil.copyProperties(bean, kbmsKlpForm);
				bean.setClassid(IntegerUtil.converStrToInteger(StringUtils
						.substringBefore(kbmsClassKey, ",")));
				bean.setCreatedate(new Date());
				this.kbmsKlpService.addKbmsKlp(bean);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", bean.toString(), KbmsKlp.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	/**
	 * 工单模板配置 -编辑
	 */
	public String editKbmsKlp() {
		try {
			KbmsKlp bean = new KbmsKlp();
			kbmsKlpForm = new KbmsKlpForm();
			HttpServletRequest req = this.getRequest();
			if (StringUtils.isNotEmpty(kbmsKlpKey)) {
				bean = this.kbmsKlpService.getKbmsKlpByKey(IntegerUtil
						.converStrToInteger(kbmsKlpKey));
			} else {
				return ajaxForwardError("主键丢失!");
			}// 返回list
			WebappUtil.copyProperties(kbmsKlpForm, bean);
			req.setAttribute("KbmsKlpForm", kbmsKlpForm);
			return AbstractActionSupport.EDIT;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("编辑错误!");
		}
	}

	/**
	 * 工单模板配置 -删除
	 */
	public String delKbmsKlp() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					int key = Integer.parseInt(ids[i]);
					this.kbmsKlpService.delKbmsKlp(key);
				}
			}
			this.logService(getRequest())
					.addLog(this.getRequest(), "LOGTYPE-SC",
							"delete:" + selectIDS.toString(), KbmsKlp.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("删除错误！");
		}
	}

	/**
	 * 工单模板配置 -列表
	 */
	public String listKbmsKlp() {
		try {
			kbmsClassKey = this.getRequest().getParameter("kbmsClassKey");
			query = this.getRequest().getParameter("query");
			HttpSession se = this.getSession();
			int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
					.converStrToInteger(this.getPageNum()) - 1
					: 0;
			int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
			int startIndex = pageNum
					* IntegerUtil.converStrToInteger(getNumPerPage());
			String search = this.getRequest().getParameter("search");
			if (StringUtils.equalsIgnoreCase(search, "true")) {
				startIndex = 0 * IntegerUtil
						.converStrToInteger(getNumPerPage());
			}
			String check_changeUrl = this.getRequest()
					.getParameter("changeUrl");
			if (StringUtils.isNotEmpty(check_changeUrl)) {
				this.setKbmsClassKey("9999999999");
			}
			List<KbmsKlp> l = this.kbmsKlpService.findKbmsKlpBySql(this.getSql(
					startIndex, numPerPage));
			se.setAttribute("KbmsKlp_list", l);
			int i = 0;
			i = this.kbmsKlpService.queryCountKbmsKlp(this
					.getDetachedCriteria());
			this.setTotalCount(i);
			se.setAttribute("totalCount", i);
			return AbstractActionSupport.LIST;
		} catch (Exception e) {
			e.getStackTrace();
			log.error(e.getMessage());
			return ajaxForwardError("获取信息错误!");
		}
	}

	private String getSql(int startIndex, int pageNum) {
		String sql = "select * from Kbms_Klp  where Id >0 ";
		if (StringUtils.isNotEmpty(kbmsClassKey)) {
			sql += " and classId in (" + kbmsClassKey + ")";
		}
		if (StringUtils.isNotEmpty(kbmsKlpKey)) {
			sql += " and Id = " + kbmsKlpKey;
		}
		if (StringUtils.isNotEmpty(queryname)) {
			sql += " and (name like '%" + queryname + "%' or content like '%"
					+ queryname + "%')";
		}else{
			if(StringUtils.equalsIgnoreCase(query,"true")){
				sql += " and Id < 0";
			}
		}
		sql += " order by Id desc";
		sql += "  LIMIT " + startIndex + "," + pageNum;
		return sql;
	}

	// 首字母转大写
	public String toUpperCaseFirstOne(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}

	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(KbmsKlp.class);
		if (StringUtils.isNotEmpty(kbmsClassKey)) {
			detachedCriteria.add(Restrictions.sqlRestriction(" classId in ("
					+ kbmsClassKey + ")"));
		}
		if (StringUtils.isNotEmpty(queryname)) {
			detachedCriteria.add(Restrictions.sqlRestriction(" (name like '%"
					+ queryname + "%' or content like '%" + queryname + "%')"));
		}
		return detachedCriteria;
	}
	/**
	 * 知识库 -上载文件
	 */
	public String uploadKbmsKlp() {
		kbmsKlpForm = new KbmsKlpForm();
		kbmsClassKey = this.getRequest().getParameter("kbmsClassKey");
		kbmsKlpKey = "";
		return SUCCESS;
	}
	
//	public String uploadKbmsKlpFile() {
//		String filetype = this.getRequest().getParameter("filetype");
//		String path = null;
//		// 上传文件类型
//		if (null == uploadify) {
//			return ajaxForwardError(getText("请选择文件..."));
//		} else {
//			CcCoreFileinfo fileinfo = new CcCoreFileinfo();
//			// 查询同名的文件
//			List<CcCoreFileinfo> list = this.ccCoreFileinfoService
//					.findfileinfoByPath(path + uploadifyFileName);
//			if (null != list && list.size() > 0) {
//				fileinfo = list.get(0);
//				fileinfo.setModifyDate(DateUtil.formatDateByFormat(new Date(),
//						"yyyy-MM-dd HH:mm:ss"));
//				fileinfo
//						.setFileDesc(this.getRequest().getParameter("filedesc"));
//				fileinfo.setFileType(filetype);
//				this.ccCoreFileinfoService.update(fileinfo);
//			} else {
//				fileinfo.setFileName(uploadifyFileName);
//				fileinfo.setFilePath(path + uploadifyFileName);
//				fileinfo.setCreateDate(DateUtil.formatDateByFormat(new Date(),
//						"yyyy-MM-dd HH:mm:ss"));
//				fileinfo.setModifyDate(DateUtil.formatDateByFormat(new Date(),
//						"yyyy-MM-dd HH:mm:ss"));
//				fileinfo
//						.setFileDesc(this.getRequest().getParameter("filedesc"));
//				fileinfo.setFileType(filetype);
//				this.ccCoreFileinfoService.add(fileinfo);
//			}
//		}
//		try {
//			 File savefile = new File(new File(path),uploadifyFileName);
//	            if (!savefile.getParentFile().exists())
//	                savefile.getParentFile().mkdirs();
//	            FileUtils.copyFile(uploadify, savefile);
//			return ajaxForwardSuccess(getText("上传成功！"));
//		} catch (Exception e) {
//			e.getStackTrace();
//			return ajaxForwardError(getText("上传文件错误..."));
//		}
//	}
	/**
	 * get/set
	 * 
	 * @return
	 */
	public KbmsKlpService getKbmsKlpService() {
		return kbmsKlpService;
	}
	public void setKbmsKlpService(KbmsKlpService kbmsKlpService) {
		this.kbmsKlpService = kbmsKlpService;
	}
	public KbmsKlpForm getKbmsKlpForm() {
		return kbmsKlpForm;
	}
	public void setKbmsKlpForm(KbmsKlpForm kbmsKlpForm) {
		this.kbmsKlpForm = kbmsKlpForm;
	}
	public String getKbmsKlpKey() {
		return kbmsKlpKey;
	}
	public void setKbmsKlpKey(String kbmsKlpKey) {
		this.kbmsKlpKey = kbmsKlpKey;
	}
	public String getKbmsClassKey() {
		return kbmsClassKey;
	}
	public void setKbmsClassKey(String kbmsClassKey) {
		this.kbmsClassKey = kbmsClassKey;
	}
	public String getQueryname() {
		return queryname;
	}
	public void setQueryname(String queryname) {
		this.queryname = queryname;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public File getUploadify() {
		return uploadify;
	}
	public void setUploadify(File uploadify) {
		this.uploadify = uploadify;
	}
	public String getUploadifyFileName() {
		return uploadifyFileName;
	}
	public void setUploadifyFileName(String uploadifyFileName) {
		this.uploadifyFileName = uploadifyFileName;
	}
	public String getUploadifyContentType() {
		return uploadifyContentType;
	}
	public void setUploadifyContentType(String uploadifyContentType) {
		this.uploadifyContentType = uploadifyContentType;
	}
	public KbmsFileService getKbmsFileService() {
		return kbmsFileService;
	}
	public void setKbmsFileService(KbmsFileService kbmsFileService) {
		this.kbmsFileService = kbmsFileService;
	}
}
