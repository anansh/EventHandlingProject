package com.sourcebits.eventHandling.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "event_id")
	String eventId;

	@Column(name = "event_name")
	String eventName;

	@Column(name = "event_venue_longitude")
	String eventVenueLong;

	@Column(name = "event_venue_latitude")
	String eventVenueLat;

	@Column(name = "event_date_time")
	Date eventDateTime;

	@Column(name = "event_created_by")
	String eventCreatedBy;

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
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