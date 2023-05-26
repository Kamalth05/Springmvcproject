package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.utils.MailUtils;

@Controller
public class ContactController {
	
	
	@Autowired
	private MailUtils mailutil;
	
	@GetMapping("/contact")
	public String getContact() {
		
		return "EmailForm";
		
		
	}
	
	@PostMapping("/contact")
	public String postContact(@RequestParam String to, @RequestParam String subject, @RequestParam String message) {
		
		mailutil.sendEmail(to,subject,message);
		
		
		return "EmailForm";
		
		
	}

}
