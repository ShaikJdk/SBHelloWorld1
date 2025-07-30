package com.spring.boot.dbmodel.oracle;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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

	public OrdersO(int orderId, String orderName, String orderType, Double price, LocalDate delivaryDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderType = orderType;
		this.price = price;
		this.delivaryDate = delivaryDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_seq_gen")
    @SequenceGenerator(
        name = "ORDERS_seq_gen",
        sequenceName = "ORDERS_SEQ",     // match the DB sequence name (schema-qualified if needed)
        allocationSize = 1            // see performance note below
    )
	@Column(name = "ORDER_ID")
	private int orderId;
	
	@Column(name = "ORDER_NAME", nullable = false)
	private String orderName;
	
	@Column(name = "ORDER_TYPE")
	private String orderType;

	@Column(name = "ORDER_PRICE")
	private Double price;

	@Column(name = "DELIVARY_DATE")
	private LocalDate delivaryDate;
	
}
