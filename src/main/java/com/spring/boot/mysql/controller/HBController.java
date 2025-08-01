package com.spring.boot.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.config.MySqlDataSourceConfig;
import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Order;
import com.spring.boot.service.mysql.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mysql")
public class HBController {
	
	@Value("Hello")
	private String localVal;
	
	@Value("${key.prop1}")
	private String propVal;
	
	@Value("${key.prop2: Hi}")
	private String defaltVal;
	
	@Value("${key.prop3}")
	private List<String> list;

	@Value("#{${key.prop4}}")
	private Map<String,String> map;
	
//	@Value("${key.prop5}")
//	private String profilePropConfigVal;
	
	@Value("${key.prop6}")
	private String springCloudConfigVal;
	
	@Autowired
	private Environment env;
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MySqlDataSourceConfig config;

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
	public ResponseEntity<com.spring.boot.dbmodel.mysql.OrdersM> getOrder(@PathVariable int orderId) throws BusinessException{

		log.info("getOrder - Start");
		Optional<com.spring.boot.dbmodel.mysql.OrdersM> order = null;
		try {
			order = orderService.getOrderById(orderId);
		} catch (Exception e) {
			log.error("getOrder - Exception " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		log.info("getOrder - end");
		return new ResponseEntity<com.spring.boot.dbmodel.mysql.OrdersM>(order.get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/getOrdersBy", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>> getOrderBySomething(@RequestBody Order order) throws BusinessException{
				
		log.info("getOrder - Start");
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders = null;
		try {
			orders = orderService.getOrdersByName(order);
		} catch (Exception e) {
			log.error("getOrder - Exception " + e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		log.info("getOrder - end");
		return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllOrder", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>> getAllOrder() {

		System.out.println(localVal);
		System.out.println(propVal);
		System.out.println(defaltVal);
		System.out.println(list);
		System.out.println(map);
		System.out.println(config.getUrl() + " " +config.getUsername() + " " + config.getPassword() );
		System.err.println(env.toString());		
//		System.err.println(profilePropConfigVal);
		System.err.println(springCloudConfigVal);
		
		log.info("getAllOrder - Start");
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders = null;
		try {
			orders = orderService.getAllOrders();
		} catch (Exception e) {
			log.error("getAllOrder - Exception " + e.getMessage());
			return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(HttpStatus.EXPECTATION_FAILED);
		}
		log.info("getAllOrder - end");
		return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSpecificOrders/{specificOrderName}", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>> getSpecificOrders(
			@PathVariable("specificOrderName") String specificOrderName){
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders = null;
		try {
			orders = orderService.getSpecificOrders(specificOrderName);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllOrdersXML", consumes = {"application/xml"}, produces =  {"application/xml"})
	public ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>> getAllOrdersXML() {
		List<com.spring.boot.dbmodel.mysql.OrdersM> orders = null;
		try {
			orders = orderService.getAllOrders();
		} catch (Exception e) {
			return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(orders, HttpStatus.OK);
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
	
	@GetMapping(value = "/getAllOrderCompletableFuture", headers = "Accept=application/json", produces =  {"application/json"})
	public ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>> getAllOrderCompletableFuture() throws InterruptedException, ExecutionException {

		CompletableFuture<List<com.spring.boot.dbmodel.mysql.OrdersM>> orders = null;
		try {
			System.out.println("Main :: " + Thread.currentThread().getName());
			orders = orderService.getAllOrders_using_CompletableFuture();
		} catch (Exception e) {
			log.error("getAllOrder - Exception " + e.getMessage());
			return orders.thenApply(s -> new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(HttpStatus.EXPECTATION_FAILED)).get();
		}
		return orders.thenApply(s -> new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(s, HttpStatus.OK)).get();
	}
	
	@GetMapping(value = "/getAllOrderCompletableFutureByMultiThread", headers = "Accept=application/json", produces =  {"application/json"})
	public ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>> getAllOrderCompletableFutureByMultiThread() {

		CompletableFuture<List<com.spring.boot.dbmodel.mysql.OrdersM>> orders1,orders2, orders3  = null;
		List<com.spring.boot.dbmodel.mysql.OrdersM> finalResult = new ArrayList<>();;
		try {
			System.out.println("Main :: " + Thread.currentThread().getName());
			orders1 = orderService.getAllOrders_using_CompletableFuture();
			orders2 = orderService.getAllOrders_using_CompletableFuture();
			orders3 = orderService.getAllOrders_using_CompletableFuture();
			CompletableFuture.allOf(orders1, orders2, orders3).join();
			finalResult.addAll(orders1.get());
			finalResult.addAll(orders2.get());
			finalResult.addAll(orders3.get());
		} catch (Exception e) {
			log.error("getAllOrder - Exception " + e.getMessage());
			return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>>(finalResult , HttpStatus.OK);
	}
}
