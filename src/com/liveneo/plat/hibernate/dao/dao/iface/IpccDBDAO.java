package com.liveneo.plat.hibernate.dao.dao.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IpccDBDAO {
	public Map<String, List<Object>> getIpccObjectByexecuteQuerySQl(String sql,
			String type) throws SQLException;
}
