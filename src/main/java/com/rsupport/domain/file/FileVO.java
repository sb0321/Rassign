package com.rsupport.domain.file;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FileVO {
	
	private String originalName;
	private String UUID;
	private Long fileID;
	
	@Builder
	public FileVO(String originalName, String UUID, Long fileID) {
		super();
		this.originalName = originalName;
		this.UUID = UUID;
		this.fileID = fileID;
	}
	
	
}
