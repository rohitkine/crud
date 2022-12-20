package com.kine.springboothibernate.service;

import java.util.List;

import com.kine.springboothibernate.entities.EmployeeEntity;
import com.kine.springboothibernate.model.EmployeeDetails;

public interface EmployeeService{
	
	public List<EmployeeEntity> getEmployees();

	public EmployeeEntity saveEmployee(EmployeeEntity employee);

	public void saveEmployees(List<EmployeeEntity> employee);

	public EmployeeDetails getEmployeesByempid(Long id);

	public void deleteEmployeByempid(Long id);

	public EmployeeEntity updateEmployee(EmployeeDetails employee);

	public EmployeeDetails getEmployeesByEmail(String email);

	

}
