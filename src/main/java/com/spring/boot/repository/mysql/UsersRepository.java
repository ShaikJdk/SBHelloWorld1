package com.spring.boot.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.mysql.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	public Users findByUsername(String username);		// Query DSL (Domain Specific Language)
	

}
