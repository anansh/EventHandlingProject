package com.sourcebits.eventHandling.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_Invitation")
public class EventInvitation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -314331919905059132L;

	@Id
	@Column(name = "event_invitation_id")
	String eventInvitationId;

	@Column(name = "event_id")
	String eventId;

	@Column(name = "emp_id")
	String empId;

	@Column(name = "propositions")
	boolean propositions;

	public String getEventInvitationId() {
		return eventInvitationId;
	}

	public void setEventInvitationId(String eventInvitationId) {
		this.eventInvitationId = eventInvitationId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public boolean getPropositions() {
		return propositions;
	}

	public void setPropositions(boolean propositions) {
		this.propositions = propositions;
	}

}