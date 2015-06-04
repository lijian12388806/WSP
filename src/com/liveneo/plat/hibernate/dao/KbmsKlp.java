package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.liveneo.plat.hibernate.dao.base.BaseKbmsKlp;



public class KbmsKlp extends BaseKbmsKlp {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public KbmsKlp () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public KbmsKlp (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_CLASSID,this.getClassid())
					.append(this.PROP_NAME,this.getName())
					.append(this.PROP_KIND,this.getKind())
					.append(this.PROP_CREATEDATE,this.getCreatedate())
					.append(this.PROP_MODIFYDATE,this.getModifydate())
					.append(this.PROP_CONTENT,this.getContent())
				 .toString();
	}
}