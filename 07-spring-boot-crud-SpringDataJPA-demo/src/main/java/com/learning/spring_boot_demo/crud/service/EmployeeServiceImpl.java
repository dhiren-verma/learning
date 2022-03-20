package com.learning.spring_boot_demo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring_boot_demo.crud.dao.EmployeeRepository;
import com.learning.spring_boot_demo.crud.entity.Employee;
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
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
//	@Transactional
	public Employee findById(int id) {
		return empRepo.findById(id).
				orElseThrow(() -> new EmployeeNotFoundException("Employee with Id: "+id+" not found!"));
	}

	@Override
//	@Transactional
	public void save(Employee theEmployee) {
		empRepo.save(theEmployee);
	}

	@Override
//	@Transactional
	public void deleteById(int id) {
		empRepo.deleteById(id);
	}

}
