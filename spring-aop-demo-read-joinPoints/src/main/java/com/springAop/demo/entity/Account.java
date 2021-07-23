package com.springAop.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Account {
	
	private final int id;
	private final String name;
	
}