package com.spring.boot.dbmodel.oracle.compositekey;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "ORDERS_COMPOSITE_KEY")
public class OrderCompositeKeyEntitiyO implements Serializable {

	public OrderCompositeKeyEntitiyO() {
	}

	
	
	public OrderCompositeKeyEntitiyO(OrderCompositeKeyIdO id, String orderName, String orderType, Double price,
			LocalDate delivaryDate, OrderCompositeKeyDelivaryAddressO address) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderType = orderType;
		this.price = price;
		this.delivaryDate = delivaryDate;
		this.address = address;
	}

	@EmbeddedId
	private OrderCompositeKeyIdO id;
	
	@Column(name = "ORDER_NAME", nullable = false)
	private String orderName;
	
	@Column(name = "ORDER_TYPE")
	private String orderType;

	@Column(name = "ORDER_PRICE")
	private Double price;

	@Column(name = "DELIVARY_DATE")
	private LocalDate delivaryDate;
	
	@Embedded
	private OrderCompositeKeyDelivaryAddressO address;
	
}
