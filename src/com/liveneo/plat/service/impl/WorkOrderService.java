package com.liveneo.plat.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.Orderdealinfo;
import com.liveneo.plat.hibernate.dao.Workorder;
import com.liveneo.plat.hibernate.dao.dao.iface.OrderdealinfoDAO;
import com.liveneo.plat.hibernate.dao.dao.iface.WorkorderDAO;
import com.liveneo.plat.service.base.AbstractBaseService;
import com.liveneo.plat.service.iface.WorkOrderServiceIface;
import com.liveneo.plat.utils.DateUtil;
import com.liveneo.plat.utils.IntegerUtil;
import com.liveneo.plat.utils.ListUtil;
import com.liveneo.plat.web.form.CountRatioForm;

public class WorkOrderService extends AbstractBaseService implements
		WorkOrderServiceIface {

	private WorkorderDAO workorderDAO;

	private OrderdealinfoDAO orderdealinfoDAO;

	public int getCountByCriteria(DetachedCriteria detachedCriteria) {
		return this.workorderDAO.getCountByCriteria(detachedCriteria);

	}

	// 服务单号
	public String createWorkorderNo() {
		String date = DateUtil.formatDate(new Date());
		String result = "";
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Workorder.class);
		detachedCriteria.addOrder(Order.desc(Workorder.PROP_WORKORDERNO));
		// 创建日期在当天
		// 获取当前时间
		// DateUtil.formatDateByFormat(new Date(),"yyyyMMdd");
		detachedCriteria.add(Restrictions.like(Workorder.PROP_WORKORDERNO,
				DateUtil.formatDateByFormat(new Date(), "yyyyMMdd"),MatchMode.START));
		// detachedCriteria.add(Restrictions.ge(Workorder.PROP_DEALTIME,
		// DateUtil.getQueryStartDate(new Date())));
		// detachedCriteria.add(Restrictions.le(Workorder.PROP_DEALTIME,
		// DateUtil.getQueryEndDate(new Date())));
		List<Workorder> workorderList = this.workorderDAO
				.findByCriteria(detachedCriteria);
		int maxNo;
		if (workorderList.isEmpty()) {
			result = date.replace("-", "") + "000" + "1";
		} else {
			Workorder workorderno = workorderList.get(0);
			String orderno = workorderno.getWorkorderno();
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

	public Workorder getWorkorder(int key) {
		return this.workorderDAO.get(key);
	}

	public Integer add(Workorder workorder) {
		return this.workorderDAO.save(workorder);
	}

	public void update(Workorder workorder) {
		this.workorderDAO.update(workorder);
	}
//更新客户信息
	public void addOrUpdateCustomer(){
		
	}
	public List<Workorder> queryWoByDetachedCriteria(
			DetachedCriteria detachedCriteria) {
		return this.workorderDAO.findByCriteria(detachedCriteria);
	}
	public List<Workorder> findWorkorderBySql(String sql) {
		return this.workorderDAO.findBySQL(sql);
	}
	public List<Workorder> findWorkorderBySql(
			DetachedCriteria detachedCriteria, int startIndex, int numPerPage) {
		return this.workorderDAO.findByCriteria(detachedCriteria, startIndex,
				numPerPage);
		// return this.workorderDAO.getListForPage(hql, startIndex, numPerPage);
	}

	//N天内工单信息
	public List<Workorder> queryWorkorderNByCallerno(String callerno,String limit) {
		String sql = "select * from Workorder where PK_WORKORDER >0 and (CALLTIME BETWEEN date_add(SYSDATE(), interval -"+limit+" day) and SYSDATE())";
		return this.findWorkorderBySql(sql);
	}
	public int queryCountWorkorder(DetachedCriteria detachedCriteria) {
		return this.workorderDAO.getCountByCriteria(detachedCriteria);
	}

	public void delWorkorder(int key) {
		List<Orderdealinfo> list = this.queryOrderdealByWk(this
				.getWorkorder(key));
		if (list.size() > 0) {
			for (Orderdealinfo o : list) {
				this.orderdealinfoDAO.delete(o);
			}
		}
		this.workorderDAO.delete(key);
	}

	public List<Orderdealinfo> queryOrderdealByWk(Workorder workorder) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Orderdealinfo.class);
		detachedCriteria.add(Restrictions.eq(Orderdealinfo.PROP_PK_WORKORDER,
				workorder));
		return this.orderdealinfoDAO.findByCriteria(detachedCriteria);
	}

	public Orderdealinfo getOrderdealinfo(int key) {
		return this.orderdealinfoDAO.get(key);

	}

	public void updateOrderdealinfo(Orderdealinfo orderdealinfo) {
		this.orderdealinfoDAO.update(orderdealinfo);
	}

	public void addOrderdealinfo(Orderdealinfo orderdealinfo) {
		this.orderdealinfoDAO.save(orderdealinfo);
	}

	public void deleteOrderdealinfo(int key) {
		this.orderdealinfoDAO.delete(key);
	}

	public void deleteOrderdealinfoByIds(String[] selectIDS) {
		List<String> keyList = new ArrayList<String>();
		keyList = ListUtil.ConvertArrayToStringList(selectIDS, "String");
		if (keyList != null) {
			for (String key : keyList) {
				this.deleteOrderdealinfo(IntegerUtil.converStrToInteger(key));
			}
		}
	}

	public ResultSet executeQuerySQl(String sql) throws SQLException {
		return this.workorderDAO.executeQuerySQl(sql);
	}

	public List<CountRatioForm> executeQuerySQlINDAO(String sql)
			throws SQLException {
		return this.workorderDAO.executeQuerySQlINDAO(sql);
	}

	public void setWorkorderDAO(WorkorderDAO workorderDAO) {
		this.workorderDAO = workorderDAO;
	}

	public void setOrderdealinfoDAO(OrderdealinfoDAO orderdealinfoDAO) {
		this.orderdealinfoDAO = orderdealinfoDAO;
	}
}
