package com.liveneo.plat.service.iface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liveneo.plat.hibernate.dao.Logmsg;

public interface LogmsgServiceIface {
	public abstract void addLog(HttpServletRequest request, String logType,
			String content, String entityName);
//	public List<Logmsg> findLogmsgBySql(String sql,int startIndex, int numPerPage);
	public abstract void deleteLogmsgByID(Integer key);
}
