package com.learning.spring_rest_demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.learning.spring_rest_demo.beans.Teacher;
import com.learning.spring_rest_demo.rest.exceptionAndError.TeacherNotFoundException;

/**
 * Here we would be throwing TeacherNotFoundException in case if the Teacher
 * doesn't exist rather than null for this demo illustration purpose
 * 
 * @author Vermas-Dell
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	
	private List<Teacher> teachers;
	
	@PostConstruct
	public void initializeTeachersList() {
		teachers = new ArrayList<>();
		
		teachers.add(new Teacher(1001, "Akshay Tyagi"));
		teachers.add(new Teacher(1002, "Deepak Jain"));
		teachers.add(new Teacher(1003, "Goverdhan Choudhary"));
		teachers.add(new Teacher(1004, "Sachin Jain"));
	}
	
	@Override
	public List<Teacher> getAllTeachers() {
		return teachers;
	}
	
	@Override
	public Teacher getTeacher(int teacherId) {
		Teacher teacher = teachers.stream().
				filter(tempTeacher -> (tempTeacher.getId()==teacherId)).
				findFirst().orElse(null);
		
		if (teacher!=null)
			return teacher;
		else
			throw new TeacherNotFoundException("Teacher Not Found");
		
	}
	
	@Override
	public Teacher updateTeacher(int teacherId, String name) {
		Teacher teacher = teachers.stream().
				filter(tempTeacher -> (tempTeacher.getId()==teacherId)).
				findFirst().orElse(null);
		
		if (teacher!=null) {
			teacher.setName(name);
			
			return teacher;
		} else
			throw new TeacherNotFoundException("Provide valid Teacher Id");
		
	}
	
}