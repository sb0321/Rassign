package com.rsupport.domain.write;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Write {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "writeID")
	private Long writeID;
	
	@ManyToOne
	@JoinColumn(name = "memberID")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "boardID")
	private Board board;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "updatedDate")
	private Date updatedDate;

	@Builder
	public Write(Member member, Board board, Date createdDate, Date updatedDate) {
		this.member = member;
		this.board = board;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	

}
