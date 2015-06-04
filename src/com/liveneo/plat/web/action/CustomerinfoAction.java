package com.liveneo.plat.web.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Cusphonelist;
import com.liveneo.plat.hibernate.dao.Customerinfo;
import com.liveneo.plat.service.impl.BdDictService;
import com.liveneo.plat.service.impl.CustomerinfoService;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.WebappUtil;
import com.liveneo.plat.web.action.base.AbstractActionSupport;
import com.liveneo.plat.web.form.CusphonelistForm;
import com.liveneo.plat.web.form.CustomerinfoForm;

public class CustomerinfoAction extends AbstractActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomerinfoService customerinfoService;
	private BdDictService bdDictService;
	private CustomerinfoForm customerinfoForm;
	private CusphonelistForm cusphonelistForm;
	private String customerKey;
	private String cusphonelistKey;

	public String getCusphonelistKey() {
		return cusphonelistKey;
	}

	public void setCusphonelistKey(String cusphonelistKey) {
		this.cusphonelistKey = cusphonelistKey;
	}

	// 查询条件
	private String querycustomername;// 公司名称
	private String querycustlinkman;// 联系人
	private String queryinfosource;
	private String querycustphoneno;
	private String querytemp1;
	private String queryemailaddr;

	private String customerstarttime;
	private String customerstoptime;

	// 联系电话
	private String querylinkman;
	private String querynostatus;

	public String addCustomerinfo() {
		customerinfoForm = new CustomerinfoForm();
		customerinfoForm.setCuststatus("Y");
		customerKey = "";
		return SUCCESS;
	}

	public String addNewCustomerinfo() {
		String callinno = this.getRequest().getParameter("callinno");
		customerinfoForm = new CustomerinfoForm();
		customerKey = "";
//		customerinfoForm.setCustphoneno(callinno);
		this.getSession().setAttribute("customerinfoForm", customerinfoForm);
		return SUCCESS;
	}

	// 编辑
	public String editCustomerinfo() {
		try {
			customerinfoForm = new CustomerinfoForm();
			Customerinfo customer = new Customerinfo();
			if (StringUtils.isNotEmpty(customerKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("customerKey")))
					customerKey = (String) this.getSession().getAttribute(
							"customerKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			customer = this.customerinfoService.getCustomer(IntegerUtil
					.converStrToInteger(customerKey));
			// System.out.println("cust id");
			List<Cusphonelist> cusphoneList = this.customerinfoService
					.queryCusphonelistByCustomer(customer);
			this.getSession().setAttribute("cusphoneList", cusphoneList);
			WebappUtil.copyProperties(customerinfoForm, customer);
			// customerinfoForm.setUpdatetime(DateUtil.formatDateByFormat(customer.getUpdatetime(),
			// "yyyy-MM-dd HH:mm:ss"));
			this.getSession()
					.setAttribute("customerinfoForm", customerinfoForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	// 保存
	public String saveCustomerinfo() {
		Boolean c = true;
		try {
			Customerinfo customer = new Customerinfo();
			if (StringUtils.isNotEmpty(customerKey)) {
				customer = this.customerinfoService.getCustomer(IntegerUtil
						.converStrToInteger(customerKey));
				WebappUtil.copyProperties(customer, customerinfoForm);
				customer.setUpdatetime(new Date());
				c = this.customerinfoService.checkCustomername(customer);
				if (!c) {
					return ajaxForwardError(getText("客户已经存在！"));
				}
				this.customerinfoService.update(customer);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", customer.toString(), Customerinfo.REF);
			} else {
				WebappUtil.copyProperties(customer, customerinfoForm);
				customer.setUpdatetime(new Date());
				c = this.customerinfoService.checkCustomername(customer);
				if (!c) {
					return ajaxForwardError(getText("客户已经存在！"));
				}
				customer.setInfosource("byhand");
				this.customerinfoService.add(customer);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", customer.toString(), Customerinfo.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listCustomerinfo() {
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
			this.setQuerycustomername("");
			this.setQuerycustlinkman("");
			this.setQueryinfosource("");
			this.setQuerycustphoneno("");
			this.setQuerytemp1("");
			this.setQueryemailaddr("");
		}
		List<Customerinfo> l = customerinfoService.findCustomerBySql(getHql(startIndex, numPerPage));
		System.out.println(l.size());
		this.getSession().setAttribute("customerinfoList", l);
		int i = 0;
		i = this.customerinfoService.queryCountCustomer(this
				.getDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	private String getHql(int startIndex, int numPerPage) {
		String hql = "select * from Customerinfo where PK_CUSTOMERINFO >0 ";
		if (StringUtils.isNotEmpty(querycustomername))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Customername like '%").append(querycustomername)
					.append("%'").toString();
		if (StringUtils.isNotEmpty(querycustlinkman))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Custlinkman = '").append(querycustlinkman)
					.append("'").toString();
		if (StringUtils.isNotEmpty(queryinfosource))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Infosource = '").append(queryinfosource).append("'")
					.toString();
		if (StringUtils.isNotEmpty(querytemp1))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Temp1 = '").append(querytemp1).append("'").toString();
		if (StringUtils.isNotEmpty(queryemailaddr))
			hql = (new StringBuilder(String.valueOf(hql))).append(
					" and Emailaddr = '").append(queryemailaddr).append("'")
					.toString();
		hql = (new StringBuilder(String.valueOf(hql))).append(" limit ")
				.append(startIndex).append(",").append(numPerPage).toString();
		System.out.println(hql.toString());
		return hql;
	}

	private DetachedCriteria getDetachedCriteria() {
//		Userinfo user = this.getUserInfo(this.getRequest());
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Customerinfo.class);
		if (StringUtils.isNotEmpty(querycustomername)) {
			detachedCriteria.add(Restrictions.ilike(
					Customerinfo.PROP_CUSTOMERNAME, querycustomername,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querycustlinkman)) {
			detachedCriteria.add(Restrictions.ilike(
					Customerinfo.PROP_CUSTLINKMAN, querycustlinkman,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryinfosource)) {
			detachedCriteria.add(Restrictions.ilike(
					Customerinfo.PROP_INFOSOURCE, queryinfosource,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querycustphoneno)) {
			detachedCriteria.add(Restrictions.ilike(
					Customerinfo.PROP_CUSTPHONENO, querycustphoneno,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querytemp1)) {
			detachedCriteria.add(Restrictions.ilike(Customerinfo.PROP_TEMP1,
					querytemp1, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(queryemailaddr)) {
			detachedCriteria.add(Restrictions.ilike(Customerinfo.PROP_CUSTADDR,
					queryemailaddr, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(customerstarttime)) {
			Date start = DateUtil.parseFormatDate(customerstarttime,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.ge(Customerinfo.PROP_UPDATETIME,
					start));
		}
		if (StringUtils.isNotEmpty(customerstoptime)) {
			Date stop = DateUtil.parseFormatDate(customerstoptime,
					"yyyy-MM-dd HH:mm:ss");
			detachedCriteria.add(Restrictions.le(Customerinfo.PROP_UPDATETIME,
					stop));
		}
		// 由于客户数据问题，暂时不做判断2013-03-25
		// if (!StringUtils.equals(user.getIsadmin(), "true")) {
		// detachedCriteria.add(Restrictions.eq(Customerinfo.PROP_CUSTSTATUS,
		// "Y"));
		// }
		return detachedCriteria;
	}

	public String addCusphonelist() {
		cusphonelistForm = new CusphonelistForm();
		cusphonelistKey = "";
		String key = this.getRequest().getParameter("customerKey");
		Customerinfo customer = new Customerinfo();
		customer = this.customerinfoService.getCustomer(IntegerUtil
				.converStrToInteger(key));
		if (null != customer) {
			cusphonelistForm.setCustlinkname(customer.getCustlinkman());
		}
		return SUCCESS;
	}

	// 编辑
	public String editCusphonelist() {
		try {
			cusphonelistForm = new CusphonelistForm();
			Cusphonelist cusphonelist = new Cusphonelist();
			if (StringUtils.isNotEmpty(cusphonelistKey)) {
			} else {
				if (StringUtils.isNotEmpty((String) this.getSession()
						.getAttribute("cusphonelistKey")))
					cusphonelistKey = (String) this.getSession().getAttribute(
							"cusphonelistKey");
				else
					return AbstractActionSupport.EDIT;
			}// 返回list
			cusphonelist = this.customerinfoService.getCusphonelist(IntegerUtil
					.converStrToInteger(cusphonelistKey));
			WebappUtil.copyProperties(cusphonelistForm, cusphonelist);
			Customerinfo customer = this.customerinfoService
					.getCustomer(cusphonelist.getPkCustomerinfo().getId());
			cusphonelistForm.setCustomername(customer.getCustomername());
			cusphonelistForm.setCustomerno(customer.getCustomerno());
			this.getSession()
					.setAttribute("cusphonelistForm", cusphonelistForm);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
		}
		return AbstractActionSupport.EDIT;
	}

	// 保存
	public String saveCusphonelist() {
		try {
			Cusphonelist cusphonelist = new Cusphonelist();
			Customerinfo customer = new Customerinfo();
			if (StringUtils.isNotEmpty(customerKey)) {
				customer = this.customerinfoService.getCustomer(IntegerUtil
						.converStrToInteger(customerKey));
			} else {
				String msgkey = getText("主键丢失！");
				return ajaxForwardError(msgkey);
			}
			if (StringUtils.isNotEmpty(cusphonelistKey)) {
				cusphonelist = this.customerinfoService
						.getCusphonelist(IntegerUtil
								.converStrToInteger(cusphonelistKey));
				WebappUtil.copyProperties(cusphonelist, cusphonelistForm);
				cusphonelist.setPkCustomerinfo(customer);
				cusphonelist.setSynstatus("Nsyn");
				cusphonelist.setUpdatetime(new Date());
				this.customerinfoService.updatePhone(cusphonelist);
				this.customerinfoService.updateCustphoneno(customer);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XG", customer.toString(), Customerinfo.REF);
			} else {
				WebappUtil.copyProperties(cusphonelist, cusphonelistForm);
				cusphonelist.setPkCustomerinfo(customer);
				cusphonelist.setSynstatus("Nsyn");
				cusphonelist.setUpdatetime(new Date());
				this.customerinfoService.addPhone(cusphonelist);
				this.customerinfoService.updateCustphoneno(customer);
				this.logService(getRequest()).addLog(this.getRequest(),
						"LOGTYPE-XZ", customer.toString(), Customerinfo.REF);
			}
			this.getSession().setAttribute("operationDone", "ajaxDone");
			return ajaxForwardSuccess(getText("common.saveok"));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ajaxForwardError(e.getLocalizedMessage());
		}
	}

	public String listCusphonelist() {

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
			this.setQuerylinkman("");
			this.setQuerynostatus("");
		}
		List<Cusphonelist> l = this.customerinfoService.findCusphonelistBySql(
				this.getCusDetachedCriteria(), startIndex, numPerPage);

		this.getSession().setAttribute("cusphoneList", l);
		int i = 0;
		i = this.customerinfoService.queryCountCusphonelist(this
				.getCusDetachedCriteria());
		this.setTotalCount(i);
		this.getSession().setAttribute("totalCount", i);
		return AbstractActionSupport.LIST;
	}

	// private String querycusphonename;
	// private String querylinkman;
	// private String querynostatus;
	private DetachedCriteria getCusDetachedCriteria() {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Cusphonelist.class);
		// detachedCriteria.addOrder(Order.asc(Customerinfo.PROP_ID));
		// if (StringUtils.isNotEmpty(querycusphonename)) {
		// detachedCriteria.add(Restrictions.ilike(Customerinfo.PROP_CUSTOMERNAME
		// ,
		// querycusphonename, MatchMode.ANYWHERE));
		// }
		if (StringUtils.isNotEmpty(querylinkman)) {
			detachedCriteria.add(Restrictions.ilike(
					Cusphonelist.PROP_CUSTLINKNAME, querylinkman,
					MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotEmpty(querynostatus)) {
			detachedCriteria.add(Restrictions.eq(Cusphonelist.PROP_SYNSTATUS,
					querynostatus));
		}
		return detachedCriteria;
	}

	public String deleteCusphonelist() {
		try {
			String selectIDS = this.getRequest().getParameter("selectIDS");
			if (StringUtils.isNotEmpty(selectIDS)) {
				this.customerinfoService.deleteCusphonelistByIds(StringUtils
						.split(selectIDS, ','));
			}
			if (StringUtils.isNotEmpty(customerKey)) {
				this.customerinfoService
						.updateCustphoneno(this.customerinfoService
								.getCustomer(IntegerUtil
										.converStrToInteger(customerKey)));
			}
			this.logService(getRequest()).addLog(this.getRequest(),
					"LOGTYPE-SC", "delete:" + selectIDS.toString(),
					Customerinfo.REF);
			return ajaxForwardSuccess(getText("删除成功！"));
		} catch (Exception ex) {
			return ajaxForwardError(ex.getLocalizedMessage());
		}
	}


	public CustomerinfoService getCustomerinfoService() {
		return customerinfoService;
	}

	public void setCustomerinfoService(CustomerinfoService customerinfoService) {
		this.customerinfoService = customerinfoService;
	}

	public CustomerinfoForm getCustomerinfoForm() {
		return customerinfoForm;
	}

	public void setCustomerinfoForm(CustomerinfoForm customerinfoForm) {
		this.customerinfoForm = customerinfoForm;
	}

	public String getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}

	public String getQuerycustomername() {
		return querycustomername;
	}

	public void setQuerycustomername(String querycustomername) {
		this.querycustomername = querycustomername;
	}

	public CusphonelistForm getCusphonelistForm() {
		return cusphonelistForm;
	}

	public void setCusphonelistForm(CusphonelistForm cusphonelistForm) {
		this.cusphonelistForm = cusphonelistForm;
	}

	public String getQuerylinkman() {
		return querylinkman;
	}

	public void setQuerylinkman(String querylinkman) {
		this.querylinkman = querylinkman;
	}

	public String getQuerynostatus() {
		return querynostatus;
	}

	public void setQuerynostatus(String querynostatus) {
		this.querynostatus = querynostatus;
	}

	public BdDictService getBdDictService() {
		return bdDictService;
	}

	public void setBdDictService(BdDictService bdDictService) {
		this.bdDictService = bdDictService;
	}

	public String getQuerycustlinkman() {
		return querycustlinkman;
	}

	public void setQuerycustlinkman(String querycustlinkman) {
		this.querycustlinkman = querycustlinkman;
	}

	public String getQueryinfosource() {
		return queryinfosource;
	}

	public void setQueryinfosource(String queryinfosource) {
		this.queryinfosource = queryinfosource;
	}

	public String getQuerycustphoneno() {
		return querycustphoneno;
	}

	public void setQuerycustphoneno(String querycustphoneno) {
		this.querycustphoneno = querycustphoneno;
	}

	public String getQuerytemp1() {
		return querytemp1;
	}

	public void setQuerytemp1(String querytemp1) {
		this.querytemp1 = querytemp1;
	}

	public String getQueryemailaddr() {
		return queryemailaddr;
	}

	public void setQueryemailaddr(String queryemailaddr) {
		this.queryemailaddr = queryemailaddr;
	}

	public String getCustomerstarttime() {
		return customerstarttime;
	}

	public void setCustomerstarttime(String customerstarttime) {
		this.customerstarttime = customerstarttime;
	}

	public String getCustomerstoptime() {
		return customerstoptime;
	}

	public void setCustomerstoptime(String customerstoptime) {
		this.customerstoptime = customerstoptime;
	}

}
