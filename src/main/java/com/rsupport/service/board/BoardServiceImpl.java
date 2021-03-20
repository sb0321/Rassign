package com.rsupport.service.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.board.BoardRepository;
import com.rsupport.domain.board.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	public List<BoardVO> findAllVOList() {
		
		List<Board> boardList = boardRepository.findAll();
		
		List<BoardVO> result = new ArrayList<>();
		
		for(Board board : boardList) {
			
			BoardVO vo = BoardVO
					.builder()
					.memberID(board.getWrite().getMember().getMemberID())
					.title(board.getTitle())
					.updatedDate(board.getWrite().getUpdatedDate())
					.boardID(board.getBoardID())
					.build();
			
			result.add(vo);
		}
		
		return result;
	}

	@Override
	public List<BoardDTO> findAll() {
		// TODO Auto-generated method stub
		
		List<Board> boardList = boardRepository.findAll();
		
		return boardList.stream().map(b -> BoardDTO
				.builder()
				.title(b.getTitle())
				.content(b.getContent())
				.boardID(b.getBoardID())
				.build()).collect(Collectors.toList());
	}

	@Override
	public BoardDTO findByBoardID(Long boardID) {
		// TODO Auto-generated method stub
		
		Optional<Board> optionalBoard = boardRepository.findByBoardID(boardID);
		
		if(optionalBoard.isEmpty()) {
			return null;
		}
		
		Board board = optionalBoard.get();
		
		BoardDTO dto = BoardDTO
				.builder()
				.boardID(board.getBoardID())
				.title(board.getTitle())
				.content(board.getContent())
				.build();
		
		return dto;
	}

	@Override
	public Boolean existByboardID(Long boardrID) {
		// TODO Auto-generated method stub
		return boardRepository.exists(boardrID);
	}

	@Override
	@Transactional
	public Long saveBoard(BoardDTO newBoard) {
		// TODO Auto-generated method stub
		
		Board board = Board
				.builder()
				.title(newBoard.getTitle())
				.content(newBoard.getContent())
				.build();
		
		return boardRepository.save(board).getBoardID();
		
	}

	@Override
	@Transactional
	public Boolean updateBoard(BoardDTO update) {
		// TODO Auto-generated method stub
		
		Optional<Board> optionalBoard = boardRepository.findByBoardID(update.getBoardID());
		
		if(optionalBoard.isEmpty()) {
			return false;
		}
		
		Board board = optionalBoard.get();
		
		board.update(update.getTitle(), update.getContent());
		
		return true;
	}

	@Override
	public Long deleteBoard(Long boardID) {
		// TODO Auto-generated method stub
		
		return boardRepository.deleteByBoardID(boardID);
	}

}
