package com.liveneo.plat.web.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Calldetail;
import com.liveneo.plat.hibernate.dao.Ivrvoice;
import com.liveneo.plat.hibernate.dao.Satscore;
import com.liveneo.plat.service.impl.SatscoreService;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.SatscoreForm;

public class SatscoreAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private SatscoreService satscoreService;
	private SatscoreForm satscoreForm;
	// 查询条件
	private String querycallerno;
	private String queryagentid;
	private String queryextno;
	private String starttime1;
	private String stoptime1;

	public String execute() {
		return SUCCESS;
	}

	public String listSatscore() {
		int pageNum = IntegerUtil.converStrToInteger(this.getPageNum()) > 0 ? IntegerUtil
				.converStrToInteger(this.getPageNum()) - 1
				: 0;
		int numPerPage = IntegerUtil.converStrToInteger(getNumPerPage());
		int startIndex = pageNum
				* IntegerUtil.converStrToInteger(getNumPerPage());
		// 检索
		String search = this.getRequest().getParameter("search");
		if (StringUtils.equalsIgnoreCase(search, "true")) {
			startIndex = 0 * IntegerUtil.converStrToInteger(getNumPerPage());
		}
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryagentid("");
			this.setQuerycallerno("");
			this.setQueryextno("");
			this.setStarttime1("");
			this.setStoptime1("");
		}
		List<Satscore> l = this.satscoreService.findSatscoreSql(getHql(startIndex, numPerPage));

		this.getSession().setAttribute("satscoreList", l);
		int i = 0;
		i = this.satscoreService.queryCountSatscore(this
				.getDetachedCriteria(false));
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int pageNum) {
		String hql = "select * from satscore where PK_satscore > 0 ";
		if (StringUtils.isNotEmpty(querycallerno))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and callerno like '%").append(querycallerno).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryagentid))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and aniarea like '%").append(queryagentid).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryextno))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and queryanicityanicity like '%").append(queryextno)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(starttime1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and svctime >= '").append(starttime1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(stoptime1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and svctime <= '").append(stoptime1).append("'")
					.toString();
		hql = (new StringBuilder(String.valueOf(hql))).append(" limit ")
				.append(startIndex).append(",").append(pageNum).toString();
		return hql;
	}

	private DetachedCriteria getDetachedCriteria(Boolean b) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Satscore.class);
		if (b) {
			detachedCriteria.addOrder(Order.desc(Satscore.PROP_SVCTIME));
		}
		if (StringUtils.isNotEmpty(querycallerno)) {
			detachedCriteria.add(Restrictions.ilike(Satscore.PROP_CALLERNO,
					querycallerno, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryagentid)) {
			detachedCriteria.add(Restrictions.ilike(Satscore.PROP_AGENTID,
					queryagentid, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryextno)) {
			detachedCriteria.add(Restrictions.ilike(Satscore.PROP_EXTNO,
					queryextno, MatchMode.ANYWHERE));
		}
		// 通话开始时间

		if (StringUtils.isNotEmpty(starttime1)) {
			detachedCriteria.add(Restrictions.ge(Satscore.PROP_SVCTIME,
					starttime1));
		}
		if (StringUtils.isNotEmpty(stoptime1)) {
			detachedCriteria.add(Restrictions.le(Satscore.PROP_SVCTIME,
					stoptime1));
		}
		return detachedCriteria;
	}

	public SatscoreService getSatscoreService() {
		return satscoreService;
	}

	public void setSatscoreService(SatscoreService satscoreService) {
		this.satscoreService = satscoreService;
	}

	public SatscoreForm getSatscoreForm() {
		return satscoreForm;
	}

	public void setSatscoreForm(SatscoreForm satscoreForm) {
		this.satscoreForm = satscoreForm;
	}

	public String getQuerycallerno() {
		return querycallerno;
	}

	public void setQuerycallerno(String querycallerno) {
		this.querycallerno = querycallerno;
	}

	public String getQueryagentid() {
		return queryagentid;
	}

	public void setQueryagentid(String queryagentid) {
		this.queryagentid = queryagentid;
	}

	public String getQueryextno() {
		return queryextno;
	}

	public void setQueryextno(String queryextno) {
		this.queryextno = queryextno;
	}

	public String getStarttime1() {
		return starttime1;
	}

	public void setStarttime1(String starttime1) {
		this.starttime1 = starttime1;
	}

	public String getStoptime1() {
		return stoptime1;
	}

	public void setStoptime1(String stoptime1) {
		this.stoptime1 = stoptime1;
	}

}
