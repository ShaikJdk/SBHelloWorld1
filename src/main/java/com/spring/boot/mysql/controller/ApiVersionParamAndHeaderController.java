package com.spring.boot.mysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql/ParamAndHeader")
public class ApiVersionParamAndHeaderController {

	@RequestMapping(params = "version=1")
	String getOrdersV1() {
		return "version=1";
	}
	
	@RequestMapping(params = "version=2")
	String getOrdersV2() {
		return "version=2";
	}
	
	@RequestMapping(headers = "X-API-VERSION=1")
	String getOrdersHV1() {
		return "getOrders from X-API-VERSION=1";
	}
	
	@RequestMapping(headers = "X-API-VERSION=2")
	String getOrdersHV2() {
		return "getOrders from X-API-VERSION=2";
	}
	
}
