package com.rsupport.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board")
	public String test() {
		
		System.out.println("ddddddd");
		
		return "board/boardList";
	}
	
}
