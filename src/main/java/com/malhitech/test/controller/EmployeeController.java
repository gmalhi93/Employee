package com.malhitech.test.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.malhitech.test.entity.Employee;
import com.malhitech.test.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService myService;
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return myService.getEmployee(id);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return myService.getAllEmployees();
	}
	
	@GetMapping("/bydate")
	public List<Employee> getEmployeesByDate(@RequestParam Date startDate, @RequestParam Date endDate) {
		return myService.getEmployees(startDate,endDate);
	}
	
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return myService.addEmployee(emp);
	}
	
	@PostMapping("/all")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees)
	{
		return myService.addEmployees(employees);
	}
	
}
