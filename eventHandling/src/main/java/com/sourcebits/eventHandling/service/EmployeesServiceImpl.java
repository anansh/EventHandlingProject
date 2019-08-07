package com.sourcebits.eventHandling.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sourcebits.eventHandling.constants.ConstantsMessages;
import com.sourcebits.eventHandling.model.Employees;
import com.sourcebits.eventHandling.model.Project;
import com.sourcebits.eventHandling.model.Role;
import com.sourcebits.eventHandling.model.User;
import com.sourcebits.eventHandling.model.UserRole;
import com.sourcebits.eventHandling.repository.EmployeeRepository;
import com.sourcebits.eventHandling.repository.ProjectRepository;
import com.sourcebits.eventHandling.repository.UserRepository;
import com.sourcebits.eventHandling.repository.UserRoleRepository;
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

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	@Transactional
	public String addEmployee(NewEmployeeRequest newEmployeeRequest, HttpServletRequest request) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User userLoggedIn = customUserDetails.getUser();
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
		employees.setEmpCreatedBy(userLoggedIn.getId());
		employeeRepository.save(employees);
		User user = new User();
		user.setUserName(newEmployeeRequest.getEmpName());
		user.setPassword(newEmployeeRequest.getPassword());
		user.setEmp_id(employees.getId());
		user.setUserCreatedBy(userLoggedIn.getId());
		user.setUserCreatedDate(new Date());
		User userReturned = userRepository.save(user);

		List<UserRole> listOfUserRoles = new ArrayList<>();
		for (Role role : newEmployeeRequest.getRoles()) {
			UserRole userRole = new UserRole();
			userRole.setRoleId(role.getId());
			userRole.setUserId(userReturned.getId());
			listOfUserRoles.add(userRole);
		}

		userRoleRepository.saveAll(listOfUserRoles);

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