package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the userinfo table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="userinfo"
 */

public abstract class BaseUserinfo  implements Serializable {

	public static String REF = "Userinfo";
	public static String PROP_DELFLAG = "Delflag";
	public static String PROP_AUTHADDR = "Authaddr";
	public static String PROP_AGENTNO = "Agentno";
	public static String PROP_AGENTTYPE = "Agenttype";
	public static String PROP_TEMP5 = "Temp5";
	public static String PROP_TEMP4 = "Temp4";
	public static String PROP_AGENTNAME = "Agentname";
	public static String PROP_AGENTSTATUS = "Agentstatus";
	public static String PROP_PK_WORKSTATION = "PkWorkstation";
	public static String PROP_CTIADDRBAK = "Ctiaddrbak";
	public static String PROP_PHONENO = "Phoneno";
	public static String PROP_ISADMIN = "Isadmin";
	public static String PROP_PK_DEPARTMENT = "PkDepartment";
	public static String PROP_FACTORY = "Factory";
	public static String PROP_CTIPWD = "Ctipwd";
	public static String PROP_LASTLOGINTIME = "Lastlogintime";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_TEMP3 = "Temp3";
	public static String PROP_AGENTEMAIL = "Agentemail";
	public static String PROP_CTIADDR = "Ctiaddr";
	public static String PROP_EXTNO = "Extno";
	public static String PROP_USERNAME = "Username";
	public static String PROP_POSITION = "Position";
	public static String PROP_ID = "Id";
	public static String PROP_AUTHTYPE = "Authtype";
	public static String PROP_REMARK = "Remark";
	public static String PROP_USERPWD = "Userpwd";
	public static String PROP_AUTOREPORT = "Autoreport";
	public static String PROP_USERSTATUS = "Userstatus";


	// constructors
	public BaseUserinfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserinfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String username;
	private java.lang.String userpwd;
	private java.lang.String isadmin;
	private java.lang.String remark;
	private java.lang.String factory;
	private java.lang.String agentno;
	private java.lang.String ctipwd;
	private java.lang.String extno;
	private java.lang.String agentname;
	private java.lang.String agentemail;
	private java.lang.String phoneno;
	private java.lang.String agentstatus;
	private java.util.Date lastlogintime;
	private java.lang.String agenttype;
	private java.lang.String position;
	private java.lang.String userstatus;
	private java.lang.String delflag;
	private java.lang.String ctiaddr;
	private java.lang.String ctiaddrbak;
	private java.lang.String authaddr;
	private java.lang.String authtype;
	private java.lang.String temp1;
	private java.lang.String temp2;
	private java.lang.String temp3;
	private java.lang.String temp4;
	private java.lang.String temp5;
	private java.lang.String autoreport;

	// many to one
	private com.liveneo.plat.hibernate.dao.Department pkDepartment;
	private com.liveneo.plat.hibernate.dao.Workstation pkWorkstation;

