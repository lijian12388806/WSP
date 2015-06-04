package com.liveneo.plat.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.Logmsg;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.dao.iface.LogmsgDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.LogmsgServiceIface;

public class LogmsgService extends AbstractBaseService implements LogmsgServiceIface{

	private LogmsgDAO logmsgDAO;

	protected transient final Log log = LogFactory.getLog(this.getClass());
	
	 
	public List<Logmsg> findLogmsgBySql(String sql){
		return this.logmsgDAO.findBySQL(sql);
		
	}
	public List<Logmsg> findLogmsgBySql(DetachedCriteria detachedCriteria,int firstResult, int resultCount){
		return this.logmsgDAO.findByCriteria(detachedCriteria, firstResult, resultCount);
//		return this.logmsgDAO.getListForPage(sql,startIndex,numPerPage);
		
	}
	public void deleteLogmsgByID(Integer key){
		this.logmsgDAO.delete(key);
	}
	public int queryCountLogmsg(DetachedCriteria detachedCriteria){
		return this.logmsgDAO.getCountByCriteria(detachedCriteria);
		
	}
	public void addLog(HttpServletRequest request, String logType,
			String content, String entityName) {
		Userinfo userInfo = (Userinfo) request.getSession().getAttribute(
				"userinfo");
		String username=userInfo.getUsername();
//		System.out.println("ip:"+request.getRemoteAddr());
		String ip = request.getRemoteAddr();
		this.addLog(username, ip, logType, content, entityName);
	}

	public void addLog(String username, String ip,
			String logType, String content, String entityName) {
//		System.out.println("param:"+username+"---"+ip+"---"+logType+"---"+content+"---"+entityName);
		try{
			Logmsg lm = new Logmsg();
			lm.setCreatetime(new Date());
			lm.setIp(ip);
			lm.setUsername(username);
			lm.setLogtype(logType);
			lm.setLogcontent(content);
			lm.setEntityname(entityName);
			this.logmsgDAO.save(lm);
			log.info("log success!");
		}catch(Exception e){
			e.getMessage();
			log.info(e.getMessage());
		}
		
	}
	
	
	
	public LogmsgDAO getLogmsgDAO() {
		return logmsgDAO;
	}

	public void setLogmsgDAO(LogmsgDAO logmsgDAO) {
		this.logmsgDAO = logmsgDAO;
	}
}
