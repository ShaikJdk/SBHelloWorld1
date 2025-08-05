package com.spring.boot.repository.oracle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dbmodel.oracle.VersionO;

public interface  VersionEntityRepository extends JpaRepository<VersionO, String> {
	
//	Optimistic locking assumes that multiple transactions can frequently complete without conflicting. 
//	It uses a special column (commonly named VERSION) to detect if someone else modified the row during your transaction.
//
//	2. How It Works in Oracle with JPA
//	You define a @Version column in your entity.
//
//	JPA/Hibernate automatically increments the version number on each update.
//
//	If two users fetch the same row and try to update it:
//
//	Only the first one succeeds.
//
//	The second gets a OptimisticLockException if the version no longer matches.
	
	
}
