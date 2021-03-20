package com.rsupport.controller.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorAdviceController {

	@ExceptionHandler(Exception.class)
	public String exception() {
		
		return "error/accessError";
	}
}
