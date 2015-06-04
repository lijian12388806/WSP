package com.liveneo.plat.hibernate.dao.dao;

import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.liveneo.plat.hibernate.dao.base.BaseUploadfileDAO;


public class UploadfileDAO extends BaseUploadfileDAO implements com.liveneo.plat.hibernate.dao.dao.iface.UploadfileDAO {

	public UploadfileDAO () {}
	
	public UploadfileDAO (Session session) {
		super(session);
	}
	

    /**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.Uploadfile> findByCriteria(org.hibernate.criterion.DetachedCriteria detachedCriteria){
		return  getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.Uploadfile> findByCriteria(org.hibernate.criterion.DetachedCriteria detachedCriteria,int firstResult,int resultCount){
		return  getHibernateTemplate().findByCriteria(detachedCriteria,firstResult,resultCount);
	}
	
	public java.util.List findBySQL(String queryString) {
		return super.findBySQL(queryString);
	}
	public java.util.List findByNamedQuery(final String queryName,final Object parameter) {
  		final String queryString = "from com.liveneo.lcp.hibernate.dao.Uploadfile where "
			+ queryName + "= ?";
		return (java.util.List) getHibernateTemplate().execute(new HibernateCallback() {   
            public Object doInHibernate(Session session) throws HibernateException {   
                Query query = session.createQuery(queryString);
                if (parameter!=null){
                        query.setParameter(0, parameter);   
                    }   
                return query.list();   
            }   
        }, true);  		
    }
	public java.util.List findByExample(com.liveneo.plat.hibernate.dao.Uploadfile uploadfile) {
  		return getHibernateTemplate().findByExample(uploadfile);
    }
    public java.util.List findByHql(String hql){
			return  getHibernateTemplate().find(hql);
	}
	public	com.liveneo.plat.hibernate.dao.Uploadfile getByUniqueIndex(
			final DetachedCriteria detachedCriteria) {
		com.liveneo.plat.hibernate.dao.Uploadfile object = (com.liveneo.plat.hibernate.dao.Uploadfile) getHibernateTemplate()
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

	public com.liveneo.plat.hibernate.dao.Uploadfile getByUniqueIndex(
			String colname, Object colvalue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(com.liveneo.plat.hibernate.dao.Uploadfile.class);
		detachedCriteria.add(Restrictions.eq(colname, colvalue));
		return this.getByUniqueIndex(detachedCriteria);
	}
	
}