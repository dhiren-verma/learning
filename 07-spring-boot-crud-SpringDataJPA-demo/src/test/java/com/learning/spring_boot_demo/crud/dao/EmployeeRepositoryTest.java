package com.learning.spring_boot_demo.crud.dao;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.learning.spring_boot_demo.crud.entity.Employee;

@DataJpaTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository underTest;
	
	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}
	
	//This is just an Example,
	//Here we might be testing Methods provided by SpringData JpaRepository implicitly,
	//Although we don't need to.
	//We just need to test those features which we define explicitly.
	
	@Test
	void itShouldCheckIfEmployeeEmailExists() {
		// given:
		String email = "pete@gmail.com";
		Employee emp = new Employee(1, "Pete", "Davidson", email);
		underTest.save(emp);
		
		// when
		boolean exists = underTest.selectExistsEmail(email);
		
		// then
		assertThat(exists).isTrue();
	}

	@Test
	void itShouldCheckWhenEmployeeEmailDoesNotExists() {
		// given:
		String email = "pete@gmail.com";
		
		// when:
		boolean exists = underTest.selectExistsEmail(email);
		
		// then:
		assertThat(exists).isFalse();
	}
	
//	@Test
//	void itShouldCheckIfExistingEmployeeIsUpdated() {
//		// given:
//		int id = 1;
//		Employee emp = new Employee(id, "Patrick", "Cummins", "patrick.c@gmail.com");
//		underTest.save(emp);
//		
//		Employee replacementEmp = new Employee(id, "Alicia", "Fox", "alicia@gmail.com");
//		
//		// when:
//		underTest.setEmployeeInfoById(replacementEmp.getFirstName(), replacementEmp.getLastName(), replacementEmp.getEmail(), id); 
//		
//		// then:
//		Employee updatedEmployee = underTest.getById(id);
//		assertThat(updatedEmployee).isEqualTo(replacementEmp);
//	}
	
}
