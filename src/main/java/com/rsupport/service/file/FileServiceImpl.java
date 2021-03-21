package com.rsupport.service.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.file.File;
import com.rsupport.domain.file.FileRepository;
import com.rsupport.service.save.SaveService;
import com.rsupport.util.FileUtil;
import com.rsupport.util.UUIDCreator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

	private final FileRepository fileRepository;
	
	private final SaveService saveService;
	
	@Override
	@Transactional
	public void saveFile(List<MultipartFile> mpf, Board board) {
		// TODO Auto-generated method stub
		
		List<File> files = new ArrayList<>();
		
		for(MultipartFile mf : mpf) {
			
			String uuid = UUIDCreator.makeUUID();
			
			try {
			File file = File
					.builder()
					.originalName(mf.getOriginalFilename())
					.UUID(uuid)
					.path(FileUtil.parseInsertFile(mf, uuid))
					.UUID(uuid)
					.build();
			
			files.add(file);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		List<File> savedFileList = fileRepository.save(files);
		
		for(File savedFile : savedFileList) {
			saveService.saveSave(savedFile, board);
			System.out.println(savedFile.getOriginalName());
		}
	}

	@Override
	public File findByfileID(Long fileID) {
		// TODO Auto-generated method stub
		Optional<File> optionalFile = fileRepository.findByFileID(fileID);
		
		if(optionalFile.isEmpty()) {
			return null;
		}
		
		return optionalFile.get();
	}

}
