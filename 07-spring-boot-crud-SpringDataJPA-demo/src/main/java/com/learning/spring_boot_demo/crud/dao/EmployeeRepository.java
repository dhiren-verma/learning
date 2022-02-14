package com.learning.spring_boot_demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.spring_boot_demo.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//By default we get all the basic CRUD Methods:
	
}
