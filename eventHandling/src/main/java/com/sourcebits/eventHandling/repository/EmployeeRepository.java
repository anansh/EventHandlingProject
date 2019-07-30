package com.sourcebits.eventHandling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sourcebits.eventHandling.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, String> {

	@Query(value = "SELECT * FROM employees where proj_id = :projId", nativeQuery = true)
	public List<Employees> getEmpByProjId(int projId);

}