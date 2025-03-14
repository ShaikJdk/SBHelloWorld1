package com.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	public Users findByUsername(String username);		// Query DSL (Domain Specific Language)
	

}
