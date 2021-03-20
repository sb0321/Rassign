package com.rsupport.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardDTO {

	private Long boardID;
	private String title;
	private String content;
	
	@Builder
	public BoardDTO(Long boardID, String title, String content) {
		this.boardID = boardID;
		this.title = title;
		this.content = content;
	}
	
	
}
