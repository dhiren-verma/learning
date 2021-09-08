package com.learning.spring_rest_demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_rest_demo.student.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		
		students.add(new Student("Allen", "Wes"));
		students.add(new Student("Jack", "Wills"));
		students.add(new Student("Bryan", "Adams"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("/student/{studentIdx}")
	public Student getStudent(@PathVariable int studentIdx) {
		if (studentIdx<students.size()) {
			return students.get(studentIdx);
		} else {
			return null;
		}
	}
	
}