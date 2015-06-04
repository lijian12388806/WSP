package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.liveneo.plat.hibernate.dao.base.BaseOrderdealinfo;



public class Orderdealinfo extends BaseOrderdealinfo {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Orderdealinfo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Orderdealinfo (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Orderdealinfo (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.Workorder pkWorkorder) {

		super (
			id,
			pkWorkorder);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_WORKORDERNO,this.getWorkorderno())
					.append(this.PROP_PROKEYWORD,this.getProkeyword())
					.append(this.PROP_PRODEPARTMENT,this.getProdepartment())
					.append(this.PROP_DEPDEALMAN,this.getDepdealman())
					.append(this.PROP_PRODESC,this.getProdesc())
					.append(this.PROP_PROREASON,this.getProreason())
					.append(this.PROP_PROSITUATION,this.getProsituation())
					.append(this.PROP_OCCTIME,this.getOcctime())
					.append(this.PROP_DEALTIME,this.getDealtime())
					.append(this.PROP_TYPEINPERSON,this.getTypeinperson())
					.append(this.PROP_ASSIGNPERSON,this.getAssignperson())
					.append(this.PROP_TYPEINTIME,this.getTypeintime())
					.append(this.PROP_WOSTATUS,this.getWostatus())
					.append(this.PROP_CREATETYPE,this.getCreatetype())
					.append(this.PROP_REMARK,this.getRemark())
					.append(this.PROP_TEMP1,this.getTemp1())
					.append(this.PROP_TEMP2,this.getTemp2())
					.append(this.PROP_TEMP3,this.getTemp3())
					.append(this.PROP_TEMP4,this.getTemp4())
					.append(this.PROP_TEMP5,this.getTemp5())
					.append(this.PROP_TEMP6,this.getTemp6())
				 .toString();
	}
}