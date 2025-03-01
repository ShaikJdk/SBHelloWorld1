package com.spring.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dbmodel.Journaling;



public interface  JournalingRepository extends JpaRepository<Journaling, String> {
	
	@Transactional
	Optional<Journaling> findById(String id);
	
	@Transactional
	void deleteById(String id);
	
	@Transactional
	Journaling findByJournalingId(String id);

}
