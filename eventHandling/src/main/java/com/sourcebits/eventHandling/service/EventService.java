package com.sourcebits.eventHandling.service;

import com.sourcebits.eventHandling.model.Event;
import com.sourcebits.eventHandling.request.EventInvitationRequest;
import com.sourcebits.eventHandling.request.EventInvitationUpdateReq;

public interface EventService {
	public Event addEvent(Event event);

	public String saveInvitation(EventInvitationRequest eventInvitationReq);

	public String updateInvitation(EventInvitationUpdateReq eventInvitationUpdateReq);
}