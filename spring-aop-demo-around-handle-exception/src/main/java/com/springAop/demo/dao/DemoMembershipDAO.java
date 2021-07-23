package com.springAop.demo.dao;

import org.springframework.stereotype.Component;

import com.springAop.demo.entity.Account;

@Component
public class DemoMembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + " has invoked method to Add Membership "
				+ "Account\n");
	}
	
	public void addAccount(Account newMemberAccount) {
		System.out.println(getClass() + " has invoked method to Add given "
				+ "Membership Account:\n" + newMemberAccount + "\n");
	}
	
	public void addAccount(Account newMemberAccount, boolean vip) {
		System.out.println(getClass() + " has invoked method to Add given "
				+ "Membership Account:\n" + newMemberAccount
				+ (vip?" who is VIP\n":" who is not VIP\n"));
	}
	
}