package com.empmanag.dao;

import java.util.List;

import com.empmanag.entity.Employee;

public interface EmployeeDao 
{

	public boolean addEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public Employee getEmployeeById(int empId);

	public Employee deleteEmployeeById(int empId);

	public List<Employee> getAllEmployees();


	

}
