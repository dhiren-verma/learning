package com.springtutorial.xml_tutorials.dao;

import java.util.Arrays;
import java.util.List;

public class AccountDaoImplementation implements AccountDao {
	
	@Override
	public List<String> getAccountNames() {
		return Arrays.asList("Sachin", "Akshay", "Deepak");
	}
	
}
