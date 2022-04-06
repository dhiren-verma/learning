package com.learning.spring_boot_demo.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring_boot_demo.crud.dao.EmployeeRepository;
import com.learning.spring_boot_demo.crud.dto.EmployeeDTO;
import com.learning.spring_boot_demo.crud.exception.EmployeeWithMailAlreadyExistsException;
import com.learning.spring_boot_demo.crud.utility.Translator;
import com.learning.spring_boot_demo.crud.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;

	private static String empNotFoundMsg = "Employee with Id: %d not found!";

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	//No need to explicitly mention @Transaction as Spring Data JPA
	//provides this functionality:
//	@Transactional
	public List<EmployeeDTO> findAllEmployees() {
		return empRepo.findAll().stream().
				map(Translator::translateEntityToDTO).
				collect(Collectors.toList());
	}

	@Override
//	@Transactional
	public EmployeeDTO findEmployeeById(int id) {
		return empRepo.findById(id).
				map(Translator::translateEntityToDTO).
				orElseThrow(() -> new EmployeeNotFoundException(String.format(empNotFoundMsg, id)));
//		new EmployeeNotFoundException("Employee with Id: "+id+" not found!")
	}

	@Override
//	@Transactional
	public int saveEmployee(EmployeeDTO theEmployee) {
		if (empRepo.selectExistsEmail(theEmployee.getEmail()))
			throw new EmployeeWithMailAlreadyExistsException("Employee with Email: "+theEmployee.getEmail()+" already exists!");
		
		return empRepo.save(Translator.translateDTOToEntity(theEmployee)).getId();
	}

	@Override
//	@Transactional
	public void updateEmployee(EmployeeDTO theEmployee) {
		if (!empRepo.existsById(theEmployee.getId()))
			throw new EmployeeNotFoundException(String.format(empNotFoundMsg, theEmployee.getId()));
		
		empRepo.save(Translator.translateDTOToEntity(theEmployee));
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
