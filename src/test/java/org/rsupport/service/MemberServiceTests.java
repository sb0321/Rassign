package org.rsupport.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.rsupport.config.RootConfig;
import com.rsupport.config.ServletConfig;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberDTO;
import com.rsupport.domain.member.MemberRepository;
import com.rsupport.service.member.MemberService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class MemberServiceTests {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Before
	public void init() {
		
		for(int i = 0; i < 10; i++) {
			
			Member member = Member
					.builder()
					.memberID(i + "")
					.nickname("nickname" + i)
					.password("password" + i)
					.build();
			
			memberRepository.save(member);
		}
		
	}
	
	@Test
	@Transactional
	public void testUpdateMember() {
		
		String memberID = "test";
		
		Member testMember = Member
				.builder()
				.memberID(memberID)
				.password("beforePassword")
				.nickname("beforeNickname")
				.build();
		
		// 일단 멤버를 저장
		memberRepository.save(testMember);
		
		// 닉네임 바꾸기
		MemberDTO changeNickname = MemberDTO
				.builder()
				.memberID(memberID)
				.nickname("afterNickname")
				.password(testMember.getPassword())
				.build();
		
		// 로직 실행
		assertEquals(true, memberService.updateMember(changeNickname));
		
		assertNotEquals("beforeNickname", memberRepository.findByMemberID(memberID).get().getNickname());
		
		// 패스워드 바꾸기
		MemberDTO changePassword = MemberDTO
				.builder()
				.memberID(memberID)
				.nickname(testMember.getNickname())
				.password("afterPassword")
				.build();
		
		// 로직 실행
		assertEquals(true, memberService.updateMember(changePassword));
		
		assertNotEquals("beforePassword", memberRepository.findByMemberID(memberID).get().getPassword());
		
	}
	
	@Test
	@Transactional
	public void testSaveMember() {
		
		MemberDTO dto = MemberDTO
				.builder()
				.memberID("test")
				.password("testPassword")
				.nickname("testNickname")
				.build();
		
		memberService.saveMember(dto);
		
		Member member = memberRepository.findByMemberID("test").get();
		
		assertEquals("test", member.getMemberID());
		assertEquals("testPassword", member.getPassword());
		assertEquals("testNickname", member.getNickname());
		
	}
	
	@Test
	@Transactional
	public void testDeleteMember() {
		
		String memberID = "test";
		
		Member testMember = Member
				.builder()
				.memberID(memberID)
				.password("beforePassword")
				.nickname("beforeNickname")
				.build();
		
		memberRepository.save(testMember);
		
		MemberDTO delMember = MemberDTO
				.builder()
				.memberID(memberID)
				.build();
		
		assertEquals(true, memberService.deleteMember(delMember));
	}
	
	@Test
	public void testGetMemberList() {
		
		int size = memberRepository.findAll().size();
		
		List<MemberDTO> result = memberService.findAll();
		
		assertEquals(size, result.size());
		
		for(MemberDTO dto : result) {
			log.info(dto);
		}
		
	}
	
	@Test
	public void testfindByMemberID() {
		
		// ok
		String memberID = "1";
		
		MemberDTO result = memberService.findByMemberID(memberID);
		
		assertEquals(memberID, result.getMemberID());
		
		//fail
		String notExistID = "notExist";
		
		MemberDTO failed = memberService.findByMemberID(notExistID);
		
		assertEquals(null, failed);
	}

}
