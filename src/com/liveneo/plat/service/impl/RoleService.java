package com.liveneo.plat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.BdDict;
import com.liveneo.plat.hibernate.dao.BdRole;
import com.liveneo.plat.hibernate.dao.BdRolemenu;
import com.liveneo.plat.hibernate.dao.BdUserinforole;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.dao.iface.BdRoleDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.BdRolemenuDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.BdUserinforoleDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.RoleServiceIface;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;

public class RoleService  extends AbstractBaseService implements RoleServiceIface{
	private BdRoleDAO bdRoleDAO;
	private BdRolemenuDAO bdRolemenuDAO;
	private BdUserinforoleDAO bdUserinforoleDAO;
	
	public BdRole getRole(int key){
		return this.bdRoleDAO.get(key);
	}
	public int add(BdRole role){
		return this.bdRoleDAO.save(role);
	}
	public void update(BdRole role){
		this.bdRoleDAO.update(role);
	}
	public void addRolemenu(BdRolemenu brm){
		this.bdRolemenuDAO.save(brm);
	}
	public void updateRolemenu(BdRolemenu brm){
		this.bdRolemenuDAO.update(brm);
	}
	public List<BdRole> findRoleBySql(String sql){
		return this.bdRoleDAO.findBySQL(sql);
	}
	public List<BdRole> findRoleBySql(String hql,int pageNo ,int pageSize){
		return this.bdRoleDAO.getListForPage(hql, pageNo, pageSize);

	}
	public int queryCountRole(DetachedCriteria detachedCriteria){
		return this.bdRoleDAO.getCountByCriteria(detachedCriteria);
		
	}
	public void deleteRoleByIds(String[] selectIDS){
		List<String> keyList = new ArrayList<String>();
		keyList = ListUtil.ConvertArrayToStringList(selectIDS, "String");
		if (keyList != null) {
			for (String key : keyList) {
				this.delRole(IntegerUtil.converStrToInteger(key));
			}
		}
	}
	public void delRole(int key){
		String hql="Delete from BdRolemenu Where PkRole="+key;
		this.bdRoleDAO.bulkUpdate(hql);
		this.bdRoleDAO.delete(key);
	}
	public List<BdRole> queryAllRole(){
		return this.bdRoleDAO.findAll();
	} 
	//rolemenu
	public void delRolemenu(int key){
		this.bdRolemenuDAO.delete(key);
	}
	public List<BdRolemenu> queryRolemenuByRole(BdRole role){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(BdRolemenu.class);
		detachedCriteria.add(Restrictions.eq(BdRolemenu.PROP_PK_ROLE,role));
		return this.bdRolemenuDAO.findByCriteria(detachedCriteria);
	}
	//人员角色
	public List<BdUserinforole> queryUserinforoleByUser(Userinfo user){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(BdUserinforole.class);
		detachedCriteria.add(Restrictions.eq(BdUserinforole.PROP_PK_USERINFO,user));
		return this.bdUserinforoleDAO.findByCriteria(detachedCriteria);
	}
	public BdUserinforole getBdUserinforoleById(int key){
		return this.bdUserinforoleDAO.get(key);
	}
	public void saveBdUserinforole(BdUserinforole bdUserinforole){
		this.bdUserinforoleDAO.save(bdUserinforole);
	}
	public void deleteUserinforole(BdUserinforole bdUserinforole){
		this.bdUserinforoleDAO.delete(bdUserinforole);
	}
	public void delAllUserinforoleByUser(Userinfo user){
		List<BdUserinforole> list=this.queryUserinforoleByUser(user);
		if(list.size()>0){
			for(BdUserinforole b:list){
				this.deleteUserinforole(b);
			}
			
		}
	}
	public List<BdDict> findBdDictByHql(String hql,int pageNo ,int pageSize){
		return this.bdRoleDAO.getListForPage(hql, pageNo, pageSize);

	}
	public BdRoleDAO getBdRoleDAO() {
		return bdRoleDAO;
	}
	public void setBdRoleDAO(BdRoleDAO bdRoleDAO) {
		this.bdRoleDAO = bdRoleDAO;
	}
	public BdRolemenuDAO getBdRolemenuDAO() {
		return bdRolemenuDAO;
	}
	public void setBdRolemenuDAO(BdRolemenuDAO bdRolemenuDAO) {
		this.bdRolemenuDAO = bdRolemenuDAO;
	}
	public BdUserinforoleDAO getBdUserinforoleDAO() {
		return bdUserinforoleDAO;
	}
	public void setBdUserinforoleDAO(BdUserinforoleDAO bdUserinforoleDAO) {
		this.bdUserinforoleDAO = bdUserinforoleDAO;
	}
	
}
