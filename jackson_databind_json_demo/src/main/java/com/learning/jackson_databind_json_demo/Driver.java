package com.learning.jackson_databind_json_demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			//Create ObjectMapper:
			ObjectMapper mapper = new ObjectMapper();
			
			//Read JSON File and map/convert to Java Pojo:
			Student newStudent = mapper.readValue(
					new File("src/main/resources/sample-lite.json"),
					Student.class);
			
			//Print Read Data from Java Pojo:
			System.out.println(newStudent);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
