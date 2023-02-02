package com.hhiephk.baitap.model.payload.request;

public class AuthenticationRequest {

	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationRequest() {
		
	}

	public AuthenticationRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}