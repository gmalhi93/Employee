package com.malhitech.test.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malhitech.test.entity.Employee;
import com.malhitech.test.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;
	
	public Employee addEmployee(Employee emp)
	{
		return repository.save(emp);
	}
	
	public List<Employee> addEmployees(List<Employee> employees)
	{
		return  repository.saveAll(employees);
	}
	public String deleteEmployee(Long id)
	{
		 repository.deleteById(id);
		 return "Employee deleted";
	}
	
	public Employee getEmployee(Long id)
	{
		return repository.findById(id).orElse(null);
	}
	public List<Employee> getAllEmployees()
	{
		return repository.findAll();
	}
	
	public List<Employee> getEmployees(Date startDate, Date endDate)
	{
		return repository.findByDojBetween(startDate,endDate);
	}
}
