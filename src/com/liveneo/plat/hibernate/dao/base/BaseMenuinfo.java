package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the menuinfo table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="menuinfo"
 */

public abstract class BaseMenuinfo  implements Serializable {

	public static String REF = "Menuinfo";
	public static String PROP_MENUNAME = "Menuname";
	public static String PROP_ISAVAILABLE = "Isavailable";
	public static String PROP_SUPERMENU = "Supermenu";
	public static String PROP_LINKADDRESS = "Linkaddress";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_ID = "Id";
	public static String PROP_MENUSEQ = "Menuseq";


	// constructors
	public BaseMenuinfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMenuinfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String isavailable;
	private java.lang.String linkaddress;
	private java.lang.String menuname;
	private java.lang.Integer menuseq;
	private java.lang.Integer supermenu;
	private java.lang.String temp1;
	private java.lang.String temp2;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="PK_MENU"
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
	 * Return the value associated with the column: ISAVAILABLE
	 */
	public java.lang.String getIsavailable () {
		return isavailable;
	}

	/**
	 * Set the value related to the column: ISAVAILABLE
	 * @param isavailable the ISAVAILABLE value
	 */
	public void setIsavailable (java.lang.String isavailable) {
		this.isavailable = isavailable;
	}



	/**
	 * Return the value associated with the column: LINKADDRESS
	 */
	public java.lang.String getLinkaddress () {
		return linkaddress;
	}

	/**
	 * Set the value related to the column: LINKADDRESS
	 * @param linkaddress the LINKADDRESS value
	 */
	public void setLinkaddress (java.lang.String linkaddress) {
		this.linkaddress = linkaddress;
	}



	/**
	 * Return the value associated with the column: MENUNAME
	 */
	public java.lang.String getMenuname () {
		return menuname;
	}

	/**
	 * Set the value related to the column: MENUNAME
	 * @param menuname the MENUNAME value
	 */
	public void setMenuname (java.lang.String menuname) {
		this.menuname = menuname;
	}



	/**
	 * Return the value associated with the column: MENUSEQ
	 */
	public java.lang.Integer getMenuseq () {
		return menuseq;
	}

	/**
	 * Set the value related to the column: MENUSEQ
	 * @param menuseq the MENUSEQ value
	 */
	public void setMenuseq (java.lang.Integer menuseq) {
		this.menuseq = menuseq;
	}



	/**
	 * Return the value associated with the column: SUPERMENU
	 */
	public java.lang.Integer getSupermenu () {
		return supermenu;
	}

	/**
	 * Set the value related to the column: SUPERMENU
	 * @param supermenu the SUPERMENU value
	 */
	public void setSupermenu (java.lang.Integer supermenu) {
		this.supermenu = supermenu;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Menuinfo)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Menuinfo menuinfo = (com.liveneo.plat.hibernate.dao.Menuinfo) obj;
			if (null == this.getId() || null == menuinfo.getId()) return false;
			else return (this.getId().equals(menuinfo.getId()));
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