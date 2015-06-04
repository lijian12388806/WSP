package com.liveneo.plat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.BdRolemenu;
import com.liveneo.plat.hibernate.dao.Menuinfo;
import com.liveneo.plat.hibernate.dao.dao.iface.MenuinfoDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.MenuinfoServiceIface;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;

public class MenuinfoService extends AbstractBaseService implements
		MenuinfoServiceIface {

	private MenuinfoDAO MenuinfoDAO;

	public int queryMenuinfoByCriteria(DetachedCriteria detachedCriteria) {
		return this.MenuinfoDAO.getCountByCriteria(detachedCriteria);
	}

	public List<Menuinfo> queryAll() {
		return this.MenuinfoDAO.findAll();
	}

	public Menuinfo queryMenuinfoById(int key) {
		return this.MenuinfoDAO.get(key);
	}

	public void addMenuinfo(Menuinfo menuinfo) {
		this.MenuinfoDAO.save(menuinfo);
	}

	public void updateMenuinfo(Menuinfo menuinfo) {
		this.MenuinfoDAO.update(menuinfo);
	}

	public void deleteMenuinfoByIds(String[] selectIDS) {
		List<String> keyList = new ArrayList<String>();
		keyList = ListUtil.ConvertArrayToStringList(selectIDS, "String");
		if (keyList != null) {
			for (String key : keyList) {
				this.deleteMenuinfo(IntegerUtil.converStrToInteger(key));
			}
		}
	}

	public void deleteMenuinfo(int key) {
		String hql = "Delete From BdRolemenu Where PkMenu=" + key;
		this.MenuinfoDAO.bulkUpdate(hql);
		this.MenuinfoDAO.delete(key);
	}

	public List<Menuinfo> findMenuinfoBySql(String sql) {
		return this.MenuinfoDAO.findBySQL(sql);
	}

	public List<Menuinfo> findMenuinfoBySql(String hql, int pageNo, int pageSize) {
		return this.MenuinfoDAO.getListForPage(hql, pageNo, pageSize);

	}

	public List<Menuinfo> querySuperMenuByCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Menuinfo.class);
		detachedCriteria.addOrder(Order.asc(Menuinfo.PROP_MENUSEQ));
		detachedCriteria.add(Restrictions.eq(Menuinfo.PROP_SUPERMENU, 0));
		return this.MenuinfoDAO.findByCriteria(detachedCriteria);
	}

	public List<Menuinfo> querySuperMenuByCriteria(Integer notKey) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Menuinfo.class);
		detachedCriteria.addOrder(Order.asc(Menuinfo.PROP_ID));
		detachedCriteria.add(Restrictions.eq(Menuinfo.PROP_SUPERMENU, 0));
		if (notKey != null) {

			detachedCriteria.add(Restrictions.not(Restrictions.eq(
					Menuinfo.PROP_ID, notKey)));
		}
		return this.MenuinfoDAO.findByCriteria(detachedCriteria);
	}

	public List<Menuinfo> queryMenuBySupermenu(int supermenu) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Menuinfo.class);
		detachedCriteria.add(Restrictions
				.eq(Menuinfo.PROP_SUPERMENU, supermenu));
		detachedCriteria.add(Restrictions.eq(Menuinfo.PROP_ISAVAILABLE, "Y"));
		detachedCriteria.addOrder(Order.asc(Menuinfo.PROP_MENUSEQ));
		return this.MenuinfoDAO.findByCriteria(detachedCriteria);

	}
	public List<Menuinfo> queryMenuBySupermenuAll(int supermenu) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Menuinfo.class);
		detachedCriteria.add(Restrictions
				.eq(Menuinfo.PROP_SUPERMENU, supermenu));
//		detachedCriteria.add(Restrictions.eq(Menuinfo.PROP_ISAVAILABLE, "Y"));
		detachedCriteria.addOrder(Order.asc(Menuinfo.PROP_MENUSEQ));
		return this.MenuinfoDAO.findByCriteria(detachedCriteria);

	}
	public List<Menuinfo> getlistmenu(BdRolemenu rm) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Menuinfo.class);
		detachedCriteria.add(Restrictions.eq(Menuinfo.PROP_ID, rm.getPkMenu()
				.getId()));
		detachedCriteria
				.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
		detachedCriteria.addOrder(Order.asc(Menuinfo.PROP_ID));
		// detachedCriteria.setProjection(Projections.distinct(Projections.property(BdMenu.PROP_MENUNAME)));
		return this.MenuinfoDAO.findByCriteria(detachedCriteria);
	}

	public void setMenuinfoDAO(MenuinfoDAO menuinfoDAO) {
		MenuinfoDAO = menuinfoDAO;
	}

}
