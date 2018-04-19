package com.org.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/signin")
	public String getSignPage() {
		return "signin";
	}
	
	
	@RequestMapping("/processForm")
	public String getName(HttpServletRequest request , Model model) {
		
		String name = request.getParameter("studentName");
		
		name = name.toUpperCase();
		
		model.addAttribute("message", "yo "+name);
		return "process";
	}
	
	@RequestMapping("/postmanRequest")
	public String getPostmanCall(@RequestParam("studentName") String name, Model model) {
		
		name = name.toUpperCase();
		
	   model.addAttribute("message", "yo"+name);
		return "process";
	}
}
