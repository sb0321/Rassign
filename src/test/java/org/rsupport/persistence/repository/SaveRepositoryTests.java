package org.rsupport.persistence.repository;

import static org.junit.Assert.assertEquals;

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
import com.rsupport.domain.file.File;
import com.rsupport.domain.file.FileRepository;
import com.rsupport.domain.save.Save;
import com.rsupport.domain.save.SaveRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
public class SaveRepositoryTests {
	
	@Autowired
	private SaveRepository saveRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Before
	public void init() {
		
		Board board = Board
				.builder()
				.title("title")
				.content("content")
				.build();
		
		boardRepository.save(board);
		
		File file = File
				.builder()
				.originalName("originalName")
				.path("path")
				.UUID("UUID")
				.build();
		
		fileRepository.save(file);
	}
	
	@Test
	public void testInsertSave() {
		
		Save save = Save
				.builder()
				.board(boardRepository.findAll().get(0))
				.file(fileRepository.findAll().get(0))
				.build();
		
		Save s = saveRepository.save(save);
		
		Board board = boardRepository.findAll().get(0);
		board.addSave(s);
		
		assertEquals(boardRepository.findAll().get(0), save.getBoard());
		assertEquals(fileRepository.findAll().get(0), save.getFile());
		
		assertEquals(fileRepository.findAll().get(0), boardRepository.findAll().get(0).getSaves().get(0).getFile());
		
	}

}
