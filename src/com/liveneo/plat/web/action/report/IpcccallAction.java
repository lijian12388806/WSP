package com.liveneo.plat.web.action.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import com.liveneo.plat.constants.GlobalConstants;
import com.liveneo.plat.service.impl.IpcccallService;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ObjectUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.report.AgentinfoForm;
import com.liveneo.plat.web.report.CallinfoForm;

public class IpcccallAction extends AbstractActionSupport {

	private static final long serialVersionUID = 1L;
	private IpcccallService ipcccallService;
	private AgentinfoForm agentinfoForm;
	// 查询条件
	private String query1;
	private String query2;
	private String query3;
	private String query4;
	private String query5;
	private String query6;
	private String query7;
	private String query8;
	private String query9;

	// 报表类型
	private String reportType;

	public String execute() {
		return SUCCESS;
	}

	// 高级检索
	public String searchAkpiJspPage() {
		String akpitimeflag = this.getRequest().getParameter("akpitimeflag");
		this.getRequest().setAttribute("akpitimeflag", akpitimeflag);
		this.getSession().setAttribute("akpisearchflag",
				this.getRequest().getParameter("akpisearchflag"));
		return SUCCESS;
	}

	// IVR话务量统计
	public String listIpccReport() {
		// 报表类型
		reportType = this.getRequest().getParameter("reportType");
		// excel文件名
		String fileName = this.getRequest().getParameter("fileName");
		this.getRequest().setAttribute("fileName", fileName);
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
			this.setQuery1("");
			this.setQuery2("");
			this.setQuery3("");
			this.setQuery4("");
			this.setQuery5("");
			this.setQuery6("");
			this.setQuery7("");
			this.setQuery8("");
			this.setQuery9("");
		}
		try {
			Map<String, List<Object>> listMap = new HashMap<String, List<Object>>();
			listMap = this.ipcccallService.executeQuerySQlInDAO(this
					.getAgentLoginAndLogoutSql(startIndex, numPerPage, "",
							reportType), reportType);
			List<Object> list = listMap.get(reportType);
			Map<String, List<Object>> listMapC = new HashMap<String, List<Object>>();
			listMapC = this.ipcccallService.executeQuerySQlInDAO(this
					.getAgentLoginAndLogoutSql(startIndex, numPerPage, "count",
							reportType), reportType);
			List<Object> listC = listMapC.get(reportType);
			int i = 0;
			// 迁入迁出明细
			if (StringUtils.equalsIgnoreCase(reportType,
					GlobalConstants.IPCC_REPORT_TYPE_AGENTINFO)) {
				List<AgentinfoForm> l = new ArrayList<AgentinfoForm>();
				for (Object o : list) {
					l.add((AgentinfoForm) o);
				}
				this.getSession().setAttribute("ipccinfolist", l);
			}
			//通话明细
			if (StringUtils.equalsIgnoreCase(reportType,
					GlobalConstants.IPCC_REPORT_TYPE_CALLINFO)) {
				List<CallinfoForm> l = new ArrayList<CallinfoForm>();
				for (Object o : list) {
					l.add((CallinfoForm) o);
				}
				this.getSession().setAttribute("ipccinfolist", l);
			}
			i = listC.size();
			if(null != listC){
				try {
				List<List<String>> lists = new ArrayList<List<String>>();
				lists = ObjectUtil.getFieldValue(listC);
				this.getSession().setAttribute("listIpccexcel", lists);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			this.setTotalCount(i);
			this.getSession().setAttribute("totalCount", i);

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return AbstractActionSupport.LIST;
	}

	// flag=count 时统计数量
	/**
	 * 报表sql语句
	 * */
	private String getAgentLoginAndLogoutSql(int startIndex, int numPerPage,
			String flag, String reportType) {
		StringBuffer sb = new StringBuffer();
		// 迁入迁出明细
		if (StringUtils.equalsIgnoreCase(reportType,
				GlobalConstants.IPCC_REPORT_TYPE_AGENTINFO)) {
			sb
					.append("select a.AgentLoginID agentLoginID,b.AgentID agentID,b.AgentDN agentDN,b.LoginTime loginTime, a.StartTime logoutTime,TIMESTAMPDIFF(SECOND,b.LoginTime,a.StartTime) as loginlenth from base_agentstate a ,base_agentinfo b where a.AgentLoginID=b.AgentLoginID and a.EventID='806354953' ");
			// 签入时间
			if (StringUtils.isNotEmpty(query1)) {
				sb.append(" and b.LoginTime >= '" + query1 + "'");
			}
			if (StringUtils.isNotEmpty(query2)) {
				sb.append(" and b.LoginTime <= '" + query2 + "'");
			}
			// 签入时间
			if (StringUtils.isNotEmpty(query3)) {
				sb.append(" and a.StartTime >= '" + query3 + "'");
			}
			if (StringUtils.isNotEmpty(query4)) {
				sb.append(" and a.StartTime <= '" + query4 + "'");
			}
			// 坐席工号
			if (StringUtils.isNotEmpty(query5)) {
				sb.append(" and b.AgentID like '%" + query5 + "%'");
			}
			// 坐席分机
			if (StringUtils.isNotEmpty(query6)) {
				sb.append(" and b.AgentDN like '%" + query6 + "%'");
			}
			// 时长
			if (StringUtils.isNotEmpty(query7)) {
				sb
						.append(" and TIMESTAMPDIFF(SECOND,b.LoginTime,a.StartTime)  = '"
								+ query7 + "'");
			}
			if (StringUtils.isNotEmpty(realOrderField())) {
				sb.append(" order by " + realOrderField());
			} else {
				sb.append(" order by b.LoginTime desc  ");
			}
			// 呼叫明细
		}
		if (StringUtils.equalsIgnoreCase(reportType,
				GlobalConstants.IPCC_REPORT_TYPE_CALLINFO)) {
			sb.append("select a.AgentLoginID agentLoginID,b.AgentID agentID,b.AgentDN agentDN,i.ContactID contactID,i.OriANI oriANI,i.OriDNIS oriDNIS,i.CallDirection callDirection, i.CallType callType,i.StartTime startTime,s.StartTime as endTime,TIMESTAMPDIFF (SECOND,i.StartTime,s.StartTime) as talkinglen from base_contactinfo i,base_contactstate s ,base_agentstate a ,base_agentinfo b where i.ContactID=s.ContactID and s.EventID='806355206'and a.ContactID=i.ContactID and a.EventID='806354951'and b.AgentLoginID=a.AgentLoginID ");
			// 开始时间
			if (StringUtils.isNotEmpty(query1)) {
				sb.append(" and i.StartTime >= '" + query1 + "'");
			}
			if (StringUtils.isNotEmpty(query2)) {
				sb.append(" and i.StartTime <= '" + query2 + "'");
			}
			// 结束时间
			if (StringUtils.isNotEmpty(query3)) {
				sb.append(" and s.StartTime >= '" + query3 + "'");
			}
			if (StringUtils.isNotEmpty(query4)) {
				sb.append(" and s.StartTime <= '" + query4 + "'");
			}
			// 坐席工号
			if (StringUtils.isNotEmpty(query5)) {
				sb.append(" and b.AgentID like '%" + query5 + "%'");
			}
			// 坐席分机
			if (StringUtils.isNotEmpty(query6)) {
				sb.append(" and b.AgentDN like '%" + query6 + "%'");
			}
			// 时长
			if (StringUtils.isNotEmpty(query7)) {
				sb.append(" and TIMESTAMPDIFF (SECOND,i.StartTime,s.StartTime)  = '"
								+ query7 + "'");
			}
			if (StringUtils.isNotEmpty(realOrderField())) {
				sb.append(" order by " + realOrderField());
			} else {
				sb.append(" order by i.StartTime desc  ");
			}
		}
		if (!StringUtils.equalsIgnoreCase(flag, "count")) {
			sb.append(" LIMIT " + startIndex + "," + numPerPage);
		}
		return sb.toString();
	}

	public String getQuery1() {
		return query1;
	}

	public void setQuery1(String query1) {
		this.query1 = query1;
	}

	public String getQuery2() {
		return query2;
	}

	public void setQuery2(String query2) {
		this.query2 = query2;
	}

	public String getQuery3() {
		return query3;
	}

	public void setQuery3(String query3) {
		this.query3 = query3;
	}

	public String getQuery4() {
		return query4;
	}

	public void setQuery4(String query4) {
		this.query4 = query4;
	}

	public String getQuery5() {
		return query5;
	}

	public void setQuery5(String query5) {
		this.query5 = query5;
	}

	public String getQuery6() {
		return query6;
	}

	public void setQuery6(String query6) {
		this.query6 = query6;
	}

	public String getQuery7() {
		return query7;
	}

	public void setQuery7(String query7) {
		this.query7 = query7;
	}

	public String getQuery8() {
		return query8;
	}

	public void setQuery8(String query8) {
		this.query8 = query8;
	}

	public String getQuery9() {
		return query9;
	}

	public void setQuery9(String query9) {
		this.query9 = query9;
	}

	public IpcccallService getIpcccallService() {
		return ipcccallService;
	}

	public void setIpcccallService(IpcccallService ipcccallService) {
		this.ipcccallService = ipcccallService;
	}

	public AgentinfoForm getAgentinfoForm() {
		return agentinfoForm;
	}

	public void setAgentinfoForm(AgentinfoForm agentinfoForm) {
		this.agentinfoForm = agentinfoForm;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

}
