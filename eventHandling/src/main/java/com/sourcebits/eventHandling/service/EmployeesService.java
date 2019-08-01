package com.sourcebits.eventHandling.service;

import java.util.List;

import com.sourcebits.eventHandling.request.NewEmployeeRequest;
import com.sourcebits.eventHandling.response.EmployeeResponse;

public interface EmployeesService {
	public String addEmployee(NewEmployeeRequest newEmployeeRequest);

	public List<EmployeeResponse> getEmployeesByProj(int projId);
}