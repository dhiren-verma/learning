package com.learning.spring_boot_demo.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring_boot_demo.crud.dao.EmployeeDAO;
import com.learning.spring_boot_demo.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDao;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl")EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return empDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return empDao.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		empDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		empDao.deleteById(id);
	}

}
