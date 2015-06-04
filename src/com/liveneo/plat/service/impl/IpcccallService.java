package com.liveneo.plat.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.liveneo.plat.hibernate.dao.dao.iface.IpccDBDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.IpcccallServiceIface;

public class IpcccallService extends AbstractBaseService implements
		IpcccallServiceIface {
	private IpccDBDAO ipccDBDAO;

	public Map<String, List<Object>> executeQuerySQlInDAO(String sql,
			String type) throws SQLException {
		return this.ipccDBDAO.getIpccObjectByexecuteQuerySQl(sql, type);
	}
	
	public IpccDBDAO getIpccDBDAO() {
		return ipccDBDAO;
	}

	public void setIpccDBDAO(IpccDBDAO ipccDBDAO) {
		this.ipccDBDAO = ipccDBDAO;
	}


	
	
}
