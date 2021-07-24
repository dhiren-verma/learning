package com.learning.webCustomerTracker_AllJavaConfig.service;

import java.util.List;

import com.learning.webCustomerTracker_AllJavaConfig.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int sortField);
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int custId);
	
	public void deleteCustomer(int custId);
	
	public List<Customer> searchCustomers(String searchStr);
	
}