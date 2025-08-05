package com.spring.boot.dbmodel.oracle.compositekey;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class OrderCompositeKeyDelivaryAddressO implements Serializable {

	public OrderCompositeKeyDelivaryAddressO() {
	}
	
	public OrderCompositeKeyDelivaryAddressO(String add1, String district, String state, int pincode) {
		super();
		this.add1 = add1;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	private String add1;
	private String district;
	private String state;
	private int pincode;
	
}
