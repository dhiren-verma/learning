package com.demo.spring.mvc.custom.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	String codePrefix;
	
	//Initialize codePrefix with value defined in CourseCode Annotation:
	@Override
	public void initialize(CourseCode courseCode) {
		codePrefix = courseCode.value();
	}
	
	//First Parameter is the Value passed from the Form for the Field:
	@Override
	public boolean isValid(String courseCodeValue,
			ConstraintValidatorContext validatorContext) {
		if (courseCodeValue != null)
			return courseCodeValue.startsWith(codePrefix);
		else
			return true;
	}
	
}