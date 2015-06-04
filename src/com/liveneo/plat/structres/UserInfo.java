/*
 * Copyright 2009 HUAPU
 */
package com.liveneo.plat.structres;

import java.io.Serializable;

import com.liveneo.plat.hibernate.dao.Userinfo;

/**
 * @author Administrator
 *
 */
public class UserInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户信息
	 */
	private Userinfo user;
	
	/**
	 * Top Menu	 
	 */
	private String topmenu;
	private String shortcutmenu;
	
	
	private String userid;
	private String username;
	public UserInfo(String userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	public UserInfo() {
	
	}
	
	public String getTopmenu() {
		return topmenu;
	}
	public void setTopmenu(String topmenu) {
		this.topmenu = topmenu;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getShortcutmenu() {
		return shortcutmenu;
	}
	public void setShortcutmenu(String shortcutmenu) {
		this.shortcutmenu = shortcutmenu;
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	
}





