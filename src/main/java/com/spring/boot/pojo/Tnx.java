package com.spring.boot.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonTypeName(value = "Tnx")
public class Tnx {
	
	@JsonProperty("tnxId")
	private int tnxId;
	@JsonProperty("tnx1Val")
	private String tnx1Val;
	@JsonProperty("tnx2Val")
	private String tnx2Val;
	
	public Tnx() {
		super();
	}

	public Tnx(int tnxId, String tnx1Val, String tnx2Val) {
		super();
		this.tnxId = tnxId;
		this.tnx1Val = tnx1Val;
		this.tnx2Val = tnx2Val;
	}

	@Override
	public String toString() {
		return "Tnx [tnxId=" + tnxId + ", tnx1Val=" + tnx1Val + ", tnx2Val=" + tnx2Val + "]";
	}
	
	
	
	
}
