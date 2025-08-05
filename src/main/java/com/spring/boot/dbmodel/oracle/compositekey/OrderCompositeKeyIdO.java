package com.spring.boot.dbmodel.oracle.compositekey;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Builder
@Data
public class OrderCompositeKeyIdO implements Serializable {

	public OrderCompositeKeyIdO() {
	}

	public OrderCompositeKeyIdO(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}

	private int orderId;
	private String orderName;
	
}
