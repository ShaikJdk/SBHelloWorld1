package com.spring.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.Order;


public interface  OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findAll();
	Optional<Order> findById(Integer id);
	void deleteById(Integer id);
	Order findByOrderId(Integer id);
	

}
