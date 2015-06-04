package com.liveneo.plat.web.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.liveneo.plat.service.iface.WorkOrderServiceIface;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.FileUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.CountRatioForm;

public class WorkReportAction extends AbstractActionSupport {
	private WorkOrderServiceIface workOrderService;
	private CountRatioForm countRatioForm;

	private static final long serialVersionUID = 1L;
	private String queryareaStart;
	private String queryareaEnd;

	
	public String execute() {
		return SUCCESS;
	}
	/****
	 * 工作量和结单率统计
	 * 
	 * */
	public String getDateString(String dateStr,String flag){
		if(flag.equals("start")){
			return DateUtil.formatDateByFormat(DateUtil.getQueryStartDate(dateStr), "yyyy-MM-dd HH:mm:ss");
		}else{
			return DateUtil.formatDateByFormat(DateUtil.getQueryEndDate(dateStr), "yyyy-MM-dd HH:mm:ss");
		}
	}
	public String listWorkratioReport(){
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQueryareaEnd("");
			this.setQueryareaStart("");
		}
		StringBuffer querySql = new StringBuffer();
		querySql.append("SELECT ISNULL(c.totalcount,0) tcount,ISNULL(c.closecount,0) ccount,u.USERNAME username,ISNULL(c.cti,0) totaltime FROM userinfo u LEFT JOIN ");
		querySql.append("(");
		querySql.append("select a.ac totalcount,ISNULL(b.bc, 0) closecount ,a.ap puser,a.ati cti from (");
		querySql.append("select count(*) ac ,pk_userinfo ap,SUM(DATEDIFF(ss,CALLTIME,DEALTIME)/60) ati from  workorder ");
		if(StringUtils.isNotEmpty(queryareaStart) || StringUtils.isNotEmpty(queryareaEnd)){
			querySql.append(" WHERE ");
		}
		if(StringUtils.isNotEmpty(queryareaStart)){
			querySql.append("CALLTIME > '");
			querySql.append(this.getDateString(queryareaStart, "start")+"' ");
			if(StringUtils.isNotEmpty(queryareaEnd)){
				querySql.append(" AND ");
			}
		}
		if(StringUtils.isNotEmpty(queryareaEnd)){
			querySql.append("CALLTIME < '");
			querySql.append(this.getDateString(queryareaEnd, "end")+"' ");
		}
		querySql.append("group by pk_userinfo) a ");
		
		querySql.append("LEFT JOIN");
		querySql.append("(");
		querySql.append("select count(*) bc,pk_userinfo bp,SUM(DATEDIFF(ss,CALLTIME,DEALTIME)/60) bti from WORKORDER where WOSTATUS = 'yjd' ");
		
		if(StringUtils.isNotEmpty(queryareaStart) || StringUtils.isNotEmpty(queryareaEnd)){
			querySql.append(" AND ");
		}
		if(StringUtils.isNotEmpty(queryareaStart)){
			querySql.append("CALLTIME > '");
			querySql.append(this.getDateString(queryareaStart, "start")+"' ");
			if(StringUtils.isNotEmpty(queryareaEnd)){
				querySql.append(" AND ");
			}
		}
		if(StringUtils.isNotEmpty(queryareaEnd)){
			querySql.append("CALLTIME < '");
			querySql.append(this.getDateString(queryareaEnd, "end")+"' ");
		}
		querySql.append(" group by PK_USERINFO) b on a.ap=b.bp ");
		querySql.append(") c ");
		querySql.append("ON c.puser = u.PK_USERINFO;");
//		System.out.println("querysql:"+querySql);
		try {
			List<CountRatioForm> countFormList = new ArrayList<CountRatioForm>();
			countFormList = this.workOrderService.executeQuerySQlINDAO(querySql.toString());
			FileUtil.createCountExcel(getServletContext().getRealPath("/excel/report_orderCount.xls"), countFormList,"工作量结单率统计");
			this.getRequest().setAttribute("fileName","report_orderCount.xls");
			this.getSession().setAttribute("countFormList", countFormList);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public CountRatioForm getCountRatioForm() {
		return countRatioForm;
	}
	public void setCountRatioForm(CountRatioForm countRatioForm) {
		this.countRatioForm = countRatioForm;
	}
	public String getQueryareaEnd() {
		return queryareaEnd;
	}
	public void setQueryareaEnd(String queryareaEnd) {
		this.queryareaEnd = queryareaEnd;
	}
	public String getQueryareaStart() {
		return queryareaStart;
	}
	public void setQueryareaStart(String queryareaStart) {
		this.queryareaStart = queryareaStart;
	}
	public WorkOrderServiceIface getWorkOrderService() {
		return workOrderService;
	}
	public void setWorkOrderService(WorkOrderServiceIface workOrderService) {
		this.workOrderService = workOrderService;
	}


}
