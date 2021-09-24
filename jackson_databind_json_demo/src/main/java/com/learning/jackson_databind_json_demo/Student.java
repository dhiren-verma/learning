package com.learning.jackson_databind_json_demo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	
	//We can achieve Custom Serialization & De-serialization of
	//LocalDate Objects in two ways:
	//1st one is demonstrated with an Annotation here itself:
	//2nd one is demonstrated in respective Serialization &
	//De-serialization Test Class
	
	//Annotation approach is useful when we want to use custom
	//Serializer/De-serializer on a few Fields: 
//	@JsonSerialize(using = LocalDateSerializer.class)
//	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate birthDate;
	private boolean active;
	private Address address;
	//Both Collection & Arrays work:
	private List<String> languages;
	
}