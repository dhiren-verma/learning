package com.springAop.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class DemoAccountDAO {
	
//	public void addAccount() {
//		System.out.println(getClass()+" has invoked method to Add Account/n");
//	}
	
	public boolean addAccount() {
		System.out.println(getClass()+" has invoked method to Add Account that "
				+ "returns boolean\n");
		
		return true;
	}
	
	public void addAccount(int id) {
		System.out.println(getClass()+" has invoked method to Add Account with "
				+ "Id: "+id+"\n");
	}
	
}