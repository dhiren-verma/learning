package spring.mvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.demo.beans.Student;

@Controller
public class SpringController {
	
	@RequestMapping("/")
	public String getHopePage(Model stuModel) {
		stuModel.addAttribute("student", new Student());
		return "stuRegForm";
	}
	
	@RequestMapping("/stuSignupForm")
	public String processRequest(@ModelAttribute("student")Student student, Model stuModel) {
		System.out.println(student);
		
		StringBuilder strBldr = new StringBuilder("Hello! ");
		
		strBldr.append(student.getFirstName());
		strBldr.append(" ");
		strBldr.append(student.getLastName());
		strBldr.append("<br>");
		strBldr.append("Your registration as Student is successful");
		
		stuModel.addAttribute("regMsg", strBldr.toString());
		
		return "stuSignupSuccessful";
	}
	
}
