package com.demo.spring.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.spring.mvc.beans.Customer;

/**
 * Spring MVC Form Validation(Hibernate Validation) Demo
 * 
 * @author Vermas-Dell
 */
@Controller
@RequestMapping("/customer")
public class CustomerController5 {
	
	@RequestMapping("/customerForm")
	public String showCustomerForm(Model custModel) {
		custModel.addAttribute("cust", new Customer());
		
		return "customer-form";
	}
	
	//Adding pre-processing code with IntiBinder from all String Data incoming:
	//Takes care of Whites-paces passing validation tests placed on lastName parameter:
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
	
	@RequestMapping("/processCustomerForm")
	public String processCustomerForm(@Valid @ModelAttribute("cust")Customer customer,
			BindingResult cBindingResult) {
		System.out.println("Binding Result is: "+cBindingResult);
		System.out.println("\n\n\n");
		
		if (cBindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
		
	}
	
}