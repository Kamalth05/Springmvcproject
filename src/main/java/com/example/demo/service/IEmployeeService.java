package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {
	
	void addEmp(Employee e);
	void deletEmp(Long id);
	void updateEmp(Employee e);
	Employee getEmpById(Long id);
	List<Employee> getAllEmps();
	

}
