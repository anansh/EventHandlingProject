package com.sourcebits.eventHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sourcebits.eventHandling.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	public Project findByProjId(Integer projId);
}