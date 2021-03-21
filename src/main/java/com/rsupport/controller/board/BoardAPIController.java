package com.rsupport.controller.board;

import java.util.List;

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
	private final FileService fileService;
	private final MemberService memberService;
	
	@PostMapping("/board/create")
	public void makeBoard(MultipartHttpServletRequest request) throws Exception {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(title + " " + content);
		
		String memberID = SecurityContextHolder
				.getContext().getAuthentication().getName();
		
		// �������� ����
		BoardDTO dto = BoardDTO
				.builder()
				.title(title)
				.content(content)
				.build();
		
		// ��� ��������
		Member member = memberService.findByMemberIDEntity(memberID);
		
		// ���带 ����
		Board board = boardService.saveBoard(dto);
		
		// write ����
		writeService.saveWrite(member, board);
		
		if(request.getFileNames().hasNext()) {
			String files = request.getFileNames().next();
			List<MultipartFile> mpf = request.getFiles(files);
			fileService.saveFile(mpf, board);
		}
	}
	
	
	
}
