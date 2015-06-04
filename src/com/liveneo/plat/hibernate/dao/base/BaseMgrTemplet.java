package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the mgr_templet table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mgr_templet"
 */

public abstract class BaseMgrTemplet  implements Serializable {

	public static String REF = "MgrTemplet";
	public static String PROP_TMP_LISTDATA = "TmpListdata";
	public static String PROP_TMP_TYPE = "TmpType";
	public static String PROP_TMP_NAME = "TmpName";
	public static String PROP_TMP_BTN = "TmpBtn";
	public static String PROP_TMP_RELATED = "TmpRelated";
	public static String PROP_ID = "Id";
	public static String PROP_TMP_CODE = "TmpCode";
	public static String PROP_TMP_STATUS = "TmpStatus";


	// constructors
	public BaseMgrTemplet () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMgrTemplet (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String tmpCode;
	private java.lang.String tmpName;
	private java.lang.String tmpType;
	private java.lang.String tmpStatus;
	private java.lang.String tmpBtn;
	private java.lang.String tmpListdata;
	private java.lang.String tmpRelated;



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
	 * Return the value associated with the column: TMP_CODE
	 */
	public java.lang.String getTmpCode () {
		return tmpCode;
	}

	/**
	 * Set the value related to the column: TMP_CODE
	 * @param tmpCode the TMP_CODE value
	 */
	public void setTmpCode (java.lang.String tmpCode) {
		this.tmpCode = tmpCode;
	}



	/**
	 * Return the value associated with the column: TMP_NAME
	 */
	public java.lang.String getTmpName () {
		return tmpName;
	}

	/**
	 * Set the value related to the column: TMP_NAME
	 * @param tmpName the TMP_NAME value
	 */
	public void setTmpName (java.lang.String tmpName) {
		this.tmpName = tmpName;
	}



	/**
	 * Return the value associated with the column: TMP_TYPE
	 */
	public java.lang.String getTmpType () {
		return tmpType;
	}

	/**
	 * Set the value related to the column: TMP_TYPE
	 * @param tmpType the TMP_TYPE value
	 */
	public void setTmpType (java.lang.String tmpType) {
		this.tmpType = tmpType;
	}



	/**
	 * Return the value associated with the column: TMP_STATUS
	 */
	public java.lang.String getTmpStatus () {
		return tmpStatus;
	}

	/**
	 * Set the value related to the column: TMP_STATUS
	 * @param tmpStatus the TMP_STATUS value
	 */
	public void setTmpStatus (java.lang.String tmpStatus) {
		this.tmpStatus = tmpStatus;
	}



	/**
	 * Return the value associated with the column: TMP_BTN
	 */
	public java.lang.String getTmpBtn () {
		return tmpBtn;
	}

	/**
	 * Set the value related to the column: TMP_BTN
	 * @param tmpBtn the TMP_BTN value
	 */
	public void setTmpBtn (java.lang.String tmpBtn) {
		this.tmpBtn = tmpBtn;
	}



	/**
	 * Return the value associated with the column: TMP_LISTDATA
	 */
	public java.lang.String getTmpListdata () {
		return tmpListdata;
	}

	/**
	 * Set the value related to the column: TMP_LISTDATA
	 * @param tmpListdata the TMP_LISTDATA value
	 */
	public void setTmpListdata (java.lang.String tmpListdata) {
		this.tmpListdata = tmpListdata;
	}



	/**
	 * Return the value associated with the column: TMP_RELATED
	 */
	public java.lang.String getTmpRelated () {
		return tmpRelated;
	}

	/**
	 * Set the value related to the column: TMP_RELATED
	 * @param tmpRelated the TMP_RELATED value
	 */
	public void setTmpRelated (java.lang.String tmpRelated) {
		this.tmpRelated = tmpRelated;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.MgrTemplet)) return false;
		else {
			com.liveneo.plat.hibernate.dao.MgrTemplet mgrTemplet = (com.liveneo.plat.hibernate.dao.MgrTemplet) obj;
			if (null == this.getId() || null == mgrTemplet.getId()) return false;
			else return (this.getId().equals(mgrTemplet.getId()));
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