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
@Table(name = "DEPT")
public class DeptO {

	public DeptO() {
	}
	public DeptO(String dId, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	@Id
	@Column(name = "DID", nullable = false)
	private String did;
	
	@Column(name = "DNAME")
	private String dname;
	
}
