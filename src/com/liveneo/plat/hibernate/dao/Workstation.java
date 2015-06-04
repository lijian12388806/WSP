package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseWorkstation;



public class Workstation extends BaseWorkstation {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Workstation () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Workstation (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_FACTORYNAMECN,this.getFactorynamecn())
					.append(this.PROP_FACTORYNAMEEN,this.getFactorynameen())
					.append(this.PROP_PHONENO,this.getPhoneno())
					.append(this.PROP_WSLINKMAN,this.getWslinkman())
					.append(this.PROP_WSEMAIL,this.getWsemail())
					.append(this.PROP_WSADDR,this.getWsaddr())
					.append(this.PROP_REMARK,this.getRemark())
					.append(this.PROP_TEMP1,this.getTemp1())
					.append(this.PROP_TEMP2,this.getTemp2())
					.append(this.PROP_TEMP3,this.getTemp3())
					.append(this.PROP_TEMP4,this.getTemp4())
				 .toString();
	}
}