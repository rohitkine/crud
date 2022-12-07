package com.kine.springboothibernate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kine.springboothibernate.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	
	

}
