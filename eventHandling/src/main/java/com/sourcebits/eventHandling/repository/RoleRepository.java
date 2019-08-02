package com.sourcebits.eventHandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sourcebits.eventHandling.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}