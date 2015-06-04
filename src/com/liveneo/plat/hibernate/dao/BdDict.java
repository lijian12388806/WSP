package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseBdDict;



public class BdDict extends BaseBdDict {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdDict () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdDict (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_DICTCODE,this.getDictcode())
					.append(this.PROP_DICTTITLE,this.getDicttitle())
					.append(this.PROP_DICTTYPE,this.getDicttype())
					.append(this.PROP_ISVALID,this.getIsvalid())
					.append(this.PROP_REMARK,this.getRemark())
					.append(this.PROP_TEMP,this.getTemp())
				 .toString();
	}
}