package com.learning.spring_boot_demo.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.learning.spring_boot_demo.crud.entity.Employee;

@Repository
//@Primary
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		//Create a query:
		TypedQuery<Employee> theQuery = entityManager.
				createQuery("from Employee", Employee.class);
		
		//execute query to fetch results:
		List<Employee> employees = theQuery.getResultList();
		
		//return results:
		return employees;
	}

	@Override
	public Employee findById(int id) {
		Employee theEmployee = entityManager.find(Employee.class, id);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//save/update the Employee:
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db... so we can get generated id from save/insert:
		//Useful in out REST API to return generated Id:
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
	}

}
