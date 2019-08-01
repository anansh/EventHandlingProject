package com.sourcebits.eventHandling.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "emp_id")
	private String empId;

	@Column(name = "emp_name")
	private String empName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "proj_id")
	private Project project;

	@Column(name = "contact_number")
	private String mobileNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(nullable = true, name = "created_date")
	private Date empCreatedDate;

	@Column(nullable = true, name = "created_by")
	private Integer empCreatedBy;

	@Column(nullable = true, name = "updated_date")
	private Date empUpdatedDate;

	@Column(nullable = true, name = "updated_by")
	private Integer empUpdatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEmpCreatedDate() {
		return empCreatedDate;
	}

	public void setEmpCreatedDate(Date empCreatedDate) {
		this.empCreatedDate = empCreatedDate;
	}

	public Integer getEmpCreatedBy() {
		return empCreatedBy;
	}

	public void setEmpCreatedBy(Integer empCreatedBy) {
		this.empCreatedBy = empCreatedBy;
	}

	public Date getEmpUpdatedDate() {
		return empUpdatedDate;
	}

	public void setEmpUpdatedDate(Date empUpdatedDate) {
		this.empUpdatedDate = empUpdatedDate;
	}

	public Integer getEmpUpdatedBy() {
		return empUpdatedBy;
	}

	public void setEmpUpdatedBy(Integer empUpdatedBy) {
		this.empUpdatedBy = empUpdatedBy;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

}