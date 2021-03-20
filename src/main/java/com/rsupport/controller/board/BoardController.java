package com.rsupport.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	@GetMapping("/board")
	public String boardList(Model model) {
		
		
		return null;
	}
	
}
