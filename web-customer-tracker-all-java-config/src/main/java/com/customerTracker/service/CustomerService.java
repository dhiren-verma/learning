package com.customerTracker.service;

import java.util.List;

import com.customerTracker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int sortField);
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int custId);
	
	public void deleteCustomer(int custId);
	
	public List<Customer> searchCustomers(String searchStr);
	
}