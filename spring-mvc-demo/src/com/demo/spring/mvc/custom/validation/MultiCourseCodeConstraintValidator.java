package com.demo.spring.mvc.custom.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultiCourseCodeConstraintValidator implements ConstraintValidator<MultiCourseCode, String> {
	
	String[] codePrefix;
	
	@Override
	public void initialize(MultiCourseCode multiCourseCode) {
		codePrefix = multiCourseCode.value();
	}
	
	@Override
	public boolean isValid(String courseCodeValue, ConstraintValidatorContext validatorContext) {
		boolean result = false;
		
		if (courseCodeValue!=null) {
			for (String tempPrefix : codePrefix) {
				if (courseCodeValue.startsWith(tempPrefix)) {
					result = true;
					break;
				}
			}
		} else {
			result = true;
		}
		
		return result;
	}

}
