package com.spring.boot.pojo.oracle;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressO {
	
	
	 	public AddressO() {
		super();
	}

		public AddressO(@NotBlank String city, @NotBlank String state, @NotBlank String zip) {
		super();
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

		@NotBlank
	    private String city;

	    @NotBlank
	    private String state;

	    @NotBlank
	    private String zip;
}
