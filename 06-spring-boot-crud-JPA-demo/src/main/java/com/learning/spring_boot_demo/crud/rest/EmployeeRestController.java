package com.learning.spring_boot_demo.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_boot_demo.crud.entity.Employee;
import com.learning.spring_boot_demo.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService empService;
	
	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		this.empService = empService;
	} 
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return empService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee = empService.findById(employeeId);
		
		if (employee == null)
			throw new RuntimeException("Employee Id not found - " + employeeId);
		
		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		//Reset Employee's Id as '0', because if Client sends some other value
		//and an Employee with that Id already exists, then that Entry will get
		//updated in DB:
		theEmployee.setId(0);
		
		empService.save(theEmployee);
		
		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		empService.save(theEmployee);
		
		return theEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable int employeeId) {
		Employee tempEmp = empService.findById(employeeId);
		
		if (tempEmp == null)
			throw new RuntimeException("Employee Id not found - " + employeeId);
		
		empService.deleteById(employeeId);
		
		return "Deleted Employee with Id - "+employeeId;
		
	}
	
}
