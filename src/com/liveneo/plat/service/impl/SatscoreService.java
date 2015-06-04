package com.liveneo.plat.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.Calldetail;
import com.liveneo.plat.hibernate.dao.Satscore;
import com.liveneo.plat.hibernate.dao.dao.iface.CalldetailDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.SatscoreDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.SatscoreServiceIface;

public class SatscoreService extends AbstractBaseService implements SatscoreServiceIface{
	
	private SatscoreDAO SatscoreDAO;

	public List<Satscore> findSatscoreSql(DetachedCriteria detachedCriteria, int firstResult,int resultCount){
		return this.SatscoreDAO.findByCriteria(detachedCriteria, firstResult, resultCount);
	}
	public List<Satscore> findSatscoreSql(String sql){
		return this.SatscoreDAO.findBySQL(sql);
	}
	public int queryCountSatscore(DetachedCriteria detachedCriteria){
		return this.SatscoreDAO.getCountByCriteria(detachedCriteria);
	}
	public SatscoreDAO getSatscoreDAO() {
		return SatscoreDAO;
	}
	public void setSatscoreDAO(SatscoreDAO satscoreDAO) {
		SatscoreDAO = satscoreDAO;
	}
	
}
