package com.liveneo.plat.constants;


public class GlobalData {
	private String DBname;
	private String DBUser;
	private String DBPwd;
	private String DBHost;
	
	private String AsteriskConfDir;
	private String AsteriskIP;
	private String AsteriskUser;
	private String AsteriskPwd;
	private String SmartDir;
	private String IvrRoutPath;
	private String calldbname;
	private String recordPath;
	private String lic;
	//平台超级管理员账号设置
	private String sadmin;
	private String admin;
	private boolean newSetup;
	private static GlobalData Data = new GlobalData();
	
	
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getSadmin() {
		return sadmin;
	}
	public void setSadmin(String sadmin) {
		this.sadmin = sadmin;
	}
	public String getDBname() {
		return DBname;
	}
	public void setDBname(String dBname) {
		DBname = dBname;
	}
	public String getDBUser() {
		return DBUser;
	}
	public void setDBUser(String dBUser) {
		DBUser = dBUser;
	}
	public String getDBPwd() {
		return DBPwd;
	}
	public void setDBPwd(String dBPwd) {
		DBPwd = dBPwd;
	}
	public String getDBHost() {
		return DBHost;
	}
	public void setDBHost(String dBHost) {
		DBHost = dBHost;
	}
	public static GlobalData getData() {
		return Data;
	}

	public String getAsteriskConfDir() {
		return AsteriskConfDir;
	}
	public void setAsteriskConfDir(String asteriskConfDir) {
		AsteriskConfDir = asteriskConfDir;
	}
	public String getSmartDir() {
		return SmartDir;
	}
	public void setSmartDir(String smartDir) {
		SmartDir = smartDir;
	}
	public String getAsteriskIP() {
		return AsteriskIP;
	}
	public void setAsteriskIP(String asteriskIP) {
		AsteriskIP = asteriskIP;
	}
	public String getAsteriskUser() {
		return AsteriskUser;
	}
	public void setAsteriskUser(String asteriskUser) {
		AsteriskUser = asteriskUser;
	}
	public String getAsteriskPwd() {
		return AsteriskPwd;
	}
	public void setAsteriskPwd(String asteriskPwd) {
		AsteriskPwd = asteriskPwd;
	}
	public boolean isNewSetup() {
		return newSetup;
	}
	public void setNewSetup(boolean newSetup) {
		this.newSetup = newSetup;
	}
	public static void setData(GlobalData data) {
		Data = data;
	}
	public String getIvrRoutPath() {
		return IvrRoutPath;
	}
	public void setIvrRoutPath(String ivrRoutPath) {
		IvrRoutPath = ivrRoutPath;
	}
	public String getCalldbname() {
		return calldbname;
	}
	public void setCalldbname(String calldbname) {
		this.calldbname = calldbname;
	}
	public String getRecordPath() {
		return recordPath;
	}
	public void setRecordPath(String recordPath) {
		this.recordPath = recordPath;
	}
	public String getLic() {
		return lic;
	}
	public void setLic(String lic) {
		this.lic = lic;
	}
}
