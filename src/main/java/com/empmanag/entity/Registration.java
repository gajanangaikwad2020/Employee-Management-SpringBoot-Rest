package com.empmanag.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@CrossOrigin
public class Registration 
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO) 
	private int userId;
//	@NotNull(message = "Employee Name Should not Be Null")
//	@Column(unique = true)
	private String fname;
	private String lname;
	private String address;
	private String username;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Email(message = "Invalid email address")
	private String emailId;
	private String password;
	@Pattern(regexp = "^$|[0-9]{10}",message = "Contact No Should be proper")
	private String contactNo;
	private String gender; 
//	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date creationDate;
	public Registration() {
		super();
	}
	public Registration(int userId, String fname, String lname, String address, String username, Date dob,
			@Email(message = "Invalid email address") String emailId, String password,
			@Pattern(regexp = "^$|[0-9]{10}", message = "Contact No Should be proper") String contactNo, String gender,
			Date creationDate) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.username = username;
		this.dob = dob;
		this.emailId = emailId;
		this.password = password;
		this.contactNo = contactNo;
		this.gender = gender;
		this.creationDate = creationDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Registration [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", username=" + username + ", dob=" + dob + ", emailId=" + emailId + ", password=" + password
				+ ", contactNo=" + contactNo + ", gender=" + gender + ", creationDate=" + creationDate + "]";
	}
	
	
}
