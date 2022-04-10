package com.ms.multitenant.entity.response;

import java.util.Date;

public class AuthResponse {


	private Date lastLogin;
	private Date createdOn;
	private String phoneHash;


	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getPhoneHash() {
		return phoneHash;
	}
	public void setPhoneHash(String phoneHash) {
		this.phoneHash = phoneHash;
	}	
	
}
