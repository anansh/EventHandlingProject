package com.sourcebits.eventHandling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginSuccess")
public class LoginController {

	@GetMapping("/employeeSuccess")
	public String successloginEmployee() {
		return "Employee login success";
	}

	@GetMapping("/adminSuccess")
	public String successloginAdmin() {
		return "Admin login success";
	}
}