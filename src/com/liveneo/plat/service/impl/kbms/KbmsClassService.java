package com.liveneo.plat.service.impl.kbms;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.KbmsClass;
import com.liveneo.plat.hibernate.dao.KbmsKlp;
import com.liveneo.plat.hibernate.dao.dao.iface.KbmsClassDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.KbmsKlpDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.kbms.KbmsClassServiceIface;

public class KbmsClassService extends AbstractBaseService implements
		KbmsClassServiceIface {
	private KbmsClassDAO kbmsClassDAO;
	private KbmsKlpDAO kbmsKlpDAO;

	public List<KbmsClass> findKbmsClassBySql(String sql) {
		return this.kbmsClassDAO.findBySQL(sql);
	}

	public int queryCountKbmsClass(DetachedCriteria detachedCriteria) {
		return this.kbmsClassDAO.getCountByCriteria(detachedCriteria);
	}

	public List<KbmsClass> findKbmsClassByHql(String hql, int pageNo,
			int pageSize) {
		return this.kbmsClassDAO.getListForPage(hql, pageNo, pageSize);
	}

	public KbmsClass getKbmsClassByKey(int key) {
		return this.kbmsClassDAO.get(key);
	}

	public int addKbmsClass(KbmsClass bean) {
		return this.kbmsClassDAO.save(bean);
	}

	public void updateKbmsClass(KbmsClass bean) {
		this.kbmsClassDAO.update(bean);
	}

	public void delKbmsClass(int key) {
		this.kbmsClassDAO.delete(key);
	}

	public void delKbmsClassCson(int key) {
		KbmsClass bean = this.getKbmsClassByKey(key);
		if (null != bean) {
			// 删除一级
			if (StringUtils.equalsIgnoreCase(bean.getPid(), "0")) {
				String sql = "select * from kbms_class where pid = " + key;
				List<KbmsClass> list = this.findKbmsClassBySql(sql);
				if (null != list && list.size() > 0) {
					for (KbmsClass k : list) {
						String sqlss = "select * from kbms_klp where CLASSID = "
								+ k.getId();
						List<KbmsKlp> listss = this.kbmsKlpDAO.findBySQL(sqlss);
						if (null != listss && listss.size() > 0) {
							for (KbmsKlp kkk : listss) {
								this.kbmsKlpDAO.delete(kkk);
							}
						}
						this.kbmsClassDAO.delete(k);
					}
				}
			} else {
				String sqls = "select * from kbms_klp where CLASSID = " + key;
				List<KbmsKlp> lists = this.kbmsKlpDAO.findBySQL(sqls);
				if (null != lists && lists.size() > 0) {
					for (KbmsKlp kk : lists) {
						this.kbmsKlpDAO.delete(kk);
					}
				}
			}
			this.kbmsClassDAO.delete(key);
		}
	}

	public List<KbmsClass> findKbmsClassSon(int pid) {
		String sql = "select * from kbms_class where pid = " + pid;
		return this.findKbmsClassBySql(sql);
	}

	/**
	 * get/set
	 * 
	 * @return
	 */
	public KbmsClassDAO getKbmsClassDAO() {
		return kbmsClassDAO;
	}

	public void setKbmsClassDAO(KbmsClassDAO kbmsClassDAO) {
		this.kbmsClassDAO = kbmsClassDAO;
	}

	public KbmsKlpDAO getKbmsKlpDAO() {
		return kbmsKlpDAO;
	}

	public void setKbmsKlpDAO(KbmsKlpDAO kbmsKlpDAO) {
		this.kbmsKlpDAO = kbmsKlpDAO;
	}
}
