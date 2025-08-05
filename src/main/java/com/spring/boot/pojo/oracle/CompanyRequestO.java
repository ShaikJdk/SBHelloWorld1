package com.spring.boot.pojo.oracle;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CompanyRequestO {
	
	 @NotBlank(message = "Company Name is required")
	 @Size(max = 30, message = "Company Name must not exceed 30 characters")
	    private String name;

	    @Min(value = 18, message = "Company Age must be at least 18")
	    private int since;

	    @NotBlank(message = "what is  type of company, field is required")
	    private String ctype;

	    @Valid
	    @NotNull
	    private AddressO address;
}

