package com.empmanag.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.bind.annotation.CrossOrigin;
@Entity
@CrossOrigin()
public class Employee 
{

	@Id
	@GeneratedValue (generator = "emp_generator",strategy = GenerationType.AUTO) //Bydefault by 1
	@SequenceGenerator(name = "emp_generator",sequenceName = "empIdSequence",initialValue = 101,allocationSize = 1)
	private int eId;
	@NotNull(message = "Employee Name Should not Be Null")
	private String eName;
	private String eDept;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate=new Date(System.currentTimeMillis());
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate=new Date(System.currentTimeMillis());
	private String updatedBy;
	@Pattern(regexp = "^$|[0-9]{10}",message = "Phone No Should not Be Null")
	private String phoneNo;
	@Email(message = "Invalid email address")
	private String emailid;
	
	private String gender; 
	
	@OneToOne
	private Country country;  //Country Class Reference Variable

	public Employee() 
	{
		super();
		
	}

	public Employee(int eId, @NotNull(message = "Employee Name Should not Be Null") String eName, String eDept,
			String status, Date createdDate, String createdBy, Date updatedDate, String updatedBy,
			@Pattern(regexp = "^$|[0-9]{10}", message = "Phone No Should not Be Null") String phoneNo,
			@Email(message = "Invalid email address") String emailid, String gender, Country country) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eDept = eDept;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.phoneNo = phoneNo;
		this.emailid = emailid;
		this.gender = gender;
		this.country = country;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteDept() {
		return eDept;
	}

	public void seteDept(String eDept) {
		this.eDept = eDept;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eDept=" + eDept + ", status=" + status
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", updatedDate=" + updatedDate
				+ ", updatedBy=" + updatedBy + ", phoneNo=" + phoneNo + ", emailid=" + emailid + ", gender=" + gender
				+ ", country=" + country + "]";
	}

	

		
}
