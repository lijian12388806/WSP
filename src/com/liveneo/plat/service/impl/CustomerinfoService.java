package com.liveneo.plat.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Cusphonelist;
import com.liveneo.plat.hibernate.dao.Customerinfo;
import com.liveneo.plat.hibernate.dao.Workstation;
import com.liveneo.plat.hibernate.dao.dao.iface.CusphonelistDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.CustomerinfoDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.CustomerinfoServiceIface;
import com.liveneo.plat.utils.CreateXml;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.LbUtil;
import com.liveneo.plat.utils.ListUtil;

public class CustomerinfoService extends AbstractBaseService implements CustomerinfoServiceIface{
	private CustomerinfoDAO customerinfoDAO;
	private CusphonelistDAO cusphonelistDAO;
	
	public List<Customerinfo> queryByCustomerno(String customerno){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Customerinfo.class);
		detachedCriteria.add(Restrictions.eq(Customerinfo.PROP_CUSTOMERNO,customerno));
		return this.customerinfoDAO.findByCriteria(detachedCriteria);
	}
	//检测唯一性
	public Boolean checkCustomername(Customerinfo customer){
		Boolean b=false;
		List<Customerinfo> list=new ArrayList<Customerinfo>();
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Customerinfo.class);
		detachedCriteria.add(Restrictions.eq(Customerinfo.PROP_CUSTLINKMAN,customer.getCustlinkman()));
		detachedCriteria.add(Restrictions.eq(Customerinfo.PROP_CUSTPHONENO,customer.getCustphoneno()));
		detachedCriteria.add(Restrictions.eq(Customerinfo.PROP_CUSTADDR,customer.getCustaddr()));
		list=this.customerinfoDAO.findByCriteria(detachedCriteria);
		if(customer.getId() == null){
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}else{
			list.remove(customer);
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}
		return b;
	}
	public Boolean checkCustomerno(Customerinfo customer){
		Boolean b=false;
		List<Customerinfo> list=new ArrayList<Customerinfo>();
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Customerinfo.class);
		detachedCriteria.add(Restrictions.eq(Customerinfo.PROP_CUSTOMERNO,customer.getCustomerno()));
		list=this.customerinfoDAO.findByCriteria(detachedCriteria);
		if(customer.getId() == null){
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}else{
			list.remove(customer);
			if(list.size()>0){
				b=false;
			}else{
				b=true;
			}
		}
		return b;
	}
	public List<Customerinfo> queryCustomerByWS(Workstation ws){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Customerinfo.class);
		detachedCriteria.add(Restrictions.eq(Customerinfo.PROP_SALESORG,ws.getFactorynamecn()));
		return this.customerinfoDAO.findByCriteria(detachedCriteria);
	}
	public Customerinfo getCustomer(int key){
		return this.customerinfoDAO.get(key);
		
	}
	public void addCustomer(Customerinfo customer){
		this.customerinfoDAO.save(customer);
	}
	public int add(Customerinfo customer){
		int key=this.customerinfoDAO.save(customer);
		Customerinfo c=this.getCustomerByNo(customer.getCustomerno());
		if(null !=c){
			this.addCustPhoneno(c);
		}
		return key;
	}
	public void updateCustomer(Customerinfo customer){
		this.updateCustphoneno(customer);
	}
	public void update(Customerinfo customer){
		this.deleteCLByCustomer(customer);
		this.updateCustomerListByCustomer(customer);
		this.updateCustphoneno(customer);
		this.customerinfoDAO.update(customer);
	}
	
	public void updateC(Customerinfo customer){
		this.customerinfoDAO.update(customer);
	}
	public List<Customerinfo> findCustomerBySql(DetachedCriteria detachedCriteria,int startIndex, int numPerPage){
		return this.customerinfoDAO.findByCriteria(detachedCriteria,startIndex,numPerPage);
		
	}
	public List<Customerinfo> findCustomerBySql(String sql){
		return this.customerinfoDAO.findBySQL(sql);
		
	}
	public int queryCountCustomer(DetachedCriteria detachedCriteria){
		return this.customerinfoDAO.getCountByCriteria(detachedCriteria);
		
	}
	public Customerinfo getCustomerByNo(String customerno){
		return this.customerinfoDAO.getByUniqueIndex(Customerinfo.PROP_CUSTOMERNO, customerno);
		
	}
	public Customerinfo getCustomerByLinkman(String custLinkman){
		return this.customerinfoDAO.getByUniqueIndex(Customerinfo.PROP_CUSTLINKMAN, custLinkman);
		
	}
	public Customerinfo getCustomerByCustomerno(String callinno){
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customerinfo.class);
		detachedCriteria.add(Restrictions.like(Customerinfo.PROP_CUSTPHONENO,callinno,MatchMode.ANYWHERE));
		List<Customerinfo> custList=new ArrayList<Customerinfo>();
		custList=this.customerinfoDAO.findByCriteria(detachedCriteria);
		Customerinfo customer=new Customerinfo();
		if(null!=custList&&custList.size()>0){
			for(Customerinfo c:custList){
				customer = c;
				break;
			}
		}else{
			customer = null;
		}
		
