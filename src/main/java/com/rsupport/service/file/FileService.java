package com.rsupport.service.file;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.file.File;

public interface FileService {
	
	void saveFile(List<MultipartFile> mpf, Board board);
	
	File findByfileID(Long fileID);
}