	// collections
	private java.util.Set<com.liveneo.plat.hibernate.dao.Workorder> wORKORDERs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="PK_USERINFO"
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
	 * Return the value associated with the column: USERNAME
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: USERNAME
	 * @param username the USERNAME value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
	}



	/**
	 * Return the value associated with the column: USERPWD
	 */
	public java.lang.String getUserpwd () {
		return userpwd;
	}

	/**
	 * Set the value related to the column: USERPWD
	 * @param userpwd the USERPWD value
	 */
	public void setUserpwd (java.lang.String userpwd) {
		this.userpwd = userpwd;
	}



	/**
	 * Return the value associated with the column: ISADMIN
	 */
	public java.lang.String getIsadmin () {
		return isadmin;
	}

	/**
	 * Set the value related to the column: ISADMIN
	 * @param isadmin the ISADMIN value
	 */
	public void setIsadmin (java.lang.String isadmin) {
		this.isadmin = isadmin;
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
	 * Return the value associated with the column: FACTORY
	 */
	public java.lang.String getFactory () {
		return factory;
	}

	/**
	 * Set the value related to the column: FACTORY
	 * @param factory the FACTORY value
	 */
	public void setFactory (java.lang.String factory) {
		this.factory = factory;
	}



	/**
	 * Return the value associated with the column: AGENTNO
	 */
	public java.lang.String getAgentno () {
		return agentno;
	}

	/**
	 * Set the value related to the column: AGENTNO
	 * @param agentno the AGENTNO value
	 */
	public void setAgentno (java.lang.String agentno) {
		this.agentno = agentno;
	}



	/**
	 * Return the value associated with the column: CTIPWD
	 */
	public java.lang.String getCtipwd () {
		return ctipwd;
	}

	/**
	 * Set the value related to the column: CTIPWD
	 * @param ctipwd the CTIPWD value
	 */
	public void setCtipwd (java.lang.String ctipwd) {
		this.ctipwd = ctipwd;
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
	 * Return the value associated with the column: AGENTNAME
	 */
	public java.lang.String getAgentname () {
		return agentname;
	}

	/**
	 * Set the value related to the column: AGENTNAME
	 * @param agentname the AGENTNAME value
	 */
	public void setAgentname (java.lang.String agentname) {
		this.agentname = agentname;
	}



	/**
	 * Return the value associated with the column: AGENTEMAIL
	 */
	public java.lang.String getAgentemail () {
		return agentemail;
	}

	/**
	 * Set the value related to the column: AGENTEMAIL
	 * @param agentemail the AGENTEMAIL value
	 */
	public void setAgentemail (java.lang.String agentemail) {
		this.agentemail = agentemail;
	}



	/**
	 * Return the value associated with the column: PHONENO
	 */
	public java.lang.String getPhoneno () {
		return phoneno;
	}

	/**
	 * Set the value related to the column: PHONENO
	 * @param phoneno the PHONENO value
	 */
	public void setPhoneno (java.lang.String phoneno) {
		this.phoneno = phoneno;
	}



	/**
	 * Return the value associated with the column: AGENTSTATUS
	 */
	public java.lang.String getAgentstatus () {
		return agentstatus;
	}

	/**
	 * Set the value related to the column: AGENTSTATUS
	 * @param agentstatus the AGENTSTATUS value
	 */
	public void setAgentstatus (java.lang.String agentstatus) {
		this.agentstatus = agentstatus;
	}



	/**
	 * Return the value associated with the column: LASTLOGINTIME
	 */
	public java.util.Date getLastlogintime () {
		return lastlogintime;
	}

	/**
	 * Set the value related to the column: LASTLOGINTIME
	 * @param lastlogintime the LASTLOGINTIME value
	 */
	public void setLastlogintime (java.util.Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}



	/**
	 * Return the value associated with the column: AGENTTYPE
	 */
	public java.lang.String getAgenttype () {
		return agenttype;
	}

	/**
	 * Set the value related to the column: AGENTTYPE
	 * @param agenttype the AGENTTYPE value
	 */
	public void setAgenttype (java.lang.String agenttype) {
		this.agenttype = agenttype;
	}



	/**
	 * Return the value associated with the column: POSITION
	 */
	public java.lang.String getPosition () {
		return position;
	}

	/**
	 * Set the value related to the column: POSITION
	 * @param position the POSITION value
	 */
	public void setPosition (java.lang.String position) {
		this.position = position;
	}



	/**
	 * Return the value associated with the column: USERSTATUS
	 */
	public java.lang.String getUserstatus () {
		return userstatus;
	}

	/**
	 * Set the value related to the column: USERSTATUS
	 * @param userstatus the USERSTATUS value
	 */
	public void setUserstatus (java.lang.String userstatus) {
		this.userstatus = userstatus;
	}



	/**
	 * Return the value associated with the column: DELFLAG
	 */
	public java.lang.String getDelflag () {
		return delflag;
	}

	/**
	 * Set the value related to the column: DELFLAG
	 * @param delflag the DELFLAG value
	 */
	public void setDelflag (java.lang.String delflag) {
		this.delflag = delflag;
	}



	/**
	 * Return the value associated with the column: CTIADDR
	 */
	public java.lang.String getCtiaddr () {
		return ctiaddr;
	}

	/**
	 * Set the value related to the column: CTIADDR
	 * @param ctiaddr the CTIADDR value
	 */
	public void setCtiaddr (java.lang.String ctiaddr) {
		this.ctiaddr = ctiaddr;
	}



	/**
	 * Return the value associated with the column: CTIADDRBAK
	 */
	public java.lang.String getCtiaddrbak () {
		return ctiaddrbak;
	}

	/**
	 * Set the value related to the column: CTIADDRBAK
	 * @param ctiaddrbak the CTIADDRBAK value
	 */
	public void setCtiaddrbak (java.lang.String ctiaddrbak) {
		this.ctiaddrbak = ctiaddrbak;
	}



	/**
	 * Return the value associated with the column: AUTHADDR
	 */
	public java.lang.String getAuthaddr () {
		return authaddr;
	}

	/**
	 * Set the value related to the column: AUTHADDR
	 * @param authaddr the AUTHADDR value
	 */
	public void setAuthaddr (java.lang.String authaddr) {
		this.authaddr = authaddr;
	}



	/**
	 * Return the value associated with the column: AUTHTYPE
	 */
	public java.lang.String getAuthtype () {
		return authtype;
	}

	/**
	 * Set the value related to the column: AUTHTYPE
	 * @param authtype the AUTHTYPE value
	 */
	public void setAuthtype (java.lang.String authtype) {
		this.authtype = authtype;
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
	 * Return the value associated with the column: AUTOREPORT
	 */
	public java.lang.String getAutoreport () {
		return autoreport;
	}

	/**
	 * Set the value related to the column: AUTOREPORT
	 * @param autoreport the AUTOREPORT value
	 */
	public void setAutoreport (java.lang.String autoreport) {
		this.autoreport = autoreport;
	}



	/**
	 * Return the value associated with the column: PK_DEPARTMENT
	 */
	public com.liveneo.plat.hibernate.dao.Department getPkDepartment () {
		return pkDepartment;
	}

	/**
	 * Set the value related to the column: PK_DEPARTMENT
	 * @param pkDepartment the PK_DEPARTMENT value
	 */
	public void setPkDepartment (com.liveneo.plat.hibernate.dao.Department pkDepartment) {
		this.pkDepartment = pkDepartment;
	}



	/**
	 * Return the value associated with the column: PK_WORKSTATION
	 */
	public com.liveneo.plat.hibernate.dao.Workstation getPkWorkstation () {
		return pkWorkstation;
	}

	/**
	 * Set the value related to the column: PK_WORKSTATION
	 * @param pkWorkstation the PK_WORKSTATION value
	 */
	public void setPkWorkstation (com.liveneo.plat.hibernate.dao.Workstation pkWorkstation) {
		this.pkWorkstation = pkWorkstation;
	}



	/**
	 * Return the value associated with the column: WORKORDERs
	 */
	public java.util.Set<com.liveneo.plat.hibernate.dao.Workorder> getWORKORDERs () {
		return wORKORDERs;
	}

	/**
	 * Set the value related to the column: WORKORDERs
	 * @param wORKORDERs the WORKORDERs value
	 */
	public void setWORKORDERs (java.util.Set<com.liveneo.plat.hibernate.dao.Workorder> wORKORDERs) {
		this.wORKORDERs = wORKORDERs;
	}

	public void addToWORKORDERs (com.liveneo.plat.hibernate.dao.Workorder workorder) {
		if (null == getWORKORDERs()) setWORKORDERs(new java.util.TreeSet<com.liveneo.plat.hibernate.dao.Workorder>());
		getWORKORDERs().add(workorder);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Userinfo)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Userinfo userinfo = (com.liveneo.plat.hibernate.dao.Userinfo) obj;
			if (null == this.getId() || null == userinfo.getId()) return false;
			else return (this.getId().equals(userinfo.getId()));
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