package com.empmanag.exception;



public class UserNameAlreadyExistException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistException(String msg) 
	{
		super(msg);
	}

	
}
