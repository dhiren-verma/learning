package com.learning.spring_crm_rest_demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_crm_rest_demo.entity.Customer;
import com.learning.spring_crm_rest_demo.rest.exceptionAndError.CustomerNotFoundException;
import com.learning.spring_crm_rest_demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId); 
		
		if (customer == null)
			throw new CustomerNotFoundException("Customer ID not found - "+customerId);
		
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@Valid @RequestBody Customer newCustomer, BindingResult validationResult) {
		if (validationResult.hasErrors())
			throw new RuntimeException("Invalid Customer Data");
		
		//Why are we setting ID of a New Customer as '0';
		//because, when we call saveOrUpdate on an Entity in Hibernate,
		//Hibernate checks if the Entity's ID already exists in DB or not, 
		//if it doesn't exist, then it Inserts,
		//but if it doesn't, then it updates:
		//Now a Non-Existant ID would either be 'null' or '0', as the Table is
		//marked to auto-increment ID from '1', therefore we set the ID as '0':
		newCustomer.setId(0);
		
		customerService.saveCustomer(newCustomer);
		
		return newCustomer;
	} 
	
	@PutMapping("/customers")
	public Customer updateCustomer(@Valid @RequestBody Customer updtCustomer, BindingResult validationResult) {
		if (validationResult.hasErrors())
			throw new RuntimeException("Invalid Customer Data");
		
		customerService.saveCustomer(updtCustomer);
		
		return updtCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if (tempCustomer == null)
			throw new CustomerNotFoundException("Customer ID not found - "+customerId);
		
		customerService.deleteCustomer(customerId);
		
		return "Customer with CustomeId: "+customerId+" deleted successfully";
	}
	
}