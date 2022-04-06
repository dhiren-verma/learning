package com.learning.spring_boot_demo.crud.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.learning.spring_boot_demo.crud.dto.EmployeeDTO;
import com.learning.spring_boot_demo.crud.entity.Employee;

public class Translator {
	
	public static EmployeeDTO translateEntityToDTO(Employee emp) {
		EmployeeDTO empDTO = new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail());
		return empDTO;
	}
	
	public static List<EmployeeDTO> translateEntityToDTO(List<Employee> emps) {
		return emps.stream().
				map(emp -> new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail())).
				collect(Collectors.toList());
	}
	
	public static Employee translateDTOToEntity(EmployeeDTO empDto) {
		Employee emp = new Employee(empDto.getId(), empDto.getFirstName(), empDto.getLastName(), empDto.getEmail());
		return emp;
	}
	
}
