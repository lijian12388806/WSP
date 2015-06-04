package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the bd_dictdetail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_dictdetail"
 */

public abstract class BaseBdDictdetail  implements Serializable {

	public static String REF = "BdDictdetail";
	public static String PROP_VALUE = "Value";
	public static String PROP_REMARK = "Remark";
	public static String PROP_PK_DICT = "PkDict";
	public static String PROP_CODE = "Code";
	public static String PROP_TITLE = "Title";
	public static String PROP_ID = "Id";
	public static String PROP_DEFAULTORDER = "Defaultorder";
	public static String PROP_ISVALID = "Isvalid";


	// constructors
	public BaseBdDictdetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdDictdetail (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdDictdetail (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.BdDict pkDict) {

		this.setId(id);
		this.setPkDict(pkDict);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String code;
	private java.lang.String title;
	private java.lang.String value;
	private java.lang.String isvalid;
	private java.lang.String remark;
	private java.lang.Integer defaultorder;

	// many to one
	private com.liveneo.plat.hibernate.dao.BdDict pkDict;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="PK_DICTDETAIL"
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
	 * Return the value associated with the column: CODE
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: CODE
	 * @param code the CODE value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
	}



	/**
	 * Return the value associated with the column: TITLE
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: TITLE
	 * @param title the TITLE value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: VALUE
	 */
	public java.lang.String getValue () {
		return value;
	}

	/**
	 * Set the value related to the column: VALUE
	 * @param value the VALUE value
	 */
	public void setValue (java.lang.String value) {
		this.value = value;
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
	 * Return the value associated with the column: DEFAULTORDER
	 */
	public java.lang.Integer getDefaultorder () {
		return defaultorder;
	}

	/**
	 * Set the value related to the column: DEFAULTORDER
	 * @param defaultorder the DEFAULTORDER value
	 */
	public void setDefaultorder (java.lang.Integer defaultorder) {
		this.defaultorder = defaultorder;
	}



	/**
	 * Return the value associated with the column: PK_DICT
	 */
	public com.liveneo.plat.hibernate.dao.BdDict getPkDict () {
		return pkDict;
	}

	/**
	 * Set the value related to the column: PK_DICT
	 * @param pkDict the PK_DICT value
	 */
	public void setPkDict (com.liveneo.plat.hibernate.dao.BdDict pkDict) {
		this.pkDict = pkDict;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.BdDictdetail)) return false;
		else {
			com.liveneo.plat.hibernate.dao.BdDictdetail bdDictdetail = (com.liveneo.plat.hibernate.dao.BdDictdetail) obj;
			if (null == this.getId() || null == bdDictdetail.getId()) return false;
			else return (this.getId().equals(bdDictdetail.getId()));
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