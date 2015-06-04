package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.BdDictdetail;
import com.liveneo.plat.hibernate.dao.Customerinfo;
import com.liveneo.plat.hibernate.dao.Orderdealinfo;
import com.liveneo.plat.hibernate.dao.Userinfo;
import com.liveneo.plat.hibernate.dao.Workorder;
import com.liveneo.plat.service.impl.BdDictService;
import com.liveneo.plat.service.impl.CalldetailService;
import com.liveneo.plat.service.impl.CustomerinfoService;
import com.liveneo.plat.service.impl.UserinfoService;
import com.liveneo.plat.service.impl.WorkOrderService;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.FileUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.JsonForm;
import com.liveneo.plat.web.form.NewWorkOrderForm;
import com.liveneo.plat.web.form.OrderdealinfoForm;
import com.liveneo.plat.web.form.SubtotalsForm;
import com.liveneo.plat.web.form.WorkOrderForm;

public class WorkOrderAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WorkOrderForm workOrderForm;
	private NewWorkOrderForm newworkOrderForm;
	private JsonForm jsonForm;
	private WorkOrderService workOrderService;
	private BdDictService bdDictService;
	private CustomerinfoService customerinfoService;
	private CalldetailService calldetailService;
	private UserinfoService userinfoService;
	private OrderdealinfoForm orderdealinfoForm;
	private SubtotalsForm subtotalsForm;
	private String workOrderKey;
	private String newworkOrderKey;
	private String orderdealinfoKey;
	private String orderCode;
	private String ordersource;
	private String pageCode;
	private String tabId;
	private String wo_ucid;

	private String subTotalsFlag;
	// 工单状态
	private String querywoyear;
	private String querywomonth;
	private String querywoday;
	// 工单类型
	private String querystwoyear;
	private String querystwomonth;
	private String querystwoday;

	// 查询
	private String querycustlinkman;
	private String queryworkorderno;
	private String queryproname;
	private String queryprocode;
	private String querycustomerno;
	private String querycustomername;
	private String querywostatus;
	private String queryordertype;
	private String queryordersource;
	private String queryprojecttype;
	private String querycallerno;
	private String querycompleteperson;
	private String querygeneratemode;
	private String queryfactoryname;
	private String starttime1;
	private String stoptime1;
	private String starttime2;
	private String stoptime2;

	private String queryagentname;
	// 报表查询-wcl
	private String querywclcompare;
	private String querywclnumber;
	private String querydhxclcompare;
	private String querydhxclnumber;
	private String queryywccompare;
	private String queryywcnumber;
	// 报表查询-type
	private String queryOSampledependc;
	private String queryOSampledependn;
	private String queryOAmodeldependc;
	private String queryOAmodeldependn;
	private String queryOSampleReqc;
	private String queryOSampleReqn;
	private String queryOOrderDeliveryc;
	private String queryOOrderDeliveryn;
	private String queryOOnsiteservicec;
	private String queryOOnsiteservicen;
	private String queryOComplainthandc;
	private String queryOComplainthandn;
	private String queryOReturnReqc;
	private String queryOReturnReqn;
	
	private String his_N;
	public String dispatchMode() {
		this.getSession().setAttribute("dispatchMode",
				this.getRequest().getParameter("dispatchMode"));
		return SUCCESS;
	}

	public String restReason() {
		return SUCCESS;
	}

	public String execute() {
		return SUCCESS;
	}
	/**
	 * 工单
	 * @return
	 */
	public String addnewWorkOrder() {
		workOrderForm = new WorkOrderForm();
		workOrderKey = "";
		Userinfo user = this.getUserInfo(this.getRequest());
		workOrderForm.setRemindflag("Y");
		workOrderForm.setActusername(user.getUsername());
		workOrderForm.setIsnew("false");
		this.getRequest().setAttribute("workOrderForm", workOrderForm);
		return SUCCESS;
	}

	public String addWorkOrder() {
		newworkOrderForm = new NewWorkOrderForm();
		workOrderKey = "";
		try {
			Userinfo user = this.getUserInfo(this.getRequest());
			if (!StringUtils.equals(ordersource, "manual")) {
				HttpServletRequest req = this.getRequest();
				Workorder workorder = new Workorder();
				Customerinfo customer = new Customerinfo();
				wo_ucid = req.getParameter("ucid");
				System.out.println("****************************"+wo_ucid);
				String agentid = req.getParameter("agentid");
				String callinno = req.getParameter("callinno");
				this.getSession().setAttribute("orderCode", "wcl");
				// 根据来电号码查询客户信息
				if (StringUtils.isNotEmpty(callinno)) {
					newworkOrderForm.setCallerno(callinno);
					customer = this.customerinfoService
							.getCustomerByCustomerno(callinno);
					if (null != customer) {
						newworkOrderForm.setCustomerid(StringUtils
								.trim(customer.getId() + ""));
						newworkOrderForm.setCustomername(customer
								.getCustomername());
						newworkOrderForm.setCustlinkman(customer
								.getCustlinkman());
						newworkOrderForm
								.setInfosource(customer.getInfosource());
						newworkOrderForm.setCustphoneno(customer
								.getCustphoneno());
						newworkOrderForm.setTemp1(customer.getTemp1());
						newworkOrderForm.setEmailaddr(customer.getEmailaddr());
						newworkOrderForm.setNetherlands(customer
								.getNetherlands());
						newworkOrderForm.setCustaddr(customer.getCustaddr());
						workorder.setPkCustomerinfo(customer);
						newworkOrderForm.setIsnew("false");
					} else {
						newworkOrderForm.setIsnew("true");
					}
					newworkOrderForm.setWorkorderno(this.workOrderService
							.createWorkorderNo());
					workorder.setWorkorderno(newworkOrderForm.getWorkorderno());
					workorder.setCalltime(new Date());
					workorder.setDealtime(null);
					workorder.setRemindflag("Y");
					workorder.setCallerno(callinno);
					workorder.setActusername(user.getUsername());
					workorder.setWostatus("wcl");
					workorder.setGeneratemode(ordersource);
					workorder.setPkUserinfo(user);
					workorder.setTemp8(wo_ucid);
					workorder.setTemp7(agentid);
					workOrderKey = IntegerUtil.converIntegerToStr(this.workOrderService.add(workorder));
				}
				newworkOrderForm.setCalltime(DateUtil.formatDateByFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));
				newworkOrderForm.setGeneratemode(ordersource);
				newworkOrderForm.setRemindflag("Y");
				newworkOrderForm.setActusername(user.getUsername());
				newworkOrderForm.setTemp8(wo_ucid);
				newworkOrderForm.setTemp7(agentid);
				this.getSession().setAttribute("workOrderForm", newworkOrderForm);
				//历史工单
				String listN = this.getHisWorkOrder();
				this.getRequest().setAttribute("his_N", listN);
			}else{
				workOrderForm = new WorkOrderForm();
				workOrderKey = "";
				workOrderForm.setRemindflag("Y");
				workOrderForm.setActusername(user.getUsername());
				workOrderForm.setGeneratemode(ordersource);
				workOrderForm.setIsnew("false");
				this.getRequest().setAttribute("workOrderForm", workOrderForm);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取历史工单信息
	 * @return
	 */
	public String getHisWorkOrder(){
		String limit_d = "7";;
		BdDictdetail bd = this.bdDictService.queryBdDictdetailByddcode("Order_his", "his_limit", "Y");
		if(null!=bd&&bd.getId()>0){
			limit_d = bd.getValue();
		}
//		List<Workorder> list = this.workOrderService.queryWorkorderNByCallerno(callinno,limit_d);
		return limit_d;
	}
	// 编辑
	public String editWorkOrder() {
		try {
			orderCode = this.getRequest().getParameter("orderCode");
			tabId = this.getRequest().getParameter("tabId");
			workOrderForm = new WorkOrderForm();
			Workorder workorder = new Workorder();
			if (StringUtils.isNotEmpty(workOrderKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("workOrderKey")))
					workOrderKey = (String) this.getSession().getAttribute(
							"workOrderKey");
				else
					return AbstractActionSupport.EDIT;
			}//工单信息
			workorder = this.workOrderService.getWorkorder(IntegerUtil
					.converStrToInteger(workOrderKey));
			WebappUtil.copyProperties(workOrderForm, workorder);
			workOrderForm.setWorkorderno(workorder.getWorkorderno());
			workOrderForm.setGeneratemode(workorder.getGeneratemode());
			workOrderForm.setCallerno(workorder.getCallerno());
			workOrderForm.setCalltime(DateUtil.formatDateByFormat(workorder
					.getCalltime(), "yyyy-MM-dd HH:mm:ss"));
			if (null != workorder.getPkCustomerinfo()) {
				workOrderForm.setCustlinkman(workorder.getPkCustomerinfo()
						.getCustlinkman());
				workOrderForm.setCustomername(workorder.getPkCustomerinfo()
						.getCustomername());
				workOrderForm.setInfosource(workorder.getPkCustomerinfo()
						.getInfosource());
				workOrderForm.setCustphoneno(workorder.getPkCustomerinfo()
						.getCustphoneno());
				workOrderForm
						.setTemp1(workorder.getPkCustomerinfo().getTemp1());
				workOrderForm.setEmailaddr(workorder.getPkCustomerinfo()
						.getEmailaddr());
				workOrderForm.setNetherlands(workorder.getPkCustomerinfo()
						.getNetherlands());
				workOrderForm.setCustaddr(workorder.getPkCustomerinfo()
						.getCustaddr());
				workOrderForm.setCustomerid(IntegerUtil
						.converIntegerToStr(workorder.getPkCustomerinfo()
								.getId()));
				workOrderForm.setIsnew("false");
			}
			this.getSession().setAttribute("workOrderForm", workOrderForm);
			//历史工单
			String listN = this.getHisWorkOrder();
			this.getRequest().setAttribute("his_N", listN);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}
	// 保存
	public String saveWorkOrder() {
		Userinfo user = this.getUserInfo(this.getRequest());
		int customerkey = 0;
		try {
			Workorder workorder = new Workorder();
			if (StringUtils.isNotEmpty(workOrderKey)) {
				workorder = this.workOrderService.getWorkorder(IntegerUtil
						.converStrToInteger(workOrderKey));
				WebappUtil.copyProperties(workorder, workOrderForm);
				if (StringUtils.equals(workOrderForm.getIsnew(), "true")) {
					Customerinfo customer = new Customerinfo();
					customerkey = this.addOrUpdateCustomer(workOrderForm,customer);
//					// 来电号码
					if (!StringUtils.contains(customer.getCustphoneno(),
							workorder.getCallerno())) {
						this.customerinfoService.addOrderPhone(customer,workorder.getCallerno());
					}
				} else {
					// 判断用户是否合法
					if (StringUtils.isNotEmpty(workOrderForm.getCustomerid())) {
						Customerinfo customer = new Customerinfo();
						customer = this.customerinfoService
								.getCustomer(IntegerUtil
										.converStrToInteger(workOrderForm
												.getCustomerid()));
						if (null == customer) {
							return ajaxForwardError(getText("该客户不存在!"));
						}
						workorder.setPkCustomerinfo(customer);
//						// 来电号码
						this.addOrUpdateCustomer(workOrderForm,customer);
						if (!StringUtils.contains(customer.getCustphoneno(),
								workorder.getCallerno())) {
							this.customerinfoService.addOrderPhone(customer,
									workorder.getCallerno());
						}
					} else {
						return ajaxForwardError(getText("该客户不存在!"));
					}
				}
				// 工单状态
				if (StringUtils.isNotEmpty(orderCode)) {
					workorder.setWostatus(orderCode);
					workorder.setDealtime(new Date());
					if (StringUtils.equals(orderCode, "yjd")) {
						workorder.setCompleteperson(user.getUsername());
						workorder.setCompletetime(new Date());
						workorder.setAuditperson(user.getUsername());
						workorder.setAudittime(new Date());
					}
				}
				if (customerkey > 0) {
					workorder.setPkCustomerinfo(this.customerinfoService
							.getCustomer(customerkey));
				}
				this.workOrderService.update(workorder);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", workorder.toString(), Workorder.REF);
			} else {
				WebappUtil.copyProperties(workorder, workOrderForm);
				if (StringUtils.equals(workOrderForm.getIsnew(), "true")) {
					Customerinfo customer = new Customerinfo();
					customerkey = this.addOrUpdateCustomer(workOrderForm,
							customer);
					workorder.setPkCustomerinfo(this.customerinfoService
							.getCustomer(customerkey));
					// 来电号码
					if (!StringUtils.contains(customer.getCustphoneno(),
							workorder.getCallerno())) {
						this.customerinfoService.addOrderPhone(customer,
								workorder.getCallerno());
					}
				} else {
					if (StringUtils.isNotEmpty(workOrderForm.getCustomerid())) {
						Customerinfo customer = new Customerinfo();
						customer = this.customerinfoService
								.getCustomer(IntegerUtil
										.converStrToInteger(workOrderForm
												.getCustomerid()));
						if (null == customer) {
							return ajaxForwardError(getText("该客户不存在!"));
						}
						// 更新customer信息
						customerkey = this.addOrUpdateCustomer(workOrderForm,
								customer);
						customer = this.customerinfoService
								.getCustomer(customerkey);
						workorder.setPkCustomerinfo(customer);
						// 来电号码
						if (!StringUtils.contains(customer.getCustphoneno(),
								workorder.getCallerno())) {
							this.customerinfoService.addOrderPhone(customer,
									workorder.getCallerno());
						}
					} else {
						return ajaxForwardError(getText("该客户不存在!"));
					}
				}
				if (StringUtils.isNotEmpty(orderCode)) {
					workorder.setWostatus(orderCode);
					workorder.setDealtime(new Date());
					if (StringUtils.equals(orderCode, "yjd")) {
						workorder.setCompleteperson(user.getUsername());
						workorder.setCompletetime(new Date());
						workorder.setAuditperson(user.getUsername());
						workorder.setAudittime(new Date());
					}
				} else {
					workorder.setWostatus("wcl");
				}
				workorder.setPkUserinfo(user);
				// 来电时间
				workorder.setWorkorderno(this.workOrderService.createWorkorderNo());
				workorder.setRemindflag("Y");
				workorder.setCalltime(new Date());
				this.workOrderService.add(workorder);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", workorder.toString(), Workorder.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	// 更新客户信息
	public int addOrUpdateCustomer(WorkOrderForm w, Customerinfo c) {
		c.setCustlinkman(w.getCustlinkman());
		if (StringUtils.isEmpty(w.getCustphoneno())) {
			c.setCustphoneno(w.getCallerno());
		} else {
			if (StringUtils.contains(w.getCustphoneno(), w.getCallerno())) {
				c.setCustphoneno(w.getCustphoneno());
			} else {
				System.out.println("*************************");
				c.setCustphoneno(w.getCustphoneno() + "," + w.getCallerno());
			}
		}
		c.setCustaddr(w.getCustaddr());
		// init data empty
		c.setInfosource(w.getInfosource());
		c.setCustomername(w.getCustomername());
		c.setTemp1(w.getTemp1());
		c.setEmailaddr(w.getEmailaddr());
		c.setNetherlands(w.getNetherlands());
		c.setCustaddr(w.getCustaddr());
		c.setUpdatetime(new Date());
		if (null != c.getId() && c.getId() > 0) {
			this.customerinfoService.update(c);
			return c.getId();
		} else {
			return this.customerinfoService.add(c);
		}
	}

	public String listWorkorder() {
		HttpServletRequest req = this.getRequest();
		orderCode = req.getParameter("orderCode");
		pageCode = req.getParameter("pageCode");
		tabId = req.getParameter("tabId");
		his_N = req.getParameter("his_N");
		wo_ucid = req.getParameter("wo_ucid");
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
		String clearPara = this.getRequest().getParameter("clearPara");
		if (StringUtils.isNotEmpty(clearPara)) {
			this.setQueryprocode("");
			this.setQuerycustomerno("");
			this.setQueryordersource("");
			this.setQueryprojecttype("");
			this.setQuerycallerno("");
			this.setQuerycompleteperson("");
			this.setQuerygeneratemode("");
			this.setQueryfactoryname("");
			this.setStarttime1("");
			this.setStoptime1("");
			this.setStarttime2("");
			this.setStoptime2("");
			this.setQueryagentname("");
		}
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQuerycustlinkman("");
			this.setQueryworkorderno("");
			this.setQueryproname("");
			this.setQueryprocode("");
			this.setQuerycustomerno("");
			this.setQuerycustomername("");
			this.setQuerywostatus("");
			this.setQueryordertype("");
			this.setQueryordersource("");
			this.setQueryprojecttype("");
			this.setQuerycallerno("");
			this.setQuerycompleteperson("");
			this.setQuerygeneratemode("");
			this.setQueryfactoryname("");
			this.setStarttime1("");
			this.setStoptime1("");
			this.setStarttime2("");
			this.setStoptime2("");
			this.setQueryagentname("");
		}
		List<Workorder> l = workOrderService.findWorkorderBySql(getHql(startIndex, numPerPage));
		List<Workorder> allOrderList = this.workOrderService
				.queryWoByDetachedCriteria(this.getDetachedCriteria());
		this.getSession().setAttribute("allOrderList", allOrderList);
		this.getSession().setAttribute("workorderList", l);
		int i = 0;
		i = this.workOrderService.queryCountWorkorder(this
				.getCountDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int pageNum) {
		String hql = "select * from Workorder where PK_WORKORDER >0 ";
		if (StringUtils.isNotEmpty(orderCode)
				&& (StringUtils.equalsIgnoreCase(orderCode, "dhxcl")
						|| StringUtils.equalsIgnoreCase(orderCode, "wcl") || StringUtils
						.equalsIgnoreCase(orderCode, "ywc")))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Wostatus = '").append(orderCode).append("'")
					.toString();
		if (StringUtils.isNotEmpty(querycustlinkman))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Custlinkman like '%").append(querycustlinkman)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(queryworkorderno))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Workorderno like '%").append(queryworkorderno)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(queryproname))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Proname like '%").append(queryproname).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryprocode))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Procode like '%").append(queryprocode).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(querycustomername))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Customername like '%").append(querycustomername)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(querywostatus))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Wostatus like '%").append(querywostatus).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(queryordertype))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Ordertype like '%").append(queryordertype).append(
					"%'").toString();
		if (StringUtils.isNotEmpty(queryordersource))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Ordersource like '%").append(queryordersource)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(queryprojecttype))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Projecttype like '%").append(queryprojecttype)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(querycallerno))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Callerno like '%").append(querycallerno).append("%'")
					.toString();
		if (StringUtils.isNotEmpty(querycompleteperson))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Completeperson like '%").append(querycompleteperson)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(querygeneratemode))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Generatemode like '%").append(querygeneratemode)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(queryfactoryname))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Factoryname like '%").append(queryfactoryname)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(starttime1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Calltime > '").append(starttime1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(stoptime1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Calltime < '").append(stoptime1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(starttime2))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Completetime > '").append(starttime2).append("'")
					.toString();
		if (StringUtils.isNotEmpty(stoptime1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Completetime < '").append(stoptime1).append("'")
					.toString();
		if (StringUtils.isNotEmpty(queryagentname))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Agentname like '").append(queryagentname).append("'")
					.toString();
		if(StringUtils.isNotEmpty(his_N)){
			hql += " and (CALLTIME BETWEEN date_add(SYSDATE(), interval -"+his_N+" day) and SYSDATE())";
		}
		hql = (new StringBuilder(String.valueOf(hql))).append(" limit ")
				.append(startIndex).append(",").append(pageNum).toString();
		return hql;
	}

	private DetachedCriteria getDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		// detachedCriteria.addOrder(Order.desc(Workorder.PROP_WORKORDERNO));
		if (StringUtils.isNotEmpty(orderCode)) {
			if (StringUtils.equalsIgnoreCase(orderCode, "dhxcl")
					|| StringUtils.equalsIgnoreCase(orderCode, "wcl")
					|| StringUtils.equalsIgnoreCase(orderCode, "ywc")) {
				detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS,
						orderCode));
			}
		}
		if (StringUtils.isNotEmpty(querycustlinkman)) {
			detachedCriteria.createAlias(Workorder.PROP_PK_CUSTOMERINFO,
					Workorder.PROP_PK_CUSTOMERINFO);
			detachedCriteria.add(Restrictions.ilike(
					Workorder.PROP_PK_CUSTOMERINFO + "."
							+ Customerinfo.PROP_CUSTLINKMAN, querycustlinkman,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querycustomername)) {
			detachedCriteria.add(Restrictions.ilike(
					Workorder.PROP_CUSTOMERNAME, querycustomername));
		}
		if (StringUtils.isNotEmpty(queryworkorderno)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_WORKORDERNO,
					queryworkorderno, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryproname)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_PRONAME,
					queryproname, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryprocode)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_PROCODE,
					queryprocode, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querycustomerno)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_CUSTOMERNO,
					querycustomerno, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querywostatus)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS,
					querywostatus));
		}
		if (StringUtils.isNotEmpty(queryordertype)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERTYPE,
					queryordertype));
		}
		if (StringUtils.isNotEmpty(queryordersource)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERSOURCE,
					queryordersource));
		}
		if (StringUtils.isNotEmpty(queryprojecttype)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_PROJECTTYPE,
					queryprojecttype));
		}
		if (StringUtils.isNotEmpty(querycompleteperson)) {
			detachedCriteria.add(Restrictions.ilike(
					Workorder.PROP_COMPLETEPERSON, querycompleteperson,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querygeneratemode)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_GENERATEMODE,
					querygeneratemode));
		}
		if (StringUtils.isNotEmpty(querycallerno)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_CALLERNO,
					querycallerno, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryfactoryname)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_TEMP8,
					queryfactoryname, MatchMode.ANYWHERE));
		}
		// 来电时间
		if (StringUtils.isNotEmpty(starttime1)) {
			Date start1 = DateUtil.parseFormatDate(starttime1,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					start1));
		}
		if (StringUtils.isNotEmpty(stoptime1)) {
			Date stop1 = DateUtil.parseFormatDate(stoptime1,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions
					.le(Workorder.PROP_CALLTIME, stop1));
		}
		// 结单时间
		if (StringUtils.isNotEmpty(starttime2)) {
			Date start2 = DateUtil.parseFormatDate(starttime2,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_COMPLETETIME,
					start2));
		}
		if (StringUtils.isNotEmpty(stoptime2)) {
			Date stop2 = DateUtil.parseFormatDate(stoptime2,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.le(Workorder.PROP_COMPLETETIME,
					stop2));
		}
		return detachedCriteria;
	}

	private DetachedCriteria getCountDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		// Userinfo user = this.getUserInfo(this.getRequest());
		// if(!StringUtils.equals(user.getIsadmin(), "true")){
		// detachedCriteria.add(Restrictions.eq(
		// Workorder.PROP_PK_CUSTOMERINFO, user));
		// }
		if (StringUtils.isNotEmpty(orderCode)) {
			if (StringUtils.equalsIgnoreCase(orderCode, "dhxcl")
					|| StringUtils.equalsIgnoreCase(orderCode, "wcl")
					|| StringUtils.equalsIgnoreCase(orderCode, "ywc")) {
				detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS,
						orderCode));
			}
		}
		if (StringUtils.isNotEmpty(querycustlinkman)) {
			detachedCriteria.createAlias(Workorder.PROP_PK_CUSTOMERINFO,
					Workorder.PROP_PK_CUSTOMERINFO);
			detachedCriteria.add(Restrictions.ilike(
					Workorder.PROP_PK_CUSTOMERINFO + "."
							+ Customerinfo.PROP_CUSTLINKMAN, querycustlinkman));
		}
		if (StringUtils.isNotEmpty(querycustomername)) {
			detachedCriteria.add(Restrictions.ilike(
					Workorder.PROP_CUSTOMERNAME, querycustomername));
		}
		if (StringUtils.isNotEmpty(queryworkorderno)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_WORKORDERNO,
					queryworkorderno, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryproname)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_PRONAME,
					queryproname, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryprocode)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_PROCODE,
					queryprocode, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querycustomerno)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_CUSTOMERNO,
					querycustomerno, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querywostatus)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS,
					querywostatus));
		}
		if (StringUtils.isNotEmpty(queryordertype)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERTYPE,
					queryordertype));
		}
		if (StringUtils.isNotEmpty(queryordersource)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERSOURCE,
					queryordersource));
		}
		if (StringUtils.isNotEmpty(queryprojecttype)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_PROJECTTYPE,
					queryprojecttype));
		}
		if (StringUtils.isNotEmpty(querycompleteperson)) {
			detachedCriteria.add(Restrictions.ilike(
					Workorder.PROP_COMPLETEPERSON, querycompleteperson,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querygeneratemode)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_GENERATEMODE,
					querygeneratemode));
		}
		if (StringUtils.isNotEmpty(querycallerno)) {
			detachedCriteria.add(Restrictions.ilike(Workorder.PROP_CALLERNO,
					querycallerno, MatchMode.ANYWHERE));
		}
		// 来电时间
		if (StringUtils.isNotEmpty(starttime1)) {
			Date start1 = DateUtil.parseFormatDate(starttime1,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					start1));
		}
		if (StringUtils.isNotEmpty(stoptime1)) {
			Date stop1 = DateUtil.parseFormatDate(stoptime1,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions
					.le(Workorder.PROP_CALLTIME, stop1));
		}
		// 结单时间
		if (StringUtils.isNotEmpty(starttime2)) {
			Date start2 = DateUtil.parseFormatDate(starttime2,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_COMPLETETIME,
					start2));
		}
		if (StringUtils.isNotEmpty(stoptime2)) {
			Date stop2 = DateUtil.parseFormatDate(stoptime2,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.le(Workorder.PROP_COMPLETETIME,
					stop2));
		}
		if (StringUtils.isNotEmpty(his_N)) {
			detachedCriteria.add(Restrictions.sqlRestriction(" (CALLTIME BETWEEN date_add(SYSDATE(), interval -"+his_N+" day) and SYSDATE())"));
		}
		return detachedCriteria;
	}

	public String deleteWorkorder() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				List<String> keyList = new ArrayList<String>();
				keyList = ListUtil.ConvertArrayToStringList(StringUtils.split(
						selectIDS, ','), "String");
				if (keyList != null) {
					for (String key : keyList) {
						this.workOrderService.delWorkorder(IntegerUtil
								.converStrToInteger(key));
					}
				}
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-XC", "delete：" + selectIDS, Orderdealinfo.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}

	/**
	 * 工单处理详情
	 * @return
	 */
	public String listOrderdealinfo(){
		List<Orderdealinfo> orderdealList = new ArrayList<Orderdealinfo>();
		if(StringUtils.isNotEmpty(workOrderKey)){
			Workorder wo = new Workorder();
			wo = this.workOrderService.getWorkorder(IntegerUtil
					.converStrToInteger(workOrderKey));
			//工单处理信息
			if(!StringUtils.equals(orderCode, "wcl")){
				// 工单处理
				orderdealList = this.workOrderService.queryOrderdealByWk(wo);
			}
		}
		this.getSession().setAttribute("orderdealList", orderdealList);
		wo_ucid = this.getRequest().getParameter("wo_ucid");
		return AbstractActionSupport.LIST;
	}
	public String addOrderdealinfo() {
		orderdealinfoForm = new OrderdealinfoForm();
		orderdealinfoKey = "";
		if (StringUtils.isNotEmpty(workOrderKey)) {
			Workorder wo = new Workorder();
			wo = this.workOrderService.getWorkorder(IntegerUtil
					.converStrToInteger(workOrderKey));
			orderdealinfoForm.setWorkorderno(wo.getWorkorderno());
			orderdealinfoForm.setWostatus(wo.getWostatus());
			this.getSession().setAttribute("orderdealinfoForm",
					orderdealinfoForm);
		}
		return SUCCESS;
	}

	public String editOrderdealinfo() {
		try {
			orderdealinfoForm = new OrderdealinfoForm();
			Orderdealinfo orderdealinfo = new Orderdealinfo();
			if (StringUtils.isNotEmpty(orderdealinfoKey)) {
				orderdealinfo = this.workOrderService
						.getOrderdealinfo(IntegerUtil
								.converStrToInteger(orderdealinfoKey));
			} else {
				return AbstractActionSupport.EDIT;// 返回list
			}
			WebappUtil.copyProperties(orderdealinfoForm, orderdealinfo);
			orderdealinfoForm.setOcctime(DateUtil.formatDateByFormat(
					orderdealinfo.getOcctime(), "yyyy-MM-dd HH:mm:ss"));
			orderdealinfoForm.setDealtime(DateUtil.formatDateByFormat(
					orderdealinfo.getDealtime(), "yyyy-MM-dd HH:mm:ss"));
			this.getSession().setAttribute("orderdealinfoForm",
					orderdealinfoForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	public String saveOrderdealinfo() {
		try {
			Orderdealinfo orderdeal = new Orderdealinfo();
			Workorder workOrder = new Workorder();
			if (StringUtils.isNotEmpty(workOrderKey)) {
				workOrder = this.workOrderService.getWorkorder(IntegerUtil
						.converStrToInteger(workOrderKey));
			} else {
				String msgkey = getText("主键丢失！");
				return ajaxForwardError(msgkey);
			}
			if (StringUtils.isNotEmpty(orderdealinfoKey)) {
				orderdeal = this.workOrderService.getOrderdealinfo(IntegerUtil
						.converStrToInteger(orderdealinfoKey));
				WebappUtil.copyProperties(orderdeal, orderdealinfoForm);
				orderdeal.setTypeintime(new Date());
				this.workOrderService.updateOrderdealinfo(orderdeal);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", orderdeal.toString(), Orderdealinfo.REF);
			} else {
				WebappUtil.copyProperties(orderdeal, orderdealinfoForm);
				orderdeal.setDealtime(new Date());
				orderdeal.setTypeintime(new Date());
				orderdeal.setPkWorkorder(workOrder);
				this.workOrderService.addOrderdealinfo(orderdeal);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", orderdeal.toString(), Orderdealinfo.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("保存成功！"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String deleteOrderdealinfo() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				this.workOrderService.deleteOrderdealinfoByIds(StringUtils
						.split(selectIDS, ','));
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete:" + selectIDS.toString(),
					Orderdealinfo.REF);
			return ajaxForwardSuccess(getText("common.deleteok"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}
	/**
	 * 
	 * **报表 year/mouth/day
	 * 
	 * @return
	 */
	// 工单分类统计年报
	public String listYearStwo() {
		String fileName = this.getRequest().getParameter("fileName");
		this.getRequest().setAttribute("fileName", fileName);
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		String nowyear = DateUtil.formatDateByFormat(new Date(), "yyyy");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQuerystwoyear(nowyear);
			this.setQueryOSampledependc("");
			this.setQueryOSampledependn("");
			this.setQueryOAmodeldependc("");
			this.setQueryOAmodeldependn("");
			this.setQueryOSampleReqc("");
			this.setQueryOSampleReqn("");

			this.setQueryOOrderDeliveryc("");
			this.setQueryOOrderDeliveryn("");
			this.setQueryOOnsiteservicec("");
			this.setQueryOOnsiteservicen("");
			this.setQueryOOnsiteservicec("");
			this.setQueryOOnsiteservicen("");

			this.setQueryOComplainthandc("");
			this.setQueryOComplainthandn("");
			this.setQueryOReturnReqc("");
			this.setQueryOReturnReqn("");
			this.setQueryagentname("");
		}
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		List<Userinfo> listuser = this.userinfoService.queryNotAdmin();
		if (StringUtils.isNotEmpty(querystwoyear)) {
			if (listuser.size() > 0) {
				for (Userinfo u : listuser) {
					SubtotalsForm stf = new SubtotalsForm();
					stf.setSubdate(querystwoyear);
					stf.setWomaker(u.getAgentname());
					stf.setOSampledepend(this.workOrderService
							.getCountByCriteria(this.getYearStDetachedCriteria(
									querystwoyear, "O_Sampledepend", u)));
					stf.setOAmodeldepend(this.workOrderService
							.getCountByCriteria(this.getYearStDetachedCriteria(
									querystwoyear, "O_Amodeldepend", u)));
					stf.setOSampleReq(this.workOrderService
							.getCountByCriteria(this.getYearStDetachedCriteria(
									querystwoyear, "O_SampleReq", u)));
					stf.setOOrderDelivery(this.workOrderService
							.getCountByCriteria(this.getYearStDetachedCriteria(
									querystwoyear, "O_OrderDelivery", u)));
					stf.setOOnsiteservice(this.workOrderService
							.getCountByCriteria(this.getYearStDetachedCriteria(
									querystwoyear, "O_Onsiteservice", u)));
					stf.setOComplainthand(this.workOrderService
							.getCountByCriteria(this.getYearStDetachedCriteria(
									querystwoyear, "O_Complainthand", u)));
					stf.setOReturnReq(this.workOrderService
							.getCountByCriteria(this.getYearStDetachedCriteria(
									querystwoyear, "O_ReturnReq", u)));
					liststf.add(stf);
				}
			}
		}
		liststf = this.filterlistst(liststf);
		FileUtil.createStExcel(getServletContext().getRealPath(
				"/excel/st_year_statements.xls"), liststf, "工单分类汇总年报");
		this.getSession().setAttribute("liststfstyear", liststf);
		return SUCCESS;
	}

	private DetachedCriteria getYearStDetachedCriteria(String date, String ot,
			Userinfo user) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date + "-01-01", "yyyy-MM-dd")));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date + "-12-31", "yyyy-MM-dd")));
		}
		if (StringUtils.isNotEmpty(ot)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERTYPE, ot));
		}
		detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
		return detachedCriteria;
	}

	// 工单分类统计月报
	public String listMonthStwo() {
		String fileName = this.getRequest().getParameter("fileName");
		this.getRequest().setAttribute("fileName", fileName);
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		String nowmonth = DateUtil.formatDateByFormat(new Date(), "yyyy-MM");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQuerystwomonth(nowmonth);
			this.setQueryOSampledependc("");
			this.setQueryOSampledependn("");
			this.setQueryOAmodeldependc("");
			this.setQueryOAmodeldependn("");
			this.setQueryOSampleReqc("");
			this.setQueryOSampleReqn("");

			this.setQueryOOrderDeliveryc("");
			this.setQueryOOrderDeliveryn("");
			this.setQueryOOnsiteservicec("");
			this.setQueryOOnsiteservicen("");
			this.setQueryOOnsiteservicec("");
			this.setQueryOOnsiteservicen("");

			this.setQueryOComplainthandc("");
			this.setQueryOComplainthandn("");
			this.setQueryOReturnReqc("");
			this.setQueryOReturnReqn("");
			this.setQueryagentname("");
		}
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		List<Userinfo> listuser = this.userinfoService.queryNotAdmin();
		if (StringUtils.isNotEmpty(querystwomonth)) {
			if (listuser.size() > 0) {
				for (Userinfo u : listuser) {
					SubtotalsForm stf = new SubtotalsForm();
					stf.setSubdate(querystwomonth);
					stf.setWomaker(u.getAgentname());
					stf.setOSampledepend(this.workOrderService
							.getCountByCriteria(this
									.getMonthStDetachedCriteria(querystwomonth,
											"O_Sampledepend", u)));
					stf.setOAmodeldepend(this.workOrderService
							.getCountByCriteria(this
									.getMonthStDetachedCriteria(querystwomonth,
											"O_Amodeldepend", u)));
					stf.setOSampleReq(this.workOrderService
							.getCountByCriteria(this
									.getMonthStDetachedCriteria(querystwomonth,
											"O_SampleReq", u)));
					stf.setOOrderDelivery(this.workOrderService
							.getCountByCriteria(this
									.getMonthStDetachedCriteria(querystwomonth,
											"O_OrderDelivery", u)));
					stf.setOOnsiteservice(this.workOrderService
							.getCountByCriteria(this
									.getMonthStDetachedCriteria(querystwomonth,
											"O_Onsiteservice", u)));
					stf.setOComplainthand(this.workOrderService
							.getCountByCriteria(this
									.getMonthStDetachedCriteria(querystwomonth,
											"O_Complainthand", u)));
					stf.setOReturnReq(this.workOrderService
							.getCountByCriteria(this
									.getMonthStDetachedCriteria(querystwomonth,
											"O_ReturnReq", u)));

					liststf.add(stf);
				}
			}
		}
		liststf = this.filterlistst(liststf);
		FileUtil.createStExcel(getServletContext().getRealPath(
				"/excel/st_month_statements.xls"), liststf, "工单分类汇总月报");
		this.getSession().setAttribute("liststfstmonth", liststf);
		return SUCCESS;
	}

	private DetachedCriteria getMonthStDetachedCriteria(String date, String ot,
			Userinfo user) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date + "-01", "yyyy-MM-dd")));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(
							DateUtil.getMonthEnd(date + "-01"), "yyyy-MM-dd")));
		}
		if (StringUtils.isNotEmpty(ot)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERTYPE, ot));
		}
		detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
		return detachedCriteria;
	}

	// 工单分类统计日报
	public String listDayStwo() {
		String fileName = this.getRequest().getParameter("fileName");
		this.getRequest().setAttribute("fileName", fileName);
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		String nowday = DateUtil.formatDateByFormat(new Date(), "yyyy-MM-dd");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQuerystwoday(nowday);
			this.setQueryOSampledependc("");
			this.setQueryOSampledependn("");
			this.setQueryOAmodeldependc("");
			this.setQueryOAmodeldependn("");
			this.setQueryOSampleReqc("");
			this.setQueryOSampleReqn("");

			this.setQueryOOrderDeliveryc("");
			this.setQueryOOrderDeliveryn("");
			this.setQueryOOnsiteservicec("");
			this.setQueryOOnsiteservicen("");
			this.setQueryOOnsiteservicec("");
			this.setQueryOOnsiteservicen("");

			this.setQueryOComplainthandc("");
			this.setQueryOComplainthandn("");
			this.setQueryOReturnReqc("");
			this.setQueryOReturnReqn("");
			this.setQueryagentname("");
		}
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		List<Userinfo> listuser = this.userinfoService.queryNotAdmin();
		if (StringUtils.isNotEmpty(querystwoday)) {
			if (listuser.size() > 0) {
				for (Userinfo u : listuser) {
					SubtotalsForm stf = new SubtotalsForm();
					stf.setSubdate(querystwoday);
					stf.setWomaker(u.getAgentname());
					stf.setOSampledepend(this.workOrderService
							.getCountByCriteria(this.getDayStDetachedCriteria(
									querystwoday, "O_Sampledepend", u)));
					stf.setOAmodeldepend(this.workOrderService
							.getCountByCriteria(this.getDayStDetachedCriteria(
									querystwoday, "O_Amodeldepend", u)));
					stf.setOSampleReq(this.workOrderService
							.getCountByCriteria(this.getDayStDetachedCriteria(
									querystwoday, "O_SampleReq", u)));
					stf.setOOrderDelivery(this.workOrderService
							.getCountByCriteria(this.getDayStDetachedCriteria(
									querystwoday, "O_OrderDelivery", u)));
					stf.setOOnsiteservice(this.workOrderService
							.getCountByCriteria(this.getDayStDetachedCriteria(
									querystwoday, "O_Onsiteservice", u)));
					stf.setOComplainthand(this.workOrderService
							.getCountByCriteria(this.getDayStDetachedCriteria(
									querystwoday, "O_Complainthand", u)));
					stf.setOReturnReq(this.workOrderService
							.getCountByCriteria(this.getDayStDetachedCriteria(
									querystwoday, "O_ReturnReq", u)));
					liststf.add(stf);
				}
			}
		}
		liststf = this.filterlistst(liststf);
		FileUtil.createStExcel(getServletContext().getRealPath(
				"/excel/st_day_statements.xls"), liststf, "工单分类汇总日报");
		this.getSession().setAttribute("liststfstday", liststf);
		return SUCCESS;
	}

	private DetachedCriteria getDayStDetachedCriteria(String date, String ot,
			Userinfo user) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.getQueryStartDate(date)));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.getQueryEndDate(date)));
		}
		if (StringUtils.isNotEmpty(ot)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_ORDERTYPE, ot));
		}
		detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
		return detachedCriteria;
	}

	// private String queryOSampledependc;
	// private String queryOAmodeldependc;
	// private String queryOSampleReqc;
	// private String queryOOrderDeliveryc;
	// private String queryOOnsiteservicec;
	// private String queryOComplainthandc;
	// private String queryOReturnReqc;
	public List<SubtotalsForm> filterlistst(List<SubtotalsForm> liststf) {
		try {
			// queryagentname
			if (StringUtils.isNotEmpty(queryagentname)) {
				for (Iterator it = liststf.iterator(); it.hasNext();) {
					SubtotalsForm s = (SubtotalsForm) it.next();
					if (!StringUtils.equalsIgnoreCase(s.getWomaker(),
							queryagentname)) {
						it.remove();
					}
				}
			}
			// queryOSampledependc1
			if (StringUtils.isNotEmpty(queryOSampledependc)
					&& StringUtils.isNotEmpty(queryOSampledependn)) {
				if (StringUtils.equals(queryOSampledependc, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampledepend() != IntegerUtil
								.converStrToInteger(queryOSampledependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampledependc, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampledepend() <= IntegerUtil
								.converStrToInteger(queryOSampledependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampledependc, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampledepend() < IntegerUtil
								.converStrToInteger(queryOSampledependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampledependc, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampledepend() >= IntegerUtil
								.converStrToInteger(queryOSampledependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampledependc, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampledepend() > IntegerUtil
								.converStrToInteger(queryOSampledependn)) {
							it.remove();
						}
					}
				}

			}
			// queryOAmodeldependc2
			if (StringUtils.isNotEmpty(queryOAmodeldependc)
					&& StringUtils.isNotEmpty(queryOAmodeldependn)) {
				if (StringUtils.equals(queryOAmodeldependc, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOAmodeldepend() != IntegerUtil
								.converStrToInteger(queryOAmodeldependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOAmodeldependc, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOAmodeldepend() <= IntegerUtil
								.converStrToInteger(queryOAmodeldependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOAmodeldependc, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOAmodeldepend() < IntegerUtil
								.converStrToInteger(queryOAmodeldependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOAmodeldependc, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOAmodeldepend() >= IntegerUtil
								.converStrToInteger(queryOAmodeldependn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOAmodeldependc, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOAmodeldepend() > IntegerUtil
								.converStrToInteger(queryOAmodeldependn)) {
							it.remove();
						}
					}
				}

			}
			// queryOSampleReqc3
			if (StringUtils.isNotEmpty(queryOSampleReqc)
					&& StringUtils.isNotEmpty(queryOSampleReqn)) {
				if (StringUtils.equals(queryOSampleReqc, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampleReq() != IntegerUtil
								.converStrToInteger(queryOSampleReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampleReqc, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampleReq() <= IntegerUtil
								.converStrToInteger(queryOSampleReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampleReqc, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampleReq() < IntegerUtil
								.converStrToInteger(queryOSampleReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampleReqc, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampleReq() >= IntegerUtil
								.converStrToInteger(queryOSampleReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOSampleReqc, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOSampleReq() > IntegerUtil
								.converStrToInteger(queryOSampleReqn)) {
							it.remove();
						}
					}
				}
			}
			// queryOSampleReqc4
			if (StringUtils.isNotEmpty(queryOOnsiteservicec)
					&& StringUtils.isNotEmpty(queryOOnsiteservicen)) {
				if (StringUtils.equals(queryOOnsiteservicec, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOnsiteservice() != IntegerUtil
								.converStrToInteger(queryOOnsiteservicen)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOnsiteservicec, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOnsiteservice() <= IntegerUtil
								.converStrToInteger(queryOOnsiteservicen)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOnsiteservicec, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOnsiteservice() < IntegerUtil
								.converStrToInteger(queryOOnsiteservicen)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOnsiteservicec, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOnsiteservice() >= IntegerUtil
								.converStrToInteger(queryOOnsiteservicen)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOnsiteservicec, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOnsiteservice() > IntegerUtil
								.converStrToInteger(queryOOnsiteservicen)) {
							it.remove();
						}
					}
				}
			}
			// queryOSampleReqc5
			if (StringUtils.isNotEmpty(queryOOrderDeliveryc)
					&& StringUtils.isNotEmpty(queryOOrderDeliveryn)) {
				if (StringUtils.equals(queryOOrderDeliveryc, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOrderDelivery() != IntegerUtil
								.converStrToInteger(queryOOrderDeliveryn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOrderDeliveryc, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOrderDelivery() <= IntegerUtil
								.converStrToInteger(queryOOrderDeliveryn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOrderDeliveryc, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOrderDelivery() < IntegerUtil
								.converStrToInteger(queryOOrderDeliveryn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOrderDeliveryc, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOrderDelivery() >= IntegerUtil
								.converStrToInteger(queryOOrderDeliveryn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOOrderDeliveryc, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOOrderDelivery() > IntegerUtil
								.converStrToInteger(queryOOrderDeliveryn)) {
							it.remove();
						}
					}
				}
			}
			// queryOSampleReqc6
			if (StringUtils.isNotEmpty(queryOComplainthandc)
					&& StringUtils.isNotEmpty(queryOComplainthandn)) {
				if (StringUtils.equals(queryOComplainthandc, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOComplainthand() != IntegerUtil
								.converStrToInteger(queryOComplainthandn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOComplainthandc, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOComplainthand() <= IntegerUtil
								.converStrToInteger(queryOComplainthandn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOComplainthandc, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOComplainthand() < IntegerUtil
								.converStrToInteger(queryOComplainthandn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOComplainthandc, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOComplainthand() >= IntegerUtil
								.converStrToInteger(queryOComplainthandn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOComplainthandc, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOComplainthand() > IntegerUtil
								.converStrToInteger(queryOComplainthandn)) {
							it.remove();
						}
					}
				}
			}
			// queryOSampleReqc7
			if (StringUtils.isNotEmpty(queryOReturnReqc)
					&& StringUtils.isNotEmpty(queryOReturnReqn)) {
				if (StringUtils.equals(queryOReturnReqc, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOReturnReq() != IntegerUtil
								.converStrToInteger(queryOReturnReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOReturnReqc, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOReturnReq() <= IntegerUtil
								.converStrToInteger(queryOReturnReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOReturnReqc, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOReturnReq() < IntegerUtil
								.converStrToInteger(queryOReturnReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOReturnReqc, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOReturnReq() >= IntegerUtil
								.converStrToInteger(queryOReturnReqn)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryOReturnReqc, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getOReturnReq() > IntegerUtil
								.converStrToInteger(queryOReturnReqn)) {
							it.remove();
						}
					}
				}
			}
			return liststf;
		} catch (Exception e) {
			e.getMessage();
			return new ArrayList<SubtotalsForm>();
		}

	}

	/****
	 * 未处理
	 * 
	 * */
	// 年度未处理工单统计
	public String listYearWclwo() {
		String fileName = this.getRequest().getParameter("fileName");
		this.getRequest().setAttribute("fileName", fileName);
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		String nowyear = DateUtil.formatDateByFormat(new Date(), "yyyy");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQuerywoyear(nowyear);
			this.setQuerywclcompare("");
			this.setQuerywclnumber("");
			this.setQuerydhxclcompare("");
			this.setQuerydhxclnumber("");
			this.setQueryywccompare("");
			this.setQueryywcnumber("");
			this.setQueryagentname("");
		}
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		List<Userinfo> listuser = this.userinfoService.queryNotAdmin();
		if (StringUtils.isNotEmpty(querywoyear)) {
			if (listuser.size() > 0) {
				for (Userinfo u : listuser) {
					SubtotalsForm stf = new SubtotalsForm();
					stf.setSubdate(querywoyear);
					stf.setWomaker(u.getAgentname());
					stf
							.setWclwo(this.workOrderService
									.getCountByCriteria(this
											.getYearWclDetachedCriteria(
													querywoyear, "wcl", u)));
					stf.setDhxclwo(this.workOrderService
							.getCountByCriteria(this
									.getYearWclDetachedCriteria(querywoyear,
											"dhxcl", u)));
					stf
							.setYwcwo(this.workOrderService
									.getCountByCriteria(this
											.getYearWclDetachedCriteria(
													querywoyear, "ywc", u)));
					liststf.add(stf);
				}
			}
		}
		liststf = this.filterlist(liststf);
		FileUtil.createWclExcel(getServletContext().getRealPath(
				"/excel/wcl_year_statements.xls"), liststf, "待办工单统计年报");
		this.getSession().setAttribute("liststfyear", liststf);
		return SUCCESS;
	}

	public List<SubtotalsForm> filterlist(List<SubtotalsForm> liststf) {
		try {
			// queryagentname
			if (StringUtils.isNotEmpty(queryagentname)) {
				for (Iterator it = liststf.iterator(); it.hasNext();) {
					SubtotalsForm s = (SubtotalsForm) it.next();
					if (!StringUtils.equalsIgnoreCase(s.getWomaker(),
							queryagentname)) {
						it.remove();
					}
				}
			}
			// querywclcompare
			if (StringUtils.isNotEmpty(querywclcompare)
					&& StringUtils.isNotEmpty(querywclnumber)) {
				if (StringUtils.equals(querywclcompare, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getWclwo() != IntegerUtil
								.converStrToInteger(querywclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querywclcompare, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getWclwo() <= IntegerUtil
								.converStrToInteger(querywclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querywclcompare, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getWclwo() < IntegerUtil
								.converStrToInteger(querywclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querywclcompare, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getWclwo() >= IntegerUtil
								.converStrToInteger(querywclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querywclcompare, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getWclwo() > IntegerUtil
								.converStrToInteger(querywclnumber)) {
							it.remove();
						}
					}
				}

			}
			// querydhxclcompare
			if (StringUtils.isNotEmpty(querydhxclcompare)
					&& StringUtils.isNotEmpty(querydhxclnumber)) {
				if (StringUtils.equals(querydhxclcompare, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getDhxclwo() != IntegerUtil
								.converStrToInteger(querydhxclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querydhxclcompare, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getDhxclwo() <= IntegerUtil
								.converStrToInteger(querydhxclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querydhxclcompare, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getDhxclwo() < IntegerUtil
								.converStrToInteger(querydhxclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querydhxclcompare, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getDhxclwo() >= IntegerUtil
								.converStrToInteger(querydhxclnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(querydhxclcompare, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getDhxclwo() > IntegerUtil
								.converStrToInteger(querydhxclnumber)) {
							it.remove();
						}
					}
				}

			}
			// queryywccompare
			if (StringUtils.isNotEmpty(queryywccompare)
					&& StringUtils.isNotEmpty(queryywcnumber)) {
				if (StringUtils.equals(queryywccompare, "=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getYwcwo() != IntegerUtil
								.converStrToInteger(queryywcnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryywccompare, ">")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getYwcwo() <= IntegerUtil
								.converStrToInteger(queryywcnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryywccompare, ">=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getYwcwo() < IntegerUtil
								.converStrToInteger(queryywcnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryywccompare, "<")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getYwcwo() >= IntegerUtil
								.converStrToInteger(queryywcnumber)) {
							it.remove();
						}
					}
				}
				if (StringUtils.equals(queryywccompare, "<=")) {
					for (Iterator it = liststf.iterator(); it.hasNext();) {
						SubtotalsForm s = (SubtotalsForm) it.next();
						if (s.getYwcwo() > IntegerUtil
								.converStrToInteger(queryywcnumber)) {
							it.remove();
						}
					}
				}
			}
			return liststf;
		} catch (Exception e) {
			e.getMessage();
			return new ArrayList<SubtotalsForm>();
		}

	}

	private DetachedCriteria getYearWclDetachedCriteria(String date, String os,
			Userinfo user) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date + "-01-01", "yyyy-MM-dd")));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date + "-12-31", "yyyy-MM-dd")));
		}
		if (StringUtils.isNotEmpty(os)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS, os));
		}
		detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
		return detachedCriteria;
	}

	// 月度未处理工单统计
	public String listMonthWclwo() {
		String fileName = this.getRequest().getParameter("fileName");
		this.getRequest().setAttribute("fileName", fileName);
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		String nowmonth = DateUtil.formatDateByFormat(new Date(), "yyyy-MM");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQuerywomonth(nowmonth);
			this.setQuerywclcompare("");
			this.setQuerywclnumber("");
			this.setQuerydhxclcompare("");
			this.setQuerydhxclnumber("");
			this.setQueryywccompare("");
			this.setQueryywcnumber("");
			this.setQueryagentname("");
		}
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		List<Userinfo> listuser = this.userinfoService.queryNotAdmin();
		if (StringUtils.isNotEmpty(querywomonth)) {
			if (listuser.size() > 0) {
				for (Userinfo u : listuser) {
					SubtotalsForm stf = new SubtotalsForm();
					stf.setSubdate(querywomonth);
					stf.setWomaker(u.getAgentname());
					stf.setWclwo(this.workOrderService
							.getCountByCriteria(this
									.getMonthWclDetachedCriteria(querywomonth,
											"wcl", u)));
					stf.setDhxclwo(this.workOrderService
							.getCountByCriteria(this
									.getMonthWclDetachedCriteria(querywomonth,
											"dhxcl", u)));
					stf.setYwcwo(this.workOrderService
							.getCountByCriteria(this
									.getMonthWclDetachedCriteria(querywomonth,
											"ywc", u)));
					liststf.add(stf);
				}
			}
		}
		liststf = this.filterlist(liststf);
		FileUtil.createWclExcel(getServletContext().getRealPath(
				"/excel/wcl_month_statements.xls"), liststf, "待办工单统计月报");
		this.getSession().setAttribute("liststfmonth", liststf);
		return SUCCESS;
	}

	private DetachedCriteria getMonthWclDetachedCriteria(String date,
			String os, Userinfo user) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date + "-01", "yyyy-MM-dd")));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(
							DateUtil.getMonthEnd(date + "-01"), "yyyy-MM-dd")));
		}
		if (StringUtils.isNotEmpty(os)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS, os));
		}
		detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
		return detachedCriteria;
	}

	// 日常未处理工单统计
	public String listDayWclwo() {
		String fileName = this.getRequest().getParameter("fileName");
		this.getRequest().setAttribute("fileName", fileName);
		String check_changeUrl = this.getRequest().getParameter("changeUrl");
		String nowday = DateUtil.formatDateByFormat(new Date(), "yyyy-MM-dd");
		if (StringUtils.isNotEmpty(check_changeUrl)) {
			this.setQuerywoday(nowday);
			this.setQuerywclcompare("");
			this.setQuerywclnumber("");
			this.setQuerydhxclcompare("");
			this.setQuerydhxclnumber("");
			this.setQueryywccompare("");
			this.setQueryywcnumber("");
			this.setQueryagentname("");
		}
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		List<Userinfo> listuser = this.userinfoService.queryNotAdmin();
		if (StringUtils.isNotEmpty(querywoday)) {
			if (listuser.size() > 0) {
				for (Userinfo u : listuser) {
					SubtotalsForm stf = new SubtotalsForm();
					stf.setSubdate(querywoday);
					stf.setWomaker(u.getAgentname());
					stf.setWclwo(this.workOrderService.getCountByCriteria(this
							.getDayWclDetachedCriteria(querywoday, "wcl", u)));
					stf.setDhxclwo(this.workOrderService
							.getCountByCriteria(this.getDayWclDetachedCriteria(
									querywoday, "dhxcl", u)));
					stf.setYwcwo(this.workOrderService.getCountByCriteria(this
							.getDayWclDetachedCriteria(querywoday, "ywc", u)));
					liststf.add(stf);
				}
			}
		}
		liststf = this.filterlist(liststf);
		FileUtil.createWclExcel(getServletContext().getRealPath(
				"/excel/wcl_day_statements.xls"), liststf, "待办工单统计日报");
		this.getSession().setAttribute("liststfday", liststf);
		return SUCCESS;
	}

	private DetachedCriteria getDayWclDetachedCriteria(String date, String os,
			Userinfo user) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.getQueryStartDate(date)));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.getQueryEndDate(date)));
		}
		if (StringUtils.isNotEmpty(os)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS, os));
		}
		detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
		return detachedCriteria;
	}

	public String searchJspPage() {
		return SUCCESS;
	}

	// 首页统计数据
	public String listIndexWorkorder() {
		List<Workorder> l = this.workOrderService
				.queryWoByDetachedCriteria(this.getIndexDetachedCriteria());
		this.getSession().setAttribute("workorderIndexList", l);
		this.getSubtotals();
		return SUCCESS;
	}

	private DetachedCriteria getIndexDetachedCriteria() {
		Userinfo user = this.getUserInfo(this.getRequest());
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		// detachedCriteria.add(Restrictions.or(Restrictions.eq(
		// Workorder.PROP_WOSTATUS, "wcl"), Restrictions.or(Restrictions
		// .eq(Workorder.PROP_WOSTATUS, "dhxcl"), Restrictions.eq(
		// Workorder.PROP_WOSTATUS, "ywc"))));
		detachedCriteria.add(Restrictions.or(Restrictions.eq(
				Workorder.PROP_WOSTATUS, "dhxcl"), Restrictions.eq(
				Workorder.PROP_WOSTATUS, "ywc")));
		if (!StringUtils.equals(user.getIsadmin(), "true")) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO,
					user));
		}
		return detachedCriteria;
	}

	// 分类汇总
	public void getSubtotals() {
		List<SubtotalsForm> liststf = new ArrayList<SubtotalsForm>();
		String nowyear = DateUtil.formatDateByFormat(new Date(), "yyyy");
		String nowmonth = DateUtil.formatDateByFormat(new Date(), "MM");

		// 一月
		for (int i = 1; i <= Integer.parseInt(nowmonth); i++) {
			SubtotalsForm stf = new SubtotalsForm();
			stf.setMonth(i + "月");
			stf.setOSampledepend(this.workOrderService.getCountByCriteria(this
					.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01",
							"O_Sampledepend")));
			stf.setOAmodeldepend(this.workOrderService.getCountByCriteria(this
					.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01",
							"O_Amodeldepend")));
			stf.setOSampleReq(this.workOrderService.getCountByCriteria(this
					.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01",
							"O_SampleReq")));
			stf.setOOrderDelivery(this.workOrderService.getCountByCriteria(this
					.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01",
							"O_OrderDelivery")));
			stf.setOOnsiteservice(this.workOrderService.getCountByCriteria(this
					.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01",
							"O_Onsiteservice")));
			stf.setOComplainthand(this.workOrderService.getCountByCriteria(this
					.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01",
							"O_Complainthand")));
			stf.setOReturnReq(this.workOrderService.getCountByCriteria(this
					.getSubtotalsDetachedCriteria(nowyear + "-" + i + "-01",
							"O_ReturnReq")));
			liststf.add(stf);
		}
		this.getSession().setAttribute("liststf", liststf);

	}

	private DetachedCriteria getSubtotalsDetachedCriteria(String date, String os) {
		Userinfo user = this.getUserInfo(this.getRequest());
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		if (StringUtils.isNotEmpty(date)) {
			detachedCriteria.add(Restrictions.ge(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(date, "yyyy-MM-dd")));
			detachedCriteria.add(Restrictions.le(Workorder.PROP_CALLTIME,
					DateUtil.parseFormatDate(DateUtil.getMonthEnd(date),
							"yyyy-MM-dd")));
		}
		if (StringUtils.isNotEmpty(os)) {
			detachedCriteria.add(Restrictions.eq(Workorder.PROP_WOSTATUS, os));
		}
		// if (!StringUtils.equals(user.getIsadmin(), "true")) {
		detachedCriteria.add(Restrictions.eq(Workorder.PROP_PK_USERINFO, user));
		// }
		return detachedCriteria;
	}
	/**
	 * get/set
	 * @return
	 */
	public WorkOrderForm getWorkOrderForm() {
		return workOrderForm;
	}

	public void setWorkOrderForm(WorkOrderForm workOrderForm) {
		this.workOrderForm = workOrderForm;
	}

	public String getWorkOrderKey() {
		return workOrderKey;
	}

	public void setWorkOrderKey(String workOrderKey) {
		this.workOrderKey = workOrderKey;
	}

	public WorkOrderService getWorkOrderService() {
		return workOrderService;
	}

	public void setWorkOrderService(WorkOrderService workOrderService) {
		this.workOrderService = workOrderService;
	}

	public OrderdealinfoForm getOrderdealinfoForm() {
		return orderdealinfoForm;
	}

	public void setOrderdealinfoForm(OrderdealinfoForm orderdealinfoForm) {
		this.orderdealinfoForm = orderdealinfoForm;
	}

	public BdDictService getBdDictService() {
		return bdDictService;
	}

	public void setBdDictService(BdDictService bdDictService) {
		this.bdDictService = bdDictService;
	}

	public CustomerinfoService getCustomerinfoService() {
		return customerinfoService;
	}

	public void setCustomerinfoService(CustomerinfoService customerinfoService) {
		this.customerinfoService = customerinfoService;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getQueryworkorderno() {
		return queryworkorderno;
	}

	public void setQueryworkorderno(String queryworkorderno) {
		this.queryworkorderno = queryworkorderno;
	}

	public String getQueryproname() {
		return queryproname;
	}

	public void setQueryproname(String queryproname) {
		this.queryproname = queryproname;
	}

	public String getQueryprocode() {
		return queryprocode;
	}

	public void setQueryprocode(String queryprocode) {
		this.queryprocode = queryprocode;
	}

	public String getQuerycustomerno() {
		return querycustomerno;
	}

	public void setQuerycustomerno(String querycustomerno) {
		this.querycustomerno = querycustomerno;
	}

	public String getQuerycustomername() {
		return querycustomername;
	}

	public void setQuerycustomername(String querycustomername) {
		this.querycustomername = querycustomername;
	}

	public String getQuerywostatus() {
		return querywostatus;
	}

	public void setQuerywostatus(String querywostatus) {
		this.querywostatus = querywostatus;
	}

	public String getQueryordertype() {
		return queryordertype;
	}

	public void setQueryordertype(String queryordertype) {
		this.queryordertype = queryordertype;
	}

	public String getQueryordersource() {
		return queryordersource;
	}

	public void setQueryordersource(String queryordersource) {
		this.queryordersource = queryordersource;
	}

	public String getQueryprojecttype() {
		return queryprojecttype;
	}

	public void setQueryprojecttype(String queryprojecttype) {
		this.queryprojecttype = queryprojecttype;
	}

	public String getOrderdealinfoKey() {
		return orderdealinfoKey;
	}

	public void setOrderdealinfoKey(String orderdealinfoKey) {
		this.orderdealinfoKey = orderdealinfoKey;
	}

	public String getOrdersource() {
		return ordersource;
	}

	public void setOrdersource(String ordersource) {
		this.ordersource = ordersource;
	}

	public JsonForm getJsonForm() {
		return jsonForm;
	}

	public void setJsonForm(JsonForm jsonForm) {
		this.jsonForm = jsonForm;
	}

	public String getQuerycallerno() {
		return querycallerno;
	}

	public void setQuerycallerno(String querycallerno) {
		this.querycallerno = querycallerno;
	}

	public String getQuerycompleteperson() {
		return querycompleteperson;
	}

	public void setQuerycompleteperson(String querycompleteperson) {
		this.querycompleteperson = querycompleteperson;
	}

	public String getQuerygeneratemode() {
		return querygeneratemode;
	}

	public void setQuerygeneratemode(String querygeneratemode) {
		this.querygeneratemode = querygeneratemode;
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

	public String getPageCode() {
		return pageCode;
	}

	public void setPageCode(String pageCode) {
		this.pageCode = pageCode;
	}

	public CalldetailService getCalldetailService() {
		return calldetailService;
	}

	public void setCalldetailService(CalldetailService calldetailService) {
		this.calldetailService = calldetailService;
	}

	public String getSubTotalsFlag() {
		return subTotalsFlag;
	}

	public void setSubTotalsFlag(String subTotalsFlag) {
		this.subTotalsFlag = subTotalsFlag;
	}

	public UserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}

	public String getQuerywoyear() {
		return querywoyear;
	}

	public void setQuerywoyear(String querywoyear) {
		this.querywoyear = querywoyear;
	}

	public String getQuerywoday() {
		return querywoday;
	}

	public void setQuerywoday(String querywoday) {
		this.querywoday = querywoday;
	}

	public String getQuerystwoyear() {
		return querystwoyear;
	}

	public void setQuerystwoyear(String querystwoyear) {
		this.querystwoyear = querystwoyear;
	}

	public String getQuerystwoday() {
		return querystwoday;
	}

	public void setQuerystwoday(String querystwoday) {
		this.querystwoday = querystwoday;
	}

	public String getQuerywomonth() {
		return querywomonth;
	}

	public void setQuerywomonth(String querywomonth) {
		this.querywomonth = querywomonth;
	}

	public String getQuerystwomonth() {
		return querystwomonth;
	}

	public void setQuerystwomonth(String querystwomonth) {
		this.querystwomonth = querystwomonth;
	}

	public SubtotalsForm getSubtotalsForm() {
		return subtotalsForm;
	}

	public void setSubtotalsForm(SubtotalsForm subtotalsForm) {
		this.subtotalsForm = subtotalsForm;
	}

	public String getQuerywclcompare() {
		return querywclcompare;
	}

	public void setQuerywclcompare(String querywclcompare) {
		this.querywclcompare = querywclcompare;
	}

	public String getQuerywclnumber() {
		return querywclnumber;
	}

	public void setQuerywclnumber(String querywclnumber) {
		this.querywclnumber = querywclnumber;
	}

	public String getQuerydhxclcompare() {
		return querydhxclcompare;
	}

	public void setQuerydhxclcompare(String querydhxclcompare) {
		this.querydhxclcompare = querydhxclcompare;
	}

	public String getQuerydhxclnumber() {
		return querydhxclnumber;
	}

	public void setQuerydhxclnumber(String querydhxclnumber) {
		this.querydhxclnumber = querydhxclnumber;
	}

	public String getQueryywccompare() {
		return queryywccompare;
	}

	public void setQueryywccompare(String queryywccompare) {
		this.queryywccompare = queryywccompare;
	}

	public String getQueryywcnumber() {
		return queryywcnumber;
	}

	public void setQueryywcnumber(String queryywcnumber) {
		this.queryywcnumber = queryywcnumber;
	}

	public String getQueryOSampledependc() {
		return queryOSampledependc;
	}

	public void setQueryOSampledependc(String queryOSampledependc) {
		this.queryOSampledependc = queryOSampledependc;
	}

	public String getQueryOSampledependn() {
		return queryOSampledependn;
	}

	public void setQueryOSampledependn(String queryOSampledependn) {
		this.queryOSampledependn = queryOSampledependn;
	}

	public String getQueryOAmodeldependc() {
		return queryOAmodeldependc;
	}

	public void setQueryOAmodeldependc(String queryOAmodeldependc) {
		this.queryOAmodeldependc = queryOAmodeldependc;
	}

	public String getQueryOAmodeldependn() {
		return queryOAmodeldependn;
	}

	public void setQueryOAmodeldependn(String queryOAmodeldependn) {
		this.queryOAmodeldependn = queryOAmodeldependn;
	}

	public String getQueryOSampleReqc() {
		return queryOSampleReqc;
	}

	public void setQueryOSampleReqc(String queryOSampleReqc) {
		this.queryOSampleReqc = queryOSampleReqc;
	}

	public String getQueryOSampleReqn() {
		return queryOSampleReqn;
	}

	public void setQueryOSampleReqn(String queryOSampleReqn) {
		this.queryOSampleReqn = queryOSampleReqn;
	}

	public String getQueryOOrderDeliveryc() {
		return queryOOrderDeliveryc;
	}

	public void setQueryOOrderDeliveryc(String queryOOrderDeliveryc) {
		this.queryOOrderDeliveryc = queryOOrderDeliveryc;
	}

	public String getQueryOOrderDeliveryn() {
		return queryOOrderDeliveryn;
	}

	public void setQueryOOrderDeliveryn(String queryOOrderDeliveryn) {
		this.queryOOrderDeliveryn = queryOOrderDeliveryn;
	}

	public String getQueryOOnsiteservicec() {
		return queryOOnsiteservicec;
	}

	public void setQueryOOnsiteservicec(String queryOOnsiteservicec) {
		this.queryOOnsiteservicec = queryOOnsiteservicec;
	}

	public String getQueryOOnsiteservicen() {
		return queryOOnsiteservicen;
	}

	public void setQueryOOnsiteservicen(String queryOOnsiteservicen) {
		this.queryOOnsiteservicen = queryOOnsiteservicen;
	}

	public String getQueryOComplainthandc() {
		return queryOComplainthandc;
	}

	public void setQueryOComplainthandc(String queryOComplainthandc) {
		this.queryOComplainthandc = queryOComplainthandc;
	}

	public String getQueryOComplainthandn() {
		return queryOComplainthandn;
	}

	public void setQueryOComplainthandn(String queryOComplainthandn) {
		this.queryOComplainthandn = queryOComplainthandn;
	}

	public String getQueryOReturnReqc() {
		return queryOReturnReqc;
	}

	public void setQueryOReturnReqc(String queryOReturnReqc) {
		this.queryOReturnReqc = queryOReturnReqc;
	}

	public String getQueryOReturnReqn() {
		return queryOReturnReqn;
	}

	public void setQueryOReturnReqn(String queryOReturnReqn) {
		this.queryOReturnReqn = queryOReturnReqn;
	}

	public String getQueryagentname() {
		return queryagentname;
	}

	public void setQueryagentname(String queryagentname) {
		this.queryagentname = queryagentname;
	}

	public NewWorkOrderForm getNewworkOrderForm() {
		return newworkOrderForm;
	}

	public void setNewworkOrderForm(NewWorkOrderForm newworkOrderForm) {
		this.newworkOrderForm = newworkOrderForm;
	}

	public String getNewworkOrderKey() {
		return newworkOrderKey;
	}

	public void setNewworkOrderKey(String newworkOrderKey) {
		this.newworkOrderKey = newworkOrderKey;
	}

	public String getQueryfactoryname() {
		return queryfactoryname;
	}

	public void setQueryfactoryname(String queryfactoryname) {
		this.queryfactoryname = queryfactoryname;
	}

	public String getQuerycustlinkman() {
		return querycustlinkman;
	}

	public void setQuerycustlinkman(String querycustlinkman) {
		this.querycustlinkman = querycustlinkman;
	}
	public String getHis_N() {
		return his_N;
	}

	public void setHis_N(String hisN) {
		his_N = hisN;
	}

	public String getTabId() {
		return tabId;
	}

	public void setTabId(String tabId) {
		this.tabId = tabId;
	}

	public String getWo_ucid() {
		return wo_ucid;
	}

	public void setWo_ucid(String woUcid) {
		wo_ucid = woUcid;
	}
}
