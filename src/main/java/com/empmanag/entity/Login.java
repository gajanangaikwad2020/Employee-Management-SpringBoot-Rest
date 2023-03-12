package com.empmanag.entity;

import javax.validation.constraints.Email;

public class Login 
{

	@Email(message = "Invalid email address")
	private String emailId;
	private String password;
	
	public Login() {
		super();
		
	}

	public Login(@Email(message = "Invalid email address") String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [emailId=" + emailId + ", password=" + password + "]";
	}
	
	
	
}
