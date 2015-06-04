package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the bd_dict table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_dict"
 */

public abstract class BaseBdDict  implements Serializable {

	public static String REF = "BdDict";
	public static String PROP_DICTCODE = "Dictcode";
	public static String PROP_TEMP = "Temp";
	public static String PROP_REMARK = "Remark";
	public static String PROP_DICTTYPE = "Dicttype";
	public static String PROP_DICTTITLE = "Dicttitle";
	public static String PROP_ID = "Id";
	public static String PROP_ISVALID = "Isvalid";


	// constructors
	public BaseBdDict () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdDict (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String dictcode;
	private java.lang.String dicttitle;
	private java.lang.String dicttype;
	private java.lang.String isvalid;
	private java.lang.String remark;
	private java.lang.String temp;

	// collections
	private java.util.Set<com.liveneo.plat.hibernate.dao.BdDictdetail> bdDictdetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="PK_DICT"
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
	 * Return the value associated with the column: DICTCODE
	 */
	public java.lang.String getDictcode () {
		return dictcode;
	}

	/**
	 * Set the value related to the column: DICTCODE
	 * @param dictcode the DICTCODE value
	 */
	public void setDictcode (java.lang.String dictcode) {
		this.dictcode = dictcode;
	}



	/**
	 * Return the value associated with the column: DICTTITLE
	 */
	public java.lang.String getDicttitle () {
		return dicttitle;
	}

	/**
	 * Set the value related to the column: DICTTITLE
	 * @param dicttitle the DICTTITLE value
	 */
	public void setDicttitle (java.lang.String dicttitle) {
		this.dicttitle = dicttitle;
	}



	/**
	 * Return the value associated with the column: DICTTYPE
	 */
	public java.lang.String getDicttype () {
		return dicttype;
	}

	/**
	 * Set the value related to the column: DICTTYPE
	 * @param dicttype the DICTTYPE value
	 */
	public void setDicttype (java.lang.String dicttype) {
		this.dicttype = dicttype;
	}



	/**
	 * Return the value associated with the column: ISVALID
	 */
	public java.lang.String getIsvalid () {
		return isvalid;
	}

	/**
	 * Set the value related to the column: ISVALID
	 * @param isvalid the ISVALID value
	 */
	public void setIsvalid (java.lang.String isvalid) {
		this.isvalid = isvalid;
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
	 * Return the value associated with the column: TEMP
	 */
	public java.lang.String getTemp () {
		return temp;
	}

	/**
	 * Set the value related to the column: TEMP
	 * @param temp the TEMP value
	 */
	public void setTemp (java.lang.String temp) {
		this.temp = temp;
	}



	/**
	 * Return the value associated with the column: BdDictdetails
	 */
	public java.util.Set<com.liveneo.plat.hibernate.dao.BdDictdetail> getBdDictdetails () {
		return bdDictdetails;
	}

	/**
	 * Set the value related to the column: BdDictdetails
	 * @param bdDictdetails the BdDictdetails value
	 */
	public void setBdDictdetails (java.util.Set<com.liveneo.plat.hibernate.dao.BdDictdetail> bdDictdetails) {
		this.bdDictdetails = bdDictdetails;
	}

	public void addToBdDictdetails (com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail) {
		if (null == getBdDictdetails()) setBdDictdetails(new java.util.TreeSet<com.liveneo.plat.hibernate.dao.BdDictdetail>());
		getBdDictdetails().add(bdDictdetail);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.BdDict)) return false;
		else {
			com.liveneo.plat.hibernate.dao.BdDict bdDict = (com.liveneo.plat.hibernate.dao.BdDict) obj;
			if (null == this.getId() || null == bdDict.getId()) return false;
			else return (this.getId().equals(bdDict.getId()));
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