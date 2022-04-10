package com.ms.multitenant.entity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "userDetails")
public class UserDetail {

	@Id
	private String phoneHash;
	private String passwordHash;
	private Date createdOn;
	private Date lastLogin;

	public String getPhoneHash() {
		return phoneHash;
	}

	public void setPhoneHash(String phoneHash) {
		this.phoneHash = phoneHash;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
