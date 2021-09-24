package com.learning.jackson_databind_json_demo;

import java.io.File;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class SerializationDeserializationTest {
	
	public static void main(String[] args) {
		try {
			//Create ObjectMapper:
			ObjectMapper mapper = new ObjectMapper();
			
			//2nd Approach to Register a Custom De-serializer for a Custom Class,
			//if it needs to be used in Multiple fields of the Class, then we can
			//register this as a Module in the ObjectMapper:
			SimpleModule module = new SimpleModule();
			module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
			mapper.registerModule(module);
			
			//Read JSON File and map/convert to Java Pojo:
			Student liteStudent = mapper.readValue(
					new File("src/main/resources/sample-lite.json"),
					Student.class);
			
			Student heavyStudent = mapper.readValue(
					new File("src/main/resources/sample-full.json"),
					Student.class);
			
			//Print Read Data from Java Pojo:
			System.out.println("Lite Student is:\n"+liteStudent);
			System.out.println("\n");
			System.out.println("Heavy Student is:\n"+heavyStudent);
			
			serializationTest(liteStudent, heavyStudent);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void serializationTest(Student liteStudent, Student heavyStudent)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		//2nd Approach to Register a Custom Serializer for a Custom Class,
		//if it needs to be used in Multiple fields of the Class, then we can
		//register this as a Module in the ObjectMapper:
		SimpleModule module = new SimpleModule();
		module.addSerializer(LocalDate.class, new LocalDateSerializer());
		mapper.registerModule(module);
		
		//To beautify/properly indent generated JSON:
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		String liteStudentJson = mapper.writeValueAsString(liteStudent);
		String heavyStudentJson = mapper.writeValueAsString(heavyStudent);
		
		System.out.println("\n");
		System.out.println("Lite Studnet Json is:\n"+liteStudentJson);
		System.out.println("\n");
		System.out.println("Heavy Studnet Json is:\n"+heavyStudentJson);
	}
	
}