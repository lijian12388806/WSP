package com.liveneo.plat.service.iface;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.BdDict;
import com.liveneo.plat.hibernate.dao.BdDictdetail;

public interface BdDictServiceIface {
	public abstract Integer addBdDict(BdDict bean);

	public abstract void updateBdDict(BdDict bean);

	public abstract void delBdDict(Integer key);

	public abstract BdDict getBdDict(Integer key);

	public abstract List<BdDict> queryAllBdDict();

	public abstract List<BdDict> queryBdDict(String dictType);

	public abstract List<BdDict> queryBdDict(String dictType,
			DetachedCriteria detachedCriteria);
	public abstract List<BdDict> queryBdDictarea(DetachedCriteria detachedCriteria,int firstResult,int resultCount);

	public abstract Integer addBdDictdetail(BdDictdetail bean);

	public abstract void updateBdDictdetail(BdDictdetail bean);

	public abstract void delBdDictdetail(Integer key);
	public abstract BdDictdetail getBdDictdetail(Integer key);

	public abstract List<BdDictdetail> queryBdDictdetail(String dictCode,
			String IsValid);
	
	public abstract Boolean checkBdDictUniqueResult(String colname,
			String colvalue, String sKey);

	public abstract Boolean checkBdDictdetailUniqueResult(String colname,
			String colvalue, String sKey);

	public abstract List<BdDict> queryBdDict(DetachedCriteria detachedCriteria);
	public abstract int queryCountBdDict(DetachedCriteria detachedCriteria);
	public abstract List<BdDict> findBdDictByHql(String hql);
	public abstract List<BdDict> findBdDictByHql(String hql,int pageNo ,int pageSize);
	public abstract Map registerBdDictPara();
	public abstract BdDictdetail getBdDictdetailByCode(String code);
	public void deleteBdDictdetailByIds(String[] selectIDS);
	

}
