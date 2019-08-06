package com.sourcebits.eventHandling.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sourcebits.eventHandling.model.Event;
import com.sourcebits.eventHandling.request.EventInvitationRequest;
import com.sourcebits.eventHandling.request.EventInvitationUpdateReq;
import com.sourcebits.eventHandling.request.GooglePlacesRequest;
import com.sourcebits.eventHandling.response.ListEventResponse;
import com.sourcebits.eventHandling.service.EventService;

@RestController
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	EventService eventService;

	@PostMapping("/saveEvent")
	public Event saveNewEvent(@RequestBody Event event, HttpServletRequest request) {
		return eventService.addEvent(event, request);
	}

	@PostMapping("/saveEventInvitation")
	public String saveEventInvitation(@RequestBody EventInvitationRequest eventInvitationReq,
			HttpServletRequest request) {
		return eventService.saveInvitation(eventInvitationReq, request);
	}

	@GetMapping("/findEventList")
	public ListEventResponse getListOfEvents() {
		ListEventResponse listEventResponse = new ListEventResponse();
		listEventResponse.setEventResponses(eventService.findListOfEvents());
		return listEventResponse;
	}

	@GetMapping("/findEventPlaces")
	@Transactional
	public String getNearByEventPlaces(@RequestBody GooglePlacesRequest googlePlacesRequest,
			HttpServletRequest request) {
		// HttpSession httpSession = request.getSession();
		RestTemplate restTemplate = new RestTemplate();
		String object = restTemplate
				.getForObject(
						"https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="
								+ googlePlacesRequest.getLatitude() + "," + googlePlacesRequest.getLongitude()
								+ "&radius=" + googlePlacesRequest.getRadius() + "&type="
								+ googlePlacesRequest.getTypeOfPlace() + "&key=AIzaSyAqnoH_s6etqy8140z3t7orPqNuymgJQfs",
						String.class);
		return object;
	}

	@PutMapping("/updateEventInvitation")
	public String updateEventInvitation(@RequestBody EventInvitationUpdateReq eventInvitationUpdateReq,
			HttpServletRequest request) {
		eventService.updateInvitation(eventInvitationUpdateReq, request);
		return "";
	}
}
