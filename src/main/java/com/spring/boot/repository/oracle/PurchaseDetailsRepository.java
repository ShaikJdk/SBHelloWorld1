package com.spring.boot.repository.oracle;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.oracle.PurchaseDetails;

public interface  PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, String> {
	
	Optional<PurchaseDetails> findByTnxIdAndTnxType(String tnxId, String tnxType);
}
