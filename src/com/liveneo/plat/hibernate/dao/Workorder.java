package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseWorkorder;



public class Workorder extends BaseWorkorder {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Workorder () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Workorder (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Workorder (
		java.lang.Integer id,
		com.liveneo.plat.hibernate.dao.Userinfo pkUserinfo) {

		super (
			id,
			pkUserinfo);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_WORKORDERNO,this.getWorkorderno())
					.append(this.PROP_CUSTOMERNO,this.getCustomerno())
					.append(this.PROP_CUSTOMERNAME,this.getCustomername())
					.append(this.PROP_CALLERNO,this.getCallerno())
					.append(this.PROP_WOSTATUS,this.getWostatus())
					.append(this.PROP_ORDERTYPE,this.getOrdertype())
					.append(this.PROP_PROJECTTYPE,this.getProjecttype())
					.append(this.PROP_WORKITEM,this.getWorkitem())
					.append(this.PROP_PRONAME,this.getProname())
					.append(this.PROP_PROCODE,this.getProcode())
					.append(this.PROP_ORDERSOURCE,this.getOrdersource())
					.append(this.PROP_GENERATEMODE,this.getGeneratemode())
					.append(this.PROP_CALLTIME,this.getCalltime())
					.append(this.PROP_DEALTIME,this.getDealtime())
					.append(this.PROP_AUDITPERSON,this.getAuditperson())
					.append(this.PROP_AUDITTIME,this.getAudittime())
					.append(this.PROP_COMPLETEPERSON,this.getCompleteperson())
					.append(this.PROP_COMPLETETIME,this.getCompletetime())
					.append(this.PROP_REMARK,this.getRemark())
					.append(this.PROP_CONSULTCONTENT,this.getConsultcontent())
					.append(this.PROP_NEXTACTION,this.getNextaction())
					.append(this.PROP_REMINDFLAG,this.getRemindflag())
					.append(this.PROP_TEMP1,this.getTemp1())
					.append(this.PROP_TEMP2,this.getTemp2())
					.append(this.PROP_TEMP3,this.getTemp3())
					.append(this.PROP_TEMP4,this.getTemp4())
					.append(this.PROP_TEMP5,this.getTemp5())
					.append(this.PROP_TEMP6,this.getTemp6())
					.append(this.PROP_TEMP7,this.getTemp7())
					.append(this.PROP_TEMP8,this.getTemp8())
					.append(this.PROP_ACTUSERNAME,this.getActusername())
				 .toString();
	}
}