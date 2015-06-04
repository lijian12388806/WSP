package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseCustomerinfo;



public class Customerinfo extends BaseCustomerinfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Customerinfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Customerinfo (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_CUSTOMERNO,this.getCustomerno())
					.append(this.PROP_CUSTOMERNAME,this.getCustomername())
					.append(this.PROP_CUSTLINKMAN,this.getCustlinkman())
					.append(this.PROP_CUSTPHONENO,this.getCustphoneno())
					.append(this.PROP_POSTCODE,this.getPostcode())
					.append(this.PROP_EMAILADDR,this.getEmailaddr())
					.append(this.PROP_NETHERLANDS,this.getNetherlands())
					.append(this.PROP_CUSTTYPE,this.getCusttype())
					.append(this.PROP_CUSTLEVEL,this.getCustlevel())
					.append(this.PROP_CUSTSTATUS,this.getCuststatus())
					.append(this.PROP_PROVINCE,this.getProvince())
					.append(this.PROP_CITY,this.getCity())
					.append(this.PROP_CUSTADDR,this.getCustaddr())
					.append(this.PROP_INFOSOURCE,this.getInfosource())
					.append(this.PROP_UPDATETIME,this.getUpdatetime())
					.append(this.PROP_REMARK,this.getRemark())
					.append(this.PROP_TEMP1,this.getTemp1())
					.append(this.PROP_TEMP2,this.getTemp2())
					.append(this.PROP_TEMP3,this.getTemp3())
					.append(this.PROP_TEMP4,this.getTemp4())
					.append(this.PROP_TEMP5,this.getTemp5())
					.append(this.PROP_TEMP6,this.getTemp6())
					.append(this.PROP_TEMP7,this.getTemp7())
					.append(this.PROP_TEMP8,this.getTemp8())
					.append(this.PROP_SALESORG,this.getSalesorg())
					.append(this.PROP_SALESOFFICE,this.getSalesoffice())
					.append(this.PROP_SALESGROUP,this.getSalesgroup())
					.append(this.PROP_SALESNAME,this.getSalesname())
					.append(this.PROP_CUSTAREA,this.getCustarea())
				 .toString();
	}
}