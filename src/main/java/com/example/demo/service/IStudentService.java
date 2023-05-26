package com.example.demo.service;



import com.example.demo.model.Student;

public interface IStudentService {
	
	
	void signUp(Student s);

	Student loginStudent(String un, String psw);

}
