package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;

@Controller
public class UserController {
	@Autowired
	private IStudentService service;
	
	@GetMapping("/")
	 public String getLogin() {
		
		
		 
		 
		 return "LogIn";
	 }
	
	@PostMapping("/LogIn")
	public String postLogin(@ModelAttribute Student s, Model model, HttpSession session) {
		
		 Student st = service.loginStudent(s.getUsername(),s.getPassword());
		 
		 if(st!=null) {
			 
			// model.addAttribute("uname", s.getUsername());
			 
			 session.setAttribute("validuser", st);
			 session.setMaxInactiveInterval(200);
			 
			 return "Home";
		 }
		
		return "LogIn";
	}
	
	@GetMapping("/signup")
	public String getSignUp() {
		
		
		return "signup";
		
		
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute Student s ) {
		
		service.signUp(s);
		
		return "LogIn";
		
		
	}
	
	@GetMapping("/Logout")
	public String logoutWabpage(HttpSession session) {
		
		session.invalidate();//kill session
		return "LogIn";
		
		
	}
	

}
