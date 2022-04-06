package com.learning.spring_boot_demo.crud.service;

import java.util.List;

import com.learning.spring_boot_demo.crud.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAllEmployees();
	
	public Employee findEmployeeById(int id);
	
	public void saveEmployee(Employee theEmployee);
	
//	public void updateEmployee(Employee theEmployee, int id);
	public void updateEmployee(Employee theEmployee);
	
	public void deleteEmployeeById(int id);

}
