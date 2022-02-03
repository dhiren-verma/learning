package com.learning.spring_boot_demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

public class DemoInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		if (HttpMethod.GET.matches(request.getMethod())) {
			return HandlerInterceptor.super.preHandle(
					request, response, handler);
		} else {
			response.sendError(HttpStatus.METHOD_NOT_ALLOWED.value(),
					"method_not_allowed");
			return false;
		}
	}
	
}
