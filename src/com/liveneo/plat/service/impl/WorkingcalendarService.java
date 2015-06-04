package com.liveneo.plat.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.Workingcalendar;
import com.liveneo.plat.hibernate.dao.dao.iface.WorkingcalendarDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.WorkingcalendarServiceIface;

public class WorkingcalendarService extends AbstractBaseService implements WorkingcalendarServiceIface{
	
	private WorkingcalendarDAO workingcalendarDAO;

	public Workingcalendar getWorkstation(int key){
		return this.workingcalendarDAO.get(key);
	}
	public void add(Workingcalendar workingcalendar){
		this.workingcalendarDAO.save(workingcalendar);
	}
	public void update(Workingcalendar workingcalendar){
		this.workingcalendarDAO.update(workingcalendar);
	}
	public List<Workingcalendar> queryByWorkingdate(String workingdate){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Workingcalendar.class);
		detachedCriteria.add(Restrictions.eq(Workingcalendar.PROP_WORKINGDATE,workingdate));
		return this.workingcalendarDAO.findByCriteria(detachedCriteria);
	}
	public List<Workingcalendar> findWorkstationBySql(DetachedCriteria detachedCriteria,int firstResult,int resultCount){
		return this.workingcalendarDAO.findByCriteria(detachedCriteria, firstResult, resultCount);
	}
	public List<Workingcalendar> findWorkstationBySql(String sql){
		return this.workingcalendarDAO.findBySQL(sql);
	}
	public int queryCountWorkstation(DetachedCriteria detachedCriteria){
		return this.workingcalendarDAO.getCountByCriteria(detachedCriteria);
		
	}
	public void delWorkingcalendar(int id){
		this.workingcalendarDAO.delete(id);
	}
	public WorkingcalendarDAO getWorkingcalendarDAO() {
		return workingcalendarDAO;
	}
	public void setWorkingcalendarDAO(WorkingcalendarDAO workingcalendarDAO) {
		this.workingcalendarDAO = workingcalendarDAO;
	}
}
