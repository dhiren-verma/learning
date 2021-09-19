package com.learning.spring_crm_rest_demo.rest.exceptionAndError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;
	
}