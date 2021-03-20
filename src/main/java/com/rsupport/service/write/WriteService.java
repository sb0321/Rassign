package com.rsupport.service.write;

import java.util.List;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.write.WriteDTO;

public interface WriteService {
	
	List<WriteDTO> findByMember(Member member);
	
	WriteDTO findByWriteID(Long writeID);
	
	Long saveWrite(Member member, Board board);

}
