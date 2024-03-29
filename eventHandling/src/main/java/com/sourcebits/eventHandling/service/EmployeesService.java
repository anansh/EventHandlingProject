package com.sourcebits.eventHandling.service;

import java.util.List;

import com.sourcebits.eventHandling.model.Employees;
import com.sourcebits.eventHandling.response.EmployeeResponse;

public interface EmployeesService {
	public void addEmployee(Employees employees);

	public List<EmployeeResponse> getEmployeesByProj(int projId);
}