package com.rsupport.domain.write;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WriteRepository extends JpaRepository<Write, Long> {
	
	Optional<Write> findByWriteID(Long writeID);

}
