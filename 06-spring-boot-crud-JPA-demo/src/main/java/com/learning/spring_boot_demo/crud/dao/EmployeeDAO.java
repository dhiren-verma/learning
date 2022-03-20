package com.learning.spring_boot_demo.crud.dao;

import java.util.List;
import java.util.Optional;

import com.learning.spring_boot_demo.crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAllEmployees();
	
	public Optional<Employee> findEmployeeById(int id);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteEmployeeById(int id);
	
}
