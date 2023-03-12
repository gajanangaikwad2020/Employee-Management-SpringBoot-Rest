package com.empmanag.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empmanag.dao.EmployeeDao;
import com.empmanag.entity.Employee;
import com.empmanag.exception.EmployeeNameAlreadyExistException;
import com.empmanag.exception.EmployeeNotFoundException;
import com.empmanag.service.EmployeeService;


@RestController
@RequestMapping(value = "/employee")
@CrossOrigin
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeDao employeeDao;

	@PostMapping(value = "/add-employee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) 
	{
		System.out.println("Employee in COntroller :"+employee);		
		boolean isAdded = employeeService.addEmployee(employee);
		if(isAdded)
		{
			return new ResponseEntity<String>("New Employee Record is Added With Emp-Id :"+employee.geteId(),HttpStatus.CREATED);
		}
		else
		{
			throw new EmployeeNameAlreadyExistException("Employee Name is Already Exist for Emp-Id :"+employee.geteId());
		}
	}
	
	@PutMapping(value = "/update-employee")
	public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee) 
	{
		
		Employee empId =employeeDao.getEmployeeById(employee.geteId());
		if(empId!=null)
		{
			if(employeeService.updateEmployee(employee))
			{	
				return new ResponseEntity<Object>("Employee is Updated of Emp-Id :"+employee.geteId(), HttpStatus.CREATED);
			}
			else
			{
				throw new EmployeeNameAlreadyExistException("Employee Name Already Exist for Id :");
			}
		}
		else
		{
			throw new EmployeeNotFoundException("Employee Id ->"+employee.geteId()+" Not Exist for Update the Employee.");
		}
		
	}
	
	@SuppressWarnings({ "unused" })
	@GetMapping(value = "/get-employee-by-id/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@Valid @PathVariable int empId) 
	{

		Employee employee2 = employeeService.getEmployeeById(empId);
		if(employee2!=null)
		{
			return new ResponseEntity<Employee>(employee2, HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotFoundException("Employee Not Found with EmpId :"+empId);
		}
	}
	
	@DeleteMapping(value = "/delete-employee-by-id/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@Valid @PathVariable int empId) 
	{
		Employee employee = null;
		employee = employeeService.deleteEmployeeById(empId);
		
		if(employee!=null)
		{
			return new ResponseEntity<String>("Employee is Deleted Which has Id :"+empId, HttpStatus.OK);
		}
		else
		{
			throw new EmployeeNotFoundException("Employee is Not Found for Id :"+empId);
		}
	}
	
	@GetMapping(value = "/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() 
	{
		  List<Employee> allEmployees = employeeService.getAllEmployees();
		  return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
	}



	//deepak - 8999901658
	//parshuram- 9011852473
	

}
