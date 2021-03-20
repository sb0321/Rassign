package com.rsupport.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "boardID")
	private Long boardID;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Builder
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
