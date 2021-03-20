package com.rsupport.domain.write;

import java.util.Date;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.member.MemberDTO;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WriteDTO {

	private Long writeID;
	private MemberDTO member;
	private Board board;
	private Date createdDate;
	private Date updatedDate;
	
	@Builder
	public WriteDTO(Long writeID, MemberDTO member, Board board, Date createdDate, Date updatedDate) {
		super();
		this.writeID = writeID;
		this.member = member;
		this.board = board;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	

}
