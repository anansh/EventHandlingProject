package com.sourcebits.eventHandling.service;

import java.util.List;

import com.sourcebits.eventHandling.model.Event;
import com.sourcebits.eventHandling.request.EventInvitationRequest;
import com.sourcebits.eventHandling.request.EventInvitationUpdateReq;
import com.sourcebits.eventHandling.response.EventResponse;

public interface EventService {
	public List<EventResponse> findListOfEvents();

	public Event addEvent(Event event);

	public String saveInvitation(EventInvitationRequest eventInvitationReq);

	public String updateInvitation(EventInvitationUpdateReq eventInvitationUpdateReq);
}