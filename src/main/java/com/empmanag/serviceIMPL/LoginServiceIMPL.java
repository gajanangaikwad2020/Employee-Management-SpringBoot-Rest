package com.empmanag.serviceIMPL;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanag.dao.LoginDao;
import com.empmanag.entity.Login;
import com.empmanag.entity.Registration;
import com.empmanag.service.LoginService;
@Service
public class LoginServiceIMPL implements LoginService
{
	@Autowired
	private LoginDao loginDao;

	@Override
	public Registration login(Login login) 
	{
		 Registration registration=null;
		 registration = loginDao.login(login);
		 if(registration!=null && registration.getPassword().equals(login.getPassword()))
		 {
			 return registration;
		 }
		 return registration;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public HashMap registration(Registration reg) 
	{
		
		Registration user=loginDao.registration(reg);
		HashMap hashMap=new HashMap();

		if(user!=null)
		{
			hashMap.put("msg","Valid User");
			user.setPassword("**********");
		}
		else
		{
			hashMap.put("msg","Invalid User");
		}
		hashMap.put("user", user);
		
		return hashMap;
	}
	
	

}
