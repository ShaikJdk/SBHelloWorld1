package com.spring.boot.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Order;

@Service
public class AsyncService {
	
	public Order purchaseOrderAsync(Order order) throws InterruptedException, BusinessException {

		order.setTrackingId(UUID.randomUUID().toString());

		System.out.println("Purchasing Order Started  :: " + Thread.currentThread().getName());
	
		if(this.inventoryService_CheckOrderAvilability(order.getOrderId())) {
			System.out.println("Yes Order is Available :: " + Thread.currentThread().getName());
		} else {
			throw new BusinessException("Order is not Available...");
		}
		System.out.println("Purchasing Order End  :: " + Thread.currentThread().getName());
		order.setDelivaryDate(LocalDate.now());
		return order;
	}
	
	@Async("asyncTaskExecutor")
	public void invokeServices_AfterPayment(Order order) throws InterruptedException {
		this.notifyService_notifyOrderToVendor(order);
		this.assignDeliveryPartnerService_AssignOrderToDeliveryPartner(order);
		this.packagingService_PackingOrder(order);
		this.assignVendoerService_delivaryOrderToVendor(order);
	}
	
	private boolean inventoryService_CheckOrderAvilability(int orderId) throws InterruptedException {
		Thread.sleep(500L);
		System.out.println("inventoryService_CheckOrderAvilability :: " + Thread.currentThread().getName());
		return true;
	}
	
	public boolean pyamentService_CheckAvilabilityOrder(Order order) throws InterruptedException {
		Thread.sleep(500L);
		System.out.println("pyamentService_CheckAvilabilityOrder :: " + Thread.currentThread().getName());
		return true;
	}
	
	@Async("asyncTaskExecutor")
	private void notifyService_notifyOrderToVendor(Order order) throws InterruptedException {
		Thread.sleep(1000L);
		System.out.println("notifyService_notifyOrderToVendor :: " + Thread.currentThread().getName());
	}
	@Async("asyncTaskExecutor")
	private void assignDeliveryPartnerService_AssignOrderToDeliveryPartner(Order order) throws InterruptedException {
		Thread.sleep(3000L);
		System.out.println("assignDeliveryPartnerService_AssignOrderToDeliveryPartner :: " + Thread.currentThread().getName());
	}
	
	@Async("asyncTaskExecutor")
	private void packagingService_PackingOrder(Order order) throws InterruptedException {
		Thread.sleep(3000L);
		System.out.println("packagingService_PackingOrder :: " + Thread.currentThread().getName());
	}
	
	@Async("asyncTaskExecutor")
	private void assignVendoerService_delivaryOrderToVendor(Order order) throws InterruptedException {
		Thread.sleep(4000L);
		System.out.println("assignVendoerService_delivaryOrderToVendor :: " + Thread.currentThread().getName());
	}
	
}
