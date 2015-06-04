package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the kbms_klp table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="kbms_klp"
 */

public abstract class BaseKbmsKlp  implements Serializable {

	public static String REF = "KbmsKlp";
	public static String PROP_NAME = "Name";
	public static String PROP_CLASSID = "Classid";
	public static String PROP_ID = "Id";
	public static String PROP_CONTENT = "Content";
	public static String PROP_MODIFYDATE = "Modifydate";
	public static String PROP_CREATEDATE = "Createdate";
	public static String PROP_KIND = "Kind";


	// constructors
	public BaseKbmsKlp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseKbmsKlp (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer classid;
	private java.lang.String name;
	private java.lang.String kind;
	private java.util.Date createdate;
	private java.util.Date modifydate;
	private java.lang.String content;



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
	 * Return the value associated with the column: CLASSID
	 */
	public java.lang.Integer getClassid () {
		return classid;
	}

	/**
	 * Set the value related to the column: CLASSID
	 * @param classid the CLASSID value
	 */
	public void setClassid (java.lang.Integer classid) {
		this.classid = classid;
	}



	/**
	 * Return the value associated with the column: NAME
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: KIND
	 */
	public java.lang.String getKind () {
		return kind;
	}

	/**
	 * Set the value related to the column: KIND
	 * @param kind the KIND value
	 */
	public void setKind (java.lang.String kind) {
		this.kind = kind;
	}



	/**
	 * Return the value associated with the column: CREATEDATE
	 */
	public java.util.Date getCreatedate () {
		return createdate;
	}

	/**
	 * Set the value related to the column: CREATEDATE
	 * @param createdate the CREATEDATE value
	 */
	public void setCreatedate (java.util.Date createdate) {
		this.createdate = createdate;
	}



	/**
	 * Return the value associated with the column: MODIFYDATE
	 */
	public java.util.Date getModifydate () {
		return modifydate;
	}

	/**
	 * Set the value related to the column: MODIFYDATE
	 * @param modifydate the MODIFYDATE value
	 */
	public void setModifydate (java.util.Date modifydate) {
		this.modifydate = modifydate;
	}



	/**
	 * Return the value associated with the column: CONTENT
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: CONTENT
	 * @param content the CONTENT value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.KbmsKlp)) return false;
		else {
			com.liveneo.plat.hibernate.dao.KbmsKlp kbmsKlp = (com.liveneo.plat.hibernate.dao.KbmsKlp) obj;
			if (null == this.getId() || null == kbmsKlp.getId()) return false;
			else return (this.getId().equals(kbmsKlp.getId()));
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