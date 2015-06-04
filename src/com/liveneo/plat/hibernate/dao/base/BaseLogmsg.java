package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the logmsg table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="logmsg"
 */

public abstract class BaseLogmsg  implements Serializable {

	public static String REF = "Logmsg";
	public static String PROP_LOGTYPE = "Logtype";
	public static String PROP_LOGCONTENT = "Logcontent";
	public static String PROP_IP = "Ip";
	public static String PROP_ENTITYNAME = "Entityname";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_ID = "Id";
	public static String PROP_USERNAME = "Username";


	// constructors
	public BaseLogmsg () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLogmsg (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String username;
	private java.util.Date createtime;
	private java.lang.String ip;
	private java.lang.String logtype;
	private java.lang.String logcontent;
	private java.lang.String entityname;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="pk_logmsg"
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
	 * Return the value associated with the column: username
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: username
	 * @param username the username value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.util.Date getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.util.Date createtime) {
		this.createtime = createtime;
	}



	/**
	 * Return the value associated with the column: ip
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: ip
	 * @param ip the ip value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: logtype
	 */
	public java.lang.String getLogtype () {
		return logtype;
	}

	/**
	 * Set the value related to the column: logtype
	 * @param logtype the logtype value
	 */
	public void setLogtype (java.lang.String logtype) {
		this.logtype = logtype;
	}



	/**
	 * Return the value associated with the column: logcontent
	 */
	public java.lang.String getLogcontent () {
		return logcontent;
	}

	/**
	 * Set the value related to the column: logcontent
	 * @param logcontent the logcontent value
	 */
	public void setLogcontent (java.lang.String logcontent) {
		this.logcontent = logcontent;
	}



	/**
	 * Return the value associated with the column: entityname
	 */
	public java.lang.String getEntityname () {
		return entityname;
	}

	/**
	 * Set the value related to the column: entityname
	 * @param entityname the entityname value
	 */
	public void setEntityname (java.lang.String entityname) {
		this.entityname = entityname;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Logmsg)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Logmsg logmsg = (com.liveneo.plat.hibernate.dao.Logmsg) obj;
			if (null == this.getId() || null == logmsg.getId()) return false;
			else return (this.getId().equals(logmsg.getId()));
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