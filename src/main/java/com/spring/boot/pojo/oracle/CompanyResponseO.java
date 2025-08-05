package com.spring.boot.pojo.oracle;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CompanyResponseO {

	public CompanyResponseO(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public CompanyResponseO() {
		super();
	}
	private String message;
    private String status;

    
}
