package com.liveneo.plat.web.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Calldetail;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.impl.CalldetailService;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.RandomGUID;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.CalldetailForm;

public class CalldetailAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private CalldetailService calldetailService;
	private CalldetailForm calldetailForm;
	// 查询条件
	private String queryagentid;
	private String queryani;
	private String queryaniarea;
	private String queryanicity;
	private String querycreatetype;
	private String querylslost;
	private String starttime1;
	private String stoptime1;
	private String starttime2;
	private String stoptime2;

	public String execute() {
		return SUCCESS;
	}

	public String listCalldetail() {
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
			this.setQueryani("");
			this.setQueryaniarea("");
			this.setQueryanicity("");
			this.setQuerycreatetype("");
			this.setQuerylslost("");
			this.setStarttime1("");
			this.setStoptime1("");
		}
		List<Calldetail> l = this.calldetailService.findCalldetailSql(getHql(startIndex, numPerPage));

		this.getSession().setAttribute("calldetailList", l);
		int i = 0;
		i = this.calldetailService.queryCountCalldetail(this
				.getDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int pageNum) {
		String hql = "select * from calldetail where PK_CALLDETAIL != 0 ";
		if (StringUtils.isNotEmpty(queryagentid))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and agentid like '%").append(queryagentid).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryani))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and ani like '%").append(queryani).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryaniarea))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and aniarea like '%").append(queryaniarea).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryanicity))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and queryanicityanicity like '%").append(queryanicity)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(querycreatetype))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and createtype like '%").append(querycreatetype).append(
					"%'").toString();
		if (StringUtils.isNotEmpty(querylslost))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and islost like '%").append(querylslost).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryanicity))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and anicity like '%").append(queryanicity).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(starttime1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and callintime >= '").append(starttime1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(stoptime1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and callintime <= '").append(stoptime1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(starttime2))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and leavetime >= '").append(starttime2).append("'")
					.toString();
		if (StringUtils.isNotEmpty(stoptime2))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and leavetime <= '").append(stoptime2).append("'")
					.toString();
		hql = (new StringBuilder(String.valueOf(hql))).append(" limit ")
				.append(startIndex).append(",").append(pageNum).toString();
		return hql;
	}

	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Calldetail.class);
		// detachedCriteria.addOrder(Order.asc(Userinfo.PROP_ID));
		if (StringUtils.isNotEmpty(queryagentid)) {
			detachedCriteria.add(Restrictions.ilike(Calldetail.PROP_AGENTID,
					queryagentid, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryani)) {
			detachedCriteria.add(Restrictions.ilike(Calldetail.PROP_ANI,
					queryani, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryaniarea)) {
			detachedCriteria.add(Restrictions.ilike(Calldetail.PROP_ANIAREA,
					queryaniarea, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryanicity)) {
			detachedCriteria.add(Restrictions.ilike(Calldetail.PROP_ANICITY,
					queryanicity, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querycreatetype)) {
			detachedCriteria.add(Restrictions.eq(Calldetail.PROP_CREATETYPE,
					querycreatetype));
		}
		if (StringUtils.isNotEmpty(querylslost)) {
			detachedCriteria.add(Restrictions.eq(Calldetail.PROP_ISLOST,
					querylslost));
		}
		// 来电时间
		if (StringUtils.isNotEmpty(starttime1)) {
			detachedCriteria.add(Restrictions.sqlRestriction("callintime >= '"
					+ starttime1 + "'"));
		}
		if (StringUtils.isNotEmpty(stoptime1)) {
			detachedCriteria.add(Restrictions.sqlRestriction("callintime <= '"
					+ stoptime1 + "'"));
		}
		// 呼损/留言/转出时间:
		if (StringUtils.isNotEmpty(starttime2)) {
			detachedCriteria.add(Restrictions.sqlRestriction("leavetime >= '"
					+ starttime2 + "'"));
		}
		if (StringUtils.isNotEmpty(stoptime2)) {
			detachedCriteria.add(Restrictions.sqlRestriction("leavetime <= '"
					+ stoptime2 + "'"));
		}
		return detachedCriteria;
	}

	public String addCallout() {
		Userinfo user = this.getUserInfo(this.getRequest());
		// 呼叫记录
		Calldetail calldetail = new Calldetail();
		calldetail.setAgentid(user.getAgentno());
		calldetail.setCallintime(DateUtil.formatDateByFormat(new Date(),
				"yyyy-MM-dd HH:mm:ss"));
		String ucid = this.getRequest().getParameter("ucid");
		if (StringUtils.isNotEmpty(ucid)) {
			calldetail.setUcid(ucid);
		}
		calldetail.setCreatetype("callout");
		calldetail.setIslost("N");
		RandomGUID myGUID = new RandomGUID();
		calldetail.setId(myGUID.valueAfterMD5);
		this.calldetailService.add(calldetail);
		return SUCCESS;
	}

	public CalldetailService getCalldetailService() {
		return calldetailService;
	}

	public void setCalldetailService(CalldetailService calldetailService) {
		this.calldetailService = calldetailService;
	}

	public CalldetailForm getCalldetailForm() {
		return calldetailForm;
	}

	public void setCalldetailForm(CalldetailForm calldetailForm) {
		this.calldetailForm = calldetailForm;
	}

	public String getQueryagentid() {
		return queryagentid;
	}

	public void setQueryagentid(String queryagentid) {
		this.queryagentid = queryagentid;
	}

	public String getQueryani() {
		return queryani;
	}

	public void setQueryani(String queryani) {
		this.queryani = queryani;
	}

	public String getQueryaniarea() {
		return queryaniarea;
	}

	public void setQueryaniarea(String queryaniarea) {
		this.queryaniarea = queryaniarea;
	}

	public String getQueryanicity() {
		return queryanicity;
	}

	public void setQueryanicity(String queryanicity) {
		this.queryanicity = queryanicity;
	}

	public String getQuerycreatetype() {
		return querycreatetype;
	}

	public void setQuerycreatetype(String querycreatetype) {
		this.querycreatetype = querycreatetype;
	}

	public String getQuerylslost() {
		return querylslost;
	}

	public void setQuerylslost(String querylslost) {
		this.querylslost = querylslost;
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

	public String getStarttime2() {
		return starttime2;
	}

	public void setStarttime2(String starttime2) {
		this.starttime2 = starttime2;
	}

	public String getStoptime2() {
		return stoptime2;
	}

	public void setStoptime2(String stoptime2) {
		this.stoptime2 = stoptime2;
	}

}
