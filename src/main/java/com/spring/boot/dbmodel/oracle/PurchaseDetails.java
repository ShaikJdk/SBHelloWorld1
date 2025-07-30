package com.spring.boot.dbmodel.oracle;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@Entity
@Table(name = "VIEW_PURCHASE_DETAILS")
@Immutable
@IdClass(PurchaseDetailsId.class)
public class PurchaseDetails {

	public PurchaseDetails() {
	}
  

	 public PurchaseDetails(String tnxId, String tnxType, LocalDate saleDate, BigDecimal totalAmt,
			BigDecimal finalOfferAmt, Integer pAvailability, BigDecimal actualPrice, BigDecimal offer) {
		super();
		this.tnxId = tnxId;
		this.tnxType = tnxType;
		this.saleDate = saleDate;
		this.totalAmt = totalAmt;
		this.finalOfferAmt = finalOfferAmt;
		this.pAvailability = pAvailability;
		this.actualPrice = actualPrice;
		this.offer = offer;
	}


	@Id
	    @Column(name = "TNX_ID")
	    private String tnxId;

	    @Id
	    @Column(name = "TNX_TYPE")
	    private String tnxType;

	    @Column(name = "SALE_DATE")
	    private LocalDate saleDate; // Use LocalDateTime if the Oracle column includes time

	    @Column(name = "S_TOT_SALE_AMT")
	    private BigDecimal totalAmt;

	    @Column(name = "S_TOT_OFFER_SALE_AMT")
	    private BigDecimal finalOfferAmt;

	    @Column(name = "P_AVAILABILITY")
	    private Integer pAvailability; // rename to reflect meaning; int if it’s NUMBER(10)

	    @Column(name = "P_PRICE")
	    private BigDecimal actualPrice;

	    @Column(name = "P_OFFER")
	    private BigDecimal offer;
	
}
