package com.liveneo.plat.utils;

import java.util.List;

import org.apache.log4j.Logger;

import org.hibernate.Query;

import org.hibernate.Session;

public class PageNoUtil {
	static Logger log = Logger.getLogger(PageNoUtil.class);

	public static List<?> getList(Session session, String hql, int offset,
			int length) {

		Query q = session.createQuery(hql);

		q.setFirstResult(offset);

		q.setMaxResults(length);

//		log.info(hql);

		List<?> list = q.list();

//		log.info("取到的每页的size" + list.size());

		return list;

	}
}
