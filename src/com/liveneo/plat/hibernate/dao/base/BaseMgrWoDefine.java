package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the mgr_wo_define table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mgr_wo_define"
 */

public abstract class BaseMgrWoDefine  implements Serializable {

	public static String REF = "MgrWoDefine";
	public static String PROP_DEF_COL_LMAX = "DefColLmax";
	public static String PROP_DEF_TYPE = "DefType";
	public static String PROP_DEF_COL_TITLE = "DefColTitle";
	public static String PROP_DEF_COL_LMIN = "DefColLmin";
	public static String PROP_DEF_CANEDIT = "DefCanedit";
	public static String PROP_DEF_COL_REGION = "DefColRegion";
	public static String PROP_DEF_COL_TYPE = "DefColType";
	public static String PROP_DEF_COL_ORDER = "DefColOrder";
	public static String PROP_DEF_COL_CLASS = "DefColClass";
	public static String PROP_DEF_COL = "DefCol";
	public static String PROP_ID = "Id";
	public static String PROP_PK_TEMPLET = "PkTemplet";
	public static String PROP_DEF_COL_FORMAT = "DefColFormat";
	public static String PROP_DEF_COL_REQUIRED = "DefColRequired";


	// constructors
	public BaseMgrWoDefine () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMgrWoDefine (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMgrWoDefine (
		java.lang.Integer id,
		java.lang.Integer pkTemplet) {

		this.setId(id);
		this.setPkTemplet(pkTemplet);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer pkTemplet;
	private java.lang.String defType;
	private java.lang.String defCol;
	private java.lang.String defCanedit;
	private java.lang.String defColTitle;
	private java.lang.String defColType;
	private java.lang.String defColFormat;
	private java.lang.String defColLmin;
	private java.lang.String defColLmax;
	private java.lang.String defColClass;
	private java.lang.String defColRequired;
	private java.lang.String defColRegion;
	private java.lang.Integer defColOrder;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
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
	 * Return the value associated with the column: PK_TEMPLET
	 */
	public java.lang.Integer getPkTemplet () {
		return pkTemplet;
	}

	/**
	 * Set the value related to the column: PK_TEMPLET
	 * @param pkTemplet the PK_TEMPLET value
	 */
	public void setPkTemplet (java.lang.Integer pkTemplet) {
		this.pkTemplet = pkTemplet;
	}



	/**
	 * Return the value associated with the column: DEF_TYPE
	 */
	public java.lang.String getDefType () {
		return defType;
	}

	/**
	 * Set the value related to the column: DEF_TYPE
	 * @param defType the DEF_TYPE value
	 */
	public void setDefType (java.lang.String defType) {
		this.defType = defType;
	}



	/**
	 * Return the value associated with the column: DEF_COL
	 */
	public java.lang.String getDefCol () {
		return defCol;
	}

	/**
	 * Set the value related to the column: DEF_COL
	 * @param defCol the DEF_COL value
	 */
	public void setDefCol (java.lang.String defCol) {
		this.defCol = defCol;
	}



	/**
	 * Return the value associated with the column: DEF_CANEDIT
	 */
	public java.lang.String getDefCanedit () {
		return defCanedit;
	}

	/**
	 * Set the value related to the column: DEF_CANEDIT
	 * @param defCanedit the DEF_CANEDIT value
	 */
	public void setDefCanedit (java.lang.String defCanedit) {
		this.defCanedit = defCanedit;
	}



	/**
	 * Return the value associated with the column: DEF_COL_TITLE
	 */
	public java.lang.String getDefColTitle () {
		return defColTitle;
	}

	/**
	 * Set the value related to the column: DEF_COL_TITLE
	 * @param defColTitle the DEF_COL_TITLE value
	 */
	public void setDefColTitle (java.lang.String defColTitle) {
		this.defColTitle = defColTitle;
	}



	/**
	 * Return the value associated with the column: DEF_COL_TYPE
	 */
	public java.lang.String getDefColType () {
		return defColType;
	}

	/**
	 * Set the value related to the column: DEF_COL_TYPE
	 * @param defColType the DEF_COL_TYPE value
	 */
	public void setDefColType (java.lang.String defColType) {
		this.defColType = defColType;
	}



	/**
	 * Return the value associated with the column: DEF_COL_FORMAT
	 */
	public java.lang.String getDefColFormat () {
		return defColFormat;
	}

	/**
	 * Set the value related to the column: DEF_COL_FORMAT
	 * @param defColFormat the DEF_COL_FORMAT value
	 */
	public void setDefColFormat (java.lang.String defColFormat) {
		this.defColFormat = defColFormat;
	}



	/**
	 * Return the value associated with the column: DEF_COL_LMIN
	 */
	public java.lang.String getDefColLmin () {
		return defColLmin;
	}

	/**
	 * Set the value related to the column: DEF_COL_LMIN
	 * @param defColLmin the DEF_COL_LMIN value
	 */
	public void setDefColLmin (java.lang.String defColLmin) {
		this.defColLmin = defColLmin;
	}



	/**
	 * Return the value associated with the column: DEF_COL_LMAX
	 */
	public java.lang.String getDefColLmax () {
		return defColLmax;
	}

	/**
	 * Set the value related to the column: DEF_COL_LMAX
	 * @param defColLmax the DEF_COL_LMAX value
	 */
	public void setDefColLmax (java.lang.String defColLmax) {
		this.defColLmax = defColLmax;
	}



	/**
	 * Return the value associated with the column: DEF_COL_CLASS
	 */
	public java.lang.String getDefColClass () {
		return defColClass;
	}

	/**
	 * Set the value related to the column: DEF_COL_CLASS
	 * @param defColClass the DEF_COL_CLASS value
	 */
	public void setDefColClass (java.lang.String defColClass) {
		this.defColClass = defColClass;
	}



	/**
	 * Return the value associated with the column: DEF_COL_REQUIRED
	 */
	public java.lang.String getDefColRequired () {
		return defColRequired;
	}

	/**
	 * Set the value related to the column: DEF_COL_REQUIRED
	 * @param defColRequired the DEF_COL_REQUIRED value
	 */
	public void setDefColRequired (java.lang.String defColRequired) {
		this.defColRequired = defColRequired;
	}



	/**
	 * Return the value associated with the column: DEF_COL_REGION
	 */
	public java.lang.String getDefColRegion () {
		return defColRegion;
	}

	/**
	 * Set the value related to the column: DEF_COL_REGION
	 * @param defColRegion the DEF_COL_REGION value
	 */
	public void setDefColRegion (java.lang.String defColRegion) {
		this.defColRegion = defColRegion;
	}



	/**
	 * Return the value associated with the column: DEF_COL_ORDER
	 */
	public java.lang.Integer getDefColOrder () {
		return defColOrder;
	}

	/**
	 * Set the value related to the column: DEF_COL_ORDER
	 * @param defColOrder the DEF_COL_ORDER value
	 */
	public void setDefColOrder (java.lang.Integer defColOrder) {
		this.defColOrder = defColOrder;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.MgrWoDefine)) return false;
		else {
			com.liveneo.plat.hibernate.dao.MgrWoDefine mgrWoDefine = (com.liveneo.plat.hibernate.dao.MgrWoDefine) obj;
			if (null == this.getId() || null == mgrWoDefine.getId()) return false;
			else return (this.getId().equals(mgrWoDefine.getId()));
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