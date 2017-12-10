package com.sachin.usercardmanagement.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotNull
	@NotEmpty
	private String userId;
	@NotNull
	@NotEmpty
	private String password;
	
	private String confirmPassword;
	@NotNull
	@NotEmpty
	private String role;
	@NotNull
	@NotEmpty
	private String firstName;
	@NotNull
	@NotEmpty
	private String lastName;
	
	private Short enabled;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Short getEnabled() {
		return enabled;
	}
	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}
	
	
	


	

}