//		DetachedCriteria detachedCriteria = DetachedCriteria
//		.forClass(Cusphonelist.class);
//		detachedCriteria.addOrder(Order.asc(Cusphonelist.PROP_NOLEVEL));
//		detachedCriteria.add(Restrictions.eq(Cusphonelist.PROP_PHONENO,callinno));
//		List<Cusphonelist> cusphonelist=new ArrayList<Cusphonelist>();
//		cusphonelist=this.cusphonelistDAO.findByCriteria(detachedCriteria);
//		Customerinfo customer=new Customerinfo();
//		if(cusphonelist.size()>0){
//			for(Cusphonelist c:cusphonelist){
//				if(StringUtils.equals(c.getPkCustomerinfo().getCuststatus(),"Y")){
//					customer=this.getCustomer(c.getPkCustomerinfo().getId());
//					break;
//				}
//			}
//		}else{
//			customer = null;
//		}
		return customer;
	}
	//附属电话清单
	public void addCustPhoneno(Customerinfo customer){
		Cusphonelist cusphonelist=new Cusphonelist();
		if(StringUtils.isNotEmpty(customer.getCustphoneno())){
			if(StringUtils.contains(customer.getCustphoneno(), ",")){
				List<String> phones=LbUtil.splitStringByCommonSeparator(customer.getCustphoneno(), ",");
				for(String s:phones){
					List<Cusphonelist> listphoneno=new ArrayList<Cusphonelist>();
					listphoneno=this.queryCusphonelistByCust(customer, s);
					if(listphoneno.size()<=0){
						cusphonelist.setCustlinkname(customer.getCustlinkman());
						cusphonelist.setPhoneno(s);
//						cusphonelist.setSynstatus("Nsyn");
						cusphonelist.setPkCustomerinfo(customer);
						cusphonelist.setUpdatetime(new Date());
						this.addPhone(cusphonelist);
					}
				}
			}else{
				List<Cusphonelist> listphoneno=new ArrayList<Cusphonelist>();
				listphoneno=this.queryCusphonelistByCust(customer, customer.getCustphoneno());
				if(listphoneno.size()<=0){
				cusphonelist.setCustlinkname(customer.getCustlinkman());
				cusphonelist.setPhoneno(customer.getCustphoneno());
//				cusphonelist.setSynstatus("Nsyn");
				cusphonelist.setPkCustomerinfo(customer);
				cusphonelist.setUpdatetime(new Date());
				this.addPhone(cusphonelist);
				}
			}
		}
	}
	public void deleteCLByCustomer(Customerinfo customer){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Cusphonelist.class);
		detachedCriteria.add(Restrictions.eq(Cusphonelist.PROP_PK_CUSTOMERINFO,customer));
		List<Cusphonelist> listphoneno=new ArrayList<Cusphonelist>();
		listphoneno = this.cusphonelistDAO.findByCriteria(detachedCriteria);
		if(listphoneno.size() > 0){
			for(Cusphonelist c:listphoneno){
				this.deleteCusphonelist(c.getId());
			}
		}
	}
	//工单来电号码
	public void addOrderPhone(Customerinfo customer,String callerno){
		Cusphonelist cusphonelist=new Cusphonelist();
		cusphonelist.setCustlinkname(customer.getCustlinkman());
		cusphonelist.setPhoneno(callerno);
//		cusphonelist.setSynstatus("Nsyn");
		cusphonelist.setPkCustomerinfo(customer);
		cusphonelist.setUpdatetime(new Date());
		this.addPhone(cusphonelist);
		this.updateCustphoneno(customer);
	}
	//customer update customerList
	public void updateCustomerListByCustomer(Customerinfo customer){
		List<String> strs = new ArrayList<String>();
		if(StringUtils.contains(customer.getCustphoneno(), ",")){
			String[] s = StringUtils.split(customer.getCustphoneno(), ",");
			for(int i=0;i<s.length;i++){
				strs.add(s[i]);
			}
			if(strs.size()>0){
				for(String ss:strs){
				this.updatePhoneList(customer,ss);
				}
			}
		}else{
			this.updatePhoneList(customer,customer.getCustphoneno());
		}
	}
	// update customer
	public void updatePhoneList(Customerinfo customer,String s){
		
			Cusphonelist cusphonelist=new Cusphonelist();
			cusphonelist.setCustlinkname(customer.getCustlinkman());
			cusphonelist.setPhoneno(s);
//			cusphonelist.setSynstatus("Nsyn");
			cusphonelist.setPkCustomerinfo(customer);
			cusphonelist.setUpdatetime(new Date());
			this.addPhone(cusphonelist);
	}
	public void updateCustphoneno(Customerinfo customer){
		//更新客户号码
		List<Cusphonelist> listphoneno=new ArrayList<Cusphonelist>();
		listphoneno=this.queryCusphonelistByCustomer(customer);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<listphoneno.size();i++){
			sb.append(listphoneno.get(i).getPhoneno());
			if (i < listphoneno.size() - 1) {
				sb.append(",");
			}
		}
		customer.setCustphoneno(sb.toString());
		this.customerinfoDAO.update(customer);
	}
	public List<Cusphonelist> queryCusphonelistByCustomer(Customerinfo customer){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Cusphonelist.class);
		detachedCriteria.addOrder(Order.asc(Cusphonelist.PROP_NOLEVEL));
		detachedCriteria.add(Restrictions.eq(Cusphonelist.PROP_PK_CUSTOMERINFO,customer));
		return this.cusphonelistDAO.findByCriteria(detachedCriteria);
	}
	//电话清单
	public List<Cusphonelist> queryCusphonelistByCust(Customerinfo customer,String phoneno){
		DetachedCriteria detachedCriteria = DetachedCriteria
		.forClass(Cusphonelist.class);
		detachedCriteria.add(Restrictions.eq(Cusphonelist.PROP_PK_CUSTOMERINFO,customer));
		detachedCriteria.add(Restrictions.eq(Cusphonelist.PROP_PHONENO,phoneno));
		return this.cusphonelistDAO.findByCriteria(detachedCriteria);
	}
	
	public void addPhone(Cusphonelist cusphonelist){
		this.cusphonelistDAO.save(cusphonelist);
	}
	public Cusphonelist getCusphonelist(int key){
		return this.cusphonelistDAO.get(key);
	}
	public void updatePhone(Cusphonelist cusphonelist){
		this.cusphonelistDAO.update(cusphonelist);
		this.updateCustphoneno(this.getCustomer(cusphonelist.getPkCustomerinfo().getId()));
	}
	public List<Cusphonelist> findCusphonelistBySql(DetachedCriteria detachedCriteria,int startIndex, int numPerPage){
		return this.cusphonelistDAO.findByCriteria(detachedCriteria, startIndex, numPerPage);}
	public int queryCountCusphonelist(DetachedCriteria detachedCriteria){
		return this.cusphonelistDAO.getCountByCriteria(detachedCriteria);
	}
	public void deleteCustomerByCustomer(Customerinfo customer){
		List<Cusphonelist> list=this.queryCusphonelistByCustomer(customer);
		if(list.size()>0){
			for(Cusphonelist c:list){
				this.deleteCusphonelist(c.getId());
			}
		}
	}
	//更新customer phoneno字段
	public void deleteCusphonelist(int key){
		this.cusphonelistDAO.delete(key);
	}
	public void deleteCusphonelistByIds(String[] selectIDS) {
		List<String> keyList = new ArrayList<String>();
		keyList = ListUtil.ConvertArrayToStringList(selectIDS, "String");
		if (keyList != null) {
			for (String key : keyList) {
				this.deleteCusphonelist(IntegerUtil.converStrToInteger(key));
			}
			
		}
	}
	public void excuteCustomerSyn() {
		Date transdate = DateUtil.getQueryStartDate(DateUtil
				.formatDate(new Date()));
		log.info("excuteCustomerSyn->" + new Date());
		try {
			String synCustinfoSQL = "";
			String synCustnoSQL = "";
			List<String> sqlList = new ArrayList<String>();
			sqlList.add(synCustinfoSQL);
			sqlList.add(synCustnoSQL);
			this.customerinfoDAO.bulkUpdateBtach(sqlList);

		} catch (Exception ex) {
			log.error("excuteCustomerSyn", ex);
		}
	}
	public void excuteCustomerSynBysqlList(List<String> sqlList) {
		log.info("excuteCustomerSynBysqlList->" + new Date());
		try {
			this.customerinfoDAO.bulkUpdateBtach(sqlList);

		} catch (Exception ex) {
			log.error("excuteCustomerSynBysqlList", ex);
		}
	}
	public CustomerinfoDAO getCustomerinfoDAO() {
		return customerinfoDAO;
	}
	public void setCustomerinfoDAO(CustomerinfoDAO customerinfoDAO) {
		this.customerinfoDAO = customerinfoDAO;
	}
	public CusphonelistDAO getCusphonelistDAO() {
		return cusphonelistDAO;
	}
	public void setCusphonelistDAO(CusphonelistDAO cusphonelistDAO) {
		this.cusphonelistDAO = cusphonelistDAO;
	}
	
}
