package com.rsupport.controller.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.member.Member;
import com.rsupport.service.board.BoardService;
import com.rsupport.service.file.FileService;
import com.rsupport.service.member.MemberService;
import com.rsupport.service.write.WriteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardAPIController {

	private final BoardService boardService;
	private final WriteService writeService;
	private final MemberService memberService;
	private final FileService fileService;
	
	@PostMapping("/board/create")
	public void makeBoard(MultipartHttpServletRequest request) throws Exception {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(title + " " + content);
		
		String memberID = SecurityContextHolder
				.getContext().getAuthentication().getName();
		
		Member member = memberService.findByMemberIDEntity(memberID);
		
		// 공지사항 저장
		BoardDTO dto = BoardDTO
				.builder()
				.title(title)
				.content(content)
				.build();
		
		// 보드를 저장
		Board board = boardService.saveBoard(dto);
		
		
		System.out.println("before");
		
		// write 저장
		writeService.saveWrite(member, board);
		
		System.out.println("after");
		System.out.println(request);
		
		if(request.getFileNames().hasNext()) {
			String files = request.getFileNames().next();
			List<MultipartFile> mpf = request.getFiles(files);
			fileService.saveFile(mpf, board);
		}
	}
	
	
	
}
