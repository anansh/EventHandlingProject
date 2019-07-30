package com.sourcebits.eventHandling.controller;

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
import com.sourcebits.eventHandling.service.EventService;

@RestController
@RequestMapping(value = "/event")
public class EventController {

	@Autowired
	EventService eventService;

	@PostMapping("/saveEvent")
	public Event saveNewEvent(@RequestBody Event event) { 
		return eventService.addEvent(event);
	}

	@PostMapping("/saveEventInvitation")
	public String saveEventInvitation(@RequestBody EventInvitationRequest eventInvitationReq) {
		eventService.saveInvitation(eventInvitationReq);
		return "";
	}

	@GetMapping("/findEventPlaces")
	public String getNearByEventPlaces(@RequestBody GooglePlacesRequest googlePlacesRequest) {
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
	public String updateEventInvitation(@RequestBody EventInvitationUpdateReq eventInvitationUpdateReq) {
		eventService.updateInvitation(eventInvitationUpdateReq);
		return "";
	}
}
