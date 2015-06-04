package com.liveneo.plat.service.impl.kbms;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.KbmsFile;
import com.liveneo.plat.hibernate.dao.dao.iface.KbmsFileDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.kbms.KbmsFileServiceIface;

public class KbmsFileService extends AbstractBaseService implements KbmsFileServiceIface {
	private KbmsFileDAO kbmsFileDAO;

	public List<KbmsFile> findKbmsFileBySql(String sql) {
		return this.kbmsFileDAO.findBySQL(sql);
	}
	public int queryCountKbmsFile(DetachedCriteria detachedCriteria) {
		return this.kbmsFileDAO.getCountByCriteria(detachedCriteria);
	}
	public KbmsFile getKbmsFileByKey(int key) {
		return this.kbmsFileDAO.get(key);
	}
	public int addKbmsFile(KbmsFile bean) {
		return this.kbmsFileDAO.save(bean);
	}
	public void updateKbmsFile(KbmsFile bean) {
		this.kbmsFileDAO.update(bean);
	}
	public void delKbmsFile(int key){
		this.kbmsFileDAO.delete(key);
	}
	/**
	 * get/set
	 * @return
	 */
	public KbmsFileDAO getKbmsFileDAO() {
		return kbmsFileDAO;
	}
	public void setKbmsFileDAO(KbmsFileDAO KbmsFileDAO) {
		this.kbmsFileDAO = KbmsFileDAO;
	}
}
