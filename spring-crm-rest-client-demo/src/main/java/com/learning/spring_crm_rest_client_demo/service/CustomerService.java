package com.learning.spring_crm_rest_client_demo.service;

import java.util.List;

import com.learning.spring_crm_rest_client_demo.dto.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int custId);
	
	public void deleteCustomer(int custId);
	
}