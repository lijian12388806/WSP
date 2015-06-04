package com.liveneo.plat.service.impl.kbms;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.KbmsKlp;
import com.liveneo.plat.hibernate.dao.dao.iface.KbmsKlpDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.kbms.KbmsKlpServiceIface;

public class KbmsKlpService extends AbstractBaseService implements KbmsKlpServiceIface {
	private KbmsKlpDAO kbmsKlpDAO;

	public List<KbmsKlp> findKbmsKlpBySql(String sql) {
		return this.kbmsKlpDAO.findBySQL(sql);
	}
	public int queryCountKbmsKlp(DetachedCriteria detachedCriteria) {
		return this.kbmsKlpDAO.getCountByCriteria(detachedCriteria);
	}
	public List<KbmsKlp> findKbmsKlpByHql(String hql,int pageNo ,int pageSize){
		return this.kbmsKlpDAO.getListForPage(hql, pageNo, pageSize);
	}
	public KbmsKlp getKbmsKlpByKey(int key) {
		return this.kbmsKlpDAO.get(key);
	}
	public int addKbmsKlp(KbmsKlp bean) {
		return this.kbmsKlpDAO.save(bean);
	}
	public void updateKbmsKlp(KbmsKlp bean) {
		this.kbmsKlpDAO.update(bean);
	}
	public void delKbmsKlp(int key){
		this.kbmsKlpDAO.delete(key);
	}
	/**
	 * get/set
	 * @return
	 */
	public KbmsKlpDAO getKbmsKlpDAO() {
		return kbmsKlpDAO;
	}
	public void setKbmsKlpDAO(KbmsKlpDAO kbmsKlpDAO) {
		this.kbmsKlpDAO = kbmsKlpDAO;
	}
}
