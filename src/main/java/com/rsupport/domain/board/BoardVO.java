package com.rsupport.domain.board;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardVO {

	private Long boardID;
	private String memberID; 
	private String title;
	private Date updatedDate;
	
	@Builder
	public BoardVO(Long boardID, String memberID, String title, Date updatedDate) {
		super();
		this.boardID = boardID;
		this.memberID = memberID;
		this.title = title;
		this.updatedDate = updatedDate;
	}
}
