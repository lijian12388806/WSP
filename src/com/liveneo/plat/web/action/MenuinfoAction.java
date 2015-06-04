package com.liveneo.plat.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Menuinfo;
import com.liveneo.plat.service.impl.MenuinfoService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.MenuinfoForm;

public class MenuinfoAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuinfoForm menuinfoForm;
	private Menuinfo menuinfo;
	private MenuinfoService menuinfoService;
	private String pkMenuKey;
	private String querymenuname;
	private String queryaddress;

	public String execute() {
		return SUCCESS;
	}

	// 添加
	public String addMenuinfo() {
		menuinfoForm = new MenuinfoForm();
		pkMenuKey = "";
		List<Menuinfo> listSuper = this.superMenu(null);
		this.getSession().setAttribute("listSuper", listSuper);
		return SUCCESS;
	}

	// 编辑
	public String editMenuinfo() {
		menuinfoForm = new MenuinfoForm();
		Menuinfo menuinfo = new Menuinfo();
		try {
			if (StringUtils.isNotEmpty(pkMenuKey)) {

			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("pkMenuKey")))
					pkMenuKey = (String) this.getSession().getAttribute(
							"pkMenuKey");
				else
					return AbstractActionSupport.EDIT;// 返回list
			}
			menuinfo = this.menuinfoService.queryMenuinfoById(Integer
					.parseInt(pkMenuKey));
			WebappUtil.copyProperties(menuinfoForm, menuinfo);
			List<Menuinfo> listSuper = this.superMenu(menuinfo.getId());
			this.getSession().setAttribute("listSuper", listSuper);
			this.getSession().setAttribute("menuinfoForm", menuinfoForm);
			return AbstractActionSupport.EDIT;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	// 上级菜单
	public List<Menuinfo> superMenu() {
		return this.menuinfoService.querySuperMenuByCriteria();
	}
	// 上级菜单 不能包括自己
	public List<Menuinfo> superMenu(Integer notKey) {
		return this.menuinfoService.querySuperMenuByCriteria(notKey);
	}
	// 保存
	public String saveMenuinfo() {
		Menuinfo menuinfo = new Menuinfo();
		try {
			if (StringUtils.isEmpty(pkMenuKey)) {
				WebappUtil.copyProperties(menuinfo, menuinfoForm);
				if (StringUtils.isEmpty(menuinfo.getSupermenu().toString())) {
					menuinfo.setSupermenu(0);
				}
				this.menuinfoService.addMenuinfo(menuinfo);
				try {
					this.logService(getRequest()).addLog(this.getRequest(),
							"LOGTYPE-XZ", menuinfo.toString(), Menuinfo.REF);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				menuinfo = this.menuinfoService.queryMenuinfoById(Integer
						.parseInt(pkMenuKey));
				WebappUtil.copyProperties(menuinfo, menuinfoForm);
				if (StringUtils.isEmpty(menuinfo.getSupermenu().toString())) {
					menuinfo.setSupermenu(0);
				}
				this.menuinfoService.updateMenuinfo(menuinfo);
				try {
					this.logService(getRequest()).addLog(this.getRequest(),
							"LOGTYPE-XZ", menuinfo.toString(), Menuinfo.REF);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			e.getStackTrace();
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	// 删除
	public String deleteMenuinfo() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				this.menuinfoService.deleteMenuinfoByIds(StringUtils.split(
						selectIDS, ','));
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete：" + selectIDS.toString(),
					Menuinfo.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}
	public String getMenuTree() {
		List<Menuinfo> supermenu = new ArrayList<Menuinfo>();
		List<Menuinfo> allsupermenu = new ArrayList<Menuinfo>();
		List<Menuinfo> listmenu = new ArrayList<Menuinfo>();
		listmenu = this.menuinfoService.queryAll();
		supermenu = this.menuinfoService.querySuperMenuByCriteria();
		allsupermenu = this.menuinfoService.querySuperMenuByCriteria();
		for (Iterator it = allsupermenu.iterator(); it.hasNext();) {
			Menuinfo sm = (Menuinfo) it.next();
			if (!supermenu.contains(sm)) {
				it.remove();
			}
		}
		List<Menuinfo> list = new ArrayList<Menuinfo>();
		StringBuffer str = new StringBuffer();
		str.append("<div layoutH=\"58\" style=\"float:left; display:block; overflow:auto; width:175px; border:solid 1px #CCC; line-height:21px; background:#fff\">");
		str.append("<ul class=\"tree treeFolder\">");
		for (Menuinfo s : allsupermenu) {
			list = this.menuinfoService.queryMenuBySupermenuAll(s.getId());
			str.append("<li>");
			str.append("<a>");
			str.append(s.getMenuname());
			str.append("</a>");
			str.append("<ul>");
			for (Menuinfo m : list) {
				if (listmenu.contains(m)) {
					str.append("<li>");
					str.append("<a href=\"");
					str.append("ListMenuinfo.action?pageNum=1&numPerPage=20&querymenuname="+m.getMenuname());
					str.append("\"");
					str.append("target=\"ajax\" rel=\"jbsxBox\" reloadFlag=1>");
					str.append(m.getMenuname());
					str.append("</a>");
					str.append("</li>");
				}
			}
			str.append("</ul>");
			str.append("</li>");

		}
		str.append("</ul>");
		str.append("</div>");
		return str.toString();

	}
	// 列表查询
	public String listMenuinfo() {
		try {
			int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
					.converStrToInteger(this.getPageNum()) - 1
					: 0;
			int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
			int startIndex = pageNum
					* IntegerUtil.converStrToInteger(getNumPerPage());

			String check_changeUrl = this.getRequest()
					.getParameter("changeUrl");
			if (StringUtils.isNotEmpty(check_changeUrl)) {
				this.setQuerymenuname("");
				this.setQueryaddress("");
			}
			List<Menuinfo> l = this.menuinfoService.findMenuinfoBySql(this.getHql(startIndex, numPerPage));
			this.getSession().setAttribute("menuinfoList", l);
			//菜单列表
			String menutree = this.getMenuTree();
			this.getSession().setAttribute("menutree", menutree);
			int i = 0;
			i = this.menuinfoService.queryMenuinfoByCriteria(this
					.getDetachedCriteria());
			this.setTotalCount(i);
			this.getSession().setAttribute("totalCount", i);
			this.setSuperName();
			return AbstractActionSupport.LIST;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}

	}

	// 获取上级菜单名
	public void setSuperName() {
		Map<Integer, String> supermenumap = new HashMap<Integer, String>();
		List<Menuinfo> list = new ArrayList<Menuinfo>();
		list = this.menuinfoService.queryAll();
		for (Menuinfo m : list) {
			supermenumap.put(m.getId(), m.getMenuname());
		}
		this.getSession().setAttribute("supermenumap", supermenumap);
	}

	private String getHql(int startIndex, int numPerPage) {
		String hql = "select * from Menuinfo where PK_MENU >0 ";

		if (StringUtils.isNotEmpty(querymenuname)) {
			hql += " and Menuname like '%" + querymenuname + "%'";
		}
		if (StringUtils.isNotEmpty(queryaddress)) {
			hql += " and Linkaddress like '%" + queryaddress + "%'";
		}
		hql += "LIMIT " + startIndex + "," + numPerPage;
		return hql;
	}

	private String getHql() {
		String hql = "from Menuinfo where PK_MENU >0 ";

		if (StringUtils.isNotEmpty(querymenuname)) {
			hql += " and Menuname like '%" + querymenuname + "%'";
		}
		if (StringUtils.isNotEmpty(queryaddress)) {
			hql += " and Linkaddress like '%" + queryaddress + "%'";
		}

		return hql;
	}

	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Menuinfo.class);
		//detachedCriteria.addOrder(Order.asc(Menuinfo.PROP_ID));
		if (StringUtils.isNotEmpty(querymenuname)) {
			detachedCriteria.add(Restrictions.ilike(Menuinfo.PROP_MENUNAME,
					querymenuname, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryaddress)) {
			detachedCriteria.add(Restrictions.ilike(Menuinfo.PROP_LINKADDRESS,
					queryaddress, MatchMode.ANYWHERE));
		}
		return detachedCriteria;
	}

	public MenuinfoForm getMenuinfoForm() {
		return menuinfoForm;
	}

	public void setMenuinfoForm(MenuinfoForm menuinfoForm) {
		this.menuinfoForm = menuinfoForm;
	}

	public Menuinfo getMenuinfo() {
		return menuinfo;
	}

	public void setMenuinfo(Menuinfo menuinfo) {
		this.menuinfo = menuinfo;
	}

	public MenuinfoService getMenuinfoService() {
		return menuinfoService;
	}

	public void setMenuinfoService(MenuinfoService menuinfoService) {
		this.menuinfoService = menuinfoService;
	}

	public String getQuerymenuname() {
		return querymenuname;
	}

	public void setQuerymenuname(String querymenuname) {
		this.querymenuname = querymenuname;
	}

	public String getPkMenuKey() {
		return pkMenuKey;
	}

	public void setPkMenuKey(String pkMenuKey) {
		this.pkMenuKey = pkMenuKey;
	}

	public String getQueryaddress() {
		return queryaddress;
	}

	public void setQueryaddress(String queryaddress) {
		this.queryaddress = queryaddress;
	}

}
