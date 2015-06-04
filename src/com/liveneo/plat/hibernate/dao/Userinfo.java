package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseUserinfo;



public class Userinfo extends BaseUserinfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Userinfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Userinfo (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_USERNAME,this.getUsername())
					.append(this.PROP_USERPWD,this.getUserpwd())
					.append(this.PROP_ISADMIN,this.getIsadmin())
					.append(this.PROP_REMARK,this.getRemark())
					.append(this.PROP_FACTORY,this.getFactory())
					.append(this.PROP_AGENTNO,this.getAgentno())
					.append(this.PROP_CTIPWD,this.getCtipwd())
					.append(this.PROP_EXTNO,this.getExtno())
					.append(this.PROP_AGENTNAME,this.getAgentname())
					.append(this.PROP_AGENTEMAIL,this.getAgentemail())
					.append(this.PROP_PHONENO,this.getPhoneno())
					.append(this.PROP_AGENTSTATUS,this.getAgentstatus())
					.append(this.PROP_LASTLOGINTIME,this.getLastlogintime())
					.append(this.PROP_AGENTTYPE,this.getAgenttype())
					.append(this.PROP_POSITION,this.getPosition())
					.append(this.PROP_USERSTATUS,this.getUserstatus())
					.append(this.PROP_DELFLAG,this.getDelflag())
					.append(this.PROP_CTIADDR,this.getCtiaddr())
					.append(this.PROP_CTIADDRBAK,this.getCtiaddrbak())
					.append(this.PROP_AUTHADDR,this.getAuthaddr())
					.append(this.PROP_AUTHTYPE,this.getAuthtype())
					.append(this.PROP_TEMP1,this.getTemp1())
					.append(this.PROP_TEMP2,this.getTemp2())
					.append(this.PROP_TEMP3,this.getTemp3())
					.append(this.PROP_TEMP4,this.getTemp4())
					.append(this.PROP_TEMP5,this.getTemp5())
				 .toString();
	}
}