package com.rsupport.service.save;

import org.springframework.stereotype.Service;

import com.rsupport.domain.save.Save;
import com.rsupport.domain.save.SaveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveServiceImpl implements SaveService {
	
	private final SaveRepository saveRepository;

	@Override
	public Save findByBoard(Long boardID) {
		// TODO Auto-generated method stub
		return null;
		
	}

}
