package com.liveneo.plat.hibernate.dao.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.liveneo.plat.hibernate.dao.dao.iface.BdDictdetailDAO;

import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseBdDictdetailDAO extends com.liveneo.plat.hibernate.dao.dao._RootDAO {

	public BaseBdDictdetailDAO () {}
	
	public BaseBdDictdetailDAO (Session session) {
		super(session);
	}

	// query name references


	public static BdDictdetailDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static BdDictdetailDAO getInstance () {
		if (null == instance) instance = new com.liveneo.plat.hibernate.dao.dao.BdDictdetailDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.liveneo.plat.hibernate.dao.BdDictdetail.class;
	}

    public Order getDefaultOrder () {
		return Order.asc("Title");
    }

	/**
	 * Cast the object as a com.liveneo.lcp.hibernate.dao.BdDictdetail
	 */
	public com.liveneo.plat.hibernate.dao.BdDictdetail cast (Object object) {
		return (com.liveneo.plat.hibernate.dao.BdDictdetail) object;
	}

	public com.liveneo.plat.hibernate.dao.BdDictdetail get(java.lang.Integer key)
	{
		return (com.liveneo.plat.hibernate.dao.BdDictdetail) get(getReferenceClass(), key);
	}

	public com.liveneo.plat.hibernate.dao.BdDictdetail get(java.lang.Integer key, Session s)
	{
		return (com.liveneo.plat.hibernate.dao.BdDictdetail) get(getReferenceClass(), key, s);
	}

	public com.liveneo.plat.hibernate.dao.BdDictdetail load(java.lang.Integer key)
	{
		return (com.liveneo.plat.hibernate.dao.BdDictdetail) load(getReferenceClass(), key);
	}

	public com.liveneo.plat.hibernate.dao.BdDictdetail load(java.lang.Integer key, Session s)
	{
		return (com.liveneo.plat.hibernate.dao.BdDictdetail) load(getReferenceClass(), key, s);
	}

	public com.liveneo.plat.hibernate.dao.BdDictdetail loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.liveneo.plat.hibernate.dao.BdDictdetail obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	 @SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.BdDictdetail> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	 @SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.BdDictdetail> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	 @SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.BdDictdetail> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}
	public java.util.List findByNamedQuery(String queryName,Object parameter) {
  		return getHibernateTemplate().findByNamedQuery(queryName, parameter);
 	}
	

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param bdDictdetail a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail)
	{
		return (java.lang.Integer) super.save(bdDictdetail);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param bdDictdetail a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail, Session s)
	{
		return (java.lang.Integer) save((Object) bdDictdetail, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param bdDictdetail a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail)
	{
		saveOrUpdate((Object) bdDictdetail);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param bdDictdetail a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail, Session s)
	{
		saveOrUpdate((Object) bdDictdetail, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param bdDictdetail a transient instance containing updated state
	 */
	public void update(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail) 
	{
		update((Object) bdDictdetail);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param bdDictdetail a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail, Session s)
	{
		update((Object) bdDictdetail, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param bdDictdetail the instance to be removed
	 */
	public void delete(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail)
	{
		delete((Object) bdDictdetail);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param bdDictdetail the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail, Session s)
	{
		delete((Object) bdDictdetail, s);
	}
	 /**
    	批量处理
    **/
    public int bulkUpdate(String queryString, Object[] values) {
		return super.bulkUpdate(queryString, values);
	}
	public int bulkUpdate(String queryString){
		return super.bulkUpdate(queryString);
	}
	public int bulkUpdate(String queryString, Object value){
		return super.bulkUpdate(queryString, value);
	}
	public Boolean updateFieldValueByQueryName( String queryName,
			 Object parameter, String fieldName,
			 Object fieldValue){
		try {	 
			String queryString = "Update com.liveneo.lcp.hibernate.dao.BdDictdetail Set "
				+ fieldName + " = ? Where " + queryName + "="+parameter;		
			 getHibernateTemplate().bulkUpdate(queryString, fieldValue);
			return true;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
	public Boolean updateFieldAddValueByQueryName( String queryName,
			 Object parameter, String fieldName,
			 Integer fieldValue){
		try {	 
			String queryString = "Update com.liveneo.lcp.hibernate.dao.BdDictdetail Set "
				+ fieldName + " = "+ fieldName + " + ? Where " + queryName + "="+parameter;		
			 getHibernateTemplate().bulkUpdate(queryString, fieldValue);
			return true;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
	public Boolean updateFieldAddValueByQueryName( String queryName,
			 Object parameter, String fieldName,
			 java.math.BigDecimal fieldValue){
		try {	 
			String queryString = "Update com.liveneo.lcp.hibernate.dao.BdDictdetail Set "
				+ fieldName + " = "+ fieldName + " + ? Where " + queryName + "="+parameter;		
			 getHibernateTemplate().bulkUpdate(queryString, fieldValue);
			return true;
		} catch (RuntimeException re) {			
			throw re;
		}
	}
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail, Session s)
	{
		refresh((Object) bdDictdetail, s);
	}


}