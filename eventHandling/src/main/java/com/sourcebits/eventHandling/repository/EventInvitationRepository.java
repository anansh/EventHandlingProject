package com.sourcebits.eventHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourcebits.eventHandling.model.EventInvitation;

@Repository
public interface EventInvitationRepository extends JpaRepository<EventInvitation, String> {

	public EventInvitation findByEventIdAndEmpId(int eventId, int empId);
}
