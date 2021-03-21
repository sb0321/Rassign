package com.rsupport.domain.write;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
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
	private Date createdDate = new Date();
	
	@Column(name = "updatedDate")
	private Date updatedDate = new Date();

	@Builder
	public Write(Member member, Board board) {
		this.member = member;
		this.board = board;
	}
	
	

}
