package com.spring.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<com.spring.boot.dbmodel.Order> getAllOrders() {
		List<com.spring.boot.dbmodel.Order> orders = orderRepository.findAll();
		return orders;
	}

	public Optional<com.spring.boot.dbmodel.Order> getOrderById(int id) throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Invalid Order Id");
		}
		return orderRepository.findById(id);
	}

	public String saveOrder(com.spring.boot.pojo.Order order) throws BusinessException {
		String trackingId = UUID.randomUUID().toString();
		com.spring.boot.dbmodel.Order ord = com.spring.boot.dbmodel.Order.builder().orderId(order.getOrderId())
				.orderName(order.getOrderName()).orderStatus(order.getOrderStatus())
				.price(order.getPrice())
				.delivaryDate(java.sql.Date.valueOf(LocalDate.now()))
				.trackingId(trackingId).build();
		if(order.getOrderId() <=0) {
			throw new BusinessException("Invalide Order Id...");
		}
		try {
			orderRepository.save(ord);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return trackingId;
	}

	public void deleteOrder(int id) throws BusinessException {
		if(id <=0) {
			throw new BusinessException("Invalide Order Id...");
		}
		try {
			orderRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
