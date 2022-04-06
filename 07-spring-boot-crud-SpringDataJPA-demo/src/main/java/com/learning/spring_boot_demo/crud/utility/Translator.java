package com.learning.spring_boot_demo.crud.utility;

import com.learning.spring_boot_demo.crud.dto.EmployeeDTO;
import com.learning.spring_boot_demo.crud.entity.Employee;

public class Translator {
	
	public static EmployeeDTO translateEntityToDTO(Employee emp) {
		return new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail());
	}
	
//	public static List<EmployeeDTO> translateEntityToDTO(List<Employee> emps) {
//		return emps.stream().
//				map(emp -> new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail())).
//				collect(Collectors.toList());
//	}
	
	public static Employee translateDTOToEntity(EmployeeDTO empDto) {
		return  new Employee(empDto.getId(), empDto.getFirstName(), empDto.getLastName(), empDto.getEmail());
		
	}
	
}
