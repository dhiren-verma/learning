package com.learning.spring_boot_demo.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
}
