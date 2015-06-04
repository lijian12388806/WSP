package com.liveneo.plat.service.impl.crm;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.CrmCust;
import com.liveneo.plat.hibernate.dao.dao.iface.CrmCustDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.crm.CrmCustServiceIface;
import com.liveneo.plat.utils.DateUtil;

public class CrmCustService extends AbstractBaseService implements CrmCustServiceIface {
	private CrmCustDAO crmCustDAO;

	public List<CrmCust> findCrmCustBySql(String sql) {
		return this.crmCustDAO.findBySQL(sql);
	}
	public int queryCountCrmCust(DetachedCriteria detachedCriteria) {
		return this.crmCustDAO.getCountByCriteria(detachedCriteria);
	}
	public CrmCust getCrmCustByKey(int key) {
		return this.crmCustDAO.get(key);
	}
	public int addCrmCust(CrmCust bean) {
		bean.setCreatetime(new Date());
		return this.crmCustDAO.save(bean);
	}
	public void updateCrmCust(CrmCust bean) {
		bean.setUpdatetime(new Date());
		this.crmCustDAO.update(bean);
	}
	public void delCrmCust(int key){
		this.crmCustDAO.delete(key);
	}
	
	public List<CrmCust> queryCrmCustByPhone(String phone){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(CrmCust.class);
		detachedCriteria.add(Restrictions.like(CrmCust.PROP_WOS_PHONE,phone,MatchMode.START));
		return this.crmCustDAO.findByCriteria(detachedCriteria);
	}
	
	//生成工单编号
	// 服务单号
	public String getCrmCustNoByCreate() {
		String date = DateUtil.formatDate(new Date());
		String result = "";
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(CrmCust.class);
		detachedCriteria.addOrder(Order.desc(CrmCust.PROP_ID));
		// 创建日期在当天
		// 获取当前时间
		// DateUtil.formatDateByFormat(new Date(),"yyyyMMdd");
		detachedCriteria.add(Restrictions.like(CrmCust.PROP_WOS_T1,
				DateUtil.formatDateByFormat(new Date(), "yyyyMMdd"),MatchMode.START));
		// detachedCriteria.add(Restrictions.ge(Custrkorder.PROP_DEALTIME,
		// DateUtil.getQueryStartDate(new Date())));
		// detachedCriteria.add(Restrictions.le(Custrkorder.PROP_DEALTIME,
		// DateUtil.getQueryEndDate(new Date())));
		List<CrmCust> CustrkorderList = this.crmCustDAO
				.findByCriteria(detachedCriteria);
		int maxNo;
		if (CustrkorderList.isEmpty()) {
			result = date.replace("-", "") + "000" + "1";
		} else {
			CrmCust Custrkorderno = CustrkorderList.get(0);
			String orderno = Custrkorderno.getWosT1() ;
			maxNo = Integer.parseInt(orderno.substring(8));
			if (maxNo < 9) {
				result = date.replace("-", "") + "000" + (maxNo + 1);
			} else if (9 <= maxNo && maxNo < 99) {
				result = date.replace("-", "") + "00" + (maxNo + 1);
			} else if (99 <= maxNo && maxNo < 999) {
				result = date.replace("-", "") + "0" + (maxNo + 1);
			} else {
				result = date.replace("-", "") + (maxNo + 1);
			}
		}
		return result;
	}
	/**
	 * get/set
	 * @return
	 */
	public CrmCustDAO getCrmCustDAO() {
		return crmCustDAO;
	}
	public void setCrmCustDAO(CrmCustDAO crmCustDAO) {
		this.crmCustDAO = crmCustDAO;
	}
}
