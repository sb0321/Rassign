package com.rsupport.controller.register;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsupport.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegisterAPIController {

	private final MemberService memberService;
	
	@PostMapping("/register/check")
	public String registerUserCheck(HttpServletRequest request) {
		
		String memberID = request.getParameter("memberID");
		
		boolean result = memberService.existByMemberID(memberID);
		
		return Boolean.toString(result);
	}
	
}
