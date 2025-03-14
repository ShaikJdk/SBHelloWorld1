package com.spring.boot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.dbmodel.Order;


public interface  OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findAll();
	Optional<Order> findById(Integer id);
	void deleteById(Integer id);
	Order findByOrderId(Integer id);
	
	List<Order> findByOrderNameOrderByOrderIdDesc(String orderName);
	List<Order> findByOrderNameContainingOrderByOrderIdDesc(String orderName);
	
	@Query("from Order where price= :price")
	List<Order> selectquery1(@Param("price") double price);
	

}
