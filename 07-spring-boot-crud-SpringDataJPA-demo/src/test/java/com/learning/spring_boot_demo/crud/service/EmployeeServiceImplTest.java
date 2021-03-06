package com.learning.spring_boot_demo.crud.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.learning.spring_boot_demo.crud.dao.EmployeeRepository;
import com.learning.spring_boot_demo.crud.dto.EmployeeDTO;
import com.learning.spring_boot_demo.crud.entity.Employee;
import com.learning.spring_boot_demo.crud.exception.EmployeeWithMailAlreadyExistsException;
import com.learning.spring_boot_demo.crud.utility.Translator;
import com.learning.spring_boot_demo.crud.exception.EmployeeNotFoundException;

//Replacement for Commented Mock:
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

	@Mock private EmployeeRepository employeeRepository;
//	private AutoCloseable autoCloseable;
	private EmployeeService underTest;
	
	@BeforeEach
	void setUp() {
//		autoCloseable = MockitoAnnotations.openMocks(this);
		underTest = new EmployeeServiceImpl(employeeRepository);
	}
	
//	@AfterEach
//	void tearDown() throws Exception {
//		autoCloseable.close();
//	}
	
	@Test
	void canGetAllEmployees() {
		// when
		underTest.findAllEmployees();
		
		// then
		verify(employeeRepository).findAll();
	}
	
	@Test
	void canFindEmployeeById() {
		// given:
		int id = 1;
		Employee emp = new Employee(id, "Dhiren", "Verma", "dhiren@gmail.com");
		
		// Setting Mock Condition:
		given(employeeRepository.findById(id)).
			willReturn(Optional.of(emp));
		
		// when
		EmployeeDTO returnedEmpDTO = underTest.findEmployeeById(id);
		Employee returnedEmp = Translator.translateDTOToEntity(returnedEmpDTO);
		
		// then
		assertThat(returnedEmp).isEqualTo(emp);
	}
	
	@Test
	void willThrowWhenFindEmployeeByIdNotFound() {
		// given:
		int id = 10;
		
		// Setting Mock Condition:
		given(employeeRepository.findById(id)).
			willReturn(Optional.empty());
		
		// when
		// then
		assertThatThrownBy(() -> underTest.findEmployeeById(id)).
			isInstanceOf(EmployeeNotFoundException.class).
			hasMessage("Employee with Id: "+id+" not found!");
		
	}
	
	@Test
	void canAddEmployee() {
		// given:
		Employee emp = new Employee(1, "Jamila", "Cabilo", "jamila@gmail.com");
		EmployeeDTO empDto = Translator.translateEntityToDTO(emp);
		
		// Setting Mock Condition:
		given(employeeRepository.save(emp)).
			willReturn(emp);
		
		// when:
		underTest.saveEmployee(empDto);
		
		// then:
		// In this Step we are instantiating an ArgumetnCaptor,
		// which will capture the actual Employee that the actual EmployeeRepository will save: 
		ArgumentCaptor<Employee> employeeArgumentCaptor =
				ArgumentCaptor.forClass(Employee.class);
		
		// Here we are just capturing the actual Employee that is saved by the
		// EmployeeRepository in the ArgumentCaptor Instance:
		verify(employeeRepository).
			save(employeeArgumentCaptor.capture());
		
		// Here we extract the Captured Employee in an Instance Variable:
		Employee capturedEmployee = employeeArgumentCaptor.getValue();
		
		assertThat(capturedEmployee).isEqualTo(emp);
	}
	
	@Test
	void willThrowWhenEmailIsTaken() {
		// given:
		Employee emp = new Employee(1, "Jamila", "Cabilo", "jamila@gmail.com");
		EmployeeDTO empDto = Translator.translateEntityToDTO(emp);
		
//		//Setting Mock condition:
//		given(employeeRepository.selectExistsEmail(emp.getEmail())).
//			willReturn(true);
		
		//Setting Mock condition:
		given(employeeRepository.selectExistsEmail(anyString())).
			willReturn(true);
		
		
		// when:
		// then:
		assertThatThrownBy(() -> underTest.saveEmployee(empDto)).
			isInstanceOf(EmployeeWithMailAlreadyExistsException.class).
			hasMessageContaining("Employee with Email: "+emp.getEmail()+" already exists!");
		
		//What we are implying here is that the EmployeeRepository never saves any Employee,
		//as it has to throw the exception:
		verify(employeeRepository, never()).save(any());
	}
	
	@Test
	void canUpdateEmployee() {
		// given:
		Employee emp = new Employee(1, "Dhiren", "Verma", "dhiren@gmail.com");
		EmployeeDTO empDto = Translator.translateEntityToDTO(emp);
		
		//Setting Mock Condition:
		given(employeeRepository.existsById(emp.getId())).
			willReturn(true);
		
		// when:
		underTest.updateEmployee(empDto);
		
		// then:
		ArgumentCaptor<Employee> employeeArgumentCaptor =
				ArgumentCaptor.forClass(Employee.class);
		
		verify(employeeRepository).
			save(employeeArgumentCaptor.capture());
		
		Employee capturedEmployee = employeeArgumentCaptor.getValue();
		
		assertThat(capturedEmployee).isEqualTo(emp);
	}
	
