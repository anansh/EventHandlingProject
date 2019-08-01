package com.sourcebits.eventHandling.request;

import java.util.List;

public class EventInvitationRequest {
	private int eventId;
	private List<EventEmployeeRequest> eventEmployeesRequest;

	public List<EventEmployeeRequest> getEventEmployeesRequest() {
		return eventEmployeesRequest;
	}

	public void setEventEmployeesRequest(List<EventEmployeeRequest> eventEmployeesRequest) {
		this.eventEmployeesRequest = eventEmployeesRequest;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
