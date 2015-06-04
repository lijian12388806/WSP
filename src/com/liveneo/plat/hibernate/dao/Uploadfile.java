package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.liveneo.plat.hibernate.dao.base.BaseUploadfile;



public class Uploadfile extends BaseUploadfile {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Uploadfile () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Uploadfile (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_FILENAME,this.getFilename())
					.append(this.PROP_FILETYPE,this.getFiletype())
					.append(this.PROP_FILEPATH,this.getFilepath())
					.append(this.PROP_CREATETIME,this.getCreatetime())
				 .toString();
	}
}