package com.empmanag.exception;



public class EmployeeNameAlreadyExistException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNameAlreadyExistException(String msg) 
	{
		super(msg);
	}

	
}
