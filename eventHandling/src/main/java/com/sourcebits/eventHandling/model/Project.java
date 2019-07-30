package com.sourcebits.eventHandling.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {


	@Id
	@Column(name = "id")
	Integer projId;

	@Column(name = "proj_name")
	String projName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
	private List<Employees> serviceHistoryList = new ArrayList<>();

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