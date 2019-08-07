package com.sourcebits.eventHandling.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginSuccess")
public class LoginController {

	@GetMapping("/employeeSuccess")
	public String successloginEmployee(HttpServletRequest request, Principal principal) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.getSession().setAttribute("auth", authentication);
		return "Employee login success";
	}

	@GetMapping("/adminSuccess")
	public String successloginAdmin(HttpServletRequest request, Principal principal) {
		String name = principal.getName();
		System.out.println(name);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		request.getSession().setAttribute("auth", authentication);
		return "Admin login success";
	}
}