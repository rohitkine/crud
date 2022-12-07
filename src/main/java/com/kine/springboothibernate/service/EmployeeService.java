package com.kine.springboothibernate.service;

import java.util.List;
import java.util.Optional;

import com.kine.springboothibernate.entities.Employee;

public interface EmployeeService{
	
	public List<Employee> getEmployees();

	public Employee saveEmployee(Employee employee);

	public void saveEmployees(List<Employee> employee);

	public Optional<Employee> getEmployeesByempid(Long id);

	public void deleteEmployeByempid(Long id);

	public void updateEmployee(Employee employee, Long id);

	

}
