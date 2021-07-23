package com.springtutorial.xml_tutorials.service;

import java.util.Arrays;
import java.util.List;

public class UnregisteredService implements StoreService {
	
	@Override
	public List<String> getUserNameList() {
		return Arrays.asList("UnregisteredService doesn't have any User");
	}

	@Override
	public List<String> getItemNameList() {
		return Arrays.asList("UnregisteredService doesn't have any Item");
	}

}
