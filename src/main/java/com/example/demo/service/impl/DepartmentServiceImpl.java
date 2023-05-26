package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departRepo;
	
	@Override
	public void addDepartment(Department dpt) {
		
		departRepo.save(dpt);
		
	}

	@Override
	public List<Department> getAllDepartment() {
		
		return departRepo.findAll();
	}

	@Override
	public void deleteDepartment(int id) {
		
		departRepo.deleteById(id);
		
	}

	@Override
	public Department getById(int id) {
		
		
		return departRepo.findById(id).get();
	}

	@Override
	public void updateDepartment(Department dept) {
		
		
		departRepo.save(dept);
		
	}

}
