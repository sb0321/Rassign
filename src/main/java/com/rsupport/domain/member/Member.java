package com.rsupport.domain.member;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.rsupport.domain.write.Write;

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
	
	@OneToMany(mappedBy = "member")
	private List<Write> writes;

	@Builder
	public Member(String memberID, String password, String nickname) {
		this.memberID = memberID;
		this.password = password;
		this.nickname = nickname;
	}
	
	public void update(String password, String nickname) {
		this.password = password;
		this.nickname = nickname;
	}
	
	public void updatePassword(String password) {
		this.password = password;
	}
	
	public void updateNickname(String nickname) {
		this.nickname = nickname;
	}
	

}
