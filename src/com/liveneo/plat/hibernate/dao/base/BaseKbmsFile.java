package com.liveneo.plat.hibernate.dao.base;

import java.io.Serializable;



/**
 * This is an object that contains data related to the kbms_file table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="kbms_file"
 */

public abstract class BaseKbmsFile  implements Serializable {

	public static String REF = "KbmsFile";
	public static String PROP_FILE_SIZE = "FileSize";
	public static String PROP_FILE_TMP3 = "FileTmp3";
	public static String PROP_FILE_NEWNAME = "FileNewname";
	public static String PROP_FILE_TIME = "FileTime";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_ID = "Id";
	public static String PROP_FILE_PATH = "FilePath";
	public static String PROP_FILE_KLP_ID = "FileKlpId";
	public static String PROP_FILE_TMP2 = "FileTmp2";
	public static String PROP_FILE_TMP1 = "FileTmp1";


	// constructors
	public BaseKbmsFile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseKbmsFile (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer fileKlpId;
	private java.lang.String fileName;
	private java.lang.String fileNewname;
	private java.lang.String filePath;
	private java.lang.String fileSize;
	private java.util.Date fileTime;
	private java.lang.String fileTmp1;
	private java.lang.String fileTmp2;
	private java.lang.String fileTmp3;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="ID"
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
	 * Return the value associated with the column: FILE_KLP_ID
	 */
	public java.lang.Integer getFileKlpId () {
		return fileKlpId;
	}

	/**
	 * Set the value related to the column: FILE_KLP_ID
	 * @param fileKlpId the FILE_KLP_ID value
	 */
	public void setFileKlpId (java.lang.Integer fileKlpId) {
		this.fileKlpId = fileKlpId;
	}



	/**
	 * Return the value associated with the column: FILE_NAME
	 */
	public java.lang.String getFileName () {
		return fileName;
	}

	/**
	 * Set the value related to the column: FILE_NAME
	 * @param fileName the FILE_NAME value
	 */
	public void setFileName (java.lang.String fileName) {
		this.fileName = fileName;
	}



	/**
	 * Return the value associated with the column: FILE_NEWNAME
	 */
	public java.lang.String getFileNewname () {
		return fileNewname;
	}

	/**
	 * Set the value related to the column: FILE_NEWNAME
	 * @param fileNewname the FILE_NEWNAME value
	 */
	public void setFileNewname (java.lang.String fileNewname) {
		this.fileNewname = fileNewname;
	}



	/**
	 * Return the value associated with the column: FILE_PATH
	 */
	public java.lang.String getFilePath () {
		return filePath;
	}

	/**
	 * Set the value related to the column: FILE_PATH
	 * @param filePath the FILE_PATH value
	 */
	public void setFilePath (java.lang.String filePath) {
		this.filePath = filePath;
	}



	/**
	 * Return the value associated with the column: FILE_SIZE
	 */
	public java.lang.String getFileSize () {
		return fileSize;
	}

	/**
	 * Set the value related to the column: FILE_SIZE
	 * @param fileSize the FILE_SIZE value
	 */
	public void setFileSize (java.lang.String fileSize) {
		this.fileSize = fileSize;
	}



	/**
	 * Return the value associated with the column: FILE_TIME
	 */
	public java.util.Date getFileTime () {
		return fileTime;
	}

	/**
	 * Set the value related to the column: FILE_TIME
	 * @param fileTime the FILE_TIME value
	 */
	public void setFileTime (java.util.Date fileTime) {
		this.fileTime = fileTime;
	}



	/**
	 * Return the value associated with the column: FILE_TMP1
	 */
	public java.lang.String getFileTmp1 () {
		return fileTmp1;
	}

	/**
	 * Set the value related to the column: FILE_TMP1
	 * @param fileTmp1 the FILE_TMP1 value
	 */
	public void setFileTmp1 (java.lang.String fileTmp1) {
		this.fileTmp1 = fileTmp1;
	}



	/**
	 * Return the value associated with the column: FILE_TMP2
	 */
	public java.lang.String getFileTmp2 () {
		return fileTmp2;
	}

	/**
	 * Set the value related to the column: FILE_TMP2
	 * @param fileTmp2 the FILE_TMP2 value
	 */
	public void setFileTmp2 (java.lang.String fileTmp2) {
		this.fileTmp2 = fileTmp2;
	}



	/**
	 * Return the value associated with the column: FILE_TMP3
	 */
	public java.lang.String getFileTmp3 () {
		return fileTmp3;
	}

	/**
	 * Set the value related to the column: FILE_TMP3
	 * @param fileTmp3 the FILE_TMP3 value
	 */
	public void setFileTmp3 (java.lang.String fileTmp3) {
		this.fileTmp3 = fileTmp3;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.liveneo.plat.hibernate.dao.KbmsFile)) return false;
		else {
			com.liveneo.plat.hibernate.dao.KbmsFile kbmsFile = (com.liveneo.plat.hibernate.dao.KbmsFile) obj;
			if (null == this.getId() || null == kbmsFile.getId()) return false;
			else return (this.getId().equals(kbmsFile.getId()));
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