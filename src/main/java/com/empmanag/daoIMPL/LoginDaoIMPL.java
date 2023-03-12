package com.empmanag.daoIMPL;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empmanag.dao.LoginDao;
import com.empmanag.entity.Login;
import com.empmanag.entity.Registration;

@Repository
public class LoginDaoIMPL implements LoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public Registration login(Login login) 
	{
//		Registration registration=new Registration(); //It does not give object of Registration directly, but it will give object based on passing primary key field or unique fields.
		Registration registration=null;
		try
		{
			Session session = sessionFactory.openSession();
			
	 		String loginEmailId=login.getEmailId();
//	 		String loginPassword=login.getPassword();
	 		
	 		Criteria criteria1 = session.createCriteria(Registration.class);

	 		criteria1.add(Restrictions.eq("emailId", loginEmailId));
	 		registration = (Registration) criteria1.uniqueResult();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return registration;
	}

//	@Override
//	public boolean registration(Registration registration) 
//	{
//		boolean isAdded=false;
//		try 
//		{
//		   Session session = sessionFactory.openSession();
//		   Registration registrationdb=session.get(Registration.class, registration.getrId());
//		   if(registrationdb==null)
//		   {
//			   Transaction transaction = session.beginTransaction();
//			   session.saveOrUpdate(registration);
//			   transaction.commit();
//			   isAdded = true;
//		   }
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}	
//		return isAdded;
	
	
	//Sir Code
	@SuppressWarnings("deprecation")
	@Override
	public Registration registration(Registration registration) 
	{
		Registration user=null;
		try 
		{
		   Session session = sessionFactory.openSession();
		   Criteria criteria = session.createCriteria(Registration.class);
		   criteria.add(Restrictions.eq("emailId", registration.getEmailId()));
		   criteria.add(Restrictions.eq("password", registration.getPassword()));

		   user=(Registration) criteria.uniqueResult();
		   
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return user;
	}
	
	

}


