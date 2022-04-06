package com.learning.spring_boot_demo.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_boot_demo.crud.dto.EmployeeDTO;
import com.learning.spring_boot_demo.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeRestController {

	private EmployeeService empService;

	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> findAllEmployees() {
		List<EmployeeDTO> allEmployees = empService.findAllEmployees();
		
		if (allEmployees.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(allEmployees, HttpStatus.OK);
		
	}

	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable int employeeId) {
		EmployeeDTO employee = empService.findEmployeeById(employeeId);
		
//		if (employee == null)
//			throw new RuntimeException("Employee Id not found - " + employeeId);
		
		return new ResponseEntity<>(employee, HttpStatus.FOUND);
	}

	@PostMapping("/employees")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO theEmployee) {
		//Reset Employee's Id as '0', because if Client sends some other value
		//and an Employee with that Id already exists, then that Entry will get
		//updated in DB:
		theEmployee.setId(0);
		
		int genId = empService.saveEmployee(theEmployee);
		
		theEmployee.setId(genId);
		
		return new ResponseEntity<>(theEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO theEmployee,
			@PathVariable int employeeId) {
		empService.updateEmployee(theEmployee);
		
		return new ResponseEntity<>(theEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int employeeId) {
//		Employee tempEmp = 
//		empService.findEmployeeById(employeeId);
		
//		if (tempEmp == null)
//			throw new RuntimeException("Employee Id not found - " + employeeId);
		
		empService.deleteEmployeeById(employeeId);
		
		return new ResponseEntity<>("Deleted Employee with Id - "+employeeId, HttpStatus.OK);
		
	}

}
