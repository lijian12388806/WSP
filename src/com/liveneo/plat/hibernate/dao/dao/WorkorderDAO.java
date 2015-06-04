package com.liveneo.plat.hibernate.dao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.liveneo.plat.hibernate.dao.base.BaseWorkorderDAO;
import com.liveneo.plat.web.form.CountRatioForm;


public class WorkorderDAO extends BaseWorkorderDAO implements com.liveneo.plat.hibernate.dao.dao.iface.WorkorderDAO {

	public WorkorderDAO () {}
	
	public WorkorderDAO (Session session) {
		super(session);
	}
	

    /**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.Workorder> findByCriteria(org.hibernate.criterion.DetachedCriteria detachedCriteria){
		return  getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	@SuppressWarnings("unchecked")
	public java.util.List<com.liveneo.plat.hibernate.dao.Workorder> findByCriteria(org.hibernate.criterion.DetachedCriteria detachedCriteria,int firstResult,int resultCount){
		return  getHibernateTemplate().findByCriteria(detachedCriteria,firstResult,resultCount);
	}
	
	public java.util.List findBySQL(String queryString) {
		return super.findBySQL(queryString);
	}
	public java.util.List findByNamedQuery(final String queryName,final Object parameter) {
  		final String queryString = "from com.liveneo.plat.hibernate.dao.Workorder where "
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
	public java.util.List findByExample(com.liveneo.plat.hibernate.dao.Workorder workorder) {
  		return getHibernateTemplate().findByExample(workorder);
    }
    public java.util.List findByHql(String hql){
			return  getHibernateTemplate().find(hql);
	}
	public	com.liveneo.plat.hibernate.dao.Workorder getByUniqueIndex(
			final DetachedCriteria detachedCriteria) {
		com.liveneo.plat.hibernate.dao.Workorder object = (com.liveneo.plat.hibernate.dao.Workorder) getHibernateTemplate()
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

	public com.liveneo.plat.hibernate.dao.Workorder getByUniqueIndex(
			String colname, Object colvalue) {
		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(com.liveneo.plat.hibernate.dao.Workorder.class);
		detachedCriteria.add(Restrictions.eq(colname, colvalue));
		return this.getByUniqueIndex(detachedCriteria);
	}
	public List<CountRatioForm> executeQuerySQlINDAO(String sql) throws SQLException {

		java.sql.Connection con = null;
		java.sql.Statement stm = null;
		try {

			con = this.getSession().connection();
			//con.setAutoCommit(false);
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			con.commit();
			List<CountRatioForm> countFormList = new ArrayList<CountRatioForm>();
			while(rs.next()) {
				CountRatioForm countRatioForm = new CountRatioForm();
				countRatioForm.setTotalCount(rs.getString("tcount"));  
				countRatioForm.setCloseCount(rs.getString("ccount"));
				countRatioForm.setUserName(rs.getString("username"));
				countRatioForm.setTotalTime(rs.getString("totaltime"));
				if(0 == rs.getInt("tcount")){
					countRatioForm.setRatio("0%");
					countRatioForm.setAveTime("0");
				}else{
					countRatioForm.setRatio(rs.getDouble("ccount")/rs.getDouble("tcount")*100+"%");
					countRatioForm.setAveTime(rs.getDouble("totaltime")/rs.getDouble("tcount")+"");
				}
				countFormList.add(countRatioForm);
			}
			return countFormList;
			//con.setAutoCommit(true);
		} catch (Exception ex) {
			System.out.println("关闭链接失败!"+ex);
			con.rollback();

		} finally {
			try {
				if (stm != null)
					stm.close();
				if (con != null)
					con.close();
			} catch (SQLException fe) {
				System.out.println("关闭链接失败!"+fe);

			}
		}
		return null;
	}

	public ResultSet executeQuerySQl(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}