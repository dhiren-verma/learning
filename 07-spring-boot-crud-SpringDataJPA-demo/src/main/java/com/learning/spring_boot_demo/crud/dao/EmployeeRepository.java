package com.learning.spring_boot_demo.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.spring_boot_demo.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//By default we get all the basic CRUD Methods:
	
	//Custom Methods:
	@Query("SELECT CASE WHEN COUNT(e) > 0 THEN " +
			"TRUE ELSE FALSE END " +
			"FROM Employee e " +
			"WHERE e.email = ?1")
	Boolean selectExistsEmail(String email);
	
	//Not required as Save method achieves the same Result: 
//	@Modifying
//	@Query("UPDATE Employee e " +
//			"SET e.firstName = :firstName, e.lastName = :lastName, e.email = :email " +
//			"WHERE e.id = :id")
//	void setEmployeeInfoById(@Param("firstName") String firstName, @Param("lastName") String lastName,
//			@Param("email") String email, @Param("id") int id);
	
}
