package com.sourcebits.eventHandling.request;

import java.util.ArrayList;
import java.util.List;

public class EventInvitationListRequest {
	List<EventInvitationRequest> eventInvitationList = new ArrayList<>();

	public List<EventInvitationRequest> getEventInvitationList() {
		return eventInvitationList;
	}

	public void setEventInvitationList(List<EventInvitationRequest> eventInvitationList) {
		this.eventInvitationList = eventInvitationList;
	}

}