package com.spring.boot.oracle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.pojo.oracle.CompanyRequestO;
import com.spring.boot.pojo.oracle.CompanyResponseO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/oracle/company")
@Slf4j
public class CompanyContractControllerO {

    @PostMapping("/create")
    public ResponseEntity<CompanyResponseO> createCompany(
            @RequestHeader("X-API-KEY") String apiKey,
            @Valid @RequestBody CompanyRequestO request
    ) {
    	log.info(request.getName());
    	CompanyResponseO response = new CompanyResponseO();
        response.setMessage("Employee " + request.getName() + " created");
        response.setStatus("SUCCESS");
        return ResponseEntity.ok(response);
    }
}
