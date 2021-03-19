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
import com.rsupport.domain.file.File;
import com.rsupport.domain.file.FileRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
public class FileRepositoryTests {
	
	@Autowired
	private FileRepository fileRepository;
	
	@Test
	public void testInsertFile() {
		
		File file = File
				.builder()
				.originalName("originalName")
				.path("path")
				.UUID("UUID")
				.build();
		
		fileRepository.save(file);
	}
	
	@Test
	public void testFindFile() {
		
		File file = File
				.builder()
				.originalName("originalName")
				.path("path")
				.UUID("UUID")
				.build();
		
		fileRepository.save(file);
		
		Optional<File> get = fileRepository.findByFileID(file.getFileID());
		
		assertEquals(get.isEmpty(), false);
		
		assertEquals(file, get.get());
		
	}

}
