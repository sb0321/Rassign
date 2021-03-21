package org.rsupport.service;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

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
import com.rsupport.domain.file.File;
import com.rsupport.domain.file.FileRepository;
import com.rsupport.domain.save.Save;
import com.rsupport.service.save.SaveService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class SaveServiceTests {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private SaveService saveService;
	
	@Test
	@Transactional
	public void testSaveSave() {
		
		File file = File
				.builder()
				.originalName("originalName")
				.path("path")
				.UUID("UUID")
				.build();
		
		File f = fileRepository.save(file);
		
		Board board = Board
				.builder()
				.title("title")
				.content("content")
				.build();
		
		Board b = boardRepository.save(board);
		
		Save save = saveService.saveSave(file, board);
		
		assertEquals(b, save.getBoard());
		assertEquals(f, save.getFile());
		
		
	}

}
