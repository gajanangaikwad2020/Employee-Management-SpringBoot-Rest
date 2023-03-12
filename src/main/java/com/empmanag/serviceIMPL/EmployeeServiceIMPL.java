package com.empmanag.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanag.dao.EmployeeDao;
import com.empmanag.entity.Employee;
import com.empmanag.service.EmployeeService;
@Service
public class EmployeeServiceIMPL implements EmployeeService
{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public boolean addEmployee(Employee employee) 
	{
		
		return employeeDao.addEmployee(employee) ;
	}

	@Override
	public Employee getEmployeeById(int empId) {
	
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public boolean updateEmployee(Employee employee) 
	{
		
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee deleteEmployeeById(int empId) 
	{
		
		return employeeDao.deleteEmployeeById(empId);
	}

	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}	

}
