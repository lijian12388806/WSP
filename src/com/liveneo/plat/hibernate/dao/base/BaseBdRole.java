package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the bd_role table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_role"
 */

public abstract class BaseBdRole  implements Serializable {

	public static String REF = "BdRole";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_ROLENAME = "Rolename";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdRole (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String description;
	private java.lang.String rolename;

	// collections
	private java.util.Set<com.liveneo.plat.hibernate.dao.BdRolemenu> bdRolemenus;
	private java.util.Set<com.liveneo.plat.hibernate.dao.BdUserinforole> bdUserinforoles;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="pk_role"
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: rolename
	 */
	public java.lang.String getRolename () {
		return rolename;
	}

	/**
	 * Set the value related to the column: rolename
	 * @param rolename the rolename value
	 */
	public void setRolename (java.lang.String rolename) {
		this.rolename = rolename;
	}



	/**
	 * Return the value associated with the column: BdRolemenus
	 */
	public java.util.Set<com.liveneo.plat.hibernate.dao.BdRolemenu> getBdRolemenus () {
		return bdRolemenus;
	}

	/**
	 * Set the value related to the column: BdRolemenus
	 * @param bdRolemenus the BdRolemenus value
	 */
	public void setBdRolemenus (java.util.Set<com.liveneo.plat.hibernate.dao.BdRolemenu> bdRolemenus) {
		this.bdRolemenus = bdRolemenus;
	}

	public void addToBdRolemenus (com.liveneo.plat.hibernate.dao.BdRolemenu bdRolemenu) {
		if (null == getBdRolemenus()) setBdRolemenus(new java.util.TreeSet<com.liveneo.plat.hibernate.dao.BdRolemenu>());
		getBdRolemenus().add(bdRolemenu);
	}



	/**
	 * Return the value associated with the column: BdUserinforoles
	 */
	public java.util.Set<com.liveneo.plat.hibernate.dao.BdUserinforole> getBdUserinforoles () {
		return bdUserinforoles;
	}

	/**
	 * Set the value related to the column: BdUserinforoles
	 * @param bdUserinforoles the BdUserinforoles value
	 */
	public void setBdUserinforoles (java.util.Set<com.liveneo.plat.hibernate.dao.BdUserinforole> bdUserinforoles) {
		this.bdUserinforoles = bdUserinforoles;
	}

	public void addToBdUserinforoles (com.liveneo.plat.hibernate.dao.BdUserinforole bdUserinforole) {
		if (null == getBdUserinforoles()) setBdUserinforoles(new java.util.TreeSet<com.liveneo.plat.hibernate.dao.BdUserinforole>());
		getBdUserinforoles().add(bdUserinforole);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.BdRole)) return false;
		else {
			com.liveneo.plat.hibernate.dao.BdRole bdRole = (com.liveneo.plat.hibernate.dao.BdRole) obj;
			if (null == this.getId() || null == bdRole.getId()) return false;
			else return (this.getId().equals(bdRole.getId()));
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