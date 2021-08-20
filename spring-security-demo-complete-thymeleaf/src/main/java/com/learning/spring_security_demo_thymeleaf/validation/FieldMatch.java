package com.learning.spring_security_demo_thymeleaf.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
@Constraint(validatedBy=FieldMatchValidator.class)
public @interface FieldMatch {
	
	String first();
	
	String second();
	
	//Default error message:
	String message() default "";
	
	@Documented
	@Retention(RUNTIME)
	@Target({TYPE, ANNOTATION_TYPE})
	@interface List{
		FieldMatch[] value();
	}
	
	//Default Groups:
	public Class<?>[] groups() default {};
	
	//Default payload:
	public Class<? extends Payload>[] payload() default {};
	
}
