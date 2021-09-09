package com.learning.spring_rest_demo.rest.exceptionAndError;

public class StudentNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2368752881521009028L;
	
	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public StudentNotFoundException(String message) {
		super(message);
	}
	
	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}
	
}