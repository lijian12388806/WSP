package com.liveneo.plat.service.iface;

import java.util.List;

import com.liveneo.plat.hibernate.dao.BdDict;
import com.liveneo.plat.hibernate.dao.BdRole;

public interface RoleServiceIface {
	public List<BdRole> findRoleBySql(String hql,int pageNo ,int pageSize);
}
