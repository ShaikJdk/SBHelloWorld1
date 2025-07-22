package com.spring.boot.service.mysql;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.repository.mysql.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<com.spring.boot.dbmodel.mysql.OrdersM> getAllOrders() {
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders = orderRepository.findAll();
		return orders;
	}
	
	@Cacheable(value="specificOrders", key="#likekeyOfOrderName")
	public List<com.spring.boot.dbmodel.mysql.OrdersM> getSpecificOrders(String likekeyOfOrderName) {
//		List<com.spring.boot.dbmodel.Order> orders = orderRepository.findByOrderNameContaining(likekeyOfOrderName);
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders =
				orderRepository.searchByOrderNameSpecificOrder(likekeyOfOrderName);
		return orders;
	}
	
	public CompletableFuture<List<com.spring.boot.dbmodel.mysql.OrdersM>> getAllOrders_using_CompletableFuture() {
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders = orderRepository.findAll();
		return CompletableFuture.completedFuture(orders);
	}

	public Optional<com.spring.boot.dbmodel.mysql.OrdersM> getOrderById(int id) throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Invalid Order Id");
		}
		return orderRepository.findById(id);
	}

	public String saveOrder(com.spring.boot.pojo.Order order) throws BusinessException {
		String trackingId = UUID.randomUUID().toString();
		com.spring.boot.dbmodel.mysql.OrdersM ord = com.spring.boot.dbmodel.mysql.OrdersM.builder().orderId(order.getOrderId())
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

	public List<com.spring.boot.dbmodel.mysql.OrdersM> getOrdersByName(com.spring.boot.pojo.Order order) {
//		List<com.spring.boot.dbmodel.Order> orders = orderRepository.findByOrderNameOrderByOrderIdDesc(order.getOrderName());
//		List<com.spring.boot.dbmodel.Order> orders = orderRepository.findByOrderNameContainingOrderByOrderIdDesc(order.getOrderName());
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders = orderRepository.selectquery1(order.getPrice());
		
		return orders;
	}
}
