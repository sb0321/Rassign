package com.rsupport.service.save;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.file.File;
import com.rsupport.domain.save.Save;

public interface SaveService {
	
	Save saveSave(File file, Board board);

}
