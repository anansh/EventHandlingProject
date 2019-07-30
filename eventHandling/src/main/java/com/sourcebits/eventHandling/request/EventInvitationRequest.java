package com.sourcebits.eventHandling.request;

import java.util.List;

public class EventInvitationRequest {
	private String eventId;
	private List<EventEmployeeRequest> eventEmployeesRequest;

	public String getEventId() {
		return eventId;
	}

	public List<EventEmployeeRequest> getEventEmployeesRequest() {
		return eventEmployeesRequest;
	}

	public void setEventEmployeesRequest(List<EventEmployeeRequest> eventEmployeesRequest) {
		this.eventEmployeesRequest = eventEmployeesRequest;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

}
