package com.org.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.spring.mvc.controller.domain.Student;

@Controller
@RequestMapping("/schools")
public class SchoolController {

	
	@RequestMapping("/ 	")
	public String getModel(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("student", student);
		
		return "show-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processConfirmation(@ModelAttribute("student") Student stu) {
		
		System.out.println(stu.getFirstName()+" "+stu.getLastName());
		
		return "dialog-submitted";
	}
}
