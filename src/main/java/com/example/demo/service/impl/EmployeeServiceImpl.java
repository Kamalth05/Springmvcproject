package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	
	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public void addEmp(Employee e) {
		employeeRepo.save(e);
		
		
	}

	@Override
	public void deletEmp(Long id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee e) {
		employeeRepo.save(e);
		
	}

	@Override
	public Employee getEmpById(Long id) {
		
		return employeeRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return employeeRepo.findAll();
	}
	
	
	
		
		
	}


