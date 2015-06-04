package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the IVRVOICE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="IVRVOICE"
 */

public abstract class BaseIvrvoice  implements Serializable {

	public static String REF = "Ivrvoice";
	public static String PROP_LEAVEWORDNUM = "Leavewordnum";
	public static String PROP_FULLENDDATE = "Fullenddate";
	public static String PROP_STARTDATE = "Startdate";
	public static String PROP_UCID = "Ucid";
	public static String PROP_DNIS = "Dnis";
	public static String PROP_FULLSTARTDATE = "Fullstartdate";
	public static String PROP_ENDDATE = "Enddate";
	public static String PROP_N1 = "N1";
	public static String PROP_STARTTIME = "Starttime";
	public static String PROP_N3 = "N3";
	public static String PROP_SERVERIP = "Serverip";
	public static String PROP_N2 = "N2";
	public static String PROP_CREATE_DATE = "CreateDate";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_CALLERID = "Callerid";
	public static String PROP_ISCHECK = "Ischeck";
	public static String PROP_PROCESSRESULT = "Processresult";
	public static String PROP_ID = "Id";
	public static String PROP_ISNOTICE = "Isnotice";
	public static String PROP_ENDTIME = "Endtime";
	public static String PROP_VDUID = "Vduid";


	// constructors
	public BaseIvrvoice () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseIvrvoice (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseIvrvoice (
		java.lang.String id,
		java.lang.String leavewordnum) {

		this.setId(id);
		this.setLeavewordnum(leavewordnum);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String leavewordnum;
	private java.lang.String serverip;
	private java.lang.String callerid;
	private java.lang.String starttime;
	private java.lang.String endtime;
	private java.lang.String startdate;
	private java.lang.String enddate;
	private java.lang.String filename;
	private java.lang.String isnotice;
	private java.lang.String ischeck;
	private java.lang.String dnis;
	private java.lang.String createDate;
	private java.lang.String processresult;
	private java.lang.String ucid;
	private java.lang.String vduid;
	private java.lang.String n1;
	private java.lang.String n2;
	private java.lang.String n3;
	private java.lang.String fullstartdate;
	private java.lang.String fullenddate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_IVRVOICE"
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
	 * Return the value associated with the column: LEAVEWORDNUM
	 */
	public java.lang.String getLeavewordnum () {
		return leavewordnum;
	}

	/**
	 * Set the value related to the column: LEAVEWORDNUM
	 * @param leavewordnum the LEAVEWORDNUM value
	 */
	public void setLeavewordnum (java.lang.String leavewordnum) {
		this.leavewordnum = leavewordnum;
	}



	/**
	 * Return the value associated with the column: SERVERIP
	 */
	public java.lang.String getServerip () {
		return serverip;
	}

	/**
	 * Set the value related to the column: SERVERIP
	 * @param serverip the SERVERIP value
	 */
	public void setServerip (java.lang.String serverip) {
		this.serverip = serverip;
	}



	/**
	 * Return the value associated with the column: CALLERID
	 */
	public java.lang.String getCallerid () {
		return callerid;
	}

	/**
	 * Set the value related to the column: CALLERID
	 * @param callerid the CALLERID value
	 */
	public void setCallerid (java.lang.String callerid) {
		this.callerid = callerid;
	}



	/**
	 * Return the value associated with the column: STARTTIME
	 */
	public java.lang.String getStarttime () {
		return starttime;
	}

	/**
	 * Set the value related to the column: STARTTIME
	 * @param starttime the STARTTIME value
	 */
	public void setStarttime (java.lang.String starttime) {
		this.starttime = starttime;
	}



	/**
	 * Return the value associated with the column: ENDTIME
	 */
	public java.lang.String getEndtime () {
		return endtime;
	}

	/**
	 * Set the value related to the column: ENDTIME
	 * @param endtime the ENDTIME value
	 */
	public void setEndtime (java.lang.String endtime) {
		this.endtime = endtime;
	}



	/**
	 * Return the value associated with the column: STARTDATE
	 */
	public java.lang.String getStartdate () {
		return startdate;
	}

	/**
	 * Set the value related to the column: STARTDATE
	 * @param startdate the STARTDATE value
	 */
	public void setStartdate (java.lang.String startdate) {
		this.startdate = startdate;
	}



	/**
	 * Return the value associated with the column: ENDDATE
	 */
	public java.lang.String getEnddate () {
		return enddate;
	}

	/**
	 * Set the value related to the column: ENDDATE
	 * @param enddate the ENDDATE value
	 */
	public void setEnddate (java.lang.String enddate) {
		this.enddate = enddate;
	}



	/**
	 * Return the value associated with the column: FILENAME
	 */
	public java.lang.String getFilename () {
		return filename;
	}

	/**
	 * Set the value related to the column: FILENAME
	 * @param filename the FILENAME value
	 */
	public void setFilename (java.lang.String filename) {
		this.filename = filename;
	}



	/**
	 * Return the value associated with the column: ISNOTICE
	 */
	public java.lang.String getIsnotice () {
		return isnotice;
	}

	/**
	 * Set the value related to the column: ISNOTICE
	 * @param isnotice the ISNOTICE value
	 */
	public void setIsnotice (java.lang.String isnotice) {
		this.isnotice = isnotice;
	}



	/**
	 * Return the value associated with the column: ISCHECK
	 */
	public java.lang.String getIscheck () {
		return ischeck;
	}

	/**
	 * Set the value related to the column: ISCHECK
	 * @param ischeck the ISCHECK value
	 */
	public void setIscheck (java.lang.String ischeck) {
		this.ischeck = ischeck;
	}



	/**
	 * Return the value associated with the column: DNIS
	 */
	public java.lang.String getDnis () {
		return dnis;
	}

	/**
	 * Set the value related to the column: DNIS
	 * @param dnis the DNIS value
	 */
	public void setDnis (java.lang.String dnis) {
		this.dnis = dnis;
	}



	/**
	 * Return the value associated with the column: CREATE_DATE
	 */
	public java.lang.String getCreateDate () {
		return createDate;
	}

	/**
	 * Set the value related to the column: CREATE_DATE
	 * @param createDate the CREATE_DATE value
	 */
	public void setCreateDate (java.lang.String createDate) {
		this.createDate = createDate;
	}



	/**
	 * Return the value associated with the column: PROCESSRESULT
	 */
	public java.lang.String getProcessresult () {
		return processresult;
	}

	/**
	 * Set the value related to the column: PROCESSRESULT
	 * @param processresult the PROCESSRESULT value
	 */
	public void setProcessresult (java.lang.String processresult) {
		this.processresult = processresult;
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



	/**
	 * Return the value associated with the column: FULLSTARTDATE
	 */
	public java.lang.String getFullstartdate () {
		return fullstartdate;
	}

	/**
	 * Set the value related to the column: FULLSTARTDATE
	 * @param fullstartdate the FULLSTARTDATE value
	 */
	public void setFullstartdate (java.lang.String fullstartdate) {
		this.fullstartdate = fullstartdate;
	}



	/**
	 * Return the value associated with the column: FULLENDDATE
	 */
	public java.lang.String getFullenddate () {
		return fullenddate;
	}

	/**
	 * Set the value related to the column: FULLENDDATE
	 * @param fullenddate the FULLENDDATE value
	 */
	public void setFullenddate (java.lang.String fullenddate) {
		this.fullenddate = fullenddate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Ivrvoice)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Ivrvoice ivrvoice = (com.liveneo.plat.hibernate.dao.Ivrvoice) obj;
			if (null == this.getId() || null == ivrvoice.getId()) return false;
			else return (this.getId().equals(ivrvoice.getId()));
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