package com.liveneo.plat.service.impl.mgr;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.MgrTemplet;
import com.liveneo.plat.hibernate.dao.MgrWoDefine;
import com.liveneo.plat.hibernate.dao.dao.iface.MgrTempletDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.MgrWoDefineDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.mgr.MgrServiceIface;
import com.liveneo.plat.utils.WebappUtil;

public class MgrService extends AbstractBaseService implements MgrServiceIface {
	private MgrTempletDAO mgrTempletDAO;

	private MgrWoDefineDAO mgrWoDefineDAO;
	
	/**
	 * 工单配置-模板
	 */
	public List<MgrTemplet> findMgrTempletByHql(String hql,int pageNo ,int pageSize){
		return this.mgrTempletDAO.getListForPage(hql, pageNo, pageSize);
	}
	public List<MgrTemplet> findMgrTempletBySql(String sql) {
		return this.mgrTempletDAO.findBySQL(sql);
	}
	public int queryCountMgrTemplet(DetachedCriteria detachedCriteria) {
		return this.mgrTempletDAO.getCountByCriteria(detachedCriteria);
	}
	public int addMgrTemplet(MgrTemplet bean) {
		return this.mgrTempletDAO.save(bean);
	}
	public void updateMgrTemplet(MgrTemplet bean) {
		 this.mgrTempletDAO.update(bean);
	}
	public MgrTemplet getMgrTemplet(int key) {
		 return this.mgrTempletDAO.get(key);
	}
	public void delMgrTemplet(int key){
		this.mgrTempletDAO.delete(key);
	}
	public List<MgrTemplet> findMgrTempletByMgrTempletCode(String code) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(MgrTemplet.class);
		detachedCriteria.add(Restrictions.eq(MgrTemplet.PROP_TMP_CODE, code));
		detachedCriteria.addOrder(Order.desc(MgrTemplet.PROP_ID));
		return this.mgrTempletDAO.findByCriteria(detachedCriteria);
	}
	//克隆 add
	public void addCloneMgrTempletAll(int key) throws IllegalAccessException, InvocationTargetException{
		MgrTemplet m = new MgrTemplet();
		WebappUtil.copyProperties(m,this.getMgrTemplet(key));
		m.setId(null);
		int i = this.addMgrTemplet(m);
		List<MgrWoDefine> list = this.findMgrWoDefineByMgrTempletKey(key,"add");
		if(null!=list&&list.size()>0){
			for(MgrWoDefine mm:list){
				MgrWoDefine mw = new MgrWoDefine();
				WebappUtil.copyProperties(mw,mm);
				mw.setId(null);
				mw.setPkTemplet(i);
				this.addMgrWoDefine(mw);
			}
		}
	}
	/**
	 * 工单配置-字段
	 */
	public List<MgrWoDefine> findMgrWoDefineAll() {
		return this.mgrWoDefineDAO.findAll();
	}
	public List<MgrWoDefine> findMgrWoDefineByMgrTempletKey(int key,String coltype) {
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(MgrWoDefine.class);
		detachedCriteria.add(Restrictions.eq(MgrWoDefine.PROP_PK_TEMPLET, key));
		detachedCriteria.add(Restrictions.eq(MgrWoDefine.PROP_DEF_TYPE,coltype));
		detachedCriteria.addOrder(Order.asc(MgrWoDefine.PROP_DEF_COL_ORDER));
		return this.mgrWoDefineDAO.findByCriteria(detachedCriteria);
	}
	public List<MgrWoDefine> findMgrWoDefineByMgrTempletCode(String code,String coltype) {
		MgrTemplet m = getMgrTempletByMgrTempletCode(code);
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(MgrWoDefine.class);
		detachedCriteria.addOrder(Order.asc(MgrWoDefine.PROP_DEF_COL_ORDER));
		detachedCriteria.add(Restrictions.eq(MgrWoDefine.PROP_PK_TEMPLET, m.getId()));
		detachedCriteria.add(Restrictions.eq(MgrWoDefine.PROP_DEF_TYPE,coltype));
		return this.mgrWoDefineDAO.findByCriteria(detachedCriteria);
	}
	public MgrTemplet getMgrTempletByMgrTempletCode(String code) {
		List<MgrTemplet> list = findMgrTempletByMgrTempletCode(code);
		MgrTemplet m = new MgrTemplet();
		if(null!=list&&list.size()>0){
			m = list.get(0);
		}
		return m;
	}
	public MgrWoDefine getMgrWoDefine(int key) {
		 return this.mgrWoDefineDAO.get(key);
	}
	public int addMgrWoDefine(MgrWoDefine bean) {
		return this.mgrWoDefineDAO.save(bean);
	}
	public void updateMgrWoDefine(MgrWoDefine bean) {
		 this.mgrWoDefineDAO.update(bean);
	}
	public void excuteCopyTo(String[] ids,String copyTo) throws IllegalAccessException, InvocationTargetException{
		for (int i = 0; i < ids.length; i++) {
			int key = Integer.parseInt(ids[i]);
			MgrWoDefine bean = new MgrWoDefine();
			WebappUtil.copyProperties(bean,this.getMgrWoDefine(key));
			bean.setId(null);
			bean.setDefType(copyTo);
			this.addMgrWoDefine(bean);
		}
	}
	public void delMgrWoDefine(int key){
		this.mgrWoDefineDAO.delete(key);
	}
	/**
	 * get/set
	 * @return
	 */
	public MgrTempletDAO getMgrTempletDAO() {
		return mgrTempletDAO;
	}
	public void setMgrTempletDAO(MgrTempletDAO mgrTempletDAO) {
		this.mgrTempletDAO = mgrTempletDAO;
	}
	public MgrWoDefineDAO getMgrWoDefineDAO() {
		return mgrWoDefineDAO;
	}
	public void setMgrWoDefineDAO(MgrWoDefineDAO mgrWoDefineDAO) {
		this.mgrWoDefineDAO = mgrWoDefineDAO;
	}
}
