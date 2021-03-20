package com.rsupport.controller.main;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String hello() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(auth.getPrincipal());
		
		return "home";
	}
	
}
