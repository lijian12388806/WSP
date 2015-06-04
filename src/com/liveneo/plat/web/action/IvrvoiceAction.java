package com.liveneo.plat.web.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Ivrvoice;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.service.impl.IvrvoiceService;
import com.liveneo.plat.utils.CreateXml;
import com.liveneo.plat.utils.FileUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.IvrvoiceForm;

public class IvrvoiceAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private IvrvoiceService ivrvoiceService;
	private String ivrvoiceKey;
	private IvrvoiceForm ivrvoiceForm;
	// 查询条件
	private String querycallerid;
	private String querydnis;
	private String startdate1;
	private String stopdate1;
	private String starttime1;
	private String stoptime1;
	private String startdate2;
	private String stopdate2;
	private String starttime2;
	private String stoptime2;
	private String queryfactory;
	private String queryStatus;
	// 录音播放
	private String musicpath;
	private String pathflag;

	public String execute() {
		return SUCCESS;
	}

	public String playmusic() {
		String url = "";
		try {
			HttpServletRequest request = this.getRequest();
			String path = ((HttpServletRequest) request).getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/voice/announcement/music/";
			System.out.println("basePath:" + basePath);
			System.out.println("musicpath:" + musicpath);
			// musicpath =
			// "/usr/src/smartcc/resources/recfile/20130703075718500_00120001_056.wav";
			if (StringUtils.equals(pathflag, "upload")) {
				FileUtil.upLoadFile(new File(musicpath), new File(
						getServletContext().getRealPath(
								"/voice/announcement/music/")
								+ "/" + request.getRemoteAddr() + ".mp3"));
				// BuildXml.createXmlFile(getServletContext().getRealPath("/pages/musicplayer/")+"/Mr.x_alixixi.xml",
				// CreateXml.initMusicxml(getServletContext().getRealPath("/pages/musicplayer/music/")+"/"+request.getRemoteAddr()+".mp3"));
				url = basePath + request.getRemoteAddr() + ".mp3";
			}
			if (StringUtils.equals(pathflag, "recording")) {
				FileUtil.upLoadFile(new File(CreateXml.recordingsdir
						+ musicpath), new File(getServletContext().getRealPath(
						"/voice/announcement/music/")
						+ "/" + request.getRemoteAddr() + ".mp3"));
				// BuildXml.createXmlFile(getServletContext().getRealPath("/pages/musicplayer/")+"/Mr.x_alixixi.xml",
				// CreateXml.initMusicxml(getServletContext().getRealPath("/pages/musicplayer/music/")+"/"+request.getRemoteAddr()+".mp3"));
				url = basePath + request.getRemoteAddr() + ".mp3";
			}
			if (StringUtils.isEmpty(url)) {
				return ajaxForwardError(getText("留言不存在！"));
			}
			this.getRequest().setAttribute("url", url);
			return SUCCESS;
		} catch (Exception e) {
			e.getMessage();
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	// 处理留言
	public String editVoice() {
		try {
			ivrvoiceForm = new IvrvoiceForm();
			Ivrvoice ivrvoice = new Ivrvoice();
			if (StringUtils.isNotEmpty(ivrvoiceKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("ivrvoiceKey")))
					ivrvoiceKey = (String) this.getSession().getAttribute(
							"ivrvoiceKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			ivrvoice = this.ivrvoiceService.getIvrvoice(ivrvoiceKey);
			WebappUtil.copyProperties(ivrvoiceForm, ivrvoice);
			this.getSession().setAttribute("ivrvoiceForm", ivrvoiceForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	// 保存处理结果
	public String saveVoice() {
		try {
			Ivrvoice ivrvoice = new Ivrvoice();
			if (StringUtils.isNotEmpty(ivrvoiceKey)) {
				Userinfo user = this.getUserInfo(this.getRequest());
				ivrvoice = this.ivrvoiceService.getIvrvoice(ivrvoiceKey);
				ivrvoice.setProcessresult(ivrvoiceForm.getProcessresult());
				ivrvoice.setIscheck("1");
				ivrvoice.setN2(user.getUsername());
				// String sql = "update IVRVOICE set processresult ='"
				// +ivrvoiceForm.getProcessresult()
				// +"',ischeck='1',n2='"+user.getUsername()+"' where pk_ivrvoice ='"+ivrvoiceKey+"'";
				this.ivrvoiceService.updateIvrvoice(ivrvoice);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", ivrvoice.toString(), Ivrvoice.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listIvrvoice() {
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
			this.setQuerycallerid("");
			this.setQuerydnis("");
			this.setQueryStatus("");
			this.setStartdate1("");
			this.setStartdate2("");
			// this.setStarttime1("");
			// this.setStarttime2("");
			this.setStopdate1("");
			// this.setStoptime1("");
			this.setStopdate2("");
			// this.setStoptime2("");
		}
		List<Ivrvoice> l = this.ivrvoiceService.findIvrvoiceSql(getHql(startIndex, numPerPage));;
		this.getSession().setAttribute("ivrvoiceList", l);
		int i = 0;
		i = this.ivrvoiceService.queryCountIvrvoice(this
				.getDetachedCriteria(false));
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int pageNum) {
		String hql = "select * from Ivrvoice  where pk_ivrvoice >0 ";
		if (StringUtils.isNotEmpty(querycallerid))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Callerid like '%").append(querycallerid).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(querydnis))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Dnis like '%").append(querydnis).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryStatus))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Status like '%").append(queryStatus).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(startdate1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and createDate > '").append(startdate1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(stopdate1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and createDate < '").append(stopdate1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(startdate2))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and fullstartdate > '").append(startdate2).append("'")
					.toString();
		if (StringUtils.isNotEmpty(stopdate2))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and fullstartdate < '").append(stopdate2).append("'")
					.toString();
		hql = (new StringBuilder(String.valueOf(hql))).append("LIMIT ").append(
				startIndex).append(",").append(pageNum).toString();
		return hql;
	}

	private DetachedCriteria getDetachedCriteria(boolean orderflag) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Ivrvoice.class);
		if (orderflag) {
			detachedCriteria.addOrder(Order.desc(Ivrvoice.PROP_STARTTIME));
		}
		if (StringUtils.isNotEmpty(querycallerid)) {
			detachedCriteria.add(Restrictions.ilike(Ivrvoice.PROP_CALLERID,
					querycallerid, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querydnis)) {
			detachedCriteria.add(Restrictions.ilike(Ivrvoice.PROP_DNIS,
					querydnis, MatchMode.ANYWHERE));
		}
		// 处理状态
		if (StringUtils.isNotEmpty(queryStatus) && queryStatus.equals("1")) {
			detachedCriteria.add(Restrictions.eq(Ivrvoice.PROP_ISCHECK,
					queryStatus));
		}
		if (StringUtils.isNotEmpty(queryStatus) && queryStatus.equals("0")) {
			detachedCriteria.add(Restrictions.not(Restrictions.eq(
					Ivrvoice.PROP_ISCHECK, "1")));
		}
		// 通话开始时间
		if (StringUtils.isNotEmpty(startdate1)) {
			detachedCriteria.add(Restrictions.ge(Ivrvoice.PROP_CREATE_DATE,
					startdate1));
		}
		if (StringUtils.isNotEmpty(stopdate1)) {
			detachedCriteria.add(Restrictions.le(Ivrvoice.PROP_CREATE_DATE,
					stopdate1));
		}
		if (StringUtils.isNotEmpty(startdate2)) {
			detachedCriteria.add(Restrictions.ge(Ivrvoice.PROP_FULLENDDATE,
					startdate2));
		}
		if (StringUtils.isNotEmpty(stopdate2)) {
			detachedCriteria.add(Restrictions.le(Ivrvoice.PROP_FULLENDDATE,
					stopdate2));
		}
		return detachedCriteria;
	}

	public IvrvoiceService getIvrvoiceService() {
		return ivrvoiceService;
	}

	public void setIvrvoiceService(IvrvoiceService ivrvoiceService) {
		this.ivrvoiceService = ivrvoiceService;
	}

	public String getIvrvoiceKey() {
		return ivrvoiceKey;
	}

	public void setIvrvoiceKey(String ivrvoiceKey) {
		this.ivrvoiceKey = ivrvoiceKey;
	}

	public IvrvoiceForm getIvrvoiceForm() {
		return ivrvoiceForm;
	}

	public void setIvrvoiceForm(IvrvoiceForm ivrvoiceForm) {
		this.ivrvoiceForm = ivrvoiceForm;
	}

	public String getQuerycallerid() {
		return querycallerid;
	}

	public void setQuerycallerid(String querycallerid) {
		this.querycallerid = querycallerid;
	}

	public String getQuerydnis() {
		return querydnis;
	}

	public void setQuerydnis(String querydnis) {
		this.querydnis = querydnis;
	}

	public String getStartdate1() {
		return startdate1;
	}

	public void setStartdate1(String startdate1) {
		this.startdate1 = startdate1;
	}

	public String getStopdate1() {
		return stopdate1;
	}

	public void setStopdate1(String stopdate1) {
		this.stopdate1 = stopdate1;
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

	public String getMusicpath() {
		return musicpath;
	}

	public void setMusicpath(String musicpath) {
		this.musicpath = musicpath;
	}

	public String getPathflag() {
		return pathflag;
	}

	public void setPathflag(String pathflag) {
		this.pathflag = pathflag;
	}

	public String getStartdate2() {
		return startdate2;
	}

	public void setStartdate2(String startdate2) {
		this.startdate2 = startdate2;
	}

	public String getStopdate2() {
		return stopdate2;
	}

	public void setStopdate2(String stopdate2) {
		this.stopdate2 = stopdate2;
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

	public String getQueryfactory() {
		return queryfactory;
	}

	public void setQueryfactory(String queryfactory) {
		this.queryfactory = queryfactory;
	}

	public String getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(String queryStatus) {
		this.queryStatus = queryStatus;
	}

}
