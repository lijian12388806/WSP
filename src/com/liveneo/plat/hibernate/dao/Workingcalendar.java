package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseWorkingcalendar;



public class Workingcalendar extends BaseWorkingcalendar {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Workingcalendar () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Workingcalendar (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Workingcalendar (
		java.lang.Integer id,
		java.lang.String workingdate,
		java.lang.String isvacation) {

		super (
			id,
			workingdate,
			isvacation);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_WORKINGDATE,this.getWorkingdate())
					.append(this.PROP_ISVACATION,this.getIsvacation())
					.append(this.PROP_REAMRK,this.getReamrk())
					.append(this.PROP_N1,this.getN1())
					.append(this.PROP_N2,this.getN2())
					.append(this.PROP_N3,this.getN3())
				 .toString();
	}
}