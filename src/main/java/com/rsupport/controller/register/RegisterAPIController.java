package com.rsupport.controller.register;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsupport.domain.member.MemberDTO;
import com.rsupport.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegisterAPIController {

	private final MemberService memberService;
	
	@PostMapping("/register/check")
	public String registerMemberCheck(HttpServletRequest request) {
		
		String memberID = request.getParameter("memberID");
		
		boolean result = memberService.existByMemberID(memberID);
		
		return Boolean.toString(result);
	}
	
	@PostMapping("/register")
	public String registerMember(HttpServletRequest request) {
		
		String memberID = request.getParameter("memberID");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		
		MemberDTO newMember = MemberDTO
				.builder()
				.memberID(memberID)
				.password(password)
				.nickname(nickname)
				.build();
		
		memberService.saveMember(newMember);
		
		return nickname;
	}
	
}
