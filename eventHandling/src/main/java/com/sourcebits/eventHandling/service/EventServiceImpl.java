package com.sourcebits.eventHandling.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourcebits.eventHandling.model.Employees;
import com.sourcebits.eventHandling.model.Event;
import com.sourcebits.eventHandling.model.EventInvitation;
import com.sourcebits.eventHandling.repository.EmployeeRepository;
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

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public Event addEvent(Event event) {
		Event event2 = eventRepository.getLastEvent();
		int lastId = 0;
		if (null != event2) {
			lastId = event2.getId();
		}
		event.setEventId("EVNT-" + (lastId + 1));
		event.setEventCreatedDate(new Date());
		return eventRepository.save(event);
	}

	@Override
	@Transactional
	public String saveInvitation(EventInvitationRequest listEventInvitation) {
		List<EventInvitation> listOfInvitations = new ArrayList<>();
		for (EventEmployeeRequest eventInvitation : listEventInvitation.getEventEmployeesRequest()) {
			EventInvitation eventInvitation2 = new EventInvitation();
			eventInvitation2.setEventId(eventRepository.findById(listEventInvitation.getEventId()).getId());
			eventInvitation2.setEmpId(eventInvitation.getEmpId());
			eventInvitation2.setInvCreatedDate(new Date());
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
		boolean data = eventInvitationUpdateReq.isPropositions();
		eventInvitation.setPropositions(Boolean.valueOf(data));
		eventInvitation.setInvUpdatedDate(new Date());
		eventInvitationRepository.save(eventInvitation);
		return "";
	}

	@Override
	public List<EventResponse> findListOfEvents() {
		List<Event> eventList = eventRepository.findAllByDate();
		List<EventResponse> listEventResponses = new ArrayList<>();
		for (Event event : eventList) {
			EventResponse eventResponse = new EventResponse();
			BeanUtils.copyProperties(event, eventResponse);
			eventResponse.setEventId(event.getId());
			Employees empData = employeeRepository.findById(Integer.valueOf(event.getEventCreatedBy()));

			String empName = empData.getEmpName();

			eventResponse.setEventCreatedBy(empName);
			listEventResponses.add(eventResponse);
		}
		return listEventResponses;
	}

}
