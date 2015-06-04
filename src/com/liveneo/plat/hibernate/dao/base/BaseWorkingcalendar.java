package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the WORKINGCALENDAR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKINGCALENDAR"
 */

public abstract class BaseWorkingcalendar  implements Serializable {

	public static String REF = "Workingcalendar";
	public static String PROP_WORKINGDATE = "Workingdate";
	public static String PROP_ISVACATION = "Isvacation";
	public static String PROP_ID = "Id";
	public static String PROP_N1 = "N1";
	public static String PROP_REAMRK = "Reamrk";
	public static String PROP_N3 = "N3";
	public static String PROP_N2 = "N2";


	// constructors
	public BaseWorkingcalendar () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkingcalendar (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkingcalendar (
		java.lang.Integer id,
		java.lang.String workingdate,
		java.lang.String isvacation) {

		this.setId(id);
		this.setWorkingdate(workingdate);
		this.setIsvacation(isvacation);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String workingdate;
	private java.lang.String isvacation;
	private java.lang.String reamrk;
	private java.lang.String n1;
	private java.lang.String n2;
	private java.lang.String n3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_WORKINGCALENDAR"
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
	 * Return the value associated with the column: WORKINGDATE
	 */
	public java.lang.String getWorkingdate () {
		return workingdate;
	}

	/**
	 * Set the value related to the column: WORKINGDATE
	 * @param workingdate the WORKINGDATE value
	 */
	public void setWorkingdate (java.lang.String workingdate) {
		this.workingdate = workingdate;
	}



	/**
	 * Return the value associated with the column: ISVACATION
	 */
	public java.lang.String getIsvacation () {
		return isvacation;
	}

	/**
	 * Set the value related to the column: ISVACATION
	 * @param isvacation the ISVACATION value
	 */
	public void setIsvacation (java.lang.String isvacation) {
		this.isvacation = isvacation;
	}



	/**
	 * Return the value associated with the column: REAMRK
	 */
	public java.lang.String getReamrk () {
		return reamrk;
	}

	/**
	 * Set the value related to the column: REAMRK
	 * @param reamrk the REAMRK value
	 */
	public void setReamrk (java.lang.String reamrk) {
		this.reamrk = reamrk;
	}



	/**
	 * Return the value associated with the column: N1
	 */
	public java.lang.String getN1 () {
		return n1;
	}

	/**
	 * Set the value related to the column: N1
	 * @param n1 the N1 value
	 */
	public void setN1 (java.lang.String n1) {
		this.n1 = n1;
	}



	/**
	 * Return the value associated with the column: N2
	 */
	public java.lang.String getN2 () {
		return n2;
	}

	/**
	 * Set the value related to the column: N2
	 * @param n2 the N2 value
	 */
	public void setN2 (java.lang.String n2) {
		this.n2 = n2;
	}



	/**
	 * Return the value associated with the column: N3
	 */
	public java.lang.String getN3 () {
		return n3;
	}

	/**
	 * Set the value related to the column: N3
	 * @param n3 the N3 value
	 */
	public void setN3 (java.lang.String n3) {
		this.n3 = n3;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Workingcalendar)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Workingcalendar workingcalendar = (com.liveneo.plat.hibernate.dao.Workingcalendar) obj;
			if (null == this.getId() || null == workingcalendar.getId()) return false;
			else return (this.getId().equals(workingcalendar.getId()));
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