package com.empmanag.exception;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse2 
{
	private String timeStamp;
	private String message;
	private List<String> fieldErrors=new ArrayList<>();
	
	public ErrorResponse2() 
	{
		super();
		
	}

	public ErrorResponse2(String timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<String> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public ErrorResponse2(String timeStamp, String message, List<String> fieldErrors) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.fieldErrors = fieldErrors;
	}
	
	
}