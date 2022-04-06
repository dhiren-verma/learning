package com.learning.spring_boot_demo.crud.exception;

public class EmployeeWithMailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 4595827796205021874L;

	public EmployeeWithMailAlreadyExistsException() {
		super();
	}

	public EmployeeWithMailAlreadyExistsException(String message) {
		super(message);
	}

	public EmployeeWithMailAlreadyExistsException(Throwable cause) {
		super(cause);
	}

	public EmployeeWithMailAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	protected EmployeeWithMailAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
