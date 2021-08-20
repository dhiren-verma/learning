package com.learning.spring_security_demo_thymeleaf.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	
	private String firstFieldName;
	private String secondFieldName;
	private String message;
	
	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(final Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		
		try {
			final Object firstFieldValue = new BeanWrapperImpl(value).
					getPropertyValue(firstFieldName);
			final Object secondFieldValue = new BeanWrapperImpl(value).
					getPropertyValue(secondFieldName);
			
			valid = (firstFieldValue==null && secondFieldValue==null) ||
					(firstFieldValue!=null && firstFieldValue.equals(secondFieldValue));
		} catch (Exception ex) {
			
		}
		
		if (!valid) {
			context.buildConstraintViolationWithTemplate(message).
					addPropertyNode(firstFieldName).
					addConstraintViolation().
					disableDefaultConstraintViolation();
		}
		
		return valid;
	}
	
}