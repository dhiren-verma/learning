package com.learning.spring_boot_demo.crud.service;

import java.util.List;

import com.learning.spring_boot_demo.crud.dto.EmployeeDTO;

public interface EmployeeService {
	
	public List<EmployeeDTO> findAllEmployees();
	
	public EmployeeDTO findEmployeeById(int id);
	
	public int saveEmployee(EmployeeDTO theEmployee);
	
//	public void updateEmployee(Employee theEmployee, int id);
	public void updateEmployee(EmployeeDTO theEmployee);
	
	public void deleteEmployeeById(int id);

}
