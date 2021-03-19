package com.rsupport.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
	
	@Id
	@Column(name = "memberID")
	private String memberID;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nickname")
	private String nickname;

	@Builder
	public Member(String memberID, String password, String nickname) {
		this.memberID = memberID;
		this.password = password;
		this.nickname = nickname;
	}
	

}
