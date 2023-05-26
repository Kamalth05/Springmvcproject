package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
      
	 @Autowired
	  private StudentRepository studentRepo;
	
	@Override
	public Student loginStudent(String un, String psw) {
		
		
		
		return studentRepo.findByUsernameAndPassword(un,psw);
	}

	@Override
	public void signUp(Student s) {
		
		studentRepo.save(s);
		
	}

}
