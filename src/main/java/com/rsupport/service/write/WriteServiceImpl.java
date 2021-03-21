package com.rsupport.service.write;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberDTO;
import com.rsupport.domain.write.Write;
import com.rsupport.domain.write.WriteDTO;
import com.rsupport.domain.write.WriteRepository;
import com.rsupport.service.board.BoardService;
import com.rsupport.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements WriteService {

	private final WriteRepository writeRepository;
	
	private final MemberService memberService;
	
	private final BoardService boardService;
	
	@Override
	public List<WriteDTO> findByMember(Member member) {
		// TODO Auto-generated method stub
		
		List<Write> writeList = writeRepository.findByMember(member);
		
		List<WriteDTO> result = new ArrayList<>();
		
		for(Write w : writeList) {
			
			Board board = w.getBoard();
			
			BoardDTO boardDTO = BoardDTO
					.builder()
					.boardID(board.getBoardID())
					.title(board.getTitle())
					.content(board.getContent())
					.build();
			
			MemberDTO memberDTO = MemberDTO
					.builder()
					.memberID(member.getMemberID())
					.nickname(member.getNickname())
					.password(member.getPassword())
					.build();
			
			WriteDTO dto = WriteDTO
					.builder()
					.board(boardDTO)
					.member(memberDTO)
					.createdDate(w.getCreatedDate())
					.updatedDate(w.getUpdatedDate())
					.build();
			
			result.add(dto);
		}
		
		return result;
	}

	@Override
	@Transactional
	public Write saveWrite(String memberID, Long boardID) {
		// TODO Auto-generated method stub
		
		Member member = memberService.findByMemberIDEntity(memberID);
		Board board = boardService.findByBoardIDEntity(boardID);
		
		Write write = Write
				.builder()
				.board(board)
				.member(member)
				.build();
		
		Write result = writeRepository.save(write);
		
		member.addWrite(result);
		board.setWrite(result);
		
		return result;
	}

	@Override
	public Write findByWriteID(Long writeID) {
		// TODO Auto-generated method stub
		
		Optional<Write> optionalWrite = writeRepository.findByWriteID(writeID);
		
		if(optionalWrite.isEmpty()) {
			return null;
		}
		
		return optionalWrite.get();
	}

	@Override
	public Write findByBoard(Board board) {
		// TODO Auto-generated method stub
		Optional<Write> optionalWrite = writeRepository.findByBoard(board);
		
		if(optionalWrite.isEmpty()) {
			return null;
		}
		
		return optionalWrite.get();
	}
	

}
