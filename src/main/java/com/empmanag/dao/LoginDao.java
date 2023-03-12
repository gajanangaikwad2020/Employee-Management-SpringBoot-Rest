package com.empmanag.dao;

import com.empmanag.entity.Login;
import com.empmanag.entity.Registration;

public interface LoginDao 
{

	public Registration login(Login login);

	public Registration registration(Registration registration);

}
