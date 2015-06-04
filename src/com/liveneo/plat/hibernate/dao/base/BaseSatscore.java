package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the SATSCORE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="SATSCORE"
 */

public abstract class BaseSatscore  implements Serializable {

	public static String REF = "Satscore";
	public static String PROP_CALLERNO = "Callerno";
	public static String PROP_SVCTIME = "Svctime";
	public static String PROP_AGENTID = "Agentid";
	public static String PROP_EXTNO = "Extno";
	public static String PROP_UCID = "Ucid";
	public static String PROP_SVCPOINT = "Svcpoint";
	public static String PROP_ID = "Id";
	public static String PROP_N1 = "N1";
	public static String PROP_N3 = "N3";
	public static String PROP_N2 = "N2";
	public static String PROP_VDUID = "Vduid";


	// constructors
	public BaseSatscore () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseSatscore (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseSatscore (
		java.lang.Integer id,
		java.lang.String ucid) {

		this.setId(id);
		this.setUcid(ucid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String ucid;
	private java.lang.String callerno;
	private java.lang.String agentid;
	private java.lang.String extno;
	private java.lang.String svctime;
	private java.lang.String svcpoint;
	private java.lang.String vduid;
	private java.lang.String n1;
	private java.lang.String n2;
	private java.lang.String n3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_SATSCORE"
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
	 * Return the value associated with the column: UCID
	 */
	public java.lang.String getUcid () {
		return ucid;
	}

	/**
	 * Set the value related to the column: UCID
	 * @param ucid the UCID value
	 */
	public void setUcid (java.lang.String ucid) {
		this.ucid = ucid;
	}



	/**
	 * Return the value associated with the column: CALLERNO
	 */
	public java.lang.String getCallerno () {
		return callerno;
	}

	/**
	 * Set the value related to the column: CALLERNO
	 * @param callerno the CALLERNO value
	 */
	public void setCallerno (java.lang.String callerno) {
		this.callerno = callerno;
	}



	/**
	 * Return the value associated with the column: AGENTID
	 */
	public java.lang.String getAgentid () {
		return agentid;
	}

	/**
	 * Set the value related to the column: AGENTID
	 * @param agentid the AGENTID value
	 */
	public void setAgentid (java.lang.String agentid) {
		this.agentid = agentid;
	}



	/**
	 * Return the value associated with the column: EXTNO
	 */
	public java.lang.String getExtno () {
		return extno;
	}

	/**
	 * Set the value related to the column: EXTNO
	 * @param extno the EXTNO value
	 */
	public void setExtno (java.lang.String extno) {
		this.extno = extno;
	}



	/**
	 * Return the value associated with the column: SVCTIME
	 */
	public java.lang.String getSvctime () {
		return svctime;
	}

	/**
	 * Set the value related to the column: SVCTIME
	 * @param svctime the SVCTIME value
	 */
	public void setSvctime (java.lang.String svctime) {
		this.svctime = svctime;
	}



	/**
	 * Return the value associated with the column: SVCPOINT
	 */
	public java.lang.String getSvcpoint () {
		return svcpoint;
	}

	/**
	 * Set the value related to the column: SVCPOINT
	 * @param svcpoint the SVCPOINT value
	 */
	public void setSvcpoint (java.lang.String svcpoint) {
		this.svcpoint = svcpoint;
	}



	/**
	 * Return the value associated with the column: VDUID
	 */
	public java.lang.String getVduid () {
		return vduid;
	}

	/**
	 * Set the value related to the column: VDUID
	 * @param vduid the VDUID value
	 */
	public void setVduid (java.lang.String vduid) {
		this.vduid = vduid;
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
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Satscore)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Satscore satscore = (com.liveneo.plat.hibernate.dao.Satscore) obj;
			if (null == this.getId() || null == satscore.getId()) return false;
			else return (this.getId().equals(satscore.getId()));
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