package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentService {
	
	void addDepartment(Department dpt);
	List<Department> getAllDepartment();
	void deleteDepartment(int id);
	Department getById(int id);
	void updateDepartment(Department dept);
	

}
