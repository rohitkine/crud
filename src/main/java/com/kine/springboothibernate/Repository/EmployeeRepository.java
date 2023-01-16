package com.kine.springboothibernate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kine.springboothibernate.entities.EmployeeEntity;
import com.kine.springboothibernate.model.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Query(value = "SELECT k FROM EmployeeEntity k where k.email = :email")
	EmployeeEntity findByEmail(@Param("email") String email);

}
