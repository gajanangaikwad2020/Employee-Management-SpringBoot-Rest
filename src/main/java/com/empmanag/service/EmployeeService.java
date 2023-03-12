package com.empmanag.service;

import java.util.List;

import com.empmanag.entity.Employee;

public interface EmployeeService 
{
	public boolean addEmployee(Employee employee);	
	
	public Employee getEmployeeById(int empId);
	
	public boolean updateEmployee(Employee employee);

	public Employee deleteEmployeeById(int empId);
	
	public List<Employee> getAllEmployees();

	
}
