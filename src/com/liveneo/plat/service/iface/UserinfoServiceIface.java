package com.liveneo.plat.service.iface;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.Userinfo;

public interface UserinfoServiceIface {
	public abstract Integer addUserinfo(Userinfo bean);
	
	

	public abstract void updateUserinfo(Userinfo bean);

	public abstract void delUserinfo(Integer key);

	public abstract Userinfo getUserinfo(Integer key);

	public abstract List<Userinfo> queryAllUserinfo();

	
	public abstract List<Userinfo> queryUserinfoarea(DetachedCriteria detachedCriteria,int firstResult,int resultCount);

	public abstract Boolean checkUserinfoUniqueResult(String colname,
			String colvalue, String sKey);

	public abstract List<Userinfo> queryUserinfo(DetachedCriteria detachedCriteria);
	public abstract int queryCountUserinfo(DetachedCriteria detachedCriteria);
	public abstract List<Userinfo> findUserinfoBySql(String sql);
	public abstract void deleteUserinfoByIds(String[] selectIDS);
}
