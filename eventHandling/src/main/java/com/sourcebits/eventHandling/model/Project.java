package com.sourcebits.eventHandling.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer projId;

	@Column(name = "proj_name")
	String projName;

	@Column(nullable = true, name = "created_date")
	private Date projCreatedDate;

	@Column(nullable = true, name = "created_by")
	private int projCreatedBy;

	@Column(nullable = true, name = "updated_date")
	private Date projUpdatedDate;

	@Column(nullable = true, name = "updated_by")
	private Integer projUpdatedBy;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
	private List<Employees> serviceHistoryList = new ArrayList<>();

	public Date getProjCreatedDate() {
		return projCreatedDate;
	}

	public void setProjCreatedDate(Date projCreatedDate) {
		this.projCreatedDate = projCreatedDate;
	}

	public int getProjCreatedBy() {
		return projCreatedBy;
	}

	public void setProjCreatedBy(int projCreatedBy) {
		this.projCreatedBy = projCreatedBy;
	}

	public Date getProjUpdatedDate() {
		return projUpdatedDate;
	}

	public void setProjUpdatedDate(Date projUpdatedDate) {
		this.projUpdatedDate = projUpdatedDate;
	}

	public Integer getProjUpdatedBy() {
		return projUpdatedBy;
	}

	public void setProjUpdatedBy(Integer projUpdatedBy) {
		this.projUpdatedBy = projUpdatedBy;
	}

	public List<Employees> getServiceHistoryList() {
		return serviceHistoryList;
	}

	public void setServiceHistoryList(List<Employees> serviceHistoryList) {
		this.serviceHistoryList = serviceHistoryList;
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

}