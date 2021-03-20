package com.rsupport.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rsupport.domain.board.BoardVO;
import com.rsupport.service.board.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board")
	public String boardList(Model model) {
		
		List<BoardVO> boardList = boardService.findAllVOList();
		
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	@GetMapping("/board/create")
	public String createBoard() {
		
		return "board/createBoard";
	}
	
}
