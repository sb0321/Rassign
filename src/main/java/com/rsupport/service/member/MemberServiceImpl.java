package com.rsupport.service.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberDTO;
import com.rsupport.domain.member.MemberRepository;
import com.rsupport.domain.member.ROLE;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	
	@Override
	public Member findByMemberIDEntity(String memberID) {
		// TODO Auto-generated method stub

		Optional<Member> optionalMember = memberRepository.findByMemberID(memberID);
		
		if(optionalMember.isEmpty()) {
			return null;
		}
		
		return optionalMember.get();
	}
	
	@Override
	@Transactional
	public void saveMember(MemberDTO newMember) {
		// TODO Auto-generated method stub
		
		// 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
		String encryptedPassword = passwordEncoder.encode(newMember.getPassword());
		
		Member member = Member
				.builder()
				.memberID(newMember.getMemberID())
				.password(encryptedPassword)
				.nickname(newMember.getNickname())
				.build();
		
		memberRepository.save(member);
	}
	
	@Override
	public boolean existByMemberID(String memberID) {
		// TODO Auto-generated method stub
		return memberRepository.exists(memberID);
	}
	
	@Override
	@Transactional
	public boolean updateMember(MemberDTO update) {
		// TODO Auto-generated method stub
		
		Optional<Member> optionalMember = memberRepository.findByMemberID(update.getMemberID());
		
		if(optionalMember.isEmpty()) {
			return false;
		}
		
		Member member = optionalMember.get();
		
		// 닉네임이 같다면 pw를 바꾼다.
		if(member.getNickname().equals(update.getNickname())) {
			member.updatePassword(update.getPassword());
		} else if(member.getPassword().equals(update.getPassword())){
			member.updateNickname(update.getNickname());
		} else {
			member.update(update.getPassword(), update.getNickname());
		}
		
		return true;
	}
	
	@Override
	public List<MemberDTO> findAll() {
		// TODO Auto-generated method stub
		List<Member> list = memberRepository.findAll();
		
		List<MemberDTO> result = new ArrayList<>();
		
		for(Member member : list) {
			
			MemberDTO dto = MemberDTO
					.builder()
					.memberID(member.getMemberID())
					.password(member.getPassword())
					.nickname(member.getNickname())
					.build();
			
			result.add(dto);
		}
		
		
		return result;
	}
	
	
	@Override
	public MemberDTO findByMemberID(String memberID) {
		// TODO Auto-generated method stub
		
		Optional<Member> optionalMember = memberRepository.findByMemberID(memberID);
		
		Member member = null;
		if(optionalMember.isPresent()) {
			member = optionalMember.get();
			
			MemberDTO dto = MemberDTO
					.builder()
					.memberID(member.getMemberID())
					.password(member.getPassword())
					.nickname(member.getNickname())
					.build();
			
			return dto;
		}
		
		return null;
	}
	
	@Override
	@Transactional
	public boolean deleteMember(MemberDTO delMember) {
		// TODO Auto-generated method stub
		
		Optional<Member> optionalMember = memberRepository.findByMemberID(delMember.getMemberID());
		
		if(optionalMember.isEmpty()) {
			return false;
		}
		
		Member member = optionalMember.get();
		
		memberRepository.delete(member);
		
		return true;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Member> member = memberRepository.findByMemberID(username);
		
		if(member.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		
		Member user = member.get();
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(ROLE.MEMBER.getValue()));
		
		return new User(user.getMemberID(), user.getPassword(), grantedAuthorities);
	}
}
