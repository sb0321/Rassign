package com.rsupport.service.member;

import java.util.List;

import com.rsupport.domain.member.MemberDTO;

public interface MemberService {
	
	List<MemberDTO> findAll();
	
	MemberDTO findByMemberID(String memberID);
	
	void saveMember(MemberDTO newMember);
	
	boolean updateMember(MemberDTO update);
	
	boolean deleteMember(MemberDTO member);

}
