package com.spring.boot.pojo;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PurchaseDetails {

	private String tnx_id;
	private String pname;
	private Date pdate;
	private Double offeramt;
	
}
