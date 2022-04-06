package com.learning.spring_boot_demo.crud.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.spring_boot_demo.crud.exception.EmployeeWithMailAlreadyExistsException;
import com.learning.spring_boot_demo.crud.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFound(EmployeeNotFoundException enfe) {
		return new ResponseEntity<>(enfe.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmployeeWithMailAlreadyExistsException.class)
	public ResponseEntity<String> employeeWithMailAlreadyExists(EmployeeWithMailAlreadyExistsException eaee) {
		return new ResponseEntity<>(eaee.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> internalServerError(Exception ex) {
		return new ResponseEntity<>("Internal Server Error!", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
