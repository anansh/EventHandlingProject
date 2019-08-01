package com.sourcebits.eventHandling.response;

import java.util.Date;

public class EventResponse {
	private int eventId;
	private String eventName;
	private String eventVenueLong;
	private String eventVenueLat;
	private Date eventDateTime;
	private String eventCreatedBy;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventVenueLong() {
		return eventVenueLong;
	}

	public void setEventVenueLong(String eventVenueLong) {
		this.eventVenueLong = eventVenueLong;
	}

	public String getEventVenueLat() {
		return eventVenueLat;
	}

	public void setEventVenueLat(String eventVenueLat) {
		this.eventVenueLat = eventVenueLat;
	}

	public Date getEventDateTime() {
		return eventDateTime;
	}

	public void setEventDateTime(Date eventDateTime) {
		this.eventDateTime = eventDateTime;
	}

	public String getEventCreatedBy() {
		return eventCreatedBy;
	}

	public void setEventCreatedBy(String eventCreatedBy) {
		this.eventCreatedBy = eventCreatedBy;
	}
}