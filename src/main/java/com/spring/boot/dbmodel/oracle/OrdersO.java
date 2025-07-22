package com.spring.boot.dbmodel.oracle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "ORDERS")
public class OrdersO {

	public OrdersO() {
	}
	public OrdersO(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	@Id
	@Column(name = "ORDER_ID")
	private int orderId;
	
	@Column(name = "ORDER_NAME", nullable = false)
	private String orderName;
	
}
