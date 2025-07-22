package com.spring.boot.repository.oracle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.oracle.DeptO;

public interface  DeptRepositoryO extends JpaRepository<DeptO, Integer> {
	List<DeptO> findAll();
}
