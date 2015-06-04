package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseBdUserinforole;



public class BdUserinforole extends BaseBdUserinforole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdUserinforole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdUserinforole (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdUserinforole (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo,
		com.liveneo.plat.hibernate.dao.BdRole pkRole) {

		super (
			id,
			pkUserinfo,
			pkRole);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
				 .toString();
	}
}