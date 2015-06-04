package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseBdDictdetail;



public class BdDictdetail extends BaseBdDictdetail {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdDictdetail () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdDictdetail (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdDictdetail (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.BdDict pkDict) {

		super (
			id,
			pkDict);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_CODE,this.getCode())
					.append(this.PROP_TITLE,this.getTitle())
					.append(this.PROP_VALUE,this.getValue())
					.append(this.PROP_ISVALID,this.getIsvalid())
					.append(this.PROP_REMARK,this.getRemark())
					.append(this.PROP_DEFAULTORDER,this.getDefaultorder())
				 .toString();
	}
}