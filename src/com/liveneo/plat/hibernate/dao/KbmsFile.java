package com.liveneo.plat.hibernate.dao;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.liveneo.plat.hibernate.dao.base.BaseKbmsFile;



public class KbmsFile extends BaseKbmsFile {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public KbmsFile () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public KbmsFile (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	@SuppressWarnings("static-access")
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.PROP_ID,this.getId())
					.append(this.PROP_FILE_KLP_ID,this.getFileKlpId())
					.append(this.PROP_FILE_NAME,this.getFileName())
					.append(this.PROP_FILE_NEWNAME,this.getFileNewname())
					.append(this.PROP_FILE_PATH,this.getFilePath())
					.append(this.PROP_FILE_SIZE,this.getFileSize())
					.append(this.PROP_FILE_TIME,this.getFileTime())
					.append(this.PROP_FILE_TMP1,this.getFileTmp1())
					.append(this.PROP_FILE_TMP2,this.getFileTmp2())
					.append(this.PROP_FILE_TMP3,this.getFileTmp3())
				 .toString();
	}
}