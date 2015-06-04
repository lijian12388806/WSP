package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the CALLDETAIL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CALLDETAIL"
 */

public abstract class BaseCalldetail  implements Serializable {

	public static String REF = "Calldetail";
	public static String PROP_N1 = "N1";
	public static String PROP_CREATETYPE = "Createtype";
	public static String PROP_LEAVETIME = "Leavetime";
	public static String PROP_N2 = "N2";
	public static String PROP_UCID = "Ucid";
	public static String PROP_CALLINTIME = "Callintime";
	public static String PROP_AGENTID = "Agentid";
	public static String PROP_BUSITYPE = "Busitype";
	public static String PROP_SVRRESULT = "Svrresult";
	public static String PROP_CALLDETAILID = "Calldetailid";
	public static String PROP_ANICITY = "Anicity";
	public static String PROP_ISLOST = "Islost";
	public static String PROP_N3 = "N3";
	public static String PROP_ANI = "Ani";
	public static String PROP_ANIAREA = "Aniarea";
	public static String PROP_ID = "Id";


	// constructors
	public BaseCalldetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCalldetail (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCalldetail (
		java.lang.String id,
		java.lang.String calldetailid) {

		this.setId(id);
		this.setCalldetailid(calldetailid);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String calldetailid;
	private java.lang.String callintime;
	private java.lang.String ani;
	private java.lang.String aniarea;
	private java.lang.String anicity;
	private java.lang.String busitype;
	private java.lang.String svrresult;
	private java.lang.String leavetime;
	private java.lang.String ucid;
	private java.lang.String createtype;
	private java.lang.String islost;
	private java.lang.String agentid;
	private java.lang.String n1;
	private java.lang.String n2;
	private java.lang.String n3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_CALLDETAIL"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: CALLDETAILID
	 */
	public java.lang.String getCalldetailid () {
		return calldetailid;
	}

	/**
	 * Set the value related to the column: CALLDETAILID
	 * @param calldetailid the CALLDETAILID value
	 */
	public void setCalldetailid (java.lang.String calldetailid) {
		this.calldetailid = calldetailid;
	}



	/**
	 * Return the value associated with the column: CALLINTIME
	 */
	public java.lang.String getCallintime () {
		return callintime;
	}

	/**
	 * Set the value related to the column: CALLINTIME
	 * @param callintime the CALLINTIME value
	 */
	public void setCallintime (java.lang.String callintime) {
		this.callintime = callintime;
	}



	/**
	 * Return the value associated with the column: ANI
	 */
	public java.lang.String getAni () {
		return ani;
	}

	/**
	 * Set the value related to the column: ANI
	 * @param ani the ANI value
	 */
	public void setAni (java.lang.String ani) {
		this.ani = ani;
	}



	/**
	 * Return the value associated with the column: ANIAREA
	 */
	public java.lang.String getAniarea () {
		return aniarea;
	}

	/**
	 * Set the value related to the column: ANIAREA
	 * @param aniarea the ANIAREA value
	 */
	public void setAniarea (java.lang.String aniarea) {
		this.aniarea = aniarea;
	}



	/**
	 * Return the value associated with the column: ANICITY
	 */
	public java.lang.String getAnicity () {
		return anicity;
	}

	/**
	 * Set the value related to the column: ANICITY
	 * @param anicity the ANICITY value
	 */
	public void setAnicity (java.lang.String anicity) {
		this.anicity = anicity;
	}



	/**
	 * Return the value associated with the column: BUSITYPE
	 */
	public java.lang.String getBusitype () {
		return busitype;
	}

	/**
	 * Set the value related to the column: BUSITYPE
	 * @param busitype the BUSITYPE value
	 */
	public void setBusitype (java.lang.String busitype) {
		this.busitype = busitype;
	}



	/**
	 * Return the value associated with the column: SVRRESULT
	 */
	public java.lang.String getSvrresult () {
		return svrresult;
	}

	/**
	 * Set the value related to the column: SVRRESULT
	 * @param svrresult the SVRRESULT value
	 */
	public void setSvrresult (java.lang.String svrresult) {
		this.svrresult = svrresult;
	}



	/**
	 * Return the value associated with the column: LEAVETIME
	 */
	public java.lang.String getLeavetime () {
		return leavetime;
	}

	/**
	 * Set the value related to the column: LEAVETIME
	 * @param leavetime the LEAVETIME value
	 */
	public void setLeavetime (java.lang.String leavetime) {
		this.leavetime = leavetime;
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
	 * Return the value associated with the column: ISLOST
	 */
	public java.lang.String getIslost () {
		return islost;
	}

	/**
	 * Set the value related to the column: ISLOST
	 * @param islost the ISLOST value
	 */
	public void setIslost (java.lang.String islost) {
		this.islost = islost;
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
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Calldetail)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Calldetail calldetail = (com.liveneo.plat.hibernate.dao.Calldetail) obj;
			if (null == this.getId() || null == calldetail.getId()) return false;
			else return (this.getId().equals(calldetail.getId()));
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