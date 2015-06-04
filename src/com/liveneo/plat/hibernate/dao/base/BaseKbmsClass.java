package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the kbms_class table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="kbms_class"
 */

public abstract class BaseKbmsClass  implements Serializable {

	public static String REF = "KbmsClass";
	public static String PROP_ORD = "Ord";
	public static String PROP_ID = "Id";
	public static String PROP_PID = "Pid";
	public static String PROP_TITLE = "Title";


	// constructors
	public BaseKbmsClass () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseKbmsClass (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String title;
	private java.lang.String pid;
	private java.lang.String ord;



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
	 * Return the value associated with the column: PID
	 */
	public java.lang.String getPid () {
		return pid;
	}

	/**
	 * Set the value related to the column: PID
	 * @param pid the PID value
	 */
	public void setPid (java.lang.String pid) {
		this.pid = pid;
	}



	/**
	 * Return the value associated with the column: ORD
	 */
	public java.lang.String getOrd () {
		return ord;
	}

	/**
	 * Set the value related to the column: ORD
	 * @param ord the ORD value
	 */
	public void setOrd (java.lang.String ord) {
		this.ord = ord;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.KbmsClass)) return false;
		else {
			com.liveneo.plat.hibernate.dao.KbmsClass kbmsClass = (com.liveneo.plat.hibernate.dao.KbmsClass) obj;
			if (null == this.getId() || null == kbmsClass.getId()) return false;
			else return (this.getId().equals(kbmsClass.getId()));
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