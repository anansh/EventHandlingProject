package com.sourcebits.eventHandling.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.http.HttpServletRequest;
import javax.mail.Session;
import javax.mail.Transport;
import com.sourcebits.eventHandling.constants.ConstantsMessages;
import com.sourcebits.eventHandling.model.Event;
import com.sourcebits.eventHandling.model.EventInvitation;
import com.sourcebits.eventHandling.model.User;
import com.sourcebits.eventHandling.repository.EmployeeRepository;
import com.sourcebits.eventHandling.repository.EventInvitationRepository;
import com.sourcebits.eventHandling.repository.EventRepository;
import com.sourcebits.eventHandling.request.EventEmployeeRequest;
import com.sourcebits.eventHandling.request.EventInvitationRequest;
import com.sourcebits.eventHandling.request.EventInvitationUpdateReq;
import com.sourcebits.eventHandling.response.EventResponse;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

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
	public Event addEvent(Event event, HttpServletRequest request) {
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = customUserDetails.getUser();
		Event event2 = eventRepository.getLastEvent();
		int lastId = 0;
		if (null != event2) {
			lastId = event2.getId();
		}
		event.setEventId("EVNT-" + (lastId + 1));
		event.setEventCreatedDate(new Date());
		event.setEventCreatedBy(Integer.toString(user.getId()));
		return eventRepository.save(event);
	}

	@Override
	@Transactional
	public String saveInvitation(EventInvitationRequest listEventInvitation, HttpServletRequest request) {
		List<EventInvitation> listOfInvitations = new ArrayList<>();
		Event event = eventRepository.findById(listEventInvitation.getEventId());
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = customUserDetails.getUser();
		//String address = findAddress(event.getEventVenueLat(), event.getEventVenueLong());
		//System.out.println(address);

		for (EventEmployeeRequest eventInvitation : listEventInvitation.getEventEmployeesRequest()) {
			EventInvitation eventInvitation2 = new EventInvitation();
			eventInvitation2.setEventId(event.getId());
			eventInvitation2.setEmpId(eventInvitation.getEmpId());
			eventInvitation2.setInvCreatedDate(new Date());
			eventInvitation2.setInvCreatedBy(user.getId());
			listOfInvitations.add(eventInvitation2);
			sendMail(employeeRepository.findById(eventInvitation2.getEmpId()).getEmailId(), "");
			// sendMessage(employees.getMobileNo());
		}
		try {
			eventInvitationRepository.saveAll(listOfInvitations);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return ConstantsMessages.SUCCESSSAVE;
	}

	public String findAddress(String lat, String lng) {
		String object = "";
		try {
			RestTemplate restTemplate = new RestTemplate();
			object = restTemplate.getForObject("https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + ","
					+ lng + "&key=AIzaSyAqnoH_s6etqy8140z3t7orPqNuymgJQfs", String.class);
			System.out.println(object);
			JSONObject jsonObject = new JSONObject(object);

			if (jsonObject.has("result")) {
				JSONArray activity = (JSONArray) jsonObject.get("result");
				for (Object each : activity) {
					System.out.println(each.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "address";
	}

	@Override
	@Transactional
	public String updateInvitation(EventInvitationUpdateReq eventInvitationUpdateReq, HttpServletRequest request) {
		EventInvitation eventInvitation = eventInvitationRepository
				.findByEventIdAndEmpId(eventInvitationUpdateReq.getEventId(), eventInvitationUpdateReq.getEmpId());
		CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		User user = customUserDetails.getUser();
		boolean data = eventInvitationUpdateReq.isPropositions();
		eventInvitation.setPropositions(Boolean.valueOf(data));
		eventInvitation.setInvUpdatedDate(new Date());
		eventInvitation.setInvUpdatedBy(user.getId());
		eventInvitationRepository.save(eventInvitation);
		return ConstantsMessages.SUCCESSUPDATE;
	}

	@Override
	@Transactional
	public List<EventResponse> findListOfEvents() {
		List<Event> eventList = eventRepository.findAllByDate();
		List<EventResponse> listEventResponses = new ArrayList<>();
		for (Event event : eventList) {
			EventResponse eventResponse = new EventResponse();
			BeanUtils.copyProperties(event, eventResponse);
			eventResponse.setEventId(event.getId());
			eventResponse.setEventCreatedBy(
					employeeRepository.findById(Integer.valueOf(event.getEventCreatedBy())).getEmpName());
			listEventResponses.add(eventResponse);
		}
		return listEventResponses;
	}

	public void sendMail(String to, String address) {
		String from = "anshuman.shrivastava@sourcebits.com";
		String password = "1001013009";
		String sub = "This is subject";
		String msg = "Join at " + address;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void sendMessage(String to) {
		// Find your Account Sid and Token at twilio.com/user/account
		final String ACCOUNT_SID = "ACd17f1bdb20eecf98babc51026559a7c1";
		final String AUTH_TOKEN = "d3ff39d7a5edfe48917a5001bae49b02";

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
				.creator(new PhoneNumber("+918920655154"), new PhoneNumber("+12055576301"), "Sample text message")
				.create();

		System.out.println(message.getSid());

	}

}
