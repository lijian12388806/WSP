package com.liveneo.plat.web.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.lm.utils.Base64Decode;
import com.liveneo.lm.utils.Base64Encode;
import com.liveneo.plat.hibernate.dao.BdRole;
import com.liveneo.plat.hibernate.dao.BdUserinforole;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.Workstation;
import com.liveneo.plat.service.impl.RoleService;
import com.liveneo.plat.service.impl.UserinfoService;
import com.liveneo.plat.service.impl.WorkstationService;
import com.liveneo.plat.utils.FileUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.UserinfoForm;

public class UserinfoAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private UserinfoService userinfoService;
	private RoleService roleService;
	private WorkstationService workstationService;
	private String userinfoKey;
	private UserinfoForm userinfoForm;

	private String isadmin;
	private String[] extnlimits;

	// excel文件上传
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String backToUrl;
	// 查询条件
	private String queryusername;
	private String queryextno;
	private String queryagentname;
	private String queryfactory;

	public String getBackToUrl() {
		return backToUrl;
	}

	public void setBackToUrl(String backToUrl) {
		this.backToUrl = backToUrl;
	}

	public String execute() {
		return SUCCESS;
	}

	// 值班人设置
	public String onduty() {
		try {
			Userinfo userinfo = new Userinfo();
			if (StringUtils.isNotEmpty(userinfoKey)) {
				userinfo = this.userinfoService.getUserinfo(IntegerUtil
						.converStrToInteger(userinfoKey));
				userinfo.setTemp3("true");
				this.userinfoService.updateUserinfo(userinfo);
				List<Userinfo> ondutyuser = this.userinfoService
						.queryOndutyUser();
				if (ondutyuser.size() > 0) {
					if (ondutyuser.contains(userinfo)) {
						ondutyuser.remove(userinfo);
					}
					for (Userinfo u : ondutyuser) {
						u.setTemp3("false");
						this.userinfoService.updateUserinfo(u);
					}
				}
			} else {
				return ajaxForwardError(getText("请选择值班人！"));
			}
			return ajaxForwardSuccess(getText("设置当前值班人为:"
					+ userinfo.getAgentname()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String addUserinfo() {
		userinfoForm = new UserinfoForm();
		userinfoKey = "";
		userinfoForm.setUserstatus("Y");
		userinfoForm.setIsadmin("false");
		userinfoForm.setAgenttype("OAgent");
		userinfoForm.setAuthtype("Batch");
		return AbstractActionSupport.EDIT;
	}

	public String editUserinfo() {
		try {
			userinfoForm = new UserinfoForm();
			Userinfo userinfo = new Userinfo();
			if (StringUtils.isNotEmpty(userinfoKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("userinfoKey")))
					userinfoKey = (String) this.getSession().getAttribute(
							"userinfoKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			userinfo = this.userinfoService.getUserinfo(IntegerUtil
					.converStrToInteger(userinfoKey));
			WebappUtil.copyProperties(userinfoForm, userinfo);
			Base64Decode base6444 = new Base64Decode();
			userinfoForm.setUserpwd(base6444.decode(userinfo.getUserpwd()));
			this.getSession().setAttribute("userinfoForm", userinfoForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveUserinfo() {
		Base64Encode base64 = new Base64Encode();
		Boolean c = true;
		Boolean b = true;
		try {
			Userinfo userinfo = new Userinfo();
			if (StringUtils.isNotEmpty(userinfoKey)) {
				userinfo = this.userinfoService.getUserinfo(IntegerUtil
						.converStrToInteger(userinfoKey));
				WebappUtil.copyProperties(userinfo, userinfoForm);
				if (StringUtils.isNotEmpty(userinfoForm.getTemp1())) {
					Workstation ws = new Workstation();
					ws = this.workstationService.getWorkstation(Integer
							.parseInt(userinfoForm.getTemp1()));
					if (null == ws) {
						return ajaxForwardError(getText("该工厂不存在!"));
					}
					userinfo.setPkWorkstation(ws);
				}
				// 坐席登陆是更新状态
				// 用户名唯一
				c = this.userinfoService.checkUsername(userinfo);
				b = this.userinfoService.checkAgentno(userinfo);
				if (!c) {
					return ajaxForwardError(getText("用户名重复！"));
				}
				if (!b) {
					return ajaxForwardError(getText("CTI登录号重复！"));
				}
				userinfo.setUserpwd(base64.encode(userinfoForm.getUserpwd()));
				this.userinfoService.updateUserinfo(userinfo);
				// this.logService(getRequest()).addLog(this.getRequest(),
				// "LOGTYPE-XG", userinfo.toString(), Userinfo.REF);
			} else {
				WebappUtil.copyProperties(userinfo, userinfoForm);
				if (StringUtils.isNotEmpty(userinfoForm.getTemp1())) {
					Workstation ws = new Workstation();
					ws = this.workstationService.getWorkstation(Integer
							.parseInt(userinfoForm.getTemp1()));
					if (null == ws) {
						return ajaxForwardError(getText("该工厂不存在!"));
					}
					userinfo.setPkWorkstation(ws);
				}
				userinfo.setIsadmin("false");
				userinfo.setAgentstatus("false");
				userinfo.setDelflag("N");
				c = this.userinfoService.checkUsername(userinfo);
				b = this.userinfoService.checkAgentno(userinfo);
				if (!c) {
					return ajaxForwardError(getText("用户名重复！"));
				}
				if (!b) {
					return ajaxForwardError(getText("CTI登录号重复！"));
				}
				userinfo.setUserpwd(base64.encode(userinfoForm.getUserpwd()));
				this.userinfoService.addUserinfo(userinfo);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", userinfo.toString(), Userinfo.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listUserinfo() {
		int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
				.converStrToInteger(this.getPageNum()) - 1
				: 0;
		int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
		int startIndex = pageNum
				* IntegerUtil.converStrToInteger(getNumPerPage());
		String search = this.getRequest().getParameter("search");
		if (StringUtils.equalsIgnoreCase(search, "true")) {
			startIndex = 0 * IntegerUtil.converStrToInteger(getNumPerPage());
		}
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryusername("");
			this.setQueryextno("");
			this.setQueryfactory("");
			this.setQueryagentname("");
		}
		List<Userinfo> l = this.userinfoService.findUserinfoBySql(getHql(startIndex, numPerPage));

		this.getSession().setAttribute("userinfoList", l);
		int i = 0;
		i = this.userinfoService.queryCountUserinfo(this.getDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int pageNum) {
		String hql = "select * from Userinfo where PK_USERINFO >0 ";
		if (StringUtils.isNotEmpty(queryusername))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and UserName like '%").append(queryusername).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryextno))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Extno like '%").append(queryextno).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryfactory))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Factory like '%").append(queryfactory).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryagentname))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Agentname like '%").append(queryagentname).append(
					"%'").toString();
		hql = (new StringBuilder(String.valueOf(hql))).append(
				" and Isadmin = 'false'").toString();
		if (StringUtils.isNotEmpty(realOrderField()))
			hql = (new StringBuilder(String.valueOf(hql))).append(" order by ")
					.append(realOrderField()).toString();
		hql = (new StringBuilder(String.valueOf(hql))).append(" LIMIT ")
				.append(startIndex).append(",").append(pageNum).toString();
		return hql;
	}

	private DetachedCriteria getDetachedCriteria() {
		Userinfo user = this.getUserInfo(this.getRequest());
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		// detachedCriteria.addOrder(Order.asc(Userinfo.PROP_ID));
		if (StringUtils.isNotEmpty(queryusername)) {
			detachedCriteria.add(Restrictions.ilike(Userinfo.PROP_USERNAME,
					queryusername, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryextno)) {
			detachedCriteria.add(Restrictions.ilike(Userinfo.PROP_EXTNO,
					queryextno, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryagentname)) {
			detachedCriteria.add(Restrictions.ilike(Userinfo.PROP_AGENTNAME,
					queryagentname, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryfactory)) {
			detachedCriteria.add(Restrictions.ilike(Userinfo.PROP_FACTORY,
					queryfactory, MatchMode.ANYWHERE));
		}
		// detachedCriteria.add(Restrictions.eq(Userinfo.PROP_DELFLAG,"N"));
		detachedCriteria.add(Restrictions.not(Restrictions.eq(
				Userinfo.PROP_ISADMIN, "true")));
		if (!StringUtils.equals(user.getIsadmin(), "true")) {
			detachedCriteria
					.add(Restrictions.eq(Userinfo.PROP_USERSTATUS, "Y"));
		}
		return detachedCriteria;
	}

	public String deleteUserinfo() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			List<BdUserinforole> listrole = new ArrayList<BdUserinforole>();
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					// 用户
					int key = Integer.parseInt(ids[i]);
					Userinfo user = this.userinfoService.getUserinfo(key);
					user.setDelflag("Y");
					user.setUserstatus("N");
					this.userinfoService.updateUserinfo(user);
					// 角色
					// listrole =
					// this.roleService.queryUserinforoleByUser(user);

				}
				// if (listrole.size() > 0) {
				// for (BdUserinforole br : listrole) {
				// this.roleService.deleteUserinforole(br);
				// }
				// }
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete:" + selectIDS.toString(),
					Userinfo.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}

	public String exceldialog() {
		return SUCCESS;
	}

	// 导入excel文件
	public String importExcel() {
		List<Userinfo> list = new ArrayList<Userinfo>();
		List<String> liststr = new ArrayList<String>();
		try {
			if (StringUtils.substringAfter(uploadFileName, ".")
					.equalsIgnoreCase("xlsx")) {
				liststr = FileUtil.readExcelXSSF(upload);
			} else if (StringUtils.substringAfter(uploadFileName, ".")
					.equalsIgnoreCase("xls")) {
				liststr = FileUtil.readExcelHSSF(upload);
			} else {
				return ajaxForwardError(getText("userinfo.excel"));
			}
			System.out.println("liststr:" + liststr.size());
			int i = (liststr.size()) / 17;
			int a = 0;
			for (int j = 0; j < i; j++) {
				Userinfo user = new Userinfo();
				user.setFactory(liststr.get(a));
				user.setUsername(liststr.get(a + 1));
				user.setUserpwd(liststr.get(a + 2));
				user.setAgentno(liststr.get(a + 3));
				user.setCtipwd(liststr.get(a + 4));
				user.setExtno(liststr.get(a + 5));
				user.setAgentname(liststr.get(a + 6));
				user.setAgentemail(liststr.get(a + 7));
				user.setPhoneno(liststr.get(a + 8));
				user.setAgenttype(liststr.get(a + 9));
				user.setPosition(liststr.get(a + 10));
				user.setRemark(liststr.get(a + 11));
				user.setCtiaddr(liststr.get(a + 12));
				user.setCtiaddrbak(liststr.get(a + 13));
				user.setAuthaddr(liststr.get(a + 14));
				user.setAuthtype(liststr.get(a + 15));
				a += 17;
				list.add(user);
			}
			StringBuffer sb = new StringBuffer();
			System.out.println(list.size());
			for (Userinfo u : list) {
				Userinfo uu = new Userinfo();
				uu = u;
				uu.setDelflag("N");
				uu.setIsadmin("false");
				System.out.println(u.getUsername() + "---" + u.getUserpwd()
						+ "---" + u.getAuthtype());
				this.userinfoService.addUserinfo(uu);
			}

			// this.logService(getRequest()).addLog(this.getRequest(),
			// "LOGTYPE-IMPORT", "Excel import userinfo" + sb.toString(),
			// Userinfo.REF);
			return ajaxForwardSuccess(getText("userinfo.import"));
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxForwardError(getText(e.getMessage()));
		}
	}

	// 分配角色
	public String dispatchRole() {
		try {
			userinfoForm = new UserinfoForm();
			Userinfo userinfo = new Userinfo();
			if (StringUtils.isNotEmpty(userinfoKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("userinfoKey")))
					userinfoKey = (String) this.getSession().getAttribute(
							"userinfoKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			userinfo = this.userinfoService.getUserinfo(IntegerUtil
					.converStrToInteger(userinfoKey));
			WebappUtil.copyProperties(userinfoForm, userinfo);
			this.getSession().setAttribute("userinfoForm", userinfoForm);
			List<BdUserinforole> listbur = this.roleService
					.queryUserinforoleByUser(userinfo);
			List<BdRole> lastroleList = new ArrayList<BdRole>();
			List<BdRole> useroleList = new ArrayList<BdRole>();
			lastroleList = this.roleService.queryAllRole();
			if (!listbur.isEmpty() && listbur.size() > 0) {
				Iterator iterator = listbur.iterator();
				while (iterator.hasNext()) {
					BdUserinforole bdUserinforole = (BdUserinforole) iterator
							.next();
					useroleList.add(bdUserinforole.getPkRole());
				}
			}
			lastroleList.removeAll(useroleList);
			this.getSession().setAttribute("lastroleList", lastroleList);
			this.getSession().setAttribute("useroleList", useroleList);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveUserRole() {
		String[] roles = this.getRequest().getParameterValues("selectUsers");
		Userinfo user = new Userinfo();
		try {
			if (StringUtils.isNotEmpty(userinfoKey)) {
				user = this.userinfoService.getUserinfo(Integer
						.parseInt(userinfoKey));
				if (roles == null) {
					this.roleService.delAllUserinforoleByUser(user);
					user.setIsadmin("false");
					this.userinfoService.updateUserinfo(user);
				} else {
					this.roleService.delAllUserinforoleByUser(user);
					user.setIsadmin("false");
					this.userinfoService.updateUserinfo(user);
					for (int i = 0; i < roles.length; i++) {
						BdRole role = new BdRole();
						BdUserinforole bur = new BdUserinforole();
						role = this.roleService.getRole(Integer
								.parseInt(roles[i]));
						if (StringUtils.equals(role.getRolename(), "系统管理员")) {
							user.setIsadmin("true");
							this.userinfoService.updateUserinfo(user);
						}
						bur.setPkRole(role);
						bur.setPkUserinfo(user);
						this.roleService.saveBdUserinforole(bur);
					}
				}

			}
			return ajaxForwardSuccess(getText("设置成功!"));
		} catch (Exception e) {
			e.getMessage();
			return ajaxForwardError(getText(e.getMessage()));
		}
	}

	public UserinfoForm getUserinfoForm() {
		return userinfoForm;
	}

	public void setUserinfoForm(UserinfoForm userinfoForm) {
		this.userinfoForm = userinfoForm;
	}

	public String getUserinfoKey() {
		return userinfoKey;
	}

	public void setUserinfoKey(String userinfoKey) {
		this.userinfoKey = userinfoKey;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public String getQueryusername() {
		return queryusername;
	}

	public void setQueryusername(String queryusername) {
		this.queryusername = queryusername;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	public String[] getExtnlimits() {
		return extnlimits;
	}

	public void setExtnlimits(String[] extnlimits) {
		this.extnlimits = extnlimits;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String getQueryextno() {
		return queryextno;
	}

	public void setQueryextno(String queryextno) {
		this.queryextno = queryextno;
	}

	public String getQueryagentname() {
		return queryagentname;
	}

	public void setQueryagentname(String queryagentname) {
		this.queryagentname = queryagentname;
	}

	public String getQueryfactory() {
		return queryfactory;
	}

	public void setQueryfactory(String queryfactory) {
		this.queryfactory = queryfactory;
	}

	public WorkstationService getWorkstationService() {
		return workstationService;
	}

	public void setWorkstationService(WorkstationService workstationService) {
		this.workstationService = workstationService;
	}

}
