package com.sourcebits.eventHandling.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcebits.eventHandling.response.EmployeeResponse;
import com.sourcebits.eventHandling.service.EmployeesService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeesService employeesService;

	@GetMapping("/getEmployeesByProjId")
	public List<EmployeeResponse> getEmployeesByDept(@RequestParam int projId) {
		return employeesService.getEmployeesByProj(projId);
	}
	
	@GetMapping("/loginprocess")
	public void getLoginDetails(HttpServletRequest request) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		request.getSession().setAttribute("Auth", auth);
	}

}