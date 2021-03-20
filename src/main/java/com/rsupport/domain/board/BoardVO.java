package com.rsupport.domain.board;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardVO {

	private String memberID; 
	private String title;
	private Date updatedDate;
	
	@Builder
	public BoardVO(String memberID, String title, Date updatedDate) {
		this.memberID = memberID;
		this.title = title;
		this.updatedDate = updatedDate;
	}
	
	
}
