package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	
	@GetMapping("/Upload")
	
	public String getUpload() {
		
		
		return "UploadForm";
		
		
	}
	
	@PostMapping("/Upload")
	
	public String postUpload(@RequestParam MultipartFile image, Model model) {
		
	if(!image.isEmpty()) {
		
		try {
			Files.copy(image.getInputStream(),Path.of("src/main/resources/static/images/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		     
			model.addAttribute("message", "upload success");
			
			return "UploadForm";
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	model.addAttribute("message", "upload failed");
		
	return "UploadForm";
		
	}
}
