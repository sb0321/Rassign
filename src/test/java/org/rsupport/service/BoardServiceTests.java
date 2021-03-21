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
import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.board.BoardDetailVO;
import com.rsupport.domain.board.BoardRepository;
import com.rsupport.domain.board.BoardVO;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberRepository;
import com.rsupport.domain.write.Write;
import com.rsupport.domain.write.WriteRepository;
import com.rsupport.service.board.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class BoardServiceTests {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private WriteRepository writeRepository;
	
	@Before
	public void init() {
		
		for(int i = 0; i < 1; i++) {
			
			Board board = Board
					.builder()
					.title(i + "")
					.content(i + "")
					.build();
			
			boardRepository.save(board);
		}
	}
	
	@Test
	public void testGetBoardDetail() {
		
		Board board = Board
				.builder()
				.title("title")
				.content("content")
				.build();
		
		Board b = boardRepository.save(board);
		
		Member member = Member
				.builder()
				.memberID("testID")
				.nickname("nickname")
				.password("password")
				.build();
		
		Member m = memberRepository.save(member);
		
		Write w = writeRepository.save(Write.builder().board(b).member(m).build());
		
		BoardDetailVO boardDetailVO = boardService.getBoardDetail(b.getBoardID());
		
		log.info(boardDetailVO);
		
	}
	
	@Test
	@Transactional
	public void testFindAll() {
		
		int boardCount = boardRepository.findAll().size();
		
		assertEquals(1, boardCount);
	}
	
	@Test
	@Transactional
	public void testFindByBoardID() {
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("testContent")
				.build();
		
		boardRepository.save(board);
		
		assertEquals(board.getTitle(), boardService.findByBoardID(board.getBoardID()).getTitle());
		
	}
	
	@Test
	@Transactional
	public void testExistByboardID() {
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("testContent")
				.build();
		
		boardRepository.save(board);
		
		assertEquals(true, boardService.existByboardID(board.getBoardID()));
	}
	
	@Test
	@Transactional
	public void testSaveBoard() {
		
		BoardDTO dto = BoardDTO
				.builder()
				.title("testTitle")
				.content("testContent")
				.build();
		
		Long boardID = boardService.saveBoard(dto).getBoardID();
		
		assertEquals(dto.getTitle(), boardRepository.findByBoardID(boardID).get().getTitle());
		
	}
	
	@Test
	@Transactional
	public void testUpdateBoard() {
		
		BoardDTO dto = BoardDTO
				.builder()
				.title("afterTestTitle")
				.content("afterTestContent")
				.build();
		
		assertEquals(false, boardService.updateBoard(dto));
		
		Board board = Board
				.builder()
				.title("beforeTestTitle")
				.content("beforeTestContent")
				.build();
		
		Long boardID = boardRepository.save(board).getBoardID();
		
		BoardDTO dto2 = BoardDTO
				.builder()
				.title("afterTestTitle")
				.content("afterTestContent")
				.boardID(boardID)
				.build();
		
		assertEquals(true, boardService.updateBoard(dto2));
		
		Board result = boardRepository.findByBoardID(boardID).get();
		
		assertEquals(dto.getTitle(), result.getTitle());
		assertEquals(dto.getContent(), result.getContent());
	}
	
	@Test
	@Transactional
	public void testDeleteBoard() {
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("testContent")
				.build();
		
		Long boardID = boardRepository.save(board).getBoardID();
		
		assertEquals(new Long(1), boardService.deleteBoard(boardID));
	}
	
	@Test
	@Transactional
	public void testfindAllVOList() {
		
		boardRepository.deleteAll();
		
		Member member = Member
				.builder()
				.memberID("testID")
				.nickname("nickname")
				.password("password")
				.build();
		
		Member m = memberRepository.save(member);
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("testContent")
				.build();
		
		Board b = boardRepository.save(board);
		
		Write w = writeRepository.save(Write.builder().board(b).member(m).build());
		
		m.addWrite(w);
		b.setWrite(w);
		
		List<BoardVO> list = boardService.findAllVOList();
		
		log.info(list);
	}

}
