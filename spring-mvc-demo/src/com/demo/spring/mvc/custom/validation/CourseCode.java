package com.demo.spring.mvc.custom.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ FIELD, METHOD })
//@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RUNTIME)
//@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//Default Value if the Custom Annotation User doesn't explicitly mention a Value: 
	public String value() default "JAVA";
	
	//Default Error Message if the Custom Annotation User doesn't explicitly mention an Error Message:
	public String message() default "must start with JAVA";
	
	//Default Groups: can group related Constraints:
	public Class<?>[] groups() default{};
	
	//Default Payload: provides custom details about Validation Failure(severity level, error code, etc.)
	public Class<? extends Payload>[] payload() default {};
	
}