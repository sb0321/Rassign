package com.rsupport.service.file;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	Long saveFile(List<MultipartFile> mpf);

}
