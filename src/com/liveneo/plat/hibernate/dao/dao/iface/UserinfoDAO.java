package com.liveneo.plat.hibernate.dao.dao.iface;

import java.io.Serializable;

public interface UserinfoDAO {
	public com.liveneo.plat.hibernate.dao.Userinfo get(java.lang.Integer key);

	public com.liveneo.plat.hibernate.dao.Userinfo load(java.lang.Integer key);

	public java.util.List<com.liveneo.plat.hibernate.dao.Userinfo> findAll ();


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param userinfo a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.liveneo.plat.hibernate.dao.Userinfo userinfo);

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param userinfo a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.liveneo.plat.hibernate.dao.Userinfo userinfo);

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param userinfo a transient instance containing updated state
	 */
	public void update(com.liveneo.plat.hibernate.dao.Userinfo userinfo);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id);

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param userinfo the instance to be removed
	 */
	public void delete(com.liveneo.plat.hibernate.dao.Userinfo userinfo);

    public java.util.List<com.liveneo.plat.hibernate.dao.Userinfo> findByCriteria(org.hibernate.criterion.DetachedCriteria detachedCriteria);
	public java.util.List<com.liveneo.plat.hibernate.dao.Userinfo> findByCriteria(org.hibernate.criterion.DetachedCriteria detachedCriteria,int firstResult,int resultCount);
	public int getCountByCriteria(final org.hibernate.criterion.DetachedCriteria detachedCriteria);
	public java.util.List findBySQL(String queryString);
	public java.util.List findByNamedQuery(final String queryName,final Object parameter);
	public java.util.List findByExample(com.liveneo.plat.hibernate.dao.Userinfo userinfo);
	public int bulkUpdate(String queryString, Object[] values);
	public int bulkUpdate(String queryString);
	public int bulkUpdate(String queryString, Object value);
	public Boolean updateFieldValueByQueryName( String queryName,
			 Object parameter, String fieldName,
			 Object fieldValue);
	public Boolean updateFieldAddValueByQueryName( String queryName,
			 Object parameter, String fieldName,
			 Integer fieldValue);
	public Boolean updateFieldAddValueByQueryName( String queryName,
			 Object parameter, String fieldName,
			 java.math.BigDecimal fieldValue);
	public java.util.List findByHql(String hql);
	public	com.liveneo.plat.hibernate.dao.Userinfo getByUniqueIndex(
			final org.hibernate.criterion.DetachedCriteria detachedCriteria) ;
    public com.liveneo.plat.hibernate.dao.Userinfo getByUniqueIndex(
			String colname, Object colvalue);	 		 		 
}