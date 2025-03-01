package com.spring.boot.pojo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonTypeName(value = "Order")
public class Order {
	
	@JsonProperty("orderId")
	private int orderId;
	@JsonProperty("orderName")
	private String orderName;
	@JsonProperty("orderStatus")
	private String orderStatus;
	@JsonProperty("price")
	private double price;
	@JsonProperty("delivaryDate")
	private LocalDate delivaryDate;
	@JsonProperty("trackingId")
	private String trackingId;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderStatus=" + orderStatus + ", price="
				+ price + ", delivaryDate=" + delivaryDate + ", trackingId=" + trackingId + "]";
	}

	public Order(int orderId, String orderName, String orderStatus, double price, LocalDate delivaryDate,
			String trackingId) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderStatus = orderStatus;
		this.price = price;
		this.delivaryDate = delivaryDate;
		this.trackingId = trackingId;
	}

	public Order() {
		super();
	}
}
