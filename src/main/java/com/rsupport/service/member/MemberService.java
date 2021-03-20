package com.rsupport.service.member;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberDTO;

public interface MemberService extends UserDetailsService {
	
	List<MemberDTO> findAll();
	
	MemberDTO findByMemberID(String memberID);
	
	Member findByMemberIDEntity(String memberID);
	
	boolean existByMemberID(String memberID);
	
	void saveMember(MemberDTO newMember);
	
	boolean updateMember(MemberDTO update);
	
	boolean deleteMember(MemberDTO member);

}
