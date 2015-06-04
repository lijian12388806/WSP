package com.liveneo.plat.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.BdUserinforole;
import com.liveneo.plat.hibernate.dao.Logmsg;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.impl.LogmsgService;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.LogmsgForm;

public class LogmsgAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LogmsgService logmsgService;
	private LogmsgForm logmsgForm;

	private String queryusername;
	private String querylogtype;
	private String queryip;
	private String starttime;
	private String stoptime;


	public String listLogmsg() throws DateParseException {
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
			this.setQueryip("");
			this.setQuerylogtype("");
			this.setQueryusername("");
			this.setStarttime(DateUtil.formatDateByFormat(new Date(), "yyyy-MM-dd 00:00:00"));
			this.setStoptime("");
		}
		List<Logmsg> l = this.logmsgService.findLogmsgBySql(this.getHql(startIndex, numPerPage));
//		System.out.println("Logmsg:"+l.size());
		this.getSession().setAttribute("logmsgList", l);
		int i = 0;
		i = this.logmsgService.queryCountLogmsg(this.getDetachedCriteria());

		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
//		this.getSession().setAttribute("userinfo",null);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int pageNum) {
		String hql = "select * from Logmsg where PK_LOGMSG >0 ";

		if (StringUtils.isNotEmpty(queryusername)) {
			hql += " and UserName like '%" + queryusername + "%'";
		}
		if (StringUtils.isNotEmpty(querylogtype)) {
			hql += " and Logtype like '%" + querylogtype + "%'";
		}
		if (StringUtils.isNotEmpty(queryip)) {
			hql += " and ip like '%" + queryip + "%'";
		}
		if (StringUtils.isNotEmpty(starttime)
				&& StringUtils.isNotEmpty(stoptime)) {
				hql += " and Createtime between '" + starttime + "' and '" + stoptime
						+ "'";
		}
		if (StringUtils.isNotEmpty(starttime)
				&& StringUtils.isEmpty(stoptime)) {
				hql += " and Createtime > '" + starttime + "'";
		}
		if (StringUtils.isEmpty(starttime)
				&& StringUtils.isNotEmpty(stoptime)) {
				hql += " and Createtime < '" + stoptime + "'";
		}
		hql += " LIMIT " + startIndex + "," + pageNum;
//		System.out.println(hql);
		return hql;
	}

	private String getHql() {
		String hql = "From Logmsg where PK_LOGMSG >0 ";

		if (StringUtils.isNotEmpty(queryusername)) {
			hql += " and UserName like '%" + queryusername + "%'";
		}
		if (StringUtils.isNotEmpty(querylogtype)) {
			hql += " and Logtype like '%" + querylogtype + "%'";
		}
		if (StringUtils.isNotEmpty(queryip)) {
			hql += " and ip like '%" + queryip + "%'";
		}
		if (StringUtils.isNotEmpty(starttime)
				&& StringUtils.isNotEmpty(stoptime)) {
				hql += " and Createtime between '" + starttime + "' and '" + stoptime
						+ "'";
		}
		if (StringUtils.isNotEmpty(starttime)
				&& StringUtils.isEmpty(stoptime)) {
				hql += " and Createtime > '" + starttime + "'";
		}
		if (StringUtils.isEmpty(starttime)
				&& StringUtils.isNotEmpty(stoptime)) {
				hql += " and Createtime < '" + stoptime + "'";
		}
		
//		System.out.println(hql);
		return hql;
	}
	
	private DetachedCriteria getDetachedCriteria() throws DateParseException {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Logmsg.class);
//		detachedCriteria.addOrder(Order.desc(Logmsg.PROP_CREATETIME));
		 if (StringUtils.isNotEmpty(queryusername)) {
		 detachedCriteria.add(Restrictions.ilike(Logmsg.PROP_USERNAME,
		 queryusername,MatchMode.ANYWHERE));
		 }
		 if (StringUtils.isNotEmpty(querylogtype)) {
		 detachedCriteria.add(Restrictions.ilike(Logmsg.PROP_LOGTYPE,
				 querylogtype,MatchMode.ANYWHERE));
		 }
		 if (StringUtils.isNotEmpty(queryip)) {
			 detachedCriteria.add(Restrictions.ilike(Logmsg.PROP_IP,
					 queryip,MatchMode.ANYWHERE));
			 }
		 if(StringUtils.isNotEmpty(starttime)){
			 Date start=DateUtil.getQueryStartDate(starttime);
			 detachedCriteria.add(Restrictions.ge(Logmsg.PROP_CREATETIME, start));
		 }
			 if(StringUtils.isNotEmpty(stoptime)){
			 Date stop=DateUtil.getQueryEndDate(stoptime);
			 detachedCriteria.add(Restrictions.le(Logmsg.PROP_CREATETIME, stop));
		 }

		return detachedCriteria;
	}
	
	public String deleteLogmsg() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				String[] ids = StringUtils.split(selectIDS, ',');
				for (int i = 0; i < ids.length; i++) {
					// 用户
					int key = Integer.parseInt(ids[i]);
					this.logmsgService.deleteLogmsgByID(key);

				}
			}
			 this.logService(getRequest()).addLog(this.getRequest(),
					 "LOGTYPE-SC", "delete:" + selectIDS.toString(), Userinfo.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}

	public LogmsgService getLogmsgService() {
		return logmsgService;
	}

	public void setLogmsgService(LogmsgService logmsgService) {
		this.logmsgService = logmsgService;
	}

	public LogmsgForm getLogmsgForm() {
		return logmsgForm;
	}

	public void setLogmsgForm(LogmsgForm logmsgForm) {
		this.logmsgForm = logmsgForm;
	}

	public String getQueryusername() {
		return queryusername;
	}

	public void setQueryusername(String queryusername) {
		this.queryusername = queryusername;
	}

	public String getQuerylogtype() {
		return querylogtype;
	}

	public void setQuerylogtype(String querylogtype) {
		this.querylogtype = querylogtype;
	}

	public String getQueryip() {
		return queryip;
	}

	public void setQueryip(String queryip) {
		this.queryip = queryip;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStoptime() {
		return stoptime;
	}

	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

}
