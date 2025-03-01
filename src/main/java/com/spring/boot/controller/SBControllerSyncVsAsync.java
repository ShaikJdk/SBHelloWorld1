package com.spring.boot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Order;
import com.spring.boot.service.AsyncService;
import com.spring.boot.service.SyncService;

@RestController
public class SBControllerSyncVsAsync {
		
	@Autowired
	public SyncService syncService;
	
	@Autowired
	public AsyncService asyncService;

	@PostMapping(value="/sync", headers = "Accept=application/json")
	public ResponseEntity<Order> purchaseOrderSync(@RequestBody Order order) {
		System.out.println("Purchasing Order Start -  purchaseOrderSync :: " + Thread.currentThread().getName());
		Order finalOrder = null;
		try {
			finalOrder = syncService.purchaseOrder(order); 
			finalOrder.setOrderStatus("Success");
			System.out.println("Purchasing Order Success  :: " + Thread.currentThread().getName());
		} catch (Exception e) {
			System.out.println("Purchasing Order Exception  :: " + Thread.currentThread().getName());
			order.setOrderStatus("Fail :: " + e.getMessage());
			return new ResponseEntity<Order>(finalOrder, HttpStatus.BAD_REQUEST);
		}
		System.out.println("Purchasing Order End  :: " + Thread.currentThread().getName());
		return new ResponseEntity<Order>(finalOrder, HttpStatus.OK);
	}
	
	@PostMapping(value="/async", headers = "Accept=application/json")
	public ResponseEntity<Order> purchaseOrderAsync(@RequestBody Order order) {
		System.out.println("Purchasing Order Start -  purchaseOrderAsync :: " + Thread.currentThread().getName());
		Order finalOrder = null;
		try {
			finalOrder = asyncService.purchaseOrderAsync(order); 
			
			if(asyncService.pyamentService_CheckAvilabilityOrder(order)) {
				System.out.println("Payment is Done Successfully :: " + Thread.currentThread().getName());
			} else {
				throw new BusinessException("Order is not Available...");
			}
			asyncService.invokeServices_AfterPayment(order);
			finalOrder.setOrderStatus("Success");
			System.out.println("Purchasing Order Success  :: " + Thread.currentThread().getName());
		} catch (Exception e) {
			System.out.println("Purchasing Order Exception  :: " + Thread.currentThread().getName());
			order.setOrderStatus("Fail :: " + e.getMessage());
			return new ResponseEntity<Order>(finalOrder, HttpStatus.BAD_REQUEST);
		}
		System.out.println("Purchasing Order End  :: " + Thread.currentThread().getName());
		return new ResponseEntity<Order>(finalOrder, HttpStatus.OK);
	}
	
	
}