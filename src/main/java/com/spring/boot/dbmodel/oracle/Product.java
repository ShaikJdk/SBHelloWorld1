package com.spring.boot.dbmodel.oracle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@Entity
@Table(name = "PRODUCT1")
//@NamedStoredProcedureQuery(
//	    name = "ProductPurchaseProcedure",
//	    procedureName = "procedure_purchase1",
//	    parameters = {
//	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "ptype", type = String.class),
//	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pquantity", type = Integer.class),
//	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ptnx_id", type = String.class),
//	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pname", type = String.class),
//	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pdate", type = java.sql.Date.class),
//	        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pofferamt", type = Double.class)
//	    }
//	)
public class Product {

	public Product() {
	}
	
	
	public Product(String did, String pname, int pavailability, String pprice, String poffer) {
		super();
		this.did = did;
		this.pname = pname;
		this.pavailability = pavailability;
		this.pprice = pprice;
		this.poffer = poffer;
	}


	@Id
	@Column(name = "P_TYPE", nullable = false)
	private String did;
	
	@Column(name = "P_NAME")
	private String pname;
	
	@Column(name = "P_AVAILABILITY")
	private int pavailability;
	
	@Column(name = "P_PRICE")
	private String pprice;
	
	@Column(name = "P_OFFER")
	private String poffer;
	
}
