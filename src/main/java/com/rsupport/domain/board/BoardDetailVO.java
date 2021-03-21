package com.rsupport.domain.board;

import java.util.Date;
import java.util.List;

import com.rsupport.domain.file.FileVO;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDetailVO {
	
	private Long boardID;
	private String memberID;
	private String title;
	private String content;
	private Date createdDate;
	private Date updatedDate;
	private List<FileVO> files;
	
	@Builder
	public BoardDetailVO(Long boardID, String memberID, String title, String content, Date createdDate,
			Date updatedDate, List<FileVO> files) {
		this.boardID = boardID;
		this.memberID = memberID;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.files = files;
	}
	
	

	
	
}
