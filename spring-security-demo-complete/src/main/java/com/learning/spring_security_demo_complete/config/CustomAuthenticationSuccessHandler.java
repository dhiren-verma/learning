package com.learning.spring_security_demo_complete.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.learning.spring_security_demo_complete.entity.User;
import com.learning.spring_security_demo_complete.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler
		implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
					throws IOException, ServletException {
		String userName = authentication.getName();
		
		User theUser = userService.findByUserName(userName);
		
		//Place User in Session:
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);
		
		//Forward to Home Page: 
		response.sendRedirect(request.getContextPath()+"/");
	}
	
}