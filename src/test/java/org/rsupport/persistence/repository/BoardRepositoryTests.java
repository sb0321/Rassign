package org.rsupport.persistence.repository;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsupport.config.RootConfig;
import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
public class BoardRepositoryTests {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@Test
	public void testInsertBoard() {
		
		Board board = Board
				.builder()
				.title("testTitle")
				.content("board content")
				.build();
		
		boardRepository.save(board);
	}

}
