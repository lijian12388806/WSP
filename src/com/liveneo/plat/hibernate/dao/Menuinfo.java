package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseMenuinfo;



public class Menuinfo extends BaseMenuinfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Menuinfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Menuinfo (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_MENUNAME,this.getMenuname())
					.append(this.PROP_MENUSEQ,this.getMenuseq())
					.append(this.PROP_ISAVAILABLE,this.getIsavailable())
					.append(this.PROP_LINKADDRESS,this.getLinkaddress())
					.append(this.PROP_TEMP1,this.getTemp1())
					.append(this.PROP_TEMP2,this.getTemp2())
				 .toString();
	}
}