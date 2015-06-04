package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.liveneo.plat.hibernate.dao.base.BaseMgrTemplet;



public class MgrTemplet extends BaseMgrTemplet {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MgrTemplet () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MgrTemplet (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_TMP_CODE,this.getTmpCode())
					.append(this.PROP_TMP_NAME,this.getTmpName())
					.append(this.PROP_TMP_TYPE,this.getTmpType())
					.append(this.PROP_TMP_STATUS,this.getTmpStatus())
				 .toString();
	}
}