package com.ms.multitenant.entity.request;

/**
 * Generic auth request
 * 
 * @author alien
 *
 */
public class AuthRequest {

	private String password;
	private String phoneHash;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneHash() {
		return phoneHash;
	}

	public void setPhoneHash(String phoneHash) {
		this.phoneHash = phoneHash;
	}

}
