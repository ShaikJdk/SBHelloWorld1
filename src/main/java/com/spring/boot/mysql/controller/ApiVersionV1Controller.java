package com.spring.boot.mysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql/v1")
public class ApiVersionV1Controller {

	@GetMapping("/orders")
	String getOrders() {
		
		return "getOrdersV1";
	}
	
}
