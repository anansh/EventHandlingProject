package com.sourcebits.eventHandling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sourcebits.eventHandling.model.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, String> {

	@Query(value = "SELECT * FROM employees where proj_id = :projId", nativeQuery = true)
	public List<Employees> getEmpByProjId(int projId);

	@Query(value = "SELECT * from employees ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public Employees getLastEmployee();

	public Employees findById(int id);
}