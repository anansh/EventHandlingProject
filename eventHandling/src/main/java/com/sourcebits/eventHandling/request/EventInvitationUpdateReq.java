package com.sourcebits.eventHandling.request;

public class EventInvitationUpdateReq {
	private int eventId;
	private int empId;
	private boolean propositions;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public boolean isPropositions() {
		return propositions;
	}

	public void setPropositions(boolean propositions) {
		this.propositions = propositions;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}