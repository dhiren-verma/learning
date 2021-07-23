package com.customerTracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customerTracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int sortField) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		String fieldName;
		
		switch (sortField) {
			case 1: fieldName = "firstName";
				break;
			case 3: fieldName = "email";
				break;
			default:
				fieldName = "lastName";
		}
		
		String customerQueryStr = "from Customer order by "+fieldName;
		
		Query<Customer> getCustomersQuery = currentSession.createQuery(customerQueryStr
				, Customer.class);
		
		List<Customer> customers = getCustomersQuery.getResultList();
		
		return customers;
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(customer);
	}
	
	@Override
	public Customer getCustomer(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, custId);
		
		return customer;
	}
	
	@Override
	public void deleteCustomer(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<?> deleteQuery =
				currentSession.createQuery("delete from Customer where id=:custId");
		
		deleteQuery.setParameter("custId", custId);
		
		deleteQuery.executeUpdate();
	}
	
	@Override
	public List<Customer> searchCustomers(String searchStr) {
Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> customerSearchQuery;
		
		if (searchStr!=null && searchStr.trim().length()>0) {
			customerSearchQuery = currentSession.createQuery("from Customer where lower(firstName) like :searchName or lower(lastName) like :searchName", Customer.class);
			
			//Here the "%" Wildcard will also help us to Search for the Given Search Name as Substring: 
			customerSearchQuery.setParameter("searchName", "%"+searchStr.trim().toLowerCase()+"%");
		} else {
			customerSearchQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> matchingCustomers = customerSearchQuery.getResultList();
		
		return matchingCustomers;
	}
	
}