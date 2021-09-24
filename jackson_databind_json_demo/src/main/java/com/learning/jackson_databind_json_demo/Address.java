package com.learning.jackson_databind_json_demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
	
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
}