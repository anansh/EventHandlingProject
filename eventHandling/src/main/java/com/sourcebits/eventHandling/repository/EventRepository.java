package com.sourcebits.eventHandling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sourcebits.eventHandling.model.Event;

public interface EventRepository extends JpaRepository<Event, String> {

	@Query(value = "select * from event where DATEDIFF(CURDATE(),event_date_time) <= 0", nativeQuery = true)
	public List<Event> findAllByDate();

	@Query(value = "select * from event ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public Event getLastEvent();

	public Event findById(int id);
}