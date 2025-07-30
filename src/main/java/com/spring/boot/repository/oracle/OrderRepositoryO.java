package com.spring.boot.repository.oracle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.spring.boot.dbmodel.oracle.OrdersO;

public interface  OrderRepositoryO extends JpaRepository<OrdersO, Integer> {
	
	List<OrdersO> findAll();
	
	@Procedure(name = "OrdersO.getOrdersByTypeUsingAnnotation")
    void getOrdersByTypeUsingAnnotation(@Param("p_in_order_type") String orderType);
 
}
