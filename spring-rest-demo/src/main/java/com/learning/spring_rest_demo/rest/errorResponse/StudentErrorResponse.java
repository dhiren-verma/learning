package com.learning.spring_rest_demo.rest.errorResponse;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentErrorResponse {
	
	private int status;
	private String message;
	private long timestamp;
	
}