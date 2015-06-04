package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.BdRole;
import com.liveneo.plat.hibernate.dao.BdRolemenu;
import com.liveneo.plat.hibernate.dao.Menuinfo;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.impl.MenuinfoService;
import com.liveneo.plat.service.impl.RoleService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.RoleForm;

public class RoleAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoleService roleService;
	private MenuinfoService menuinfoService;
	private RoleForm roleForm;
	private String queryrolename;
	private String roleKey;

	private String[] Mname;

	public String addRole() {
		Userinfo user = this.getUserInfo(this.getRequest());
		roleForm = new RoleForm();
		roleKey = "";
		List<Menuinfo> listSuperMenu = this.menuinfoService
				.querySuperMenuByCriteria();
		if (!StringUtils.equals(user.getUsername(), "superadmin")) {
			for (Iterator it = listSuperMenu.iterator(); it.hasNext();) {
				Menuinfo sm = (Menuinfo) it.next();
				if (StringUtils.equals(sm.getMenuname(), "系统设置")) {
					it.remove();
				}
			}
		}
		// 权限 增删改查
//		Map<Integer, String> map = new HashMap<Integer, String>();
//		map.put(0, "新增");
//		map.put(1, "删除");
//		map.put(2, "修改");
//		map.put(3, "查询");
		StringBuffer sb = new StringBuffer();
		for (Menuinfo m : listSuperMenu) {
			sb.append("<li>");
			sb.append("<a>");
			sb.append(m.getMenuname());
			sb.append("</a>");
			sb.append("<ul>");
			List<Menuinfo> listMenu = this.menuinfoService
					.queryMenuBySupermenu(m.getId());
			for (Menuinfo o : listMenu) {
				sb.append("<li>");
				sb.append("<a tname=\"Mname");
				sb.append("\" tvalue=\"");
				sb.append(o.getId());
				sb.append("\" >");
				sb.append(o.getMenuname());
				sb.append("</a>");
//				sb.append("<ul>");
//				for (int i = 0; i < map.size(); i++) {
//					sb.append("<li><a tname=\"MMname\" tvalue=" + i
//							+ " checked=\"true\">" + map.get(i) + "</a></li>");
//				}
//				sb.append("</ul>");
				sb.append("</li>");
			}
			sb.append("</ul>");
			sb.append("</li>");
		}
		this.getSession().setAttribute("listmenus", sb.toString());
		return SUCCESS;
	}

	public String editRole() {
		try {
			Userinfo user = this.getUserInfo(this.getRequest());
			roleForm = new RoleForm();
			BdRole role = new BdRole();
			if (StringUtils.isNotEmpty(roleKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("roleKey")))
					roleKey = (String) this.getSession()
							.getAttribute("roleKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			role = this.roleService.getRole(IntegerUtil
					.converStrToInteger(roleKey));
			WebappUtil.copyProperties(roleForm, role);
			this.getSession().setAttribute("roleForm", roleForm);
			List<Menuinfo> listm = new ArrayList<Menuinfo>();
			List<BdRolemenu> listrm = this.roleService
					.queryRolemenuByRole(role);
			for (BdRolemenu b : listrm) {
				listm.add(b.getPkMenu());
			}
			List<Menuinfo> listSuperMenu = this.menuinfoService
					.querySuperMenuByCriteria();
			if (!StringUtils.equals(user.getUsername(), "superadmin")) {
				for (Iterator it = listSuperMenu.iterator(); it.hasNext();) {
					Menuinfo sm = (Menuinfo) it.next();
					if (StringUtils.equals(sm.getMenuname(), "系统设置")) {
						it.remove();
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			for (Menuinfo m : listSuperMenu) {
				sb.append("<li>");
				sb.append("<a>");
				sb.append(m.getMenuname());
				sb.append("</a>");
				sb.append("<ul>");
				List<Menuinfo> listMenu = this.menuinfoService
						.queryMenuBySupermenu(m.getId());
				for (Menuinfo o : listMenu) {
					sb.append("<li>");
					sb.append("<a tname=\"Mname");
					sb.append("\" tvalue=\"");
					sb.append(o.getId());
					if (listm.contains(o)) {
						sb.append("\" checked=\"true\">");
					} else {
						sb.append("\" >");
					}
					sb.append(o.getMenuname());
					sb.append("</a>");
					sb.append("</li>");
				}
				sb.append("</ul>");
				sb.append("</li>");
			}
			this.getSession().setAttribute("listmenus", sb.toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveRole() {
		if (null == Mname || Mname.length <= 0) {
			return ajaxForwardError("请选择菜单项！");
		}
		try {
			BdRole role = new BdRole();
			if (StringUtils.isNotEmpty(roleKey)) {
				role = this.roleService.getRole(IntegerUtil
						.converStrToInteger(roleKey));
				WebappUtil.copyProperties(role, roleForm);
				this.roleService.update(role);
				List<BdRolemenu> listrm = this.roleService
						.queryRolemenuByRole(role);
				for (BdRolemenu b : listrm) {
					this.roleService.delRolemenu(b.getId());
				}
				for (int i = 0; i < Mname.length; i++) {
					BdRolemenu brm = new BdRolemenu();
					Menuinfo m = this.menuinfoService.queryMenuinfoById(Integer
							.parseInt(Mname[i]));
					brm.setPkMenu(m);
					brm.setPkRole(role);
					this.roleService.addRolemenu(brm);
				}
			} else {
				WebappUtil.copyProperties(role, roleForm);
				int key = this.roleService.add(role);
				BdRole r = new BdRole();
				r = this.roleService.getRole(key);
				for (int i = 0; i < Mname.length; i++) {
					BdRolemenu brm = new BdRolemenu();
					Menuinfo m = this.menuinfoService.queryMenuinfoById(Integer
							.parseInt(Mname[i]));
					brm.setPkMenu(m);
					brm.setPkRole(r);
					this.roleService.addRolemenu(brm);
				}
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listRole() {
		int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
				.converStrToInteger(this.getPageNum()) - 1
				: 0;
		int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
		int startIndex = pageNum
				* IntegerUtil.converStrToInteger(getNumPerPage());

		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryrolename("");
		}
		// List<BdRole> l =
		// this.roleService.findRoleBySql(this.getHql(startIndex,numPerPage));
		List<BdRole> l = this.roleService.findRoleBySql(this.getHql(pageNum,
				numPerPage));
		this.getSession().setAttribute("roleList", l);
		int i = 0;
		i = this.roleService.queryCountRole(this.getDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int pageNum) {
		String hql = "select * from Bd_Role where PK_ROLE >0 ";
		if (StringUtils.isNotEmpty(queryrolename)) {
			hql += " and Rolename like '%" + queryrolename + "%'";
		}
		hql += " LIMIT " + startIndex + "," + pageNum;
		return hql;
	}

	private String getHql() {
		String hql = "from com.liveneo.plat.hibernate.dao.BdRole where PK_ROLE >0 ";
		if (StringUtils.isNotEmpty(queryrolename)) {
			hql += " and Rolename like '%" + queryrolename + "%'";
		}
		return hql;
	}

	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(BdRole.class);
		if (StringUtils.isNotEmpty(queryrolename)) {
			detachedCriteria.add(Restrictions.ilike(BdRole.PROP_ROLENAME,
					queryrolename, MatchMode.ANYWHERE));
		}
		return detachedCriteria;
	}

	public String deleteRole() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				this.roleService.deleteRoleByIds(StringUtils.split(selectIDS,
						','));
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete：" + selectIDS.toString(), BdRole.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public RoleForm getRoleForm() {
		return roleForm;
	}

	public void setRoleForm(RoleForm roleForm) {
		this.roleForm = roleForm;
	}

	public String getQueryrolename() {
		return queryrolename;
	}

	public void setQueryrolename(String queryrolename) {
		this.queryrolename = queryrolename;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

	public MenuinfoService getMenuinfoService() {
		return menuinfoService;
	}

	public void setMenuinfoService(MenuinfoService menuinfoService) {
		this.menuinfoService = menuinfoService;
	}

	public String[] getMname() {
		return Mname;
	}

	public void setMname(String[] mname) {
		Mname = mname;
	}

}
