package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the bd_userinforole table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_userinforole"
 */

public abstract class BaseBdUserinforole  implements Serializable {

	public static String REF = "BdUserinforole";
	public static String PROP_PK_ROLE = "PkRole";
	public static String PROP_ID = "Id";
	public static String PROP_PK_USERINFO = "PkUserinfo";


	// constructors
	public BaseBdUserinforole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdUserinforole (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdUserinforole (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo,
		com.liveneo.plat.hibernate.dao.BdRole pkRole) {

		this.setId(id);
		this.setPkUserinfo(pkUserinfo);
		this.setPkRole(pkRole);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private com.liveneo.plat.hibernate.dao.BdRole pkRole;
	private com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="PK_USERINFOROLE"
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
	 * Return the value associated with the column: pk_role
	 */
	public com.liveneo.plat.hibernate.dao.BdRole getPkRole () {
		return pkRole;
	}

	/**
	 * Set the value related to the column: pk_role
	 * @param pkRole the pk_role value
	 */
	public void setPkRole (com.liveneo.plat.hibernate.dao.BdRole pkRole) {
		this.pkRole = pkRole;
	}



	/**
	 * Return the value associated with the column: pk_userinfo
	 */
	public com.liveneo.plat.hibernate.dao.Userinfo getPkUserinfo () {
		return pkUserinfo;
	}

	/**
	 * Set the value related to the column: pk_userinfo
	 * @param pkUserinfo the pk_userinfo value
	 */
	public void setPkUserinfo (com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo) {
		this.pkUserinfo = pkUserinfo;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.BdUserinforole)) return false;
		else {
			com.liveneo.plat.hibernate.dao.BdUserinforole bdUserinforole = (com.liveneo.plat.hibernate.dao.BdUserinforole) obj;
			if (null == this.getId() || null == bdUserinforole.getId()) return false;
			else return (this.getId().equals(bdUserinforole.getId()));
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