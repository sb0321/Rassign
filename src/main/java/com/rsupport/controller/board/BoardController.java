package com.rsupport.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rsupport.service.board.BoardService;
import com.rsupport.service.member.MemberService;
import com.rsupport.service.write.WriteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	private final MemberService memberService;
	private final WriteService writeService;
	
	@GetMapping("/board")
	public String boardList(Model model) {
		
		
		
		return null;
	}
	
}
