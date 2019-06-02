package com.spring.security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {


	@RequestMapping("/")
	public String showHome()
	{
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  String Pass = ((UserDetails)principal).getPassword();
		  System.out.println("One + "+username+"   "+Pass);
		} else {
		  String username = principal.toString();
		  System.out.println("Two + "+username);
		}
		
		return "home";
	}

	
	@GetMapping("/leaders")
	public String leaders()
	{
		return "leaders";
	}
	
	@GetMapping("/system")
	public String system()
	{
		return "system";
	}
	
	
}





