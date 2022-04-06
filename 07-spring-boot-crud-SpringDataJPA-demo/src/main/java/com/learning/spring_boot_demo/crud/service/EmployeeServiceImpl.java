package com.learning.spring_boot_demo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring_boot_demo.crud.dao.EmployeeRepository;
import com.learning.spring_boot_demo.crud.entity.Employee;
import com.learning.spring_boot_demo.crud.exception.EmployeeWithMailAlreadyExistsException;
import com.learning.spring_boot_demo.crud.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	@Override
	//No need to explicitly mention @Transaction as Spring Data JPA
	//provides this functionality:
//	@Transactional
	public List<Employee> findAllEmployees() {
		return empRepo.findAll();
	}

	@Override
//	@Transactional
	public Employee findEmployeeById(int id) {
		return empRepo.findById(id).
				orElseThrow(() -> new EmployeeNotFoundException("Employee with Id: "+id+" not found!"));
	}

	@Override
//	@Transactional
	public void saveEmployee(Employee theEmployee) {
		if (empRepo.selectExistsEmail(theEmployee.getEmail()))
			throw new EmployeeWithMailAlreadyExistsException("Employee with Email: "+theEmployee.getEmail()+" already exists!");
		
		empRepo.save(theEmployee);
	}

	@Override
//	@Transactional
	public void updateEmployee(Employee theEmployee) {
		if (!empRepo.existsById(theEmployee.getId()))
			throw new EmployeeNotFoundException("Employee with Id: "+theEmployee.getId()+" not found!");
		
		empRepo.save(theEmployee);
//		empRepo.setEmployeeInfoById(theEmployee.getFirstName(), theEmployee.getLastName(), theEmployee.getEmail(), id);
	}

	@Override
//	@Transactional
	public void deleteEmployeeById(int id) {
		if (!empRepo.existsById(id))
			throw new EmployeeNotFoundException("Employee with Id: "+id+" not found!");
		
		empRepo.deleteById(id);
	}

}
