package com.sourcebits.eventHandling.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "event_id")
	private String eventId;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_venue_longitude")
	private String eventVenueLong;

	@Column(name = "event_venue_latitude")
	private String eventVenueLat;

	@Column(name = "event_date_time")
	private Date eventDateTime;

	@Column(name = "event_created_by")
	private String eventCreatedBy;

	@Column(name = "event_created_date")
	private Date eventCreatedDate;

	@Column(name = "event_updated_by")
	private String eventUpdatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEventCreatedDate() {
		return eventCreatedDate;
	}

	public void setEventCreatedDate(Date eventCreatedDate) {
		this.eventCreatedDate = eventCreatedDate;
	}

	public String getEventUpdatedBy() {
		return eventUpdatedBy;
	}

	public void setEventUpdatedBy(String eventUpdatedBy) {
		this.eventUpdatedBy = eventUpdatedBy;
	}

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