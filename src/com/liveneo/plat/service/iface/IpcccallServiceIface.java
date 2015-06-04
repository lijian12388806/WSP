package com.liveneo.plat.service.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public interface IpcccallServiceIface {
//	public ResultSet executeQuerySQl(String sql) throws SQLException;
	public Map<String, List<Object>> executeQuerySQlInDAO(String sql,String type) throws SQLException;
}
