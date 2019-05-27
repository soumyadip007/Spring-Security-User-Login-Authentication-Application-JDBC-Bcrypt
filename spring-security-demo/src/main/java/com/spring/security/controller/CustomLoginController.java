package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomLoginController {

	
	@GetMapping("/showMyLoginPage")
	public String showHome()
	{
	//	return "login";
		return "fancylogin";
	}
	
	
}
