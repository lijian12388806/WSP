package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.lm.utils.Base64Decode;
import com.liveneo.lm.utils.Base64Encode;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.impl.UserinfoService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.UserinfoForm;

public class IsAdminAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private UserinfoService userinfoService;
	private String adminKey;
	private UserinfoForm userinfoForm;
	private String queryusername;

	private String isadmin;
	private String pwdagain;
	private String oldpwd; 
	public String execute() {
		return SUCCESS;
	}

	public String addAdminUserinfo() {
		userinfoForm = new UserinfoForm();
		adminKey = "";
		pwdagain = "";
		return SUCCESS;
	}

	public String editAdminUserinfo() {
		try {
			userinfoForm = new UserinfoForm();
			Userinfo userinfo = new Userinfo();
			if (StringUtils.isNotEmpty(adminKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("adminKey")))
					adminKey = (String) this.getSession().getAttribute(
							"adminKey");
				else

					return AbstractActionSupport.EDIT;
			}// 返回list
			userinfo = this.userinfoService.getUserinfo(IntegerUtil
					.converStrToInteger(adminKey));
			WebappUtil.copyProperties(userinfoForm, userinfo);
			Base64Decode base64 = new Base64Decode();
			userinfoForm.setUserpwd(base64.decode(userinfo.getUserpwd()));
			this.pwdagain=userinfoForm.getUserpwd();
			this.getSession().setAttribute("userinfoForm", userinfoForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveAdminUserinfo() {
		try {
			Userinfo userinfo = new Userinfo();
			Base64Encode base64 = new Base64Encode();
			if (StringUtils.isNotEmpty(adminKey)) {
				userinfo = this.userinfoService.getUserinfo(IntegerUtil
						.converStrToInteger(adminKey));
				WebappUtil.copyProperties(userinfo, userinfoForm);

				if (!StringUtils.equalsIgnoreCase((pwdagain),
						userinfo.getUserpwd())) {
					return ajaxForwardError(getText("userinfo.nomatch"));
				}
				userinfo.setUserpwd(base64.encode(pwdagain));
				this.userinfoService.updateUserinfo(userinfo);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", userinfo.toString(), Userinfo.REF);
			} else {
				WebappUtil.copyProperties(userinfo, userinfoForm);
				if (this.userinfoService.checkName(userinfo) == false) {
					
					if (!StringUtils.equalsIgnoreCase((pwdagain),
							userinfo.getUserpwd())) {
						return ajaxForwardError(getText("userinfo.nomatch"));
					}
					userinfo.setUserpwd(base64.encode(pwdagain));
					this.userinfoService.addUserinfo(userinfo);
					this.logService(getRequest()).addLog(this.getRequest(),
							"LOGTYPE-XZ", userinfo.toString(), Userinfo.REF);
				} else {
					return ajaxForwardError(getText("userinfo.exsit"));
				}
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	// 管理员、密码
	public String listAdminUserinfo() {
		int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
				.converStrToInteger(this.getPageNum()) - 1
				: 0;
		int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
		int startIndex = pageNum
				* IntegerUtil.converStrToInteger(getNumPerPage());

		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryusername("");
		}
		List<Userinfo> l = this.userinfoService.findUserinfoBySql(this
				.getAdminDetachedCriteria(),startIndex, numPerPage);

		this.getSession().setAttribute("userinfoList", l);
		int i = 0;
		i = this.userinfoService.queryCountUserinfo(this
				.getAdminDetachedCriteria());

		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;

	}

	private String getAdminHql(int startIndex, int pageNum) {
		String hql = "select * from Userinfo where PK_USERINFO >0 ";

		if (StringUtils.isNotEmpty(queryusername)) {
			hql += " and UserName like '%" + queryusername + "%'";
		}
		hql += " and Isadmin = 'true'";
		hql += "LIMIT " + startIndex + "," + pageNum;
		return hql;
	}
	
	private String getAdminHql() {
		String hql = "From Userinfo where PK_USERINFO >0 ";

		if (StringUtils.isNotEmpty(queryusername)) {
			hql += " and UserName like '%" + queryusername + "%'";
		}
	
		return hql;
	}

	private DetachedCriteria getAdminDetachedCriteria() {
		// System.out.println("listadmin:"+isadmin);
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Userinfo.class);
		//detachedCriteria.addOrder(Order.asc(Userinfo.PROP_ID));
		if (StringUtils.isNotEmpty(queryusername)) {
			detachedCriteria.add(Restrictions.ilike(Userinfo.PROP_USERNAME,
					queryusername, MatchMode.ANYWHERE));
		}
		detachedCriteria.add(Restrictions.eq(Userinfo.PROP_ISADMIN, "true"));
		return detachedCriteria;
	}

	public String deleteAdminUserinfo() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				this.userinfoService.deleteAdminUserinfoByIds(StringUtils
						.split(selectIDS, ','));
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete：" + selectIDS.toString(),
					Userinfo.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}

	// 修改密码

	public String changePwd() {
		Userinfo user = (Userinfo) this.getSession().getAttribute("userinfo");
		// System.out.println("id:"+user.getId());
		this.getSession().setAttribute("user", user);
		return SUCCESS;
	}

	public String savePwd() {
		Userinfo userinfo = new Userinfo();
		Base64Encode base64 = new Base64Encode();
		if(StringUtils.equals(pwdagain, userinfoForm.getUserpwd())){
			userinfo = this.userinfoService.getUserinfo(IntegerUtil.converStrToInteger(adminKey));
			if(!StringUtils.equals(userinfo.getUserpwd(), base64.encode(oldpwd))){
				return ajaxForwardError(getText("密码错误！"));
			}
			userinfo.setUserpwd(base64.encode(userinfoForm.getUserpwd()));
			this.userinfoService.updateUserinfo(userinfo);
			this.logService(getRequest()).addLog(this.getRequest(), "LOGTYPE-XG", "update password："+adminKey, Userinfo.REF);
			return ajaxForwardSuccess(getText("修改密码成功！"));
		}else{
			return ajaxForwardError(getText("两次输入的新密码不匹配！"));
		}
	}

	public String logoutpwd() {
		log.info("logout!");
		// this.getSession().invalidate();
		return SUCCESS;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public String getAdminKey() {
		return adminKey;
	}

	public void setAdminKey(String adminKey) {
		this.adminKey = adminKey;
	}

	public UserinfoForm getUserinfoForm() {
		return userinfoForm;
	}

	public void setUserinfoForm(UserinfoForm userinfoForm) {
		this.userinfoForm = userinfoForm;
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

	public String getPwdagain() {
		return pwdagain;
	}

	public void setPwdagain(String pwdagain) {
		this.pwdagain = pwdagain;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

}
