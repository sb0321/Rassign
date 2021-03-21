package com.rsupport.domain.member;

import java.util.List;

import com.rsupport.domain.write.Write;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberDTO {
	
	private String memberID;
	private String password;
	private String nickname;
	private List<Write> writes;
	
	@Builder
	public MemberDTO(String memberID, String password, String nickname, List<Write> writes) {
		super();
		this.memberID = memberID;
		this.password = password;
		this.nickname = nickname;
		this.writes = writes;
	}
	
}
