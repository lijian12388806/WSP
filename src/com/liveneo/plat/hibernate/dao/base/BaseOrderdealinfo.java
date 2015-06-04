package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the ORDERDEALINFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ORDERDEALINFO"
 */

public abstract class BaseOrderdealinfo  implements Serializable {

	public static String REF = "Orderdealinfo";
	public static String PROP_PROREASON = "Proreason";
	public static String PROP_PK_WORKORDER = "PkWorkorder";
	public static String PROP_PRODESC = "Prodesc";
	public static String PROP_TEMP6 = "Temp6";
	public static String PROP_TEMP5 = "Temp5";
	public static String PROP_TEMP4 = "Temp4";
	public static String PROP_ASSIGNPERSON = "Assignperson";
	public static String PROP_DEPDEALMAN = "Depdealman";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_WOSTATUS = "Wostatus";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_PRODEPARTMENT = "Prodepartment";
	public static String PROP_OCCTIME = "Occtime";
	public static String PROP_TEMP3 = "Temp3";
	public static String PROP_WORKORDERNO = "Workorderno";
	public static String PROP_DEALTIME = "Dealtime";
	public static String PROP_TYPEINPERSON = "Typeinperson";
	public static String PROP_CREATETYPE = "Createtype";
	public static String PROP_ID = "Id";
	public static String PROP_PROKEYWORD = "Prokeyword";
	public static String PROP_REMARK = "Remark";
	public static String PROP_PROSITUATION = "Prosituation";
	public static String PROP_TYPEINTIME = "Typeintime";


