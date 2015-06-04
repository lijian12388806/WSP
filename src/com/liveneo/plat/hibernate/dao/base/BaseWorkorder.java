package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the WORKORDER table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="WORKORDER"
 */

public abstract class BaseWorkorder  implements Serializable {

	public static String REF = "Workorder";
	public static String PROP_PROCODE = "Procode";
	public static String PROP_PROJECTTYPE = "Projecttype";
	public static String PROP_TEMP7 = "Temp7";
	public static String PROP_ACTUSERNAME = "Actusername";
	public static String PROP_TEMP6 = "Temp6";
	public static String PROP_TEMP5 = "Temp5";
	public static String PROP_GENERATEMODE = "Generatemode";
	public static String PROP_TEMP4 = "Temp4";
	public static String PROP_NEXTACTION = "Nextaction";
	public static String PROP_CUSTOMERNAME = "Customername";
	public static String PROP_PK_USERINFO = "PkUserinfo";
	public static String PROP_TEMP8 = "Temp8";
	public static String PROP_REMINDFLAG = "Remindflag";
	public static String PROP_PRONAME = "Proname";
	public static String PROP_WORKORDERNO = "Workorderno";
	public static String PROP_COMPLETEPERSON = "Completeperson";
	public static String PROP_CALLERNO = "Callerno";
	public static String PROP_DEALTIME = "Dealtime";
	public static String PROP_CONSULTCONTENT = "Consultcontent";
	public static String PROP_WORKITEM = "Workitem";
	public static String PROP_COMPLETETIME = "Completetime";
	public static String PROP_PK_CUSTOMERINFO = "PkCustomerinfo";
	public static String PROP_AUDITPERSON = "Auditperson";
	public static String PROP_ORDERSOURCE = "Ordersource";
	public static String PROP_WOSTATUS = "Wostatus";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_TEMP3 = "Temp3";
	public static String PROP_CALLTIME = "Calltime";
	public static String PROP_CUSTOMERNO = "Customerno";
	public static String PROP_ID = "Id";
	public static String PROP_AUDITTIME = "Audittime";
	public static String PROP_REMARK = "Remark";
	public static String PROP_ORDERTYPE = "Ordertype";


