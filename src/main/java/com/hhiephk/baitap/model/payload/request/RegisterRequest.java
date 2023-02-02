package com.hhiephk.baitap.model.payload.request;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	@Email(message = "invalid email address")
	private String email;
	@NotBlank(message = "Name shouldn't be null")
	private String name;
	@NotNull(message = "Name shouldn't be null")
	private Date dob;
	@Length(min = 6, max = 20)
	private String username;
	@Length(min = 6, max = 20)
	private String password;
	@NotBlank(message = "Status shouldn't be null")
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RegisterRequest(String name, String email, String username, String password, Date dob, String status) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.status = status;
	}
	
	public RegisterRequest() {
		
	}

}
