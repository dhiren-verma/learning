package spring.mvc.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.demo.beans.Customer;

@Controller
@RequestMapping("/customer")
public class ValidationController {
	
	@RequestMapping("/showForm")
	public String showCustomerForm(Model custModel) {
		custModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/custValidationForm")
	public String processCustomerForm(@Valid @ModelAttribute("customer")Customer customer,
			BindingResult validationResult) {
		if (validationResult.hasErrors())
			return "customer-form";
		else
			return "cust-processed-form";
	}
	
}
