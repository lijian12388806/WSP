package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseBdRole;



public class BdRole extends BaseBdRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdRole (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_DESCRIPTION,this.getDescription())
					.append(this.PROP_ROLENAME,this.getRolename())
				 .toString();
	}
}