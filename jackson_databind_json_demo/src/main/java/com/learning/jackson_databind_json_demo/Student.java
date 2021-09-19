package com.learning.jackson_databind_json_demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	//Both Collection & Arrays work:
	private List<String> languages;
	
}