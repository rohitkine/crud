package com.kine.springboothibernate.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kine.springboothibernate.Repository.EmployeeRepository;
import com.kine.springboothibernate.entities.EmployeeEntity;
import com.kine.springboothibernate.mapper.EmployeeMapper;
import com.kine.springboothibernate.model.EmployeeDetails;
import com.kine.springboothibernate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeMapper employeeMapper;
	

	public List<EmployeeEntity> getEmployees() {
		return (List<EmployeeEntity>) employeeRepository.findAll();
	}

	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		employeeRepository.save(employee);
		return employee;
	}

	public void saveEmployees(List<EmployeeEntity> employee) {
		employeeRepository.saveAll(employee);
	}

	public EmployeeDetails  getEmployeesByempid(Long id) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> optional=employeeRepository.findById(id);
		System.out.println(optional.isPresent());
		return employeeMapper.toPojo(optional.get());
	}

	@Override
	public void deleteEmployeByempid(Long id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeDetails employeeDetails) {

		EmployeeEntity employeeEntity=employeeRepository.findByEmail(employeeDetails.email);
		employeeEntity=employeeMapper.updateEntity(employeeEntity, employeeDetails);
		System.out.println(employeeEntity.email+"\t"+employeeEntity.firstname+"\t"+employeeEntity.lastname);
		
		employeeRepository.save(employeeEntity);
		return employeeEntity;
	}

	public EmployeeDetails getEmployeesByEmail(String email) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity= employeeRepository.findByEmail(email);
		
		return employeeMapper.toPojo(employeeEntity);
	}

}
