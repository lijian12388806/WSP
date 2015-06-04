package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the DEPARTMENT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="DEPARTMENT"
 */

public abstract class BaseDepartment  implements Serializable {

	public static String REF = "Department";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_TEMP3 = "Temp3";
	public static String PROP_SPK_DEPARTMENT = "SpkDepartment";
	public static String PROP_DEPNAME = "Depname";
	public static String PROP_ID = "Id";
	public static String PROP_TEMP4 = "Temp4";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseDepartment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDepartment (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String depname;
	private java.lang.String remark;
	private java.lang.Integer spkDepartment;
	private java.lang.String temp1;
	private java.lang.String temp2;
	private java.lang.String temp3;
	private java.lang.String temp4;

	// collections
	private java.util.Set<com.liveneo.plat.hibernate.dao.Userinfo> userinfos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_DEPARTMENT"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: DEPNAME
	 */
	public java.lang.String getDepname () {
		return depname;
	}

	/**
	 * Set the value related to the column: DEPNAME
	 * @param depname the DEPNAME value
	 */
	public void setDepname (java.lang.String depname) {
		this.depname = depname;
	}



	/**
	 * Return the value associated with the column: REMARK
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: REMARK
	 * @param remark the REMARK value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: SPK_DEPARTMENT
	 */
	public java.lang.Integer getSpkDepartment () {
		return spkDepartment;
	}

	/**
	 * Set the value related to the column: SPK_DEPARTMENT
	 * @param spkDepartment the SPK_DEPARTMENT value
	 */
	public void setSpkDepartment (java.lang.Integer spkDepartment) {
		this.spkDepartment = spkDepartment;
	}



	/**
	 * Return the value associated with the column: TEMP1
	 */
	public java.lang.String getTemp1 () {
		return temp1;
	}

	/**
	 * Set the value related to the column: TEMP1
	 * @param temp1 the TEMP1 value
	 */
	public void setTemp1 (java.lang.String temp1) {
		this.temp1 = temp1;
	}



	/**
	 * Return the value associated with the column: TEMP2
	 */
	public java.lang.String getTemp2 () {
		return temp2;
	}

	/**
	 * Set the value related to the column: TEMP2
	 * @param temp2 the TEMP2 value
	 */
	public void setTemp2 (java.lang.String temp2) {
		this.temp2 = temp2;
	}



	/**
	 * Return the value associated with the column: TEMP3
	 */
	public java.lang.String getTemp3 () {
		return temp3;
	}

	/**
	 * Set the value related to the column: TEMP3
	 * @param temp3 the TEMP3 value
	 */
	public void setTemp3 (java.lang.String temp3) {
		this.temp3 = temp3;
	}



	/**
	 * Return the value associated with the column: TEMP4
	 */
	public java.lang.String getTemp4 () {
		return temp4;
	}

	/**
	 * Set the value related to the column: TEMP4
	 * @param temp4 the TEMP4 value
	 */
	public void setTemp4 (java.lang.String temp4) {
		this.temp4 = temp4;
	}



	/**
	 * Return the value associated with the column: Userinfos
	 */
	public java.util.Set<com.liveneo.plat.hibernate.dao.Userinfo> getUserinfos () {
		return userinfos;
	}

	/**
	 * Set the value related to the column: Userinfos
	 * @param userinfos the Userinfos value
	 */
	public void setUserinfos (java.util.Set<com.liveneo.plat.hibernate.dao.Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

	public void addToUserinfos (com.liveneo.plat.hibernate.dao.Userinfo userinfo) {
		if (null == getUserinfos()) setUserinfos(new java.util.TreeSet<com.liveneo.plat.hibernate.dao.Userinfo>());
		getUserinfos().add(userinfo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Department)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Department department = (com.liveneo.plat.hibernate.dao.Department) obj;
			if (null == this.getId() || null == department.getId()) return false;
			else return (this.getId().equals(department.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	 public String toString () {
		return super.toString();
	}



}