package com.empmanag.exception;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		HashMap<String, Object> hmap = new HashMap<>();
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new java.util.Date());
		hmap.put("Timestamp", timeStamp);
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) 
		{
			hmap.put(fieldError.getField(), fieldError.getDefaultMessage());	
		}
		return hmap;
	}
//	
	@ExceptionHandler(EmployeeNameAlreadyExistException.class)
	public ResponseEntity<ErrorResponse2> handleEmployeeNameAlreadyExistException(EmployeeNameAlreadyExistException exception)
	{
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new java.util.Date());
		ErrorResponse2 response=new ErrorResponse2(timeStamp, exception.getMessage());
		return new ResponseEntity<ErrorResponse2>(response,HttpStatus.ALREADY_REPORTED);
	}
	@ExceptionHandler(CountryNameAlreadyExistException.class)
	public ResponseEntity<ErrorResponse2> handleCountryNameAlreadyExistException(CountryNameAlreadyExistException exception)
	{
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new java.util.Date());
		ErrorResponse2 response=new ErrorResponse2(timeStamp, exception.getMessage());
		return new ResponseEntity<ErrorResponse2>(response,HttpStatus.ALREADY_REPORTED);
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse2> handleEmployeeNotFoundException(EmployeeNotFoundException exception)
	{
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new java.util.Date());
		ErrorResponse2 response=new ErrorResponse2(timeStamp, exception.getMessage());
		return new ResponseEntity<ErrorResponse2>(response,HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<ErrorResponse2> handleCountryNotFoundException(CountryNotFoundException exception)
	{
		String timeStamp = new SimpleDateFormat("yyyy:MM:dd.HH:mm:ss").format(new java.util.Date());
		ErrorResponse2 response=new ErrorResponse2(timeStamp, exception.getMessage());
		return new ResponseEntity<ErrorResponse2>(response,HttpStatus.NOT_FOUND);
	}
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) 
//	{
//		BindingResult bindingResult = ex.getBindingResult();
//		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//		List<String> errors=new ArrayList<>();
//		for (FieldError fieldError : fieldErrors) 
//		{
//			errors.add(fieldError.getDefaultMessage());
////			hmap.put(fieldError.getField(), fieldError.getDefaultMessage());	
//		}
//		ErrorResponse2 errorResponse2=new ErrorResponse2(LocalDateTime.now(),"Bad Request",errors);
//
//		return handleExceptionInternal(ex, errorResponse2, headers, status, request);
//	}

//	{
//		   
//	    "eName":"Nayan",
//	    "eDept":"Admin",
//	    "status":"Active",
//	   
//	    "createdBy":"Raj Sir",
//	   
//	    "updatedBy":"Minal Madam",
//	    "phoneo":9298456287,
//	    "emailid":"nayan141@gmail.com",
//	    "gender":"Male",
//	    "country":{
//	       
//	        "cName":"China"
//	    }
//	}
	 

  
}
	
