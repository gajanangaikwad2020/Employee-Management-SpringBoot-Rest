package com.empmanag.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmanag.entity.Login;
import com.empmanag.entity.Registration;
import com.empmanag.exception.UserNameAlreadyExistException;
import com.empmanag.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class LoginController 
{
	@Autowired
	private LoginService loginService;


	@PostMapping(value = "/login")
	public ResponseEntity<HashMap<String, Object>> login(@Valid @RequestBody Login login) 
	{
		Registration user=loginService.login(login);
		HashMap<String, Object> hashMap=new HashMap<>();

		if(user!=null)
		{
			hashMap.put("msg","Valid User");
			hashMap.put("Valid User", user);
		}
		else
		{
			hashMap.put("msg","Invalid User");
			hashMap.put("User", user);
		}
		return new ResponseEntity<HashMap<String, Object>>(hashMap,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes" })
	@PostMapping(value = "/registration")
	public HashMap registration(@Valid @RequestBody Registration reg) 
	{
		HashMap user=loginService.registration(reg);
		
		return user;
	}
}


//"emailId":"pavanthakare@gmail.com",
//"password":"pavan123"
//	
//	   "name": "Prakash Pande",
//       "address": "Washim",
//       "dob": "1992/08/02",
//       "emailId": "prakashkale@gmail.com",
//       "password": "prakash123",
//       "contactNo": "8484848484",
//       "gender": "Male",
//       "creationDate": "2023-01-09"