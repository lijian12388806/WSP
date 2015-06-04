package com.liveneo.plat.service.iface;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.Menuinfo;

public interface MenuinfoServiceIface {
	public abstract int queryMenuinfoByCriteria(DetachedCriteria detachedCriteria);
	public abstract List<Menuinfo> findMenuinfoBySql(String sql);
	public abstract List<Menuinfo> queryAll();
	public abstract Menuinfo queryMenuinfoById(int key);
	public abstract void addMenuinfo(Menuinfo menuinfo);
	public abstract void updateMenuinfo(Menuinfo menuinfo);
	public abstract void deleteMenuinfoByIds(String[] selectIDS);
	public abstract List<Menuinfo> querySuperMenuByCriteria();
	public abstract List<Menuinfo> queryMenuBySupermenu(int supermenu);
	public List<Menuinfo> querySuperMenuByCriteria(Integer notKey);

}
