package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@RestController
public class EmployeeRestApi {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getEmps() {
		
		
		return service.getAllEmps();
		
		
	}
	

}
