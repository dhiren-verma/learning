package com.springAop.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springAop.demo.entity.Account;

@Component
public class DemoAccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	public String getName() {
		System.out.println(getClass()+" in getName()\n");
		return name;
	}
	
	public void setName(String name) {
		System.out.println(getClass()+" in setName()\n");
		this.name = name;
	}
	
	public String getServiceCode() {
		System.out.println(getClass()+" in getServiceCode()\n");
		return serviceCode;
	}
	
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" in setServiceCode()\n");
		this.serviceCode = serviceCode;
	}
	
	public boolean addAccount() {
		System.out.println(getClass()+" has invoked method to Add Account that "
				+ "returns boolean\n");
		
		return true;
	}
	
	public void addAccount(int id) {
		System.out.println(getClass()+" has invoked method to Add Account with "
				+ "Id: "+id+"\n");
	}
	
	public List<Account> findAccounts(boolean throwException) {
		System.out.println("DemoAccountDAO: finding Accounts:");
		
		if (throwException)
			throw new RuntimeException("No data available due to Misc Error");
		
		List<Account> accounts = new ArrayList<>();
		
		accounts.add(new Account(1001, "ABC"));
		accounts.add(new Account(1001, "DEF"));
		accounts.add(new Account(1001, "PQR"));
		accounts.add(new Account(1001, "XYZ"));
		
		System.out.println("DemoAccountDAO: returning found Accounts:");
		
		return accounts; 
	}
	
}