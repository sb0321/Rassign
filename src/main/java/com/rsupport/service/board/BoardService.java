package com.rsupport.service.board;

import java.util.List;

import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.board.BoardVO;

public interface BoardService {
	
	List<BoardVO> findAllVOList();
	
	List<BoardDTO> findAll();
	
	BoardDTO findByBoardID(Long boardID);
	
	Boolean existByboardID(Long boardrID);
	
	Long saveBoard(BoardDTO newBoard);
	
	Boolean updateBoard(BoardDTO update);
	
	Long deleteBoard(Long boardID);

}
