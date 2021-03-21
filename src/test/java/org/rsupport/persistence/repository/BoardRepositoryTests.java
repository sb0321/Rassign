package org.rsupport.persistence.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsupport.config.RootConfig;
import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardRepository;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	public void testFindAll() {
		
		for(int i = 0; i < 10; i++) {
			Board board = Board
					.builder()
					.title("testTitle" + i)
					.content("board content" + i)
					.build();
			
			boardRepository.save(board);
		}
		
		List<Board> boardList = boardRepository.findAll();
		
		for(Board b : boardList) {
			log.info(b);
		}
	}
	
	@Test
	public void testInsertBoard() {
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("board content")
				.build();
		
		boardRepository.save(board);
	}
	
	@Test
	public void testFindByBoardID() {
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("board content")
				.build();
		
		boardRepository.save(board);
		
		Optional<Board> get = boardRepository.findByBoardID(board.getBoardID());
		
		assertEquals(get.isEmpty(), false);
		
		assertEquals(get.get().getTitle(), board.getTitle());
	}
	
	@Test
	public void testDeleteByBoardID() {
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("board content")
				.build();
		
		Long boardID = boardRepository.save(board).getBoardID();
		
		assertEquals(1, boardRepository.findAll().size());
		
		log.info(boardRepository.deleteByBoardID(boardID) + "------------------------");
			
		assertEquals(0, boardRepository.findAll().size());
	}

}
