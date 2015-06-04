package com.liveneo.plat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.Workstation;
import com.liveneo.plat.hibernate.dao.dao.iface.WorkstationDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.WorkstationServiceIface;

public class WorkstationService extends AbstractBaseService implements WorkstationServiceIface{
	
	private WorkstationDAO workstationDAO;

	public Workstation getWorkstation(int key){
		return this.workstationDAO.get(key);
	}
	public void add(Workstation workstation){
		this.workstationDAO.save(workstation);
	}
	public void update(Workstation workstation){
		this.workstationDAO.update(workstation);
	}
	
	//检测唯一性
	public Boolean checkFactorynamecn(Workstation workstation){
		Boolean b=false;
		List<Workstation> list=new ArrayList<Workstation>();
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Workstation.class);
		detachedCriteria.add(Restrictions.eq(Workstation.PROP_FACTORYNAMECN,workstation.getFactorynamecn()));
		list=this.workstationDAO.findByCriteria(detachedCriteria);
		if(workstation.getId() == null){
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}else{
			list.remove(workstation);
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}
		return b;
	}
	public Boolean checkFactorynameen(Workstation workstation){
		Boolean b=false;
		List<Workstation> list=new ArrayList<Workstation>();
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Workstation.class);
		detachedCriteria.add(Restrictions.eq(Workstation.PROP_FACTORYNAMEEN,workstation.getFactorynameen()));
		list=this.workstationDAO.findByCriteria(detachedCriteria);
		if(workstation.getId() == null){
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}else{
			list.remove(workstation);
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}
		return b;
	}
	public List<Workstation> findWorkstationBySql(DetachedCriteria detachedCriteria,int firstResult,int resultCount){
		return this.workstationDAO.findByCriteria(detachedCriteria, firstResult, resultCount);
	}
	public int queryCountWorkstation(DetachedCriteria detachedCriteria){
		return this.workstationDAO.getCountByCriteria(detachedCriteria);
		
	}
	public void delWorkstation(int id){
		this.workstationDAO.delete(id);
	}
	public WorkstationDAO getWorkstationDAO() {
		return workstationDAO;
	}
	public void setWorkstationDAO(WorkstationDAO workstationDAO) {
		this.workstationDAO = workstationDAO;
	}
}
