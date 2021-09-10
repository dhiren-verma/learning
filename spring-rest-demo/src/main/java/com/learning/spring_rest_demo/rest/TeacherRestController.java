package com.learning.spring_rest_demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.learning.spring_rest_demo.beans.Teacher;
import com.learning.spring_rest_demo.rest.exceptionAndError.TeacherNotFoundException;
import com.learning.spring_rest_demo.service.TeacherService;

@RestController
@RequestMapping("/api")
public class TeacherRestController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/teachers")
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}
	
	@GetMapping("/teachers/{id}")
	public Teacher getTeacher(@PathVariable int id) {
		try {
			return teacherService.getTeacher(id);
		} catch (TeacherNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher Not Found");
		}
	}
	
	@PutMapping("/teacher/{id}/{name}")
	public Teacher updateTeacher(@PathVariable int id,
			@PathVariable("name") String updatedName) {
		try {
			return teacherService.updateTeacher(id, updatedName);
		} catch (TeacherNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide valid Teacher Id");
		}
	}
	
}