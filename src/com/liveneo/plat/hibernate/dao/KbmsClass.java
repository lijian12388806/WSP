package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.liveneo.plat.hibernate.dao.base.BaseKbmsClass;



public class KbmsClass extends BaseKbmsClass {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public KbmsClass () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public KbmsClass (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_TITLE,this.getTitle())
					.append(this.PROP_PID,this.getPid())
					.append(this.PROP_ORD,this.getOrd())
				 .toString();
	}
}