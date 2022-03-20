package com.learning.spring_boot_demo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring_boot_demo.crud.dao.EmployeeDAO;
import com.learning.spring_boot_demo.crud.entity.Employee;
import com.learning.spring_boot_demo.crud.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDao;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl")EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	@Transactional
	public List<Employee> findAllEmployees() {
		return empDao.findAllEmployees();
	}

	@Override
	@Transactional
	public Employee findEmployeeById(int id) {
		return empDao.findEmployeeById(id).
				orElseThrow(() -> new EmployeeNotFoundException("Employee with Id: "+id+" not found!"));
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		empDao.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int id) {
		empDao.deleteEmployeeById(id);
	}

}
