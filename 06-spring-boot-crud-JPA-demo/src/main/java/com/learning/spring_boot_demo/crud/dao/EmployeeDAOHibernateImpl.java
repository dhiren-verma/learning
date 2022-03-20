package com.learning.spring_boot_demo.crud.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.spring_boot_demo.crud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		//Get current Hibernate Session:
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Create a query:
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query to fetch results:
		List<Employee> employees = theQuery.getResultList();
		
		//return results:
		return employees;
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, id);
		
		return Optional.ofNullable(theEmployee);
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteEmployeeById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId", Employee.class);
		
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
	}

}
