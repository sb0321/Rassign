package com.rsupport.service.board;

import java.util.List;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.board.BoardDetailVO;
import com.rsupport.domain.board.BoardVO;
import com.rsupport.domain.member.Member;

public interface BoardService {
	
	List<BoardVO> findAllVOList();
	
	List<BoardDTO> findAll();
	
	BoardDTO findByBoardID(Long boardID);
	
	BoardDetailVO getBoardDetail(Long boardID);
	
	Boolean existByboardID(Long boardrID);
	
	Board saveBoard(BoardDTO newBoard);
	
	Boolean updateBoard(BoardDTO update);
	
	Long deleteBoard(Long boardID);

}
