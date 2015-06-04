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

import com.liveneo.plat.hibernate.dao.base.BaseBdDictDAO;
import com.liveneo.plat.utils.PageNoUtil;

public class BdDictDAO extends BaseBdDictDAO implements
		com.liveneo.plat.hibernate.dao.dao.iface.BdDictDAO {

	public BdDictDAO() {
	}

	public BdDictDAO(Session session) {
		super(session);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.BdDict> findByCriteria(
			org.hibernate.criterion.DetachedCriteria detachedCriteria) {
		return getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no
	 * filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.BdDict> findByCriteria(
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
		final String queryString = "from com.liveneo.lcp.hibernate.dao.BdDict where "
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
			com.liveneo.plat.hibernate.dao.BdDict bdDict) {
		return getHibernateTemplate().findByExample(bdDict);
	}

	public java.util.List findByHql(String hql) {
		return getHibernateTemplate().find(hql);
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

	public com.liveneo.plat.hibernate.dao.BdDict getByUniqueIndex(
			final DetachedCriteria detachedCriteria) {
		com.liveneo.plat.hibernate.dao.BdDict object = (com.liveneo.plat.hibernate.dao.BdDict) getHibernateTemplate()
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

	public com.liveneo.plat.hibernate.dao.BdDict getByUniqueIndex(
			String colname, Object colvalue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(com.liveneo.plat.hibernate.dao.BdDict.class);
		detachedCriteria.add(Restrictions.eq(colname, colvalue));
		return this.getByUniqueIndex(detachedCriteria);
	}

}