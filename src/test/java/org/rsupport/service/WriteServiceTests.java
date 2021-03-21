package org.rsupport.service;

import static org.junit.Assert.assertEquals;

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
import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardRepository;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberRepository;
import com.rsupport.domain.write.Write;
import com.rsupport.domain.write.WriteDTO;
import com.rsupport.domain.write.WriteRepository;
import com.rsupport.service.write.WriteService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class WriteServiceTests {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private WriteRepository writeRepository;
	
	@Autowired
	private WriteService writeService;
	
	private static final String MEMBER_ID = "test";
	
	@Before
	@Transactional
	public void init() {
		
		Member member = Member
				.builder()
				.memberID(MEMBER_ID)
				.password("password")
				.nickname("nickname")
				.build();
		
		memberRepository.save(member);
	
		Board board = Board
				.builder()
				.title("testTitle")
				.content("board content")
				.build();
		
		boardRepository.save(board);
		
		Write write = Write
				.builder()
				.board(board)
				.member(member)
				.build();
		
		writeRepository.save(write);
	}
	
	@Test
	@Transactional
	public void testFindByMember() {
		
		Member member = memberRepository.findByMemberID(MEMBER_ID).get();
		
		List<WriteDTO> find = writeService.findByMember(member);
		
		log.info(find.size());
		log.info(find.get(0).getBoard().toString());
		log.info(find.get(0).getMember().toString());
	}
	
	@Test
	@Transactional
	public void testFindByWriteID() {
		
		Member member = memberRepository.findAll().get(0);
		Board board = boardRepository.findAll().get(0);
		
		Write write = Write
				.builder()
				.board(board)
				.member(member)
				.build();
		
		Long writeID = writeRepository.save(write).getWriteID();
		
		assertEquals(writeID, writeService.findByWriteID(writeID).getWriteID());
	}
	
	@Test
	@Transactional
	public void testSaveWrite() {
		
		Member member = memberRepository.findAll().get(0);
		Board board = boardRepository.findAll().get(0);
		
		Write write = writeService.saveWrite(member, board);

		assertEquals(member, write.getMember());
		assertEquals(board, write.getBoard());
		
		assertEquals(board, memberRepository.findAll().get(0).getWrites().get(0).getBoard());
		assertEquals(member, boardRepository.findAll().get(0).getWrite().getMember());
	}
	
	@Test
	@Transactional
	public void testFindByBoard() {
		
		Board board = boardRepository.findAll().get(0);
		Member member = memberRepository.findAll().get(0);
		
		writeService.saveWrite(member, board);
		
		assertEquals(member, board.getWrite().getMember());
		assertEquals(board, member.getWrites().get(0).getBoard());
	}

}
