package com.liveneo.plat.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.Ivrvoice;
import com.liveneo.plat.hibernate.dao.dao.iface.IvrvoiceDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.IvrvoiceServiceIface;

public class IvrvoiceService extends AbstractBaseService implements IvrvoiceServiceIface{
	
	private IvrvoiceDAO ivrvoiceDAO;

	public List<Ivrvoice> findIvrvoiceSql(DetachedCriteria detachedCriteria, int firstResult,int resultCount){
		return this.ivrvoiceDAO.findByCriteria(detachedCriteria, firstResult, resultCount);
	}
	public List<Ivrvoice> findIvrvoiceSql(String sql){
		return this.ivrvoiceDAO.findBySQL(sql);
	}
	public int queryCountIvrvoice(DetachedCriteria detachedCriteria){
		return this.ivrvoiceDAO.getCountByCriteria(detachedCriteria);
	}
	public Ivrvoice getIvrvoice(String key){
		return this.ivrvoiceDAO.get(key);
		
	}
	public void updateIvrvoice(Ivrvoice ivrvoice){
		this.ivrvoiceDAO.update(ivrvoice);
	}
	public void updateIvrvoicebysql(String sql){
		this.ivrvoiceDAO.bulkUpdate(sql);
	}
	public IvrvoiceDAO getIvrvoiceDAO() {
		return ivrvoiceDAO;
	}
	public void setIvrvoiceDAO(IvrvoiceDAO ivrvoiceDAO) {
		this.ivrvoiceDAO = ivrvoiceDAO;
	}
}
