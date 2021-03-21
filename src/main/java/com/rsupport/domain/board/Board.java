package com.rsupport.domain.board;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.rsupport.domain.save.Save;
import com.rsupport.domain.write.Write;

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
	
	@OneToOne(mappedBy = "board")
	private Write write;
	
	@OneToMany(mappedBy = "board")
	private List<Save> saves = new ArrayList<>();
	
	public void setWrite(Write write) {
		this.write = write;
	}
	
	public void addSave(Save save) {
		saves.add(save);
	}
	
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
