package org.rsupport.persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;
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
				.createdDate(new Date())
				.updatedDate(new Date())
				.build();
		
		writeRepository.save(write);
		
	}
	
	@Test
	public void testFindWrite() {
		
		Write write = Write
				.builder()
				.board(boardRepository.findAll().get(0))
				.member(memberRepository.findAll().get(0))
				.createdDate(new Date())
				.updatedDate(new Date())
				.build();
		
		writeRepository.save(write);
		
		Optional<Write> get = writeRepository.findByWriteID(write.getWriteID());
		
		assertEquals(0, 0);
		
		assertEquals(write, get.get());
		
	}
	

}
