package org.rsupport.persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsupport.config.RootConfig;
import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardRepository;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberRepository;
import com.rsupport.domain.write.Write;
import com.rsupport.domain.write.WriteRepository;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
public class WriteRepositoryTests {
	
	@Autowired
	private WriteRepository writeRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Before
	public void init() {
		
		Member member = Member
				.builder()
				.memberID("id")
				.password("password")
				.nickname("nickname")
				.build();
		
		memberRepository.save(member);
		
		Board board = Board
				.builder()
				.title("title")
				.content("content")
				.build();
		
		boardRepository.save(board);
		
	}
	
	@Test
	public void testInsertWrite() {
		
		Write write = Write
				.builder()
				.board(boardRepository.findAll().get(0))
				.member(memberRepository.findAll().get(0))
				.build();
		
		log.info(writeRepository.save(write).toString());
		
	}
	
	@Test
	public void testFindWrite() {
		
		Write write = Write
				.builder()
				.board(boardRepository.findAll().get(0))
				.member(memberRepository.findAll().get(0))
				.build();
		
		writeRepository.save(write);
		
		List<Write> get = writeRepository.findByMember(memberRepository.findAll().get(0));
		
		assertEquals(write, get.get(0));
		
	}
	

}
