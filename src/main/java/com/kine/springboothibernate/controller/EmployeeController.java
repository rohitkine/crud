package com.kine.springboothibernate.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.kine.springboothibernate.Repository.EmployeeRepository;
import com.kine.springboothibernate.entities.Employee;
import com.kine.springboothibernate.service.EmployeeService;

import java.util.List;
import java.util.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	//get the employee
	@PostMapping("/employee/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return this.employeeService.saveEmployee(employee);
	}
	
	//multiple employee detail save
	@PostMapping("/employee/savemultiple")
	public String saveEmployees(@RequestBody List<Employee> employee) {
		this.employeeService.saveEmployees(employee);
		return "Your Multiple record is successfully saved";
	}
		
	//get all employee detail
	@GetMapping("/employee/detail")
	public List<Employee> getEmployees(){
		return this.employeeService.getEmployees();
	}
	
	//get the employee detail using id
	@GetMapping("/employee/detail/{empid}")
	public Optional<Employee> getEmployeesByempid(@PathVariable("empid") Long id) {
		return this.employeeService.getEmployeesByempid(id);
		
	}
	
	
	//delete the employee detail
	@DeleteMapping("/employee/detail/{empid}")
	public String deleteEmployeeByempid(@PathVariable("empid") Long id) {
		this.employeeService.deleteEmployeByempid(id);
		return "Your record is successfully deleted";
		
	}
	
	//update employee data
	@PutMapping("/employee/change/{empid}")
	public String uopdateEmployee(@RequestBody Employee employee,@PathVariable("empid") Long id) {
		this.employeeService.updateEmployee(employee,id);
		return "Update Succesfully !!!";
	}
	
	
}
