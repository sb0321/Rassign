package com.rsupport.controller.main;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String hello(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(auth.getPrincipal());

        if (!auth.getName().equals("anonymousUser")) {
            model.addAttribute("member", (UserDetails) auth.getPrincipal());
        }
		
		return "home";
	}
	
}
