package com.learning.spring_security_demo_complete.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({TYPE, ANNOTATION_TYPE})
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface FieldMatch {
	
	String first();
	
	String second();
	
	//Default Error Message:
	String message() default "";
	
	@Retention(RUNTIME)
	@Target({TYPE, ANNOTATION_TYPE})
	@Documented
	@interface List {
		FieldMatch[] value();
	}
	
	//Default Groups:
	Class<?>[] groups() default {};
	
	//Default Payload: provides custom details about validation failure(severity
	//level, error code, etc.)
	Class<? extends Payload>[] payload() default {};
	
}