package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.liveneo.plat.hibernate.dao.base.BaseMgrWoDefine;



public class MgrWoDefine extends BaseMgrWoDefine {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MgrWoDefine () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MgrWoDefine (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MgrWoDefine (
		java.lang.Integer id,
		java.lang.Integer pkTemplet) {

		super (
			id,
			pkTemplet);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_PK_TEMPLET,this.getPkTemplet())
					.append(this.PROP_DEF_TYPE,this.getDefType())
					.append(this.PROP_DEF_COL,this.getDefCol())
					.append(this.PROP_DEF_CANEDIT,this.getDefCanedit())
					.append(this.PROP_DEF_COL_TITLE,this.getDefColTitle())
					.append(this.PROP_DEF_COL_TYPE,this.getDefColType())
					.append(this.PROP_DEF_COL_FORMAT,this.getDefColFormat())
					.append(this.PROP_DEF_COL_LMIN,this.getDefColLmin())
					.append(this.PROP_DEF_COL_LMAX,this.getDefColLmax())
					.append(this.PROP_DEF_COL_CLASS,this.getDefColClass())
					.append(this.PROP_DEF_COL_REQUIRED,this.getDefColRequired())
					.append(this.PROP_DEF_COL_REGION,this.getDefColRegion())
					.append(this.PROP_DEF_COL_ORDER,this.getDefColOrder())
				 .toString();
	}
}