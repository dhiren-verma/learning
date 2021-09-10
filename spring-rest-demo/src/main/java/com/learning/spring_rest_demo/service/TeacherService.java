package com.learning.spring_rest_demo.service;

import java.util.List;

import com.learning.spring_rest_demo.beans.Teacher;

public interface TeacherService {
	
	public List<Teacher> getAllTeachers();
	
	public Teacher getTeacher(int teacherId);
	
	public Teacher updateTeacher(int teacherId, String name);
	
}