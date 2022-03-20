package com.learning.spring_boot_demo.crud.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.spring_boot_demo.crud.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<String> employeeNotFound(NotFoundException nfe) {
		return new ResponseEntity<>(nfe.getMessage(), HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> internalServerException(Exception internalServerException) {
		return new ResponseEntity<>("", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
