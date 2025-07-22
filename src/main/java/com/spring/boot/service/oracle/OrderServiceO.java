package com.spring.boot.service.oracle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.repository.oracle.OrderRepositoryO;

@Service
public class OrderServiceO {

	@Autowired
	private OrderRepositoryO orderRepositoryO;

	public List<com.spring.boot.dbmodel.oracle.OrdersO> getAllOrders() {
		List<com.spring.boot.dbmodel.oracle.OrdersO> orders = orderRepositoryO.findAll();
		return orders;
	}
}
