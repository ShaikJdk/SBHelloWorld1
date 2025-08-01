package com.spring.boot.dbmodel.oracle;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "DUMMY")
public class DummyEntity {

	public DummyEntity() {
	}
	public DummyEntity(String did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "DID", updatable = false, nullable = false)
	private String did;
	
	@Column(name = "DNAME")
	private String dname;
	
}
