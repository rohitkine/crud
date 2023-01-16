package com.kine.springboothibernate.controller;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kine.springboothibernate.entities.EmployeeEntity;
import com.kine.springboothibernate.model.EmployeeDetails;
import com.kine.springboothibernate.service.EmployeeService;

@RestController

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// get the employee
	@PostMapping("/employee/save")
	public String saveEmployee(@RequestBody EmployeeEntity employee) {

		boolean save = false;
		if (getEmployeesByemail(employee.email) == null) {
			this.employeeService.saveEmployee(employee);
			save = true;

		} else if (getEmployeesByemail(employee.email) != null) {
			save = false;
		}

		if (save == true) {
			return "Your record has been successfully saved !!";
		} else {
			return "Your record has not been saved";
		}

	}

	// multiple employee detail save
	@PostMapping("/employee/savemultiple")
	public String saveEmployees(@RequestBody List<EmployeeEntity> employee) {
		this.employeeService.saveEmployees(employee);
		return "Your Multiple record is successfully saved";
	}

	// get all employee detail
	@GetMapping("/employee/detail")
	public List<EmployeeEntity> getEmployees() {
		return this.employeeService.getEmployees();
	}

	// get the employee detail using id
	@GetMapping("/employee/detail/{empid}")
	public EmployeeDetails getEmployeesByempid(@PathVariable("empid") Long id) {
		return this.employeeService.getEmployeesByempid(id);

	}

	// get the employee detail using email
	@GetMapping("employee/detailbyemail/{email}")
	public EmployeeDetails getEmployeesByemail(@PathVariable("email") String email) {
		System.out.println(email);
		return this.employeeService.getEmployeesByEmail(email);
	}

	// delete the employee detail
	@DeleteMapping("/employee/detail/{empid}")
	public String deleteEmployeeByempid(@PathVariable("empid") Long id) {
		this.employeeService.deleteEmployeByempid(id);
		return "Your record is successfully deleted";

	}

	// update employee data
	@PutMapping("/employee/change")
	public String updateEmployee(@RequestBody EmployeeDetails employee) {
		//System.out.println(employee.email);
		this.employeeService.updateEmployee(employee);
		return "Update Succesfully !!!";
	}

}
