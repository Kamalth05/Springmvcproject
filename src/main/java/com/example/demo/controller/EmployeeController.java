package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.model.Student;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.IEmployeeService;
import com.example.demo.utils.EmployeeExcelView;
import com.example.demo.utils.EmployeePdfView;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/employee")
	public String getEmployee(Model model, HttpSession session) { // This is to open form of Add(EmployeeForm)
		
		if(session.getAttribute("validuser")==null) {
			
			return "LogIn";
			
			
			
		}
		
		 model.addAttribute("deptList", deptService.getAllDepartment());  
	
		return "EmployeeForm";
		
		
	}
	
	@PostMapping("/addEmployee") // To add data
	public String postEmployee(@ModelAttribute Employee emp) {
		
		service.addEmp(emp);
		
		return "redirect:/employee";
		
		
	}
	
	@GetMapping("/employeeList") // this emloyeeList is from SideBar - Pull the data from database to show in web
	public String getemployees(Model model) {
		
		model.addAttribute("empList", service.getAllEmps());
		
		return "EmployeeList";
		
		
	}
	
	@GetMapping("/editemployee/{id}") // this is needed in order to open edit Emploee and work on update.
	public String edit(@PathVariable Long id, Model model) {
		
		model.addAttribute("empObject", service.getEmpById(id));
		 model.addAttribute("deptList", deptService.getAllDepartment());  
		
		
		return "EmployeeEdit";
	}
	
	
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee employee) {
		
		service.addEmp(employee);
	
		
		return "redirect:/employeeList";
		
		
	}
	
	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable Long id ) {
		
		service.deletEmp(id);
		
		return "redirect:/employeeList";
		
		
	}
	
	@GetMapping("/excel")
	public ModelAndView exportToExcel() {
		ModelAndView m =  new ModelAndView();
		m.setView(new EmployeeExcelView());

		//read data from DB
		List<Employee> list = service.getAllEmps();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}
	
	@GetMapping("/pdf")
	public ModelAndView exportToPdf() {
		ModelAndView m = new ModelAndView();
		m.setView(new EmployeePdfView());
		
		//read data from DB
		List<Employee> list = service.getAllEmps();
		//send to Excel Impl class
		m.addObject("list", list);

		return m;
	}
	
	
	@GetMapping("/home")
	public String getHome() {
		
		return "Home";
	}
	

	
}
