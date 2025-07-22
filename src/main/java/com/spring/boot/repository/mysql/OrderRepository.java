package com.spring.boot.repository.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.boot.dbmodel.mysql.OrdersM;


public interface  OrderRepository extends JpaRepository<OrdersM, Integer> {
	List<OrdersM> findAll();
	Optional<OrdersM> findById(Integer id);
	void deleteById(Integer id);
	OrdersM findByOrderId(Integer id);
	
	List<OrdersM> findByOrderNameOrderByOrderIdDesc(String orderName);
	List<OrdersM> findByOrderNameContainingOrderByOrderIdDesc(String orderName);
	
	@Query("from OrdersM where price= :price")
	List<OrdersM> selectquery1(@Param("price") double price);
	
	
	List<OrdersM> findByOrderNameContaining(String likekeyOfOrderName);

	@Query("select o FROM OrdersM o WHERE o.orderName LIKE CONCAT('%', :likekeyOfOrderName, '%')")
	List<OrdersM> searchByOrderNameSpecificOrder(@Param("likekeyOfOrderName") String likekeyOfOrderName);
	

}
