package com.rsupport.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberDTO {
	
	private String memberID;
	private String password;
	private String nickname;
	
	@Builder
	public MemberDTO(String memberID, String password, String nickname) {
		this.memberID = memberID;
		this.password = password;
		this.nickname = nickname;
	}

	
}
