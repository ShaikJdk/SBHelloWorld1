package com.spring.boot.dbmodel.mysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "TNX1")
public class Tnx1 {

	@Column(name = "TNX_ID")
    @Id
	private int tnxId;
	
	@Column(name = "TNX_VAL", nullable = false)
	private int tnxVal;
	
	public Tnx1() {
		super();
	}

	public Tnx1(int tnxId, int tnxVal) {
		super();
		this.tnxId = tnxId;
		this.tnxVal = tnxVal;
	}
	
	
}
