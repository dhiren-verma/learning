package com.customerTracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerTracker.dao.CustomerDAO;
import com.customerTracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//Need to inject relevant DAO to get Data from DB:
	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(int sortField) {
		//Get & return Data from DAO:
		return customerDao.getCustomers(sortField);
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}
	
	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchName) {
		return customerDao.searchCustomers(searchName);
	}
	
}