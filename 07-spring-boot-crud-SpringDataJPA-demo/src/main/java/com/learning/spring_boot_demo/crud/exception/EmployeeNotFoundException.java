package com.learning.spring_boot_demo.crud.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -456850539625569216L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	protected EmployeeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
