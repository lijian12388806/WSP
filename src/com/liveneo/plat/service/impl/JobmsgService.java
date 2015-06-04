package com.liveneo.plat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.BdJobmsg;
import com.liveneo.plat.hibernate.dao.dao.iface.BdJobmsgDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.JobmsgServiceIface;


public class JobmsgService extends AbstractBaseService implements JobmsgServiceIface{
	private BdJobmsgDAO bdJobmsgDAO;

	public BdJobmsg getBdJobmsg(int key){
		return this.bdJobmsgDAO.get(key);
		
	}
	public void add(BdJobmsg bdJobmsg){
		this.bdJobmsgDAO.save(bdJobmsg);
	}
	public void update(BdJobmsg bdJobmsg){
		this.bdJobmsgDAO.update(bdJobmsg);
	}
	public List<BdJobmsg> findJobmsgBySql(DetachedCriteria detachedCriteria, int firstResult, int resultCount){
		return this.bdJobmsgDAO.findByCriteria(detachedCriteria, firstResult, resultCount);
	}
	public List<BdJobmsg> findJobmsgBySql(String sql){
		return this.bdJobmsgDAO.findBySQL(sql);
	}
	public int queryCountJobmsg(DetachedCriteria detachedCriteria){
		return this.bdJobmsgDAO.getCountByCriteria(detachedCriteria);
	}
	public List<BdJobmsg> queryJobmsg(DetachedCriteria detachedCriteria) {
		
		return this.bdJobmsgDAO.findByCriteria(detachedCriteria);
	}
	
	public void deleteJobmsg(int key){
		this.bdJobmsgDAO.delete(key);
	}
	public BdJobmsg queryBdJobmsgByBeanname(String beanname){
		return this.bdJobmsgDAO.getByUniqueIndex(BdJobmsg.PROP_JOB_BEANNAME, beanname);
	}
	//检测唯一性
	public Boolean checkBeanname(BdJobmsg r){
		Boolean b=false;
		List<BdJobmsg> list=new ArrayList<BdJobmsg>();
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(BdJobmsg.class);
		detachedCriteria.add(Restrictions.eq(BdJobmsg.PROP_JOB_BEANNAME,r.getJobBeanname()));
		list=this.bdJobmsgDAO.findByCriteria(detachedCriteria);
		if(r.getId() == null){
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}else{
			list.remove(r);
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}
		return b;
	}
	public BdJobmsgDAO getBdJobmsgDAO() {
		return bdJobmsgDAO;
	}

	public void setBdJobmsgDAO(BdJobmsgDAO bdJobmsgDAO) {
		this.bdJobmsgDAO = bdJobmsgDAO;
	}
	
}
