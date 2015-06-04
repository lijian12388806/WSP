package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the bd_rolemenu table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bd_rolemenu"
 */

public abstract class BaseBdRolemenu  implements Serializable {

	public static String REF = "BdRolemenu";
	public static String PROP_PK_MENU = "PkMenu";
	public static String PROP_PK_ROLE = "PkRole";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdRolemenu () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdRolemenu (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdRolemenu (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.BdRole pkRole,
		com.liveneo.plat.hibernate.dao.Menuinfo pkMenu) {

		this.setId(id);
		this.setPkRole(pkRole);
		this.setPkMenu(pkMenu);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private com.liveneo.plat.hibernate.dao.Menuinfo pkMenu;
	private com.liveneo.plat.hibernate.dao.BdRole pkRole;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="pk_rolemenu"
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
	 * Return the value associated with the column: pk_menu
	 */
	public com.liveneo.plat.hibernate.dao.Menuinfo getPkMenu () {
		return pkMenu;
	}

	/**
	 * Set the value related to the column: pk_menu
	 * @param pkMenu the pk_menu value
	 */
	public void setPkMenu (com.liveneo.plat.hibernate.dao.Menuinfo pkMenu) {
		this.pkMenu = pkMenu;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.BdRolemenu)) return false;
		else {
			com.liveneo.plat.hibernate.dao.BdRolemenu bdRolemenu = (com.liveneo.plat.hibernate.dao.BdRolemenu) obj;
			if (null == this.getId() || null == bdRolemenu.getId()) return false;
			else return (this.getId().equals(bdRolemenu.getId()));
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