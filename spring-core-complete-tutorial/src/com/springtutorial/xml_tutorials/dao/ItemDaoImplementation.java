package com.springtutorial.xml_tutorials.dao;

import java.util.Arrays;
import java.util.List;

public class ItemDaoImplementation implements ItemDao {
	
	@Override
	public List<String> getItemNames() {
		return Arrays.asList("Cookies", "Bread", "Toast");
	}

}