package com.spring.boot.service.mysql.async;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Order;

@Service
public class SyncService {

	public Order purchaseOrder(Order order) throws InterruptedException, BusinessException {

		order.setTrackingId(UUID.randomUUID().toString());

		System.out.println("Purchasing Order Started  :: " + Thread.currentThread().getName());
	
		if(this.inventoryService_CheckOrderAvilability(order.getOrderId())) {
			System.out.println("Yes Order is Available :: " + Thread.currentThread().getName());
			if(this.pyamentService_CheckAvilabilityOrder(order)) {
				System.out.println("Payment is Done Successfully :: " + Thread.currentThread().getName());
				this.notifyService_notifyOrderToVendor(order);
				this.assignDeliveryPartnerService_AssignOrderToDeliveryPartner(order);
				this.packagingService_PackingOrder(order);
				this.assignVendoerService_delivaryOrderToVendor(order);
			} else {
				throw new BusinessException("Order is not Available...");
			}
		} else {
			throw new BusinessException("Order is not Available...");
		}
		System.out.println("Purchasing Order End  :: " + Thread.currentThread().getName());
		order.setDelivaryDate(LocalDate.now());
		return order;
	}
	
	private boolean inventoryService_CheckOrderAvilability(int orderId) throws InterruptedException {
		Thread.sleep(500L);
		System.out.println("inventoryService_CheckOrderAvilability :: " + Thread.currentThread().getName());
		return true;
	}
	
	private boolean pyamentService_CheckAvilabilityOrder(Order order) throws InterruptedException {
		Thread.sleep(500L);
		System.out.println("pyamentService_CheckAvilabilityOrder :: " + Thread.currentThread().getName());
		return true;
	}
	
	private void notifyService_notifyOrderToVendor(Order order) throws InterruptedException {
		Thread.sleep(1000L);
		System.out.println("notifyService_notifyOrderToVendor :: " + Thread.currentThread().getName());
	}
	
	private void assignDeliveryPartnerService_AssignOrderToDeliveryPartner(Order order) throws InterruptedException {
		Thread.sleep(3000L);
		System.out.println("assignDeliveryPartnerService_AssignOrderToDeliveryPartner :: " + Thread.currentThread().getName());
	}
	
	private void packagingService_PackingOrder(Order order) throws InterruptedException {
		Thread.sleep(3000L);
		System.out.println("packagingService_PackingOrder :: " + Thread.currentThread().getName());
	}
	
	private void assignVendoerService_delivaryOrderToVendor(Order order) throws InterruptedException {
		Thread.sleep(4000L);
		System.out.println("assignVendoerService_delivaryOrderToVendor :: " + Thread.currentThread().getName());
	}
	
}
