package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseCalldetail;



public class Calldetail extends BaseCalldetail {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Calldetail () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Calldetail (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Calldetail (
		java.lang.String id,
		java.lang.String calldetailid) {

		super (
			id,
			calldetailid);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_CALLDETAILID,this.getCalldetailid())
					.append(this.PROP_CALLINTIME,this.getCallintime())
					.append(this.PROP_ANI,this.getAni())
					.append(this.PROP_ANIAREA,this.getAniarea())
					.append(this.PROP_ANICITY,this.getAnicity())
					.append(this.PROP_BUSITYPE,this.getBusitype())
					.append(this.PROP_SVRRESULT,this.getSvrresult())
					.append(this.PROP_LEAVETIME,this.getLeavetime())
					.append(this.PROP_UCID,this.getUcid())
					.append(this.PROP_CREATETYPE,this.getCreatetype())
					.append(this.PROP_ISLOST,this.getIslost())
					.append(this.PROP_AGENTID,this.getAgentid())
					.append(this.PROP_N1,this.getN1())
					.append(this.PROP_N2,this.getN2())
					.append(this.PROP_N3,this.getN3())
				 .toString();
	}
}