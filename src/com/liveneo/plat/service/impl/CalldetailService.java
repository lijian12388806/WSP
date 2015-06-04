package com.liveneo.plat.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.Calldetail;
import com.liveneo.plat.hibernate.dao.dao.iface.CalldetailDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.CalldetailServiceIface;

public class CalldetailService extends AbstractBaseService implements CalldetailServiceIface{
	
	private CalldetailDAO calldetailDAO;
	public void add(Calldetail calldetail){
		this.calldetailDAO.save(calldetail);
	}
	public List<Calldetail> findCalldetailSql(DetachedCriteria detachedCriteria, int firstResult,int resultCount){
		return this.calldetailDAO.findByCriteria(detachedCriteria, firstResult, resultCount);
	}
	public List<Calldetail> findCalldetailSql(String sql){
		return this.calldetailDAO.findBySQL(sql);
	}
	public int queryCountCalldetail(DetachedCriteria detachedCriteria){
		return this.calldetailDAO.getCountByCriteria(detachedCriteria);
	}
	
	
	public CalldetailDAO getCalldetailDAO() {
		return calldetailDAO;
	}
	public void setCalldetailDAO(CalldetailDAO calldetailDAO) {
		this.calldetailDAO = calldetailDAO;
	}
}
