package com.rsupport.domain.file;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
	
	Optional<File> findByFileID(Long fileID);

}
