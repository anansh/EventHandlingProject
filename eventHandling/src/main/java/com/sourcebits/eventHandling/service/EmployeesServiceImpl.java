package com.sourcebits.eventHandling.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcebits.eventHandling.constants.ConstantsMessages;
import com.sourcebits.eventHandling.model.Employees;
import com.sourcebits.eventHandling.model.Project;
import com.sourcebits.eventHandling.model.User;
import com.sourcebits.eventHandling.repository.EmployeeRepository;
import com.sourcebits.eventHandling.repository.ProjectRepository;
import com.sourcebits.eventHandling.repository.UserRepository;
import com.sourcebits.eventHandling.request.NewEmployeeRequest;
import com.sourcebits.eventHandling.response.EmployeeResponse;
import com.sourcebits.eventHandling.response.ProjectResponse;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public String addEmployee(NewEmployeeRequest newEmployeeRequest, HttpServletRequest request) {
		Employees employees = new Employees();
		BeanUtils.copyProperties(newEmployeeRequest, employees);
		employees.setProject(projectRepository.findByProjId(newEmployeeRequest.getProjectId()));
		Employees employees1 = employeeRepository.getLastEmployee();
		int lastId = 0;
		if (null != employees1) {
			lastId = employees1.getId();
		}
		employees.setEmpId("EMP-" + (lastId + 1));
		employees.setEmpCreatedDate(new Date());
		employeeRepository.save(employees);
		User user = new User();
		user.setPassword(newEmployeeRequest.getPassword());
		user.setEmp_id(employees.getId());
		user.setUserCreatedBy(0);
		user.setUserCreatedDate(new Date());
		user.setRoles(newEmployeeRequest.getRoles());
		userRepository.save(user);
		return ConstantsMessages.SUCCESSSAVE;
	}

	@Override
	public List<EmployeeResponse> getEmployeesByProj(int projId) {
		EmployeeResponse empRes = null;
		List<Employees> empList = employeeRepository.getEmpByProjId(projId);
		List<EmployeeResponse> empListResponse = new ArrayList<>();
		for (Employees emp : empList) {
			empRes = new EmployeeResponse();
			empRes.setEmpId(emp.getEmpId());
			empRes.setEmpName(emp.getEmpName());
			empRes.setEmailId(emp.getEmailId());
			empRes.setMobileNo(emp.getMobileNo());
			Project p = emp.getProject();
			ProjectResponse res = new ProjectResponse();
			res.setId(p.getProjId());
			res.setName(p.getProjName());
			empRes.setProjResponse(res);
			empListResponse.add(empRes);
		}
		return empListResponse;
	}
}