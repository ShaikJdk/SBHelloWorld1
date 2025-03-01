package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.dbmodel.Tnx1;


public interface  Tnx1Repository extends JpaRepository<Tnx1, Integer> {
	
//	@Transactional
	@Modifying
	@Query("update Tnx1 t set t.tnxVal = :val where t.tnxId = :id")
	void updateTnx1(@Param("id") int id, @Param("val") int val);
	

}
