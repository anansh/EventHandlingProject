package com.sourcebits.eventHandling.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sourcebits.eventHandling.model.Event;
import com.sourcebits.eventHandling.request.EventInvitationRequest;
import com.sourcebits.eventHandling.request.EventInvitationUpdateReq;
import com.sourcebits.eventHandling.response.EventResponse;

public interface EventService {
	public List<EventResponse> findListOfEvents();

	public Event addEvent(Event event, HttpServletRequest request);

	public String saveInvitation(EventInvitationRequest eventInvitationReq, HttpServletRequest request);

	public String updateInvitation(EventInvitationUpdateReq eventInvitationUpdateReq, HttpServletRequest request);
}