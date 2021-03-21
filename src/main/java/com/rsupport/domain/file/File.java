package com.rsupport.domain.file;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fileID")
	private Long fileID;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "originalName")
	private String originalName;
	
	@Column(name = "UUID")
	private String UUID;
	
	@Builder
	public File(String path, String originalName, String UUID) {
		this.path = path;
		this.originalName = originalName;
		this.UUID = UUID;
	}
	
	

}
