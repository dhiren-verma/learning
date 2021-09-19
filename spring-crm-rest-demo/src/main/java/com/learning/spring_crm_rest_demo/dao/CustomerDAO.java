package com.learning.spring_crm_rest_demo.dao;

import java.util.List;

import com.learning.spring_crm_rest_demo.entity.Customer;

public interface CustomerDAO {
	
//	public List<Customer> getCustomers(int sortField);
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int custId);
	
	public void deleteCustomer(int custId);
	
	public List<Customer> searchCustomers(String searchStr);
	
}