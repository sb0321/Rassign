package org.rsupport.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.rsupport.config.RootConfig;
import com.rsupport.config.ServletConfig;
import com.rsupport.domain.file.File;
import com.rsupport.domain.file.FileRepository;
import com.rsupport.service.file.FileService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class FileServiceTests {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private FileRepository fileRepository;
	

}
