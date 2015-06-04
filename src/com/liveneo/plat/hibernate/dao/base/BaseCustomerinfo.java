package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the CUSTOMERINFO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="CUSTOMERINFO"
 */

public abstract class BaseCustomerinfo  implements Serializable {

	public static String REF = "Customerinfo";
	public static String PROP_SALESNAME = "Salesname";
	public static String PROP_SALESGROUP = "Salesgroup";
	public static String PROP_TEMP8 = "Temp8";
	public static String PROP_REMARK = "Remark";
	public static String PROP_CUSTSTATUS = "Custstatus";
	public static String PROP_TEMP2 = "Temp2";
	public static String PROP_TEMP5 = "Temp5";
	public static String PROP_POSTCODE = "Postcode";
	public static String PROP_CITY = "City";
	public static String PROP_CUSTOMERNO = "Customerno";
	public static String PROP_CUSTLINKMAN = "Custlinkman";
	public static String PROP_TEMP4 = "Temp4";
	public static String PROP_CUSTLEVEL = "Custlevel";
	public static String PROP_CUSTTYPE = "Custtype";
	public static String PROP_TEMP7 = "Temp7";
	public static String PROP_CUSTADDR = "Custaddr";
	public static String PROP_INFOSOURCE = "Infosource";
	public static String PROP_TEMP6 = "Temp6";
	public static String PROP_CUSTOMERNAME = "Customername";
	public static String PROP_EMAILADDR = "Emailaddr";
	public static String PROP_NETHERLANDS = "Netherlands";
	public static String PROP_UPDATETIME = "Updatetime";
	public static String PROP_TEMP3 = "Temp3";
	public static String PROP_SALESOFFICE = "Salesoffice";
	public static String PROP_CUSTPHONENO = "Custphoneno";
	public static String PROP_SALESORG = "Salesorg";
	public static String PROP_TEMP1 = "Temp1";
	public static String PROP_ID = "Id";
	public static String PROP_CUSTAREA = "Custarea";
	public static String PROP_PROVINCE = "Province";


	// constructors
	public BaseCustomerinfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerinfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String customerno;
	private java.lang.String customername;
	private java.lang.String custlinkman;
	private java.lang.String custphoneno;
	private java.lang.String postcode;
	private java.lang.String emailaddr;
	private java.lang.String netherlands;
	private java.lang.String custtype;
	private java.lang.String custlevel;
	private java.lang.String custstatus;
	private java.lang.String province;
	private java.lang.String city;
	private java.lang.String custaddr;
	private java.lang.String infosource;
	private java.util.Date updatetime;
	private java.lang.String remark;
	private java.lang.String temp1;
	private java.lang.String temp2;
	private java.lang.String temp3;
	private java.lang.String temp4;
	private java.lang.String temp5;
	private java.lang.String temp6;
	private java.lang.String temp7;
	private java.lang.String temp8;
	private java.lang.String salesorg;
	private java.lang.String salesoffice;
	private java.lang.String salesgroup;
	private java.lang.String salesname;
	private java.lang.String custarea;

	// collections
	private java.util.Set<com.liveneo.plat.hibernate.dao.Workorder> wORKORDERs;
	private java.util.Set<com.liveneo.plat.hibernate.dao.Cusphonelist> cUSPHONELISTs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="PK_CUSTOMERINFO"
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
	 * Return the value associated with the column: CUSTLINKMAN
	 */
	public java.lang.String getCustlinkman () {
		return custlinkman;
	}

	/**
	 * Set the value related to the column: CUSTLINKMAN
	 * @param custlinkman the CUSTLINKMAN value
	 */
	public void setCustlinkman (java.lang.String custlinkman) {
		this.custlinkman = custlinkman;
	}



	/**
	 * Return the value associated with the column: CUSTPHONENO
	 */
	public java.lang.String getCustphoneno () {
		return custphoneno;
	}

	/**
	 * Set the value related to the column: CUSTPHONENO
	 * @param custphoneno the CUSTPHONENO value
	 */
	public void setCustphoneno (java.lang.String custphoneno) {
		this.custphoneno = custphoneno;
	}



	/**
	 * Return the value associated with the column: POSTCODE
	 */
	public java.lang.String getPostcode () {
		return postcode;
	}

	/**
	 * Set the value related to the column: POSTCODE
	 * @param postcode the POSTCODE value
	 */
	public void setPostcode (java.lang.String postcode) {
		this.postcode = postcode;
	}



	/**
	 * Return the value associated with the column: EMAILADDR
	 */
	public java.lang.String getEmailaddr () {
		return emailaddr;
	}

	/**
	 * Set the value related to the column: EMAILADDR
	 * @param emailaddr the EMAILADDR value
	 */
	public void setEmailaddr (java.lang.String emailaddr) {
		this.emailaddr = emailaddr;
	}



	/**
	 * Return the value associated with the column: NETHERLANDS
	 */
	public java.lang.String getNetherlands () {
		return netherlands;
	}

	/**
	 * Set the value related to the column: NETHERLANDS
	 * @param netherlands the NETHERLANDS value
	 */
	public void setNetherlands (java.lang.String netherlands) {
		this.netherlands = netherlands;
	}



	/**
	 * Return the value associated with the column: CUSTTYPE
	 */
	public java.lang.String getCusttype () {
		return custtype;
	}

