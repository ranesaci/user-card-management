package com.sachin.usercardmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserInfo {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_id",length=50,nullable=false)
	private String userId;
	
	@Column(name="password",length=800,nullable=false)
	private String password;
	
	@Column(name="role",length=50)	
	private String role;
	
	@Column(name="first_name",length=50)	
	private String firstName;
	@Column(name="last_name",length=50)	
	private String lastName;
	

	@Column(name="enabled")	
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
