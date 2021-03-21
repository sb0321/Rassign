package com.rsupport.service.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rsupport.domain.file.File;
import com.rsupport.domain.file.FileRepository;
import com.rsupport.util.FileUtil;
import com.rsupport.util.UUIDCreator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

	private final FileRepository fileRepository;
	
	@Override
	public Long saveFile(List<MultipartFile> mpf) {
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
		
		fileRepository.save(files);
		
		return 1L;
	}

}
