package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class UploadForm extends BaseForm{
	private java.lang.String filename;
	private java.lang.String filepath;
	private java.util.Date createtime;
	private java.lang.String filetype;
	public java.lang.String getFilename() {
		return filename;
	}
	public void setFilename(java.lang.String filename) {
		this.filename = filename;
	}
	public java.lang.String getFilepath() {
		return filepath;
	}
	public void setFilepath(java.lang.String filepath) {
		this.filepath = filepath;
	}
	public java.util.Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	public java.lang.String getFiletype() {
		return filetype;
	}
	public void setFiletype(java.lang.String filetype) {
		this.filetype = filetype;
	}
	

}
