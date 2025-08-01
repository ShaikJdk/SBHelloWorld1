package com.spring.boot.repository.oracle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.dbmodel.oracle.relationship.EmployeeO;


public interface EmployeeRepository extends JpaRepository<EmployeeO, Integer> {
	
	@Transactional
	EmployeeO findByEid(Integer empid);
	@Transactional
	List<EmployeeO> findAll();
}
