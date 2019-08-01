package com.sourcebits.eventHandling.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_Invitation")
public class EventInvitation implements Serializable {

	private static final long serialVersionUID = -314331919905059132L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "emp_id")
	private int empId;

	@Column(nullable = true, name = "propositions")
	private Boolean propositions;

	@Column(name = "created_date")
	private Date invCreatedDate;

	@Column(name = "created_by")
	private int invCreatedBy;

	@Column(name = "updated_date")
	private Date invUpdatedDate;

	@Column(name = "updated_by")
	private int invUpdatedBy;

	public int getId() {
		return id;
	}

	public Date getInvCreatedDate() {
		return invCreatedDate;
	}

	public void setInvCreatedDate(Date invCreatedDate) {
		this.invCreatedDate = invCreatedDate;
	}

	public int getInvCreatedBy() {
		return invCreatedBy;
	}

	public void setInvCreatedBy(int invCreatedBy) {
		this.invCreatedBy = invCreatedBy;
	}

	public Date getInvUpdatedDate() {
		return invUpdatedDate;
	}

	public void setInvUpdatedDate(Date invUpdatedDate) {
		this.invUpdatedDate = invUpdatedDate;
	}

	public int getInvUpdatedBy() {
		return invUpdatedBy;
	}

	public void setInvUpdatedBy(int invUpdatedBy) {
		this.invUpdatedBy = invUpdatedBy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Boolean getPropositions() {
		return propositions;
	}

	public void setPropositions(Boolean propositions) {
		this.propositions = propositions;
	}

}