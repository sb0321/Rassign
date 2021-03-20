package com.rsupport.controller.board;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rsupport.service.board.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardAPIController {

	private final BoardService boardService;
	
	@PostMapping("/board/create")
	public void makeBoard(MultipartHttpServletRequest request) throws Exception {
		
		String files = request.getFileNames().next();
		
		List<MultipartFile> mpr = request.getFiles(files);
		
		for(MultipartFile f : mpr) {
			System.out.println(f.getOriginalFilename());
		}
	}
	
}
