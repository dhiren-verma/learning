package com.customerTracker.service;

import java.util.List;

import com.customerTracker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int sortField);

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int customerId);
	
	public void deleteCustomer(int customerId);
	
	public List<Customer> searchCustomers(String searchName);
	
}