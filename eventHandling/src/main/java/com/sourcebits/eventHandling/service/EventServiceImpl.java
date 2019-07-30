package com.sourcebits.eventHandling.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcebits.eventHandling.model.Event;
import com.sourcebits.eventHandling.model.EventInvitation;
import com.sourcebits.eventHandling.repository.EventInvitationRepository;
import com.sourcebits.eventHandling.repository.EventRepository;
import com.sourcebits.eventHandling.request.EventEmployeeRequest;
import com.sourcebits.eventHandling.request.EventInvitationRequest;
import com.sourcebits.eventHandling.request.EventInvitationUpdateReq;
import com.sourcebits.eventHandling.response.EventResponse;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	EventInvitationRepository eventInvitationRepository;

	@Override
	@Transactional
	public Event addEvent(Event event) {
		event.setEventId("EVNT_" + UUID.randomUUID().toString());
		return eventRepository.save(event);
	}

	@Override
	@Transactional
	public String saveInvitation(EventInvitationRequest listEventInvitation) {
		List<EventInvitation> listOfInvitations = new ArrayList<>();
		for (EventEmployeeRequest eventInvitation : listEventInvitation.getEventEmployeesRequest()) {
			EventInvitation eventInvitation2 = new EventInvitation();
			eventInvitation2.setEventInvitationId("EVNT_INV_" + UUID.randomUUID().toString());
			eventInvitation2.setEmpId(eventInvitation.getEmpId());
			eventInvitation2.setEventId(listEventInvitation.getEventId());
			listOfInvitations.add(eventInvitation2);
		}
		try {
			eventInvitationRepository.saveAll(listOfInvitations);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	@Override
	@Transactional
	public String updateInvitation(EventInvitationUpdateReq eventInvitationUpdateReq) {
		EventInvitation eventInvitation = eventInvitationRepository
				.findByEventIdAndEmpId(eventInvitationUpdateReq.getEventId(), eventInvitationUpdateReq.getEmpId());
		eventInvitation.setPropositions(eventInvitationUpdateReq.getPropositions());
		eventInvitationRepository.save(eventInvitation);
		return null;
	}

	@Override
	public List<EventResponse> findListOfEvents() {
		List<Event> eventList = eventRepository.findAllByDate();
		List<EventResponse> listEventResponses = new ArrayList<>();
		for (Event event : eventList) {
			EventResponse eventResponse = new EventResponse();
			BeanUtils.copyProperties(event, eventResponse);
			listEventResponses.add(eventResponse);
		}
		return listEventResponses;
	}

}
