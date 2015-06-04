package com.liveneo.plat.service.iface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.liveneo.plat.web.form.CountRatioForm;

public interface WorkOrderServiceIface {
	public ResultSet executeQuerySQl(String sql) throws SQLException;
	public List<CountRatioForm> executeQuerySQlINDAO(String sql) throws SQLException;
}
