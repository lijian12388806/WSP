package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the uploadfile table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="uploadfile"
 */

public abstract class BaseUploadfile  implements Serializable {

	public static String REF = "Uploadfile";
	public static String PROP_FILEPATH = "Filepath";
	public static String PROP_FILETYPE = "Filetype";
	public static String PROP_FILENAME = "Filename";
	public static String PROP_CREATETIME = "Createtime";
	public static String PROP_ID = "Id";


	// constructors
	public BaseUploadfile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUploadfile (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String filename;
	private java.lang.String filetype;
	private java.lang.String filepath;
	private java.util.Date createtime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="pk_upfile"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: filename
	 */
	public java.lang.String getFilename () {
		return filename;
	}

	/**
	 * Set the value related to the column: filename
	 * @param filename the filename value
	 */
	public void setFilename (java.lang.String filename) {
		this.filename = filename;
	}



	/**
	 * Return the value associated with the column: filetype
	 */
	public java.lang.String getFiletype () {
		return filetype;
	}

	/**
	 * Set the value related to the column: filetype
	 * @param filetype the filetype value
	 */
	public void setFiletype (java.lang.String filetype) {
		this.filetype = filetype;
	}



	/**
	 * Return the value associated with the column: filepath
	 */
	public java.lang.String getFilepath () {
		return filepath;
	}

	/**
	 * Set the value related to the column: filepath
	 * @param filepath the filepath value
	 */
	public void setFilepath (java.lang.String filepath) {
		this.filepath = filepath;
	}



	/**
	 * Return the value associated with the column: createtime
	 */
	public java.util.Date getCreatetime () {
		return createtime;
	}

	/**
	 * Set the value related to the column: createtime
	 * @param createtime the createtime value
	 */
	public void setCreatetime (java.util.Date createtime) {
		this.createtime = createtime;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.Uploadfile)) return false;
		else {
			com.liveneo.plat.hibernate.dao.Uploadfile uploadfile = (com.liveneo.plat.hibernate.dao.Uploadfile) obj;
			if (null == this.getId() || null == uploadfile.getId()) return false;
			else return (this.getId().equals(uploadfile.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	 public String toString () {
		return super.toString();
	}



}