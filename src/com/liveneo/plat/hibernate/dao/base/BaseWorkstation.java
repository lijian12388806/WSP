package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the WORKSTATION table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKSTATION"
 */

public abstract class BaseWorkstation  implements Serializable {

	public static String REF = "Workstation";
	public static String PROP_WSEMAIL = "Wsemail";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_WSADDR = "Wsaddr";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_TEMP3 = "Temp3";
	public static String PROP_FACTORYNAMECN = "Factorynamecn";
	public static String PROP_WSLINKMAN = "Wslinkman";
	public static String PROP_PHONENO = "Phoneno";
	public static String PROP_ID = "Id";
	public static String PROP_FACTORYNAMEEN = "Factorynameen";
	public static String PROP_TEMP4 = "Temp4";
	public static String PROP_REMARK = "Remark";


	// constructors
	public BaseWorkstation () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkstation (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String factorynamecn;
	private java.lang.String factorynameen;
	private java.lang.String phoneno;
	private java.lang.String remark;
	private java.lang.String temp1;
	private java.lang.String temp2;
	private java.lang.String temp3;
	private java.lang.String temp4;
	private java.lang.String wsaddr;
	private java.lang.String wsemail;
	private java.lang.String wslinkman;

	// collections
	private java.util.Set<com.liveneo.plat.hibernate.dao.Userinfo> userinfos;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_WORKSTATION"
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
	 * Return the value associated with the column: FACTORYNAMECN
	 */
	public java.lang.String getFactorynamecn () {
		return factorynamecn;
	}

	/**
	 * Set the value related to the column: FACTORYNAMECN
	 * @param factorynamecn the FACTORYNAMECN value
	 */
	public void setFactorynamecn (java.lang.String factorynamecn) {
		this.factorynamecn = factorynamecn;
	}



	/**
	 * Return the value associated with the column: FACTORYNAMEEN
	 */
	public java.lang.String getFactorynameen () {
		return factorynameen;
	}

	/**
	 * Set the value related to the column: FACTORYNAMEEN
	 * @param factorynameen the FACTORYNAMEEN value
	 */
	public void setFactorynameen (java.lang.String factorynameen) {
		this.factorynameen = factorynameen;
	}



	/**
	 * Return the value associated with the column: PHONENO
	 */
	public java.lang.String getPhoneno () {
		return phoneno;
	}

	/**
	 * Set the value related to the column: PHONENO
	 * @param phoneno the PHONENO value
	 */
	public void setPhoneno (java.lang.String phoneno) {
		this.phoneno = phoneno;
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
	 * Return the value associated with the column: WSADDR
	 */
	public java.lang.String getWsaddr () {
		return wsaddr;
	}

	/**
	 * Set the value related to the column: WSADDR
	 * @param wsaddr the WSADDR value
	 */
	public void setWsaddr (java.lang.String wsaddr) {
		this.wsaddr = wsaddr;
	}



	/**
	 * Return the value associated with the column: WSEMAIL
	 */
	public java.lang.String getWsemail () {
		return wsemail;
	}

	/**
	 * Set the value related to the column: WSEMAIL
	 * @param wsemail the WSEMAIL value
	 */
	public void setWsemail (java.lang.String wsemail) {
		this.wsemail = wsemail;
	}



	/**
	 * Return the value associated with the column: WSLINKMAN
	 */
	public java.lang.String getWslinkman () {
		return wslinkman;
	}

	/**
	 * Set the value related to the column: WSLINKMAN
	 * @param wslinkman the WSLINKMAN value
	 */
	public void setWslinkman (java.lang.String wslinkman) {
		this.wslinkman = wslinkman;
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
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Workstation)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Workstation workstation = (com.liveneo.plat.hibernate.dao.Workstation) obj;
			if (null == this.getId() || null == workstation.getId()) return false;
			else return (this.getId().equals(workstation.getId()));
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