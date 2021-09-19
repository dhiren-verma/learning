package com.learning.spring_crm_rest_demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.learning.spring_crm_rest_demo.dao.CustomerDAO;
import com.learning.spring_crm_rest_demo.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDao;
	
//	@Override
//	@Transactional
//	public List<Customer> getCustomers(int sortField) {
//		return customerDao.getCustomers(sortField);
//	}
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}
	
	@Override
	@Transactional
	public Customer getCustomer(int custId) {
		return customerDao.getCustomer(custId);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(int custId) {
		customerDao.deleteCustomer(custId);
	}
	
	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchStr) {
		return customerDao.searchCustomers(searchStr);
	}
	
}