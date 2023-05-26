package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping("/Department")
	public String getDepartment(HttpSession session) {
		if(session.getAttribute("validuser")==null) {
			
			return "LogIn";
			
		}
		return "Department";
		
		
	}
	
	@PostMapping("/Department")
	public String postDepartment(@ModelAttribute  Department dept) {
		
		service.addDepartment(dept);
		
		return "Department";
		
		
	}
	
	@GetMapping("/deptList")
	public String getAll(Model model) {
		
		model.addAttribute("dlist", service.getAllDepartment());
		
		
		return "DepartmentList";
		
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		
		service.deleteDepartment(id);
		
		return "redirect:/deptList";
		
		
	}
	
	@GetMapping("/edit/{id}")
	public String editDepartment(@PathVariable int id, Model model) {
		
		model.addAttribute("deptObject", service.getById(id));
		

		
		return "EditDepartment";
		
		
	}
	
	@PostMapping("/update")
	public String updateDepartment(@ModelAttribute Department dpt) {
		
		service.updateDepartment(dpt);

		
		return "redirect:/deptList";
		
		
	}
	
	
	


}
