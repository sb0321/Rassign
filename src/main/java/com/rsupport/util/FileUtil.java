package com.rsupport.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	private static final String filePath = "C:\\upload\\";
	
	public static String parseInsertFile(MultipartFile mpf, String UUID)
			throws IllegalStateException, IOException {
		
		File file = new File(filePath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String originalFileName = mpf.getOriginalFilename();
		String originalFormat = "";
		if(originalFileName.lastIndexOf(".") != -1) {
		 originalFormat = originalFileName
				.substring(originalFileName.lastIndexOf("."));
		}
		File savePath = new File(filePath + UUID + originalFormat);
		mpf.transferTo(savePath);
	
		return savePath.toString();
	}
	

}
