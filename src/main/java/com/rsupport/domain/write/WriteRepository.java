package com.rsupport.domain.write;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsupport.domain.board.Board;
import com.rsupport.domain.member.Member;

public interface WriteRepository extends JpaRepository<Write, Long> {
	
	List<Write> findByMember(Member member);
	
	Optional<Write> findByWriteID(Long writeID);
	
	Optional<Write> findByBoard(Board board);

}
