package com.rsupport.controller.file;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rsupport.domain.file.File;
import com.rsupport.service.file.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FileAPIController {
	
	private final FileService fileService;
	
	@GetMapping("/download")
	public ModelAndView download(@RequestParam Map<Object, Object> params, ModelAndView mv) {
		
		Long fileID = Long.parseLong((String) params.get("fileID"));
		File file = fileService.findByfileID(fileID);
		
		System.out.println(file.toString());
		
		return mv;
		
	}

}
