package com.sourcebits.eventHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcebits.eventHandling.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	public Project findByProjId(Integer projId);
}