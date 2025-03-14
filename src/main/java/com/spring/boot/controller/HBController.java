package com.spring.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Order;
import com.spring.boot.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mysql")
public class HBController {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/postOrder", headers = "Accept=application/json")
	public ResponseEntity<String> postOrder(@RequestBody Order order) throws BusinessException{

		log.info("postOrder - Start");
		String trackingId = null;
		try {
			trackingId = orderService.saveOrder(order);
		} catch (Exception e) {
			log.error("getOrder - Exception " +e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		log.info("postOrder - end");
		return new ResponseEntity<Void>(HttpStatus.CREATED)
				.ofNullable("Order is Placed Successfully .... Your Order Tracking Id : " + trackingId);
	}
	
	@GetMapping(value = "/getOrder/{orderId}", headers = "Accept=application/json")
	public ResponseEntity<com.spring.boot.dbmodel.Order> getOrder(@PathVariable int orderId) throws BusinessException{

		log.info("getOrder - Start");
		Optional<com.spring.boot.dbmodel.Order> order = null;
		try {
			order = orderService.getOrderById(orderId);
		} catch (Exception e) {
			log.error("getOrder - Exception " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		log.info("getOrder - end");
		return new ResponseEntity<com.spring.boot.dbmodel.Order>(order.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/getOrdersBy", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.Order>> getOrderBySomething(@RequestBody Order order) throws BusinessException{

		log.info("getOrder - Start");
		List<com.spring.boot.dbmodel.Order> orders = null;
		try {
			orders = orderService.getOrdersByName(order);
		} catch (Exception e) {
			log.error("getOrder - Exception " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		log.info("getOrder - end");
		return new ResponseEntity<List<com.spring.boot.dbmodel.Order>>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllOrder", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.Order>> getAllOrder() {

		log.info("getAllOrder - Start");
		List<com.spring.boot.dbmodel.Order> orders = null;
		try {
			orders = orderService.getAllOrders();
		} catch (Exception e) {
			log.error("getAllOrder - Exception " + e.getMessage());
			return new ResponseEntity<List<com.spring.boot.dbmodel.Order>>(HttpStatus.EXPECTATION_FAILED);
		}
		log.info("getAllOrder - end");
		return new ResponseEntity<List<com.spring.boot.dbmodel.Order>>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/deleteOrder", headers = "Accept=application/json")
	public ResponseEntity<String> deleteOrder(@RequestParam int orderId) throws BusinessException {

		log.info("deleteOrder - Start");
		try {
			orderService.deleteOrder(orderId);
		} catch (Exception e) {
			log.error("deleteOrder - Exception " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		log.info("deleteOrder - end");
		return new ResponseEntity<Void>(HttpStatus.OK)
				.ofNullable("Order is deleted Successfully .... Your Order  Id : " + orderId);
	}
}
