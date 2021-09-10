package com.learning.spring_rest_demo.rest.exceptionAndError;

public class TeacherNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7584958202435516883L;

	public TeacherNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public TeacherNotFoundException(String message) {
		super(message);
	}
	
	public TeacherNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public TeacherNotFoundException() {
		super();
	}
	
}