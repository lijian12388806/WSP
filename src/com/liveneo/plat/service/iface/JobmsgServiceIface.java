package com.liveneo.plat.service.iface;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.liveneo.plat.hibernate.dao.BdJobmsg;


public interface JobmsgServiceIface {
	public abstract List<BdJobmsg> queryJobmsg(
			DetachedCriteria detachedCriteria);

}
