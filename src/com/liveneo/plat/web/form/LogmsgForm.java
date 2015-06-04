package com.liveneo.plat.web.form;

import com.liveneo.plat.web.form.base.BaseForm;

public class LogmsgForm extends BaseForm{
	private java.lang.String username;
	private java.util.Date createtime;
	private java.lang.String ip;
	private java.lang.String logtype;
	private java.lang.String logcontent;
	private java.lang.String entityname;
	public java.lang.String getUsername() {
		return username;
	}
	public void setUsername(java.lang.String username) {
		this.username = username;
	}
	public java.util.Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}
	public java.lang.String getIp() {
		return ip;
	}
	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}
	public java.lang.String getLogtype() {
		return logtype;
	}
	public void setLogtype(java.lang.String logtype) {
		this.logtype = logtype;
	}
	public java.lang.String getLogcontent() {
		return logcontent;
	}
	public void setLogcontent(java.lang.String logcontent) {
		this.logcontent = logcontent;
	}
	public java.lang.String getEntityname() {
		return entityname;
	}
	public void setEntityname(java.lang.String entityname) {
		this.entityname = entityname;
	}
	

}
