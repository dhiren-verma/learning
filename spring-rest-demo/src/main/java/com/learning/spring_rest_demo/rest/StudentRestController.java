package com.learning.spring_rest_demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_rest_demo.beans.Student;
import com.learning.spring_rest_demo.rest.exceptionAndError.StudentNotFoundException;

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
		if (studentIdx>=students.size() || studentIdx<0)
			throw new StudentNotFoundException("Student Id not fouund: "+studentIdx);
		
		return students.get(studentIdx);
	}
	
	
	//Both Exception Handers have been moved to StudentRestExceptionHandler class
	//for Global Exception Handling:
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException snfe) {
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(snfe.getMessage());
//		error.setTimestamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//	}
//	
//	//Exception Handler to handle Generic Exceptions other than those that have
//	//already been covered: 
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
//		StudentErrorResponse error = new StudentErrorResponse();
//		
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimestamp(System.currentTimeMillis());
//		
//		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//	}
	
}