//	@Test
//	public void canUpdateEmployee() {
//		// given:
//		Employee emp = new Employee(1, "Dhiren", "Verma", "dhiren@gmail.com");
//		//Setting Mock Condition:
//		given(employeeRepository.existsById(emp.getId())).
//			willReturn(true);
//		
//		// when:
//		underTest.updateEmployee(emp, emp.getId());
//		
//		//Setting updated Mock Condition:
//		given(employeeRepository.findById(emp.getId())).
//			willReturn(Optional.of(emp));
//		
//		//Argument Captor will not work here, as our Update method in Service Layer doesnm't call save method in Repository,
//		//rather first Update the Employee, then Fetch and check if the Fetched Employee is same as the one sent to be Updated:
//		Employee returnedEmp = underTest.findEmployeeById(emp.getId());
//		
//		assertThat(returnedEmp).isEqualTo(emp);
//	}
	
	@Test
	void willThrowWhenUpdateUpdateRequestEmployeeIdNotFound() {
		// given:
		Employee emp = new Employee(1, "Dhiren", "Verma", "dhiren@gmail.com");
		EmployeeDTO empDto = Translator.translateEntityToDTO(emp);
		
		//Setting Mock Condition:
		given(employeeRepository.existsById(emp.getId())).
			willReturn(false);
		
		// when:
		// then:
		assertThatThrownBy(() -> underTest.updateEmployee(empDto)).
			isInstanceOf(EmployeeNotFoundException.class).
			hasMessageContaining("Employee with Id: "+emp.getId()+" not found!");
	}
	
	@Test
	 void canDeleteEmployeeById() {
		// given:
		int id = 10;
		
		//Setting Mock Condition:
		given(employeeRepository.existsById(id)).
			willReturn(true);
		
//		//Setting Mock Condition:
//		given(employeeRepository.existsById(anyInt())).
//			willReturn(true);
		
		// when:
		underTest.deleteEmployeeById(id);
		
		// then:
		verify(employeeRepository).deleteById(id);
	}
	
	@Test
	void willThrowWhenDeleteEmployeeNotFound() {
		// given:
		int id = 10;
		
		//Setting Mock Condition:
		given(employeeRepository.existsById(id)).
			willReturn(false);
		
		// when:
		// then:
		assertThatThrownBy(() -> underTest.deleteEmployeeById(id)).
			isInstanceOf(EmployeeNotFoundException.class).
			hasMessage("Employee with Id: "+id+" not found!");
		
		verify(employeeRepository, never()).delete(any());
	}
	
}
