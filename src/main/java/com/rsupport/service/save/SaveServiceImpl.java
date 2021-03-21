package com.rsupport.service.save;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.file.File;
import com.rsupport.domain.save.Save;
import com.rsupport.domain.save.SaveRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveServiceImpl implements SaveService {
	
	private final SaveRepository saveRepository;

	@Override
	@Transactional
	public Save saveSave(File file, Board board) {
		// TODO Auto-generated method stub
		
		Save save = Save
				.builder()
				.board(board)
				.file(file)
				.build();
		
		Save result = saveRepository.save(save);
		
		board.addSave(result);
		
		return result;
	}


}
