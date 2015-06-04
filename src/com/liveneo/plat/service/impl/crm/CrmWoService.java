package com.liveneo.plat.service.impl.crm;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.CrmWo;
import com.liveneo.plat.hibernate.dao.dao.iface.CrmWoDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.crm.CrmWoServiceIface;
import com.liveneo.plat.utils.DateUtil;

public class CrmWoService extends AbstractBaseService implements CrmWoServiceIface {
	private CrmWoDAO crmWoDAO;

	public List<CrmWo> findCrmWoBySql(String sql) {
		return this.crmWoDAO.findBySQL(sql);
	}
	public int queryCountCrmWo(DetachedCriteria detachedCriteria) {
		return this.crmWoDAO.getCountByCriteria(detachedCriteria);
	}
	public CrmWo getCrmWoByKey(int key) {
		return this.crmWoDAO.get(key);
	}
	public int addCrmWo(CrmWo bean) {
		if(StringUtils.isEmpty(bean.getWosNo())){
			bean.setWosNo(this.getCrmWoNoByCreate());
		}
		bean.setWosCreatetime(new Date());
		return this.crmWoDAO.save(bean);
	}
	public void updateCrmWo(CrmWo bean) {
		bean.setWosUpdatetime(new Date());
		this.crmWoDAO.update(bean);
	}
	public void delCrmWo(int key){
		this.crmWoDAO.delete(key);
	}
	
	//生成工单编号
	// 服务单号
	public String getCrmWoNoByCreate() {
		String date = DateUtil.formatDate(new Date());
		String result = "";
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(CrmWo.class);
		detachedCriteria.addOrder(Order.desc(CrmWo.PROP_ID));
		// 创建日期在当天
		// 获取当前时间
		// DateUtil.formatDateByFormat(new Date(),"yyyyMMdd");
		detachedCriteria.add(Restrictions.like(CrmWo.PROP_WOS_NO,
				DateUtil.formatDateByFormat(new Date(), "yyyyMMdd"),MatchMode.START));
		// detachedCriteria.add(Restrictions.ge(Workorder.PROP_DEALTIME,
		// DateUtil.getQueryStartDate(new Date())));
		// detachedCriteria.add(Restrictions.le(Workorder.PROP_DEALTIME,
		// DateUtil.getQueryEndDate(new Date())));
		List<CrmWo> workorderList = this.crmWoDAO
				.findByCriteria(detachedCriteria);
		int maxNo;
		if (workorderList.isEmpty()) {
			result = date.replace("-", "") + "000" + "1";
		} else {
			CrmWo workorderno = workorderList.get(0);
			String orderno = workorderno.getWosNo() ;
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
	public CrmWoDAO getCrmWoDAO() {
		return crmWoDAO;
	}
	public void setCrmWoDAO(CrmWoDAO crmWoDAO) {
		this.crmWoDAO = crmWoDAO;
	}
}
