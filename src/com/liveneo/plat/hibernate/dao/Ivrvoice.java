package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;
import com.liveneo.plat.hibernate.dao.base.BaseIvrvoice;



public class Ivrvoice extends BaseIvrvoice {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Ivrvoice () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Ivrvoice (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Ivrvoice (
		java.lang.String id,
		java.lang.String leavewordnum) {

		super (
			id,
			leavewordnum);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_LEAVEWORDNUM,this.getLeavewordnum())
					.append(this.PROP_SERVERIP,this.getServerip())
					.append(this.PROP_CALLERID,this.getCallerid())
					.append(this.PROP_STARTTIME,this.getStarttime())
					.append(this.PROP_ENDTIME,this.getEndtime())
					.append(this.PROP_STARTDATE,this.getStartdate())
					.append(this.PROP_ENDDATE,this.getEnddate())
					.append(this.PROP_FILENAME,this.getFilename())
					.append(this.PROP_ISNOTICE,this.getIsnotice())
					.append(this.PROP_ISCHECK,this.getIscheck())
					.append(this.PROP_DNIS,this.getDnis())
					.append(this.PROP_CREATE_DATE,this.getCreateDate())
					.append(this.PROP_PROCESSRESULT,this.getProcessresult())
					.append(this.PROP_UCID,this.getUcid())
					.append(this.PROP_VDUID,this.getVduid())
					.append(this.PROP_N1,this.getN1())
					.append(this.PROP_N2,this.getN2())
					.append(this.PROP_N3,this.getN3())
				 .toString();
	}
}