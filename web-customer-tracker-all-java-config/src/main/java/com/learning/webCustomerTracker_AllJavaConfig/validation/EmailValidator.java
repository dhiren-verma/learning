package com.learning.webCustomerTracker_AllJavaConfig.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]"
			+ "+(?:\\.[a-zA-Z0-9_+&*-]+)"
			+ "*@(?:[a-zA-Z0-9-]+\\.)"
			+ "+[a-zA-Z]{2,7}";
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value==null)
			return false;
		
		pattern = Pattern.compile(EMAIL_PATTERN);
		
		matcher = pattern.matcher(value);
		
		if (matcher.matches()) {
			String localPart = value.split("@")[0];
			
			if (localPart.length()>63 || value.length()>254)
				return false;
			else 
				return true;
			
		} else
			return false;
		
	}
	
}