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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WriteServiceImpl implements WriteService {

	private final WriteRepository writeRepository;
	
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
	public WriteDTO findByWriteID(Long writeID) {
		// TODO Auto-generated method stub
		
		Optional<Write> optionalWrite = writeRepository.findByWriteID(writeID);
		
		if(optionalWrite.isEmpty()) {
			return null;
		}
		
		Write write = optionalWrite.get();
		
		MemberDTO memberDTO = MemberDTO
				.builder()
				.memberID(write.getMember().getMemberID())
				.nickname(write.getMember().getNickname())
				.password(write.getMember().getPassword())
				.build();
		
		BoardDTO boardDTO = BoardDTO
				.builder()
				.boardID(write.getBoard().getBoardID())
				.title(write.getBoard().getTitle())
				.content(write.getBoard().getContent())
				.build();
		
		return WriteDTO
				.builder()
				.writeID(writeID)
				.board(boardDTO)
				.member(memberDTO)
				.createdDate(write.getCreatedDate())
				.updatedDate(write.getUpdatedDate())
				.build();
	}

	@Override
	@Transactional
	public Long saveWrite(Member member, Board board) {
		// TODO Auto-generated method stub
		
		Write write = Write
				.builder()
				.board(board)
				.member(member)
				.createdDate(new Date())
				.updatedDate(new Date())
				.build();
		
		return writeRepository.save(write).getWriteID();
	}
	

}
