package com.hhiephk.baitap.model.payload.request;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class PersonRequest {
	@Email(message = "invalid email address")
	private String email;
	@NotBlank(message = "Name shouldn't be null")
	private String name;
	@NotNull(message = "Name shouldn't be null")
	private Date dob;
	@NotNull(message = "Username shouldn't be null")
	private String username;
	@NotNull(message = "Password shouldn't be null")
	private String password;
	@NotNull(message = "Status shouldn't be null")
	private String status;
	
	public PersonRequest() {
		
	}
	
	public PersonRequest(String email, String name, Date dob, String username, String password, String status) {
		this.email = email;
		this.name = name;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
