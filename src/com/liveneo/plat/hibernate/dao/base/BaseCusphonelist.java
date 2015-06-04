package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the CUSPHONELIST table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CUSPHONELIST"
 */

public abstract class BaseCusphonelist  implements Serializable {

	public static String REF = "Cusphonelist";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_TEMP3 = "Temp3";
	public static String PROP_NOLEVEL = "Nolevel";
	public static String PROP_SYNSTATUS = "Synstatus";
	public static String PROP_PHONENO = "Phoneno";
	public static String PROP_PK_CUSTOMERINFO = "PkCustomerinfo";
	public static String PROP_CUSTLINKNAME = "Custlinkname";
	public static String PROP_ID = "Id";
	public static String PROP_TEMP4 = "Temp4";
	public static String PROP_REMARK = "Remark";
	public static String PROP_UPDATETIME = "Updatetime";


	// constructors
	public BaseCusphonelist () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCusphonelist (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCusphonelist (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.Customerinfo pkCustomerinfo,
		java.util.Date updatetime) {

		this.setId(id);
		this.setPkCustomerinfo(pkCustomerinfo);
		this.setUpdatetime(updatetime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String custlinkname;
	private java.lang.String nolevel;
	private java.lang.String phoneno;
	private java.lang.String remark;
	private java.lang.String synstatus;
	private java.lang.String temp1;
	private java.lang.String temp2;
	private java.lang.String temp3;
	private java.lang.String temp4;
	private java.util.Date updatetime;

	// many to one
	private com.liveneo.plat.hibernate.dao.Customerinfo pkCustomerinfo;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_CUSPHONELIST"
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
	 * Return the value associated with the column: CUSTLINKNAME
	 */
	public java.lang.String getCustlinkname () {
		return custlinkname;
	}

	/**
	 * Set the value related to the column: CUSTLINKNAME
	 * @param custlinkname the CUSTLINKNAME value
	 */
	public void setCustlinkname (java.lang.String custlinkname) {
		this.custlinkname = custlinkname;
	}



	/**
	 * Return the value associated with the column: NOLEVEL
	 */
	public java.lang.String getNolevel () {
		return nolevel;
	}

	/**
	 * Set the value related to the column: NOLEVEL
	 * @param nolevel the NOLEVEL value
	 */
	public void setNolevel (java.lang.String nolevel) {
		this.nolevel = nolevel;
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
	 * Return the value associated with the column: SYNSTATUS
	 */
	public java.lang.String getSynstatus () {
		return synstatus;
	}

	/**
	 * Set the value related to the column: SYNSTATUS
	 * @param synstatus the SYNSTATUS value
	 */
	public void setSynstatus (java.lang.String synstatus) {
		this.synstatus = synstatus;
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
	 * Return the value associated with the column: UPDATETIME
	 */
	public java.util.Date getUpdatetime () {
		return updatetime;
	}

	/**
	 * Set the value related to the column: UPDATETIME
	 * @param updatetime the UPDATETIME value
	 */
	public void setUpdatetime (java.util.Date updatetime) {
		this.updatetime = updatetime;
	}



	/**
	 * Return the value associated with the column: PK_CUSTOMERINFO
	 */
	public com.liveneo.plat.hibernate.dao.Customerinfo getPkCustomerinfo () {
		return pkCustomerinfo;
	}

	/**
	 * Set the value related to the column: PK_CUSTOMERINFO
	 * @param pkCustomerinfo the PK_CUSTOMERINFO value
	 */
	public void setPkCustomerinfo (com.liveneo.plat.hibernate.dao.Customerinfo pkCustomerinfo) {
		this.pkCustomerinfo = pkCustomerinfo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Cusphonelist)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Cusphonelist cusphonelist = (com.liveneo.plat.hibernate.dao.Cusphonelist) obj;
			if (null == this.getId() || null == cusphonelist.getId()) return false;
			else return (this.getId().equals(cusphonelist.getId()));
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