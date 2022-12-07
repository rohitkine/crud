package com.kine.springboothibernate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kine.springboothibernate.Repository.EmployeeRepository;
import com.kine.springboothibernate.entities.Employee;
import com.kine.springboothibernate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	
	
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}


	
	public Employee saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}


	
	public void saveEmployees(List<Employee> employee) {
		employeeRepository.saveAll(employee);
	}



	public Optional<Employee> getEmployeesByempid(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}



	@Override
	public void deleteEmployeByempid(Long id) {
		employeeRepository.deleteById(id);
		
	}



	@Override
	public void updateEmployee(Employee newEmployee, Long id) {
		
		 employeeRepository.findById(id)
			   .map(employee->{
				   employee.setFirstname(newEmployee.getFirstname());
				   employee.setLastname(newEmployee.getLastname());
				   employee.setEmail(newEmployee.getEmail());
				   
				   return employeeRepository.save(employee);
			   })
			   .orElseGet(()->{
				   return employeeRepository.save(newEmployee);
			   });
	}

}
