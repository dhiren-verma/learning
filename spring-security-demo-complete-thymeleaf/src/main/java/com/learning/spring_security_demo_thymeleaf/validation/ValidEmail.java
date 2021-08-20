package com.learning.spring_security_demo_thymeleaf.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Constraint(validatedBy=EmailValidator.class)
public @interface ValidEmail {
	
	//No default Value:
	
	//Default Error Message:
	String message() default "Invalid Email!";
	
	//Default Groups:
	Class<?>[] groups() default {};
	
	//Default Payload:
	Class<? extends Payload>[] payload() default {};
	
}