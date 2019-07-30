package com.sourcebits.eventHandling.request;

public class EventInvitationUpdateReq {
	private String eventId;
	private String empId;
	private boolean propositions;

	public boolean getPropositions() {
		return propositions;
	}

	public void setPropositions(boolean propositions) {
		this.propositions = propositions;
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

}