	// constructors
	public BaseOrderdealinfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrderdealinfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrderdealinfo (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.Workorder pkWorkorder) {

		this.setId(id);
		this.setPkWorkorder(pkWorkorder);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String workorderno;
	private java.lang.String prokeyword;
	private java.lang.String prodepartment;
	private java.lang.String depdealman;
	private java.lang.String prodesc;
	private java.lang.String proreason;
	private java.lang.String prosituation;
	private java.util.Date occtime;
	private java.util.Date dealtime;
	private java.lang.String typeinperson;
	private java.lang.String assignperson;
	private java.util.Date typeintime;
	private java.lang.String wostatus;
	private java.lang.String createtype;
	private java.lang.String remark;
	private java.lang.String temp1;
	private java.lang.String temp2;
	private java.lang.String temp3;
	private java.lang.String temp4;
	private java.lang.String temp5;
	private java.lang.String temp6;

	// many to one
	private com.liveneo.plat.hibernate.dao.Workorder pkWorkorder;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_ORDERDEALINFO"
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
	 * Return the value associated with the column: WORKORDERNO
	 */
	public java.lang.String getWorkorderno () {
		return workorderno;
	}

	/**
	 * Set the value related to the column: WORKORDERNO
	 * @param workorderno the WORKORDERNO value
	 */
	public void setWorkorderno (java.lang.String workorderno) {
		this.workorderno = workorderno;
	}



	/**
	 * Return the value associated with the column: PROKEYWORD
	 */
	public java.lang.String getProkeyword () {
		return prokeyword;
	}

	/**
	 * Set the value related to the column: PROKEYWORD
	 * @param prokeyword the PROKEYWORD value
	 */
	public void setProkeyword (java.lang.String prokeyword) {
		this.prokeyword = prokeyword;
	}



	/**
	 * Return the value associated with the column: PRODEPARTMENT
	 */
	public java.lang.String getProdepartment () {
		return prodepartment;
	}

	/**
	 * Set the value related to the column: PRODEPARTMENT
	 * @param prodepartment the PRODEPARTMENT value
	 */
	public void setProdepartment (java.lang.String prodepartment) {
		this.prodepartment = prodepartment;
	}



	/**
	 * Return the value associated with the column: DEPDEALMAN
	 */
	public java.lang.String getDepdealman () {
		return depdealman;
	}

	/**
	 * Set the value related to the column: DEPDEALMAN
	 * @param depdealman the DEPDEALMAN value
	 */
	public void setDepdealman (java.lang.String depdealman) {
		this.depdealman = depdealman;
	}



	/**
	 * Return the value associated with the column: PRODESC
	 */
	public java.lang.String getProdesc () {
		return prodesc;
	}

	/**
	 * Set the value related to the column: PRODESC
	 * @param prodesc the PRODESC value
	 */
	public void setProdesc (java.lang.String prodesc) {
		this.prodesc = prodesc;
	}



	/**
	 * Return the value associated with the column: PROREASON
	 */
	public java.lang.String getProreason () {
		return proreason;
	}

	/**
	 * Set the value related to the column: PROREASON
	 * @param proreason the PROREASON value
	 */
	public void setProreason (java.lang.String proreason) {
		this.proreason = proreason;
	}



	/**
	 * Return the value associated with the column: PROSITUATION
	 */
	public java.lang.String getProsituation () {
		return prosituation;
	}

	/**
	 * Set the value related to the column: PROSITUATION
	 * @param prosituation the PROSITUATION value
	 */
	public void setProsituation (java.lang.String prosituation) {
		this.prosituation = prosituation;
	}



	/**
	 * Return the value associated with the column: OCCTIME
	 */
	public java.util.Date getOcctime () {
		return occtime;
	}

	/**
	 * Set the value related to the column: OCCTIME
	 * @param occtime the OCCTIME value
	 */
	public void setOcctime (java.util.Date occtime) {
		this.occtime = occtime;
	}



	/**
	 * Return the value associated with the column: DEALTIME
	 */
	public java.util.Date getDealtime () {
		return dealtime;
	}

	/**
	 * Set the value related to the column: DEALTIME
	 * @param dealtime the DEALTIME value
	 */
	public void setDealtime (java.util.Date dealtime) {
		this.dealtime = dealtime;
	}



	/**
	 * Return the value associated with the column: TYPEINPERSON
	 */
	public java.lang.String getTypeinperson () {
		return typeinperson;
	}

	/**
	 * Set the value related to the column: TYPEINPERSON
	 * @param typeinperson the TYPEINPERSON value
	 */
	public void setTypeinperson (java.lang.String typeinperson) {
		this.typeinperson = typeinperson;
	}



	/**
	 * Return the value associated with the column: ASSIGNPERSON
	 */
	public java.lang.String getAssignperson () {
		return assignperson;
	}

	/**
	 * Set the value related to the column: ASSIGNPERSON
	 * @param assignperson the ASSIGNPERSON value
	 */
	public void setAssignperson (java.lang.String assignperson) {
		this.assignperson = assignperson;
	}



	/**
	 * Return the value associated with the column: TYPEINTIME
	 */
	public java.util.Date getTypeintime () {
		return typeintime;
	}

	/**
	 * Set the value related to the column: TYPEINTIME
	 * @param typeintime the TYPEINTIME value
	 */
	public void setTypeintime (java.util.Date typeintime) {
		this.typeintime = typeintime;
	}



	/**
	 * Return the value associated with the column: WOSTATUS
	 */
	public java.lang.String getWostatus () {
		return wostatus;
	}

	/**
	 * Set the value related to the column: WOSTATUS
	 * @param wostatus the WOSTATUS value
	 */
	public void setWostatus (java.lang.String wostatus) {
		this.wostatus = wostatus;
	}



	/**
	 * Return the value associated with the column: CREATETYPE
	 */
	public java.lang.String getCreatetype () {
		return createtype;
	}

	/**
	 * Set the value related to the column: CREATETYPE
	 * @param createtype the CREATETYPE value
	 */
	public void setCreatetype (java.lang.String createtype) {
		this.createtype = createtype;
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
	 * Return the value associated with the column: TEMP5
	 */
	public java.lang.String getTemp5 () {
		return temp5;
	}

	/**
	 * Set the value related to the column: TEMP5
	 * @param temp5 the TEMP5 value
	 */
	public void setTemp5 (java.lang.String temp5) {
		this.temp5 = temp5;
	}



	/**
	 * Return the value associated with the column: TEMP6
	 */
	public java.lang.String getTemp6 () {
		return temp6;
	}

	/**
	 * Set the value related to the column: TEMP6
	 * @param temp6 the TEMP6 value
	 */
	public void setTemp6 (java.lang.String temp6) {
		this.temp6 = temp6;
	}



	/**
	 * Return the value associated with the column: PK_WORKORDER
	 */
	public com.liveneo.plat.hibernate.dao.Workorder getPkWorkorder () {
		return pkWorkorder;
	}

	/**
	 * Set the value related to the column: PK_WORKORDER
	 * @param pkWorkorder the PK_WORKORDER value
	 */
	public void setPkWorkorder (com.liveneo.plat.hibernate.dao.Workorder pkWorkorder) {
		this.pkWorkorder = pkWorkorder;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Orderdealinfo)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Orderdealinfo orderdealinfo = (com.liveneo.plat.hibernate.dao.Orderdealinfo) obj;
			if (null == this.getId() || null == orderdealinfo.getId()) return false;
			else return (this.getId().equals(orderdealinfo.getId()));
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