package com.example.demo.controller;


import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	
	@GetMapping("/GalleryList")
	public String gallery(Model model, HttpSession session) {
		

		if(session.getAttribute("validuser")==null) {
			
			return "LogIn";
			
			
		}
		String[] imgNames = new File("src/main/resources/static/images").list();
		model.addAttribute("images", imgNames);
		
		
		return "GalleryList";
	}

}
