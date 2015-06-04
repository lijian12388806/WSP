package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseBdRolemenu;



public class BdRolemenu extends BaseBdRolemenu {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdRolemenu () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdRolemenu (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdRolemenu (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.BdRole pkRole,
		com.liveneo.plat.hibernate.dao.Menuinfo pkMenu) {

		super (
			id,
			pkRole,
			pkMenu);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
				 .toString();
	}
}