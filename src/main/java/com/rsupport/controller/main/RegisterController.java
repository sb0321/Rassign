package com.rsupport.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegisterController {

	@GetMapping("/register")
	public String register() {
		return "register/register";
	}
	
}
