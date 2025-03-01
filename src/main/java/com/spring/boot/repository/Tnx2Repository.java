package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.dbmodel.Tnx2;


public interface  Tnx2Repository extends JpaRepository<Tnx2, Integer> {
	
//	@Transactional
	@Modifying
	@Query("update Tnx2 t set t.tnxVal = :val where t.tnxId = :id")
	void updateTnx2(@Param("id") int id,@Param("val") int val);
	

}
