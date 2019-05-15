package com.codinsaint.tutorial.spring.userservice.config;

public class DefaultUser {
	
	private String user;
	private String email;
	private String [] roles;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	

}