	/**
	 * Set the value related to the column: CUSTTYPE
	 * @param custtype the CUSTTYPE value
	 */
	public void setCusttype (java.lang.String custtype) {
		this.custtype = custtype;
	}



	/**
	 * Return the value associated with the column: CUSTLEVEL
	 */
	public java.lang.String getCustlevel () {
		return custlevel;
	}

	/**
	 * Set the value related to the column: CUSTLEVEL
	 * @param custlevel the CUSTLEVEL value
	 */
	public void setCustlevel (java.lang.String custlevel) {
		this.custlevel = custlevel;
	}



	/**
	 * Return the value associated with the column: CUSTSTATUS
	 */
	public java.lang.String getCuststatus () {
		return custstatus;
	}

	/**
	 * Set the value related to the column: CUSTSTATUS
	 * @param custstatus the CUSTSTATUS value
	 */
	public void setCuststatus (java.lang.String custstatus) {
		this.custstatus = custstatus;
	}



	/**
	 * Return the value associated with the column: PROVINCE
	 */
	public java.lang.String getProvince () {
		return province;
	}

	/**
	 * Set the value related to the column: PROVINCE
	 * @param province the PROVINCE value
	 */
	public void setProvince (java.lang.String province) {
		this.province = province;
	}



	/**
	 * Return the value associated with the column: CITY
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: CITY
	 * @param city the CITY value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: CUSTADDR
	 */
	public java.lang.String getCustaddr () {
		return custaddr;
	}

	/**
	 * Set the value related to the column: CUSTADDR
	 * @param custaddr the CUSTADDR value
	 */
	public void setCustaddr (java.lang.String custaddr) {
		this.custaddr = custaddr;
	}



	/**
	 * Return the value associated with the column: INFOSOURCE
	 */
	public java.lang.String getInfosource () {
		return infosource;
	}

	/**
	 * Set the value related to the column: INFOSOURCE
	 * @param infosource the INFOSOURCE value
	 */
	public void setInfosource (java.lang.String infosource) {
		this.infosource = infosource;
	}



	/**
	 * Return the value associated with the column: UPDATETIME
	 */
	public java.util.Date getUpdatetime () {
		return updatetime;
	}

	/**
	 * Set the value related to the column: UPDATETIME
	 * @param updatetime the UPDATETIME value
	 */
	public void setUpdatetime (java.util.Date updatetime) {
		this.updatetime = updatetime;
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
	 * Return the value associated with the column: SALESORG
	 */
	public java.lang.String getSalesorg () {
		return salesorg;
	}

	/**
	 * Set the value related to the column: SALESORG
	 * @param salesorg the SALESORG value
	 */
	public void setSalesorg (java.lang.String salesorg) {
		this.salesorg = salesorg;
	}



	/**
	 * Return the value associated with the column: SALESOFFICE
	 */
	public java.lang.String getSalesoffice () {
		return salesoffice;
	}

	/**
	 * Set the value related to the column: SALESOFFICE
	 * @param salesoffice the SALESOFFICE value
	 */
	public void setSalesoffice (java.lang.String salesoffice) {
		this.salesoffice = salesoffice;
	}



	/**
	 * Return the value associated with the column: SALESGROUP
	 */
	public java.lang.String getSalesgroup () {
		return salesgroup;
	}

	/**
	 * Set the value related to the column: SALESGROUP
	 * @param salesgroup the SALESGROUP value
	 */
	public void setSalesgroup (java.lang.String salesgroup) {
		this.salesgroup = salesgroup;
	}



	/**
	 * Return the value associated with the column: SALESNAME
	 */
	public java.lang.String getSalesname () {
		return salesname;
	}

	/**
	 * Set the value related to the column: SALESNAME
	 * @param salesname the SALESNAME value
	 */
	public void setSalesname (java.lang.String salesname) {
		this.salesname = salesname;
	}



	/**
	 * Return the value associated with the column: CUSTAREA
	 */
	public java.lang.String getCustarea () {
		return custarea;
	}

	/**
	 * Set the value related to the column: CUSTAREA
	 * @param custarea the CUSTAREA value
	 */
	public void setCustarea (java.lang.String custarea) {
		this.custarea = custarea;
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



	/**
	 * Return the value associated with the column: CUSPHONELISTs
	 */
	public java.util.Set<com.liveneo.plat.hibernate.dao.Cusphonelist> getCUSPHONELISTs () {
		return cUSPHONELISTs;
	}

	/**
	 * Set the value related to the column: CUSPHONELISTs
	 * @param cUSPHONELISTs the CUSPHONELISTs value
	 */
	public void setCUSPHONELISTs (java.util.Set<com.liveneo.plat.hibernate.dao.Cusphonelist> cUSPHONELISTs) {
		this.cUSPHONELISTs = cUSPHONELISTs;
	}

	public void addToCUSPHONELISTs (com.liveneo.plat.hibernate.dao.Cusphonelist cusphonelist) {
		if (null == getCUSPHONELISTs()) setCUSPHONELISTs(new java.util.TreeSet<com.liveneo.plat.hibernate.dao.Cusphonelist>());
		getCUSPHONELISTs().add(cusphonelist);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Customerinfo)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Customerinfo customerinfo = (com.liveneo.plat.hibernate.dao.Customerinfo) obj;
			if (null == this.getId() || null == customerinfo.getId()) return false;
			else return (this.getId().equals(customerinfo.getId()));
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