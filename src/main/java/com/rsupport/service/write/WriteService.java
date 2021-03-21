package com.rsupport.service.write;

import java.util.List;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.write.Write;
import com.rsupport.domain.write.WriteDTO;

public interface WriteService {
	
	List<WriteDTO> findByMember(Member member);
	
	Write findByWriteID(Long writeID);
	
	Write saveWrite(Member member, Board board);
	
	Write findByBoard(Board board);

}
