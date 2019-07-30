package com.sourcebits.eventHandling.response;

public class EmployeeResponse {
	private String empId;
	private String empName;
	private String mobileNo;
	private String emailId;
	ProjectResponse projResponse;

	public String getEmailId() {
		return emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public ProjectResponse getProjResponse() {
		return projResponse;
	}

	public void setProjResponse(ProjectResponse projResponse) {
		this.projResponse = projResponse;
	}

}