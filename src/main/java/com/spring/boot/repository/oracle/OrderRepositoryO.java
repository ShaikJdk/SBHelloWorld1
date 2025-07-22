package com.spring.boot.repository.oracle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.dbmodel.oracle.OrdersO;

public interface  OrderRepositoryO extends JpaRepository<OrdersO, Integer> {
	List<OrdersO> findAll();
}
