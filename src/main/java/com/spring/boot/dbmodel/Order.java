package com.spring.boot.dbmodel;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "ORDER_PROD")
public class Order {

	public Order() {
	}
	public Order(int orderId, String orderName, String orderStatus, double price, Date delivaryDate,
			String trackingId) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderStatus = orderStatus;
		this.price = price;
		this.delivaryDate = delivaryDate;
		this.trackingId = trackingId;
	}

	@Column(name = "ORDER_ID")
    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	@Column(name = "ORDER_NAME", nullable = false)
	private String orderName;
	
	@Column(name = "ORDER_STATUS")
	private String orderStatus;
	
	@Column(name = "ORDER_PRICE")
	private double price;
	
	@Column(name = "DELIVARY_DATE")
	private Date delivaryDate;
	
	@Column(name = "TRACKING_ID")
	private String trackingId;

//	@Override
//	public String toString() {
//		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderStatus=" + orderStatus + ", price="
//				+ price + ", delivaryDate=" + delivaryDate + ", trackingId=" + trackingId + "]";
//	}
	
	

	
}