	// constructors
	public BaseWorkorder () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseWorkorder (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseWorkorder (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo) {

		this.setId(id);
		this.setPkUserinfo(pkUserinfo);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String workorderno;
	private java.lang.String customerno;
	private java.lang.String customername;
	private java.lang.String callerno;
	private java.lang.String wostatus;
	private java.lang.String ordertype;
	private java.lang.String projecttype;
	private java.lang.String workitem;
	private java.lang.String proname;
	private java.lang.String procode;
	private java.lang.String ordersource;
	private java.lang.String generatemode;
	private java.util.Date calltime;
	private java.util.Date dealtime;
	private java.lang.String auditperson;
	private java.util.Date audittime;
	private java.lang.String completeperson;
	private java.util.Date completetime;
	private java.lang.String remark;
	private java.lang.String consultcontent;
	private java.lang.String nextaction;
	private java.lang.String remindflag;
	private java.lang.String temp1;
	private java.lang.String temp2;
	private java.lang.String temp3;
	private java.lang.String temp4;
	private java.lang.String temp5;
	private java.lang.String temp6;
	private java.lang.String temp7;
	private java.lang.String temp8;
	private java.lang.String actusername;

	// many to one
	private com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo;
	private com.liveneo.plat.hibernate.dao.Customerinfo pkCustomerinfo;

	// collections
	private java.util.Set<com.liveneo.plat.hibernate.dao.Orderdealinfo> oRDERDEALINFOs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_WORKORDER"
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
	 * Return the value associated with the column: WORKORDERNO
	 */
	public java.lang.String getWorkorderno () {
		return workorderno;
	}

	/**
	 * Set the value related to the column: WORKORDERNO
	 * @param workorderno the WORKORDERNO value
	 */
	public void setWorkorderno (java.lang.String workorderno) {
		this.workorderno = workorderno;
	}



	/**
	 * Return the value associated with the column: CUSTOMERNO
	 */
	public java.lang.String getCustomerno () {
		return customerno;
	}

	/**
	 * Set the value related to the column: CUSTOMERNO
	 * @param customerno the CUSTOMERNO value
	 */
	public void setCustomerno (java.lang.String customerno) {
		this.customerno = customerno;
	}



	/**
	 * Return the value associated with the column: CUSTOMERNAME
	 */
	public java.lang.String getCustomername () {
		return customername;
	}

	/**
	 * Set the value related to the column: CUSTOMERNAME
	 * @param customername the CUSTOMERNAME value
	 */
	public void setCustomername (java.lang.String customername) {
		this.customername = customername;
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
	 * Return the value associated with the column: WOSTATUS
	 */
	public java.lang.String getWostatus () {
		return wostatus;
	}

	/**
	 * Set the value related to the column: WOSTATUS
	 * @param wostatus the WOSTATUS value
	 */
	public void setWostatus (java.lang.String wostatus) {
		this.wostatus = wostatus;
	}



	/**
	 * Return the value associated with the column: ORDERTYPE
	 */
	public java.lang.String getOrdertype () {
		return ordertype;
	}

	/**
	 * Set the value related to the column: ORDERTYPE
	 * @param ordertype the ORDERTYPE value
	 */
	public void setOrdertype (java.lang.String ordertype) {
		this.ordertype = ordertype;
	}



	/**
	 * Return the value associated with the column: PROJECTTYPE
	 */
	public java.lang.String getProjecttype () {
		return projecttype;
	}

	/**
	 * Set the value related to the column: PROJECTTYPE
	 * @param projecttype the PROJECTTYPE value
	 */
	public void setProjecttype (java.lang.String projecttype) {
		this.projecttype = projecttype;
	}



	/**
	 * Return the value associated with the column: WORKITEM
	 */
	public java.lang.String getWorkitem () {
		return workitem;
	}

	/**
	 * Set the value related to the column: WORKITEM
	 * @param workitem the WORKITEM value
	 */
	public void setWorkitem (java.lang.String workitem) {
		this.workitem = workitem;
	}



	/**
	 * Return the value associated with the column: PRONAME
	 */
	public java.lang.String getProname () {
		return proname;
	}

	/**
	 * Set the value related to the column: PRONAME
	 * @param proname the PRONAME value
	 */
	public void setProname (java.lang.String proname) {
		this.proname = proname;
	}



	/**
	 * Return the value associated with the column: PROCODE
	 */
	public java.lang.String getProcode () {
		return procode;
	}

	/**
	 * Set the value related to the column: PROCODE
	 * @param procode the PROCODE value
	 */
	public void setProcode (java.lang.String procode) {
		this.procode = procode;
	}



	/**
	 * Return the value associated with the column: ORDERSOURCE
	 */
	public java.lang.String getOrdersource () {
		return ordersource;
	}

	/**
	 * Set the value related to the column: ORDERSOURCE
	 * @param ordersource the ORDERSOURCE value
	 */
	public void setOrdersource (java.lang.String ordersource) {
		this.ordersource = ordersource;
	}



	/**
	 * Return the value associated with the column: GENERATEMODE
	 */
	public java.lang.String getGeneratemode () {
		return generatemode;
	}

	/**
	 * Set the value related to the column: GENERATEMODE
	 * @param generatemode the GENERATEMODE value
	 */
	public void setGeneratemode (java.lang.String generatemode) {
		this.generatemode = generatemode;
	}



	/**
	 * Return the value associated with the column: CALLTIME
	 */
	public java.util.Date getCalltime () {
		return calltime;
	}

	/**
	 * Set the value related to the column: CALLTIME
	 * @param calltime the CALLTIME value
	 */
	public void setCalltime (java.util.Date calltime) {
		this.calltime = calltime;
	}



	/**
	 * Return the value associated with the column: DEALTIME
	 */
	public java.util.Date getDealtime () {
		return dealtime;
	}

	/**
	 * Set the value related to the column: DEALTIME
	 * @param dealtime the DEALTIME value
	 */
	public void setDealtime (java.util.Date dealtime) {
		this.dealtime = dealtime;
	}



	/**
	 * Return the value associated with the column: AUDITPERSON
	 */
	public java.lang.String getAuditperson () {
		return auditperson;
	}

	/**
	 * Set the value related to the column: AUDITPERSON
	 * @param auditperson the AUDITPERSON value
	 */
	public void setAuditperson (java.lang.String auditperson) {
		this.auditperson = auditperson;
	}



	/**
	 * Return the value associated with the column: AUDITTIME
	 */
	public java.util.Date getAudittime () {
		return audittime;
	}

	/**
	 * Set the value related to the column: AUDITTIME
	 * @param audittime the AUDITTIME value
	 */
	public void setAudittime (java.util.Date audittime) {
		this.audittime = audittime;
	}



	/**
	 * Return the value associated with the column: COMPLETEPERSON
	 */
	public java.lang.String getCompleteperson () {
		return completeperson;
	}

	/**
	 * Set the value related to the column: COMPLETEPERSON
	 * @param completeperson the COMPLETEPERSON value
	 */
	public void setCompleteperson (java.lang.String completeperson) {
		this.completeperson = completeperson;
	}



	/**
	 * Return the value associated with the column: COMPLETETIME
	 */
	public java.util.Date getCompletetime () {
		return completetime;
	}

	/**
	 * Set the value related to the column: COMPLETETIME
	 * @param completetime the COMPLETETIME value
	 */
	public void setCompletetime (java.util.Date completetime) {
		this.completetime = completetime;
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
	 * Return the value associated with the column: CONSULTCONTENT
	 */
	public java.lang.String getConsultcontent () {
		return consultcontent;
	}

	/**
	 * Set the value related to the column: CONSULTCONTENT
	 * @param consultcontent the CONSULTCONTENT value
	 */
	public void setConsultcontent (java.lang.String consultcontent) {
		this.consultcontent = consultcontent;
	}



	/**
	 * Return the value associated with the column: NEXTACTION
	 */
	public java.lang.String getNextaction () {
		return nextaction;
	}

	/**
	 * Set the value related to the column: NEXTACTION
	 * @param nextaction the NEXTACTION value
	 */
	public void setNextaction (java.lang.String nextaction) {
		this.nextaction = nextaction;
	}



	/**
	 * Return the value associated with the column: REMINDFLAG
	 */
	public java.lang.String getRemindflag () {
		return remindflag;
	}

	/**
	 * Set the value related to the column: REMINDFLAG
	 * @param remindflag the REMINDFLAG value
	 */
	public void setRemindflag (java.lang.String remindflag) {
		this.remindflag = remindflag;
	}



	/**
	 * Return the value associated with the column: TEMP1
	 */
	public java.lang.String getTemp1 () {
		return temp1;
	}

	/**
	 * Set the value related to the column: TEMP1
	 * @param temp1 the TEMP1 value
	 */
	public void setTemp1 (java.lang.String temp1) {
		this.temp1 = temp1;
	}



	/**
	 * Return the value associated with the column: TEMP2
	 */
	public java.lang.String getTemp2 () {
		return temp2;
	}

	/**
	 * Set the value related to the column: TEMP2
	 * @param temp2 the TEMP2 value
	 */
	public void setTemp2 (java.lang.String temp2) {
		this.temp2 = temp2;
	}



	/**
	 * Return the value associated with the column: TEMP3
	 */
	public java.lang.String getTemp3 () {
		return temp3;
	}

	/**
	 * Set the value related to the column: TEMP3
	 * @param temp3 the TEMP3 value
	 */
	public void setTemp3 (java.lang.String temp3) {
		this.temp3 = temp3;
	}



	/**
	 * Return the value associated with the column: TEMP4
	 */
	public java.lang.String getTemp4 () {
		return temp4;
	}

	/**
	 * Set the value related to the column: TEMP4
	 * @param temp4 the TEMP4 value
	 */
	public void setTemp4 (java.lang.String temp4) {
		this.temp4 = temp4;
	}



	/**
	 * Return the value associated with the column: TEMP5
	 */
	public java.lang.String getTemp5 () {
		return temp5;
	}

	/**
	 * Set the value related to the column: TEMP5
	 * @param temp5 the TEMP5 value
	 */
	public void setTemp5 (java.lang.String temp5) {
		this.temp5 = temp5;
	}



	/**
	 * Return the value associated with the column: TEMP6
	 */
	public java.lang.String getTemp6 () {
		return temp6;
	}

	/**
	 * Set the value related to the column: TEMP6
	 * @param temp6 the TEMP6 value
	 */
	public void setTemp6 (java.lang.String temp6) {
		this.temp6 = temp6;
	}



	/**
	 * Return the value associated with the column: TEMP7
	 */
	public java.lang.String getTemp7 () {
		return temp7;
	}

	/**
	 * Set the value related to the column: TEMP7
	 * @param temp7 the TEMP7 value
	 */
	public void setTemp7 (java.lang.String temp7) {
		this.temp7 = temp7;
	}



	/**
	 * Return the value associated with the column: TEMP8
	 */
	public java.lang.String getTemp8 () {
		return temp8;
	}

	/**
	 * Set the value related to the column: TEMP8
	 * @param temp8 the TEMP8 value
	 */
	public void setTemp8 (java.lang.String temp8) {
		this.temp8 = temp8;
	}



	/**
	 * Return the value associated with the column: ACTUSERNAME
	 */
	public java.lang.String getActusername () {
		return actusername;
	}

	/**
	 * Set the value related to the column: ACTUSERNAME
	 * @param actusername the ACTUSERNAME value
	 */
	public void setActusername (java.lang.String actusername) {
		this.actusername = actusername;
	}



	/**
	 * Return the value associated with the column: PK_USERINFO
	 */
	public com.liveneo.plat.hibernate.dao.Userinfo getPkUserinfo () {
		return pkUserinfo;
	}

	/**
	 * Set the value related to the column: PK_USERINFO
	 * @param pkUserinfo the PK_USERINFO value
	 */
	public void setPkUserinfo (com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo) {
		this.pkUserinfo = pkUserinfo;
	}



	/**
	 * Return the value associated with the column: PK_CUSTOMERINFO
	 */
	public com.liveneo.plat.hibernate.dao.Customerinfo getPkCustomerinfo () {
		return pkCustomerinfo;
	}

	/**
	 * Set the value related to the column: PK_CUSTOMERINFO
	 * @param pkCustomerinfo the PK_CUSTOMERINFO value
	 */
	public void setPkCustomerinfo (com.liveneo.plat.hibernate.dao.Customerinfo pkCustomerinfo) {
		this.pkCustomerinfo = pkCustomerinfo;
	}



	/**
	 * Return the value associated with the column: ORDERDEALINFOs
	 */
	public java.util.Set<com.liveneo.plat.hibernate.dao.Orderdealinfo> getORDERDEALINFOs () {
		return oRDERDEALINFOs;
	}

	/**
	 * Set the value related to the column: ORDERDEALINFOs
	 * @param oRDERDEALINFOs the ORDERDEALINFOs value
	 */
	public void setORDERDEALINFOs (java.util.Set<com.liveneo.plat.hibernate.dao.Orderdealinfo> oRDERDEALINFOs) {
		this.oRDERDEALINFOs = oRDERDEALINFOs;
	}

	public void addToORDERDEALINFOs (com.liveneo.plat.hibernate.dao.Orderdealinfo orderdealinfo) {
		if (null == getORDERDEALINFOs()) setORDERDEALINFOs(new java.util.TreeSet<com.liveneo.plat.hibernate.dao.Orderdealinfo>());
		getORDERDEALINFOs().add(orderdealinfo);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Workorder)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Workorder workorder = (com.liveneo.plat.hibernate.dao.Workorder) obj;
			if (null == this.getId() || null == workorder.getId()) return false;
			else return (this.getId().equals(workorder.getId()));
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