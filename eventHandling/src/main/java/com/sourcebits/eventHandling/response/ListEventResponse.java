package com.sourcebits.eventHandling.response;

import java.util.ArrayList;
import java.util.List;

public class ListEventResponse {
	List<EventResponse> eventResponses = new ArrayList<>();

	public List<EventResponse> getEventResponses() {
		return eventResponses;
	}

	public void setEventResponses(List<EventResponse> eventResponses) {
		this.eventResponses = eventResponses;
	}
}