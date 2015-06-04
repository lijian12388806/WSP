package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseSatscore;



public class Satscore extends BaseSatscore {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Satscore () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Satscore (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Satscore (
		java.lang.Integer id,
		java.lang.String ucid) {

		super (
			id,
			ucid);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_UCID,this.getUcid())
					.append(this.PROP_CALLERNO,this.getCallerno())
					.append(this.PROP_AGENTID,this.getAgentid())
					.append(this.PROP_EXTNO,this.getExtno())
					.append(this.PROP_SVCTIME,this.getSvctime())
					.append(this.PROP_SVCPOINT,this.getSvcpoint())
					.append(this.PROP_VDUID,this.getVduid())
					.append(this.PROP_N1,this.getN1())
					.append(this.PROP_N2,this.getN2())
					.append(this.PROP_N3,this.getN3())
				 .toString();
	}
}