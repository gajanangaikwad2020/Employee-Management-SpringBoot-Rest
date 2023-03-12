package com.empmanag.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Country 
{
	@Id
	@GeneratedValue (generator = "contry_generator",strategy = GenerationType.AUTO) //Bydefault by 1
	@SequenceGenerator(name = "country_generator",sequenceName = "conIdSequence",initialValue = 1,allocationSize = 1)
	private int cId;
	@NotNull(message = "Country Name is Required")
	private String cName;
	public Country() 
	{
		super();	
	}
	public Country(int cId, @NotNull(message = "Country Name is Required") String cName) 
	{
		super();
		this.cId = cId;
		this.cName = cName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "Country [cId=" + cId + ", cName=" + cName + "]";
	}
	
	
	
}
