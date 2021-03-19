package org.rsupport.persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsupport.config.RootConfig;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
public class MemberRepositoryTests {
	
	@Autowired
	private MemberRepository memberRepository;

	
	@Test
	public void testInsertMember() {
		
		Member member = Member
				.builder()
				.memberID("test")
				.password("password")
				.nickname("nickname")
				.build();
		
		memberRepository.save(member);
		
	}
	
	@Test
	public void testFindByMemberID() {
		
		Member member = Member
				.builder()
				.memberID("test1")
				.password("password1")
				.nickname("nickname1")
				.build();
		
		memberRepository.save(member);
		
		Optional<Member> get = memberRepository.findByMemberID("test1");
		
		assertEquals(get.isEmpty(), false);

		
		assertEquals(member.getMemberID(), get.get().getMemberID());
	}
}
