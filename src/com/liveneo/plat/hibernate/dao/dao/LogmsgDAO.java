package com.liveneo.plat.hibernate.dao.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.base.BaseLogmsgDAO;
import com.liveneo.plat.utils.PageNoUtil;

public class LogmsgDAO extends BaseLogmsgDAO implements
		com.liveneo.plat.hibernate.dao.dao.iface.LogmsgDAO {

	public LogmsgDAO() {
	}

	public LogmsgDAO(Session session) {
		super(session);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.Logmsg> findByCriteria(
			org.hibernate.criterion.DetachedCriteria detachedCriteria) {
		return getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.Logmsg> findByCriteria(
			org.hibernate.criterion.DetachedCriteria detachedCriteria,
			int firstResult, int resultCount) {
		return getHibernateTemplate().findByCriteria(detachedCriteria,
				firstResult, resultCount);
	}

	public java.util.List findBySQL(String queryString) {
		return super.findBySQL(queryString);
	}

	public java.util.List findByNamedQuery(final String queryName,
			final Object parameter) {
		final String queryString = "from com.liveneo.lcp.hibernate.dao.Logmsg where "
				+ queryName + "= ?";
		return (java.util.List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(queryString);
						if (parameter != null) {
							query.setParameter(0, parameter);
						}
						return query.list();
					}
				}, true);
	}

	public java.util.List findByExample(
			com.liveneo.plat.hibernate.dao.Logmsg logmsg) {
		return getHibernateTemplate().findByExample(logmsg);
	}

	public java.util.List findByHql(String hql) {
		return getHibernateTemplate().find(hql);
	}

	public com.liveneo.plat.hibernate.dao.Logmsg getByUniqueIndex(
			final DetachedCriteria detachedCriteria) {
		com.liveneo.plat.hibernate.dao.Logmsg object = (com.liveneo.plat.hibernate.dao.Logmsg) getHibernateTemplate()
				.execute(new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Criteria criteria = detachedCriteria
								.getExecutableCriteria(session);
						return criteria.uniqueResult();
					}
				}, true);
		return object;
	}

	public com.liveneo.plat.hibernate.dao.Logmsg getByUniqueIndex(
			String colname, Object colvalue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(com.liveneo.plat.hibernate.dao.Logmsg.class);
		detachedCriteria.add(Restrictions.eq(colname, colvalue));
		return this.getByUniqueIndex(detachedCriteria);
	}

	public List getListForPage(final String hql, final int offset,
			final int length) {
		List list1 = getHibernateTemplate().executeFind(

		new HibernateCallback() {

			public Object doInHibernate(Session session)

			throws HibernateException, SQLException {

				List list2 = PageNoUtil.getList(session, hql, offset, length);

				return list2;

			}

		});

		return list1;

	}
}