package com.empmanag.service;

import java.util.HashMap;

import com.empmanag.entity.Login;
import com.empmanag.entity.Registration;

public interface LoginService 
{

	public Registration login(Login login);

	@SuppressWarnings("rawtypes")
	public HashMap registration(Registration registration);

}
