package com.liveneo.plat.service.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.utils.IntegerUtil;

public abstract class AbstractBaseService implements BaseServiceIface {
	protected transient final Log log = LogFactory.getLog(getClass());

	public DetachedCriteria uniqueResultCrit(String entityName, String colname,
			String colvalue, String sKey) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forEntityName(entityName);
		detachedCriteria.add(Restrictions.eq(colname, colvalue));
		if (StringUtils.isNotEmpty(sKey)) {
			detachedCriteria.add(Restrictions.not(Restrictions.eq(colname,
					IntegerUtil.converStrToInteger(sKey))));
		}
		return detachedCriteria;
	}
	public DetachedCriteria uniqueResultCrit(Class entityName, String colname,
			String colvalue, String sKey) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(entityName);
		detachedCriteria.add(Restrictions.eq(colname, colvalue));
		if (StringUtils.isNotEmpty(sKey)) {
			detachedCriteria.add(Restrictions.not(Restrictions.eq("Id",
					IntegerUtil.converStrToInteger(sKey))));
		}
		return detachedCriteria;
	}
}
