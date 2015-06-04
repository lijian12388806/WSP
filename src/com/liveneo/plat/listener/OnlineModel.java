package com.liveneo.plat.listener;

public class OnlineModel {
	private Object userId;
	private String userName;

	private String ipAddress;

	private String loadTime;

	private int  address;
    private String sessionId;
	/**
	 * OnlineModel
	 */
	public OnlineModel() {
	}

	public OnlineModel(Object userId,String name, String ip, String time, int address,String sessionId) {
		this.userId=userId;
		this.userName = name;
		this.ipAddress = ip;
		this.loadTime = time;
		this.address = address;
		this.sessionId = sessionId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public int getAddress() {
		return address;
	}

	public String getLoadTime() {
		return loadTime;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public void setLoadTime(String loadTime) {
		this.loadTime = loadTime;
	}

	public String getUserName() {
		return userName;
	}

	public String toString() {
		return this.userName + " " + this.ipAddress + " " + this.loadTime + " "
				+ this.address ;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

}
