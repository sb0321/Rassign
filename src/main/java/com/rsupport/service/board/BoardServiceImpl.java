package com.rsupport.service.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.board.BoardDTO;
import com.rsupport.domain.board.BoardDetailVO;
import com.rsupport.domain.board.BoardRepository;
import com.rsupport.domain.board.BoardVO;
import com.rsupport.domain.file.File;
import com.rsupport.domain.file.FileVO;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.save.Save;
import com.rsupport.domain.write.Write;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	public List<BoardVO> findAllVOList() {
		
		List<BoardVO> result = new ArrayList<>();
		
		List<Board> list = boardRepository.findAll();
		
		for(Board b : list) {
			
			BoardVO vo = BoardVO
					.builder()
					.boardID(b.getBoardID())
					.memberID(b.getWrite().getMember().getMemberID())
					.title(b.getTitle())
					.updatedDate(b.getWrite().getUpdatedDate())
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
	public Board saveBoard(BoardDTO newBoard) {
		// TODO Auto-generated method stub
		
		Board board = Board
				.builder()
				.title(newBoard.getTitle())
				.content(newBoard.getContent())
				.build();
		
		return boardRepository.save(board);
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

	@Override
	@Transactional
	public BoardDetailVO getBoardDetail(Long boardID) {
		// TODO Auto-generated method stub
		
		Optional<Board> optionalBoard = boardRepository.findByBoardID(boardID);
		
		if(optionalBoard.isEmpty()) {
			return null;
		}
		
		Board board = optionalBoard.get();
		
		Write write = board.getWrite();
		
		Member member = write.getMember();
		
		BoardDetailVO vo = BoardDetailVO
				.builder()
				.boardID(boardID)
				.memberID(member.getMemberID())
				.updatedDate(write.getUpdatedDate())
				.createdDate(write.getCreatedDate())
				.content(board.getContent())
				.title(board.getTitle())
				.build();
		
		return vo;
	}

	@Override
	public Board findByBoardIDEntity(Long boardID) {
		// TODO Auto-generated method stub
		Optional<Board> optionalBoard = boardRepository.findByBoardID(boardID);
		
		if(optionalBoard.isEmpty()) {
			return null;
		}
		
		return optionalBoard.get();
	}

}
