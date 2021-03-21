package com.rsupport.domain.save;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsupport.domain.board.Board;

public interface SaveRepository extends JpaRepository<Save, Long> {
	
	Optional<Save> findBySaveID(Long saveID);
	
	Optional<Save> findByBoard(Board board);
}
