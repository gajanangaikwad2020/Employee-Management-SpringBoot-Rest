package com.empmanag.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.empmanag.dao.EmployeeDao;
import com.empmanag.entity.Employee;

@Repository
public class EmployeeDaoIMPL implements EmployeeDao
{
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public boolean addEmployee(Employee employee) 
	{	  
//		System.out.println("Employee in Dao 1 :"+employee);	
		boolean isAdded=false;
		try 
		{
		   Session session = sessionFactory.openSession();
		   Employee employeedb=session.get(Employee.class, employee.geteId());
//		   System.out.println("Employee in dao check null :"+employeedb);
		   if(employeedb==null)
		   {
			   Transaction transaction = session.beginTransaction();
			   session.save(employee);
			   System.out.println("Employee in Dao Transaction :"+employee); 
			   transaction.commit();
			   isAdded = true;
		   }
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return isAdded;
	}


	@Override
	public Employee getEmployeeById(int empId) 
	{
		Employee employee=new Employee();
		try 
		{
			Session session = sessionFactory.openSession();
			employee = session.get(Employee.class, empId);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return employee;
	}


	@Override
	public boolean updateEmployee(Employee employee) 
	{
		boolean updated = false;
		try {
			Session session = sessionFactory.openSession();
			Employee employee2 = session.get(Employee.class, employee.geteId());
			if(employee2!=null) 
			{
				Session session2 = sessionFactory.openSession();
				Transaction transaction = session2.beginTransaction();
				session2.update(employee);
				transaction.commit();
				updated=true;
			}
			else
				System.out.println("Employee id:"+employee.geteId()+" is not exist");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return updated;
	}


	@Override
	public Employee deleteEmployeeById(int empId) 
	{
		Employee employee=null;
		try 
		{
			Session session = sessionFactory.openSession();
			employee = session.get(Employee.class, empId);
			Transaction transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
			System.out.println("Employee which has "+empId+ " Id is Deleted.");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return employee;
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Employee> getAllEmployees() 
	{	
		List<Employee> employees=null;
		try 
		{
			Session session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(Employee.class);
			employees=criteria.list();
			session.close();
			return employees;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
		return employees;
	}
	

}
