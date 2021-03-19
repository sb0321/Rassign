package com.rsupport.domain.save;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.file.File;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Save {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saveID")
	private Long saveID;
	
	@ManyToOne
	@JoinColumn(name = "boardID")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name = "fileID")
	private File file;

	@Builder
	public Save(Board board, File file) {
		this.board = board;
		this.file = file;
	}

}
