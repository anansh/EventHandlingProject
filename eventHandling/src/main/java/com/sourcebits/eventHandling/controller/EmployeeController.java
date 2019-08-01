package com.sourcebits.eventHandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sourcebits.eventHandling.constants.ConstantsMessages;
import com.sourcebits.eventHandling.request.NewEmployeeRequest;
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

	@PostMapping("/saveNewEmployee")
	public String saveNewEmployee(@RequestBody NewEmployeeRequest newEmployeeRequest) {
		employeesService.addEmployee(newEmployeeRequest);
		return ConstantsMessages.SUCCESSSAVE;
	}
}