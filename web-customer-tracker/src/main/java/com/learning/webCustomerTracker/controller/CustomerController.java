package com.learning.webCustomerTracker.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.webCustomerTracker.entity.Customer;
import com.learning.webCustomerTracker.service.CustomerService;
import com.learning.webCustomerTracker.util.SortUtil;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	String patternStr = "^[a-zA-Z]+";
    Pattern pattern = Pattern.compile(patternStr);
    Matcher matcher = pattern.matcher("");
    
	//Need to inject relevant Service to get Data from DAO:
	@Autowired
	private CustomerService customerService;
	
	//Adding pre-processing code with IntiBinder from all incoming String Data:
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//A class available in Spring API for String Trimming.
		//'true' passed in Constructor means that if the String only consists of
		//white-spaces, it will be trimmed down to 'null'
		StringTrimmerEditor strTrimmerEditor = new StringTrimmerEditor(true);
		
		//With this statement, this String Trimmer Editor instance will process
		//each String class object
		dataBinder.registerCustomEditor(String.class, strTrimmerEditor);
	}
	
	@GetMapping("/listCustomers")
	public String listCustomers(Model listCustModel,
			@RequestParam(value="sort", required=false) String sort) {
		try {
			//Get the List of Customers from Service:
			List<Customer> customers;
			
			if (sort!=null) {
				int sortField = Integer.parseInt(sort);
				
				if (sortField!=SortUtil.FIRST_NAME
						&& sortField!=SortUtil.LAST_NAME
						&& sortField!=SortUtil.EMAIL)
					throw new IllegalArgumentException("Invalid Sort Field");
				
				customers = customerService.getCustomers(sortField);
			} else
				customers = customerService.getCustomers(SortUtil.LAST_NAME);
			
			//Add the List of Customers to the Model:
			listCustModel.addAttribute("customers", customers);
			
			return "list-customers";
		} catch (NumberFormatException ex) {
			//Send an invalid Sort Filed Error Message
			return "error-page";
		} catch (IllegalArgumentException ex) {
			//Send an invalid Sort Filed Error Message
			return "error-page";
		} catch (Exception ex) {
			//Send an invalid Sort Filed Error Message
			return "error-page";
		}
	}
	
	@GetMapping("/addCustomerForm")
	public String showAddCustomerForm(Model addCustModel) {
		Customer newCustomer = new Customer();
		
		addCustModel.addAttribute("customer", newCustomer);
		
		return "add-customer";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@Valid @ModelAttribute("customer")Customer newCustomer
			, BindingResult validationResult) {
		System.out.println("Validation Result is: "+validationResult);
		System.out.println("\n\n\n");
		
		if (validationResult.hasErrors())
			return "add-customer";
		else {
			customerService.saveCustomer(newCustomer);
			
			return "redirect:/customer/listCustomers";
		}
	}
	
	@GetMapping("/updateCustomerForm")
	public String showCustomerUpdateForm(@RequestParam("customerId") int custId
			, Model updtCustModel) {
		Customer customer = customerService.getCustomer(custId);
		
		if (customer!=null) {
			updtCustModel.addAttribute("updtCustomer", customer);
			
			return "update-customer";
		} else {
			//Probably show an Error Message:
			return "redirect:/customer/listCustomers";
		}
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute("updtCustomer") Customer updtCustomer
			, BindingResult validationResult) {
		System.out.println("Validation Result is: "+validationResult);
		System.out.println("\n\n\n");
		
		if (validationResult.hasErrors())
			return "update-customer";
		else {
			customerService.saveCustomer(updtCustomer);
			
			return "redirect:/customer/listCustomers";
		}
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int custId) {
		customerService.deleteCustomer(custId);
		
		return "redirect:/customer/listCustomers";
	}
	
	//There are Three ways to mark a Parameter as Optional:
	//@RequestParam(value = "searchName", required=false) String searchName
	//@RequestParam("searchName") @Nullable String searchName
	//@RequestParam("searchName") Optional<String> searchName
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("searchName") Optional<String> searchName
			, Model custModel) {
		if (searchName!=null) {
			//Apply Input Validation on SearchName:
			matcher.reset(searchName.get());
			
			if (matcher.matches()) {
				//Search Customer from the Service:
				List<Customer> matchingCustomers = customerService.searchCustomers(searchName.get());
				
				//Add found Customers to the Model:
				custModel.addAttribute("customers", matchingCustomers);
				
				return "list-customers";
			} else {
				return "error-page";
			}
		} else {
			return "error-page";
		}
	}
	
}