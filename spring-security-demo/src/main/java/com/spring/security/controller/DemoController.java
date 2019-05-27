package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {


	@RequestMapping("/")
	public String showHome()
	{
		return "home";
	}

	
	@GetMapping("/leaders")
	public String leaders()
	{
		return "leaders";
	}
	
	
}





