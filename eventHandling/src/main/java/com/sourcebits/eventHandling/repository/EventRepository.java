package com.sourcebits.eventHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcebits.eventHandling.model.Event;

public interface EventRepository extends JpaRepository<Event, String> {

	

}