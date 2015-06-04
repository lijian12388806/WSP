package com.liveneo.plat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.Workstation;
import com.liveneo.plat.hibernate.dao.dao.iface.UserinfoDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.UserinfoServiceIface;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;

public class UserinfoService extends AbstractBaseService implements
		UserinfoServiceIface {
	private UserinfoDAO UserinfoDAO;

	public List<Userinfo> queryUserinfoByWS(Workstation ws) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		detachedCriteria.add(Restrictions.eq(Userinfo.PROP_PK_WORKSTATION, ws));
		return this.UserinfoDAO.findByCriteria(detachedCriteria);
	}

	// 检测唯一性
	public Boolean checkUsername(Userinfo user) {
		Boolean b = false;
		List<Userinfo> list = new ArrayList<Userinfo>();
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		detachedCriteria.add(Restrictions.eq(Userinfo.PROP_USERNAME, user
				.getUsername()));
		list = this.UserinfoDAO.findByCriteria(detachedCriteria);
		if (user.getId() == null) {
			if (list.size() > 0) {
				b = false;
			} else {
				b = true;
			}
		} else {
			list.remove(user);
			if (list.size() > 0) {
				b = false;
			} else {
				b = true;
			}
		}
		return b;
	}

	// 检测唯一性
	public Boolean checkAgentno(Userinfo user) {
		Boolean b = false;
		List<Userinfo> list = new ArrayList<Userinfo>();
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		detachedCriteria.add(Restrictions.eq(Userinfo.PROP_AGENTNO, user
				.getAgentno()));
		list = this.UserinfoDAO.findByCriteria(detachedCriteria);
		if (user.getId() == null) {
			if (list.size() > 0) {
				b = false;
			} else {
				b = true;
			}
		} else {
			list.remove(user);
			if (list.size() > 0) {
				b = false;
			} else {
				b = true;
			}
		}
		return b;
	}

	public Integer addUserinfo(Userinfo bean) {
		if (this.checkUserinfoUniqueResult(Userinfo.PROP_USERNAME, bean
				.getUsername(), "")) {
			return this.UserinfoDAO.save(bean);
		} else {
			return 0;
		}
	}

	public void delUserinfo(Integer key) {
		Userinfo userinfo = new Userinfo();
		userinfo = this.getUserinfo(key);
		String hql = "Delete From BdUserinforole Where PkUserinfo=" + key;
		this.UserinfoDAO.bulkUpdate(hql);
		this.UserinfoDAO.delete(key);
	}

	public void delAdminUserinfo(Integer key) {
		this.UserinfoDAO.delete(key);

	}

	public void deleteAdminUserinfoByIds(String[] selectIDS) {
		List<String> keyList = new ArrayList<String>();
		keyList = ListUtil.ConvertArrayToStringList(selectIDS, "String");
		if (keyList != null) {
			for (String key : keyList) {
				this.delUserinfo(IntegerUtil.converStrToInteger(key));
			}
		}
	}

	public Userinfo getUserinfo(Integer key) {
		return this.UserinfoDAO.get(key);
	}

	public Userinfo getByUniqueIndex(String colname, String colvalue) {
		return this.UserinfoDAO.getByUniqueIndex(colname, colvalue);
	}

	public List<Userinfo> queryAllUserinfo() {
		return UserinfoDAO.findAll();
	}

	public List<Userinfo> queryUserinfo(DetachedCriteria detachedCriteria) {
		return this.UserinfoDAO.findByCriteria(detachedCriteria);
	}

	public List<Userinfo> findUserinfoBySql(String sql) {
		return this.UserinfoDAO.findBySQL(sql);
	}

	public List<Userinfo> findUserinfoBySql(DetachedCriteria detachedCriteria,
			int pageNo, int pageSize) {
		return this.UserinfoDAO.findByCriteria(detachedCriteria, pageNo,
				pageSize);
	}

	// public List<Userinfo> findUserinfoBySql(DetachedCriteria
	// detachedCriteria, int pageNo, int pageSize) {
	// return this.UserinfoDAO.findByCriteria(detachedCriteria, pageNo,
	// pageSize);
	// }

	public int queryCountUserinfo(DetachedCriteria detachedCriteria) {
		return this.UserinfoDAO.getCountByCriteria(detachedCriteria);
	}

	public List<Userinfo> queryUserinfoarea(DetachedCriteria detachedCriteria,
			int firstResult, int resultCount) {
		return this.UserinfoDAO.findByCriteria(detachedCriteria, firstResult,
				resultCount);
	}

	public void updateUserinfo(Userinfo bean) {
		this.UserinfoDAO.update(bean);
	}

	public Userinfo queryuserinfoIndex(String colname, String colvalue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		detachedCriteria.add(Restrictions.eq(colname,colvalue));
		List<Userinfo> list = this.UserinfoDAO.findByCriteria(detachedCriteria);
		if(null!=list&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	public Boolean checkUserinfoUniqueResult(String colname, String colvalue,
			String sKey) {
		List ret = this.queryUserinfo(this.uniqueResultCrit(Userinfo.class,
				colname, colvalue, sKey));
		if (ret.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean checkName(Userinfo userinfo) {
		Boolean b = false;
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		detachedCriteria.add(Restrictions.eq(Userinfo.PROP_USERNAME, userinfo
				.getUsername()));
		List<Userinfo> list = this.UserinfoDAO.findByCriteria(detachedCriteria);
		if (list.size() > 0) {
			b = true;
		}
		return b;
	}

	public void deleteUserinfoByIds(String[] selectIDS) {
		List<String> keyList = new ArrayList<String>();
		keyList = ListUtil.ConvertArrayToStringList(selectIDS, "String");
		if (keyList != null) {
			for (String key : keyList) {
				this.delUserinfo(IntegerUtil.converStrToInteger(key));
			}
		}

	}

	public List<Userinfo> querybatchUser(int start, int stop) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		for (int i = start; i <= stop; i++) {
			Userinfo user = new Userinfo();
			user = this.queryuserinfoIndex(Userinfo.PROP_USERNAME, Integer
					.toString(i));
			if (user == null) {
				continue;
			}
			if (user.getId() > 0) {
				list.add(user);
			}
		}
		return list;
	}

	public List<Userinfo> queryNotAdmin() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		detachedCriteria.add(Restrictions.eq(Userinfo.PROP_ISADMIN, "false"));
		return this.UserinfoDAO.findByCriteria(detachedCriteria);
	}

	public List<Userinfo> queryOndutyUser() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		detachedCriteria.add(Restrictions.ne(Userinfo.PROP_TEMP3, "false"));
		return this.UserinfoDAO.findByCriteria(detachedCriteria);
	}

	public void setUserinfoDAO(UserinfoDAO UserinfoDAO) {
		this.UserinfoDAO = UserinfoDAO;
	}

	public UserinfoDAO getUserinfoDAO() {
		return UserinfoDAO;
	}

}
