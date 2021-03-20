package com.rsupport.domain.write;

import java.util.Date;

import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.member.MemberDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WriteDTO {

	private Long writeID;
	private MemberDTO member;
	private BoardDTO board;
	private Date createdDate;
	private Date updatedDate;
	
	@Builder
	public WriteDTO(Long writeID, MemberDTO member, BoardDTO board, Date createdDate, Date updatedDate) {
		super();
		this.writeID = writeID;
		this.member = member;
		this.board = board;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
}
