package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseLogmsg;



public class Logmsg extends BaseLogmsg {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Logmsg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Logmsg (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_USERNAME,this.getUsername())
					.append(this.PROP_CREATETIME,this.getCreatetime())
					.append(this.PROP_IP,this.getIp())
					.append(this.PROP_LOGTYPE,this.getLogtype())
					.append(this.PROP_LOGCONTENT,this.getLogcontent())
					.append(this.PROP_ENTITYNAME,this.getEntityname())
				 .toString();
	}
}