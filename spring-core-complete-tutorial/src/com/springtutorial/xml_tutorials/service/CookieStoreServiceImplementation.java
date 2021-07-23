package com.springtutorial.xml_tutorials.service;

import java.util.List;

import com.springtutorial.xml_tutorials.dao.AccountDao;
import com.springtutorial.xml_tutorials.dao.ItemDao;

public class CookieStoreServiceImplementation implements StoreService {
	
	private AccountDao accounts;
	private ItemDao items;
	
	public CookieStoreServiceImplementation(AccountDao accounts, ItemDao items) {
		this.accounts = accounts;
		this.items = items;
	}
	
	@Override
	public List<String> getUserNameList() {
		return accounts.getAccountNames();
	}
	
	@Override
	public List<String> getItemNameList() {
		return items.getItemNames();
	}
	
}
