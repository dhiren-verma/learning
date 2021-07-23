package com.customerTracker.dao;

import java.util.List;

import com.customerTracker.entity.Customer;

public interface CustomerDAO {
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int customerId);
	
	public List<Customer> getCustomers(int sortField);
	
	public void deleteCustomer(int customerId);
	
	public List<Customer> searchCustomers(String searchName);
	
}