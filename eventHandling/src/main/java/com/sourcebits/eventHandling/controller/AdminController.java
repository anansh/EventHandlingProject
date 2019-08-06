package com.sourcebits.eventHandling.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sourcebits.eventHandling.constants.ConstantsMessages;

import com.sourcebits.eventHandling.request.NewEmployeeRequest;
import com.sourcebits.eventHandling.service.EmployeesService;

@RestController
@RequestMapping(value = "/secure/rest")
public class AdminController {

	@Autowired
	EmployeesService employeesService;

	@Autowired
	BCryptPasswordEncoder encodePassword;

	@PostMapping("/admin/add")
	@PreAuthorize("hasAnyRole('Admin')")
	public String addUserByAdmin(@RequestBody NewEmployeeRequest newEmployeeRequest, HttpServletRequest request) {
		newEmployeeRequest.setPassword(encodePassword.encode(newEmployeeRequest.getPassword()));
		employeesService.addEmployee(newEmployeeRequest,request);
		return ConstantsMessages.SUCCESSSAVE;
	}
}