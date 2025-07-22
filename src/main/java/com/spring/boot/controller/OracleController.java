package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.service.oracle.DeptServiceO;
import com.spring.boot.service.oracle.OrderServiceO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/oracle")
public class OracleController {
	
	@Autowired
	private OrderServiceO orderServiceO;
	
	@Autowired
	private DeptServiceO deptServiceO;
	
	@GetMapping(value = "/getAllOrdersO", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>> getAllOrder() {

		
		log.info("getAllOrder - Start");
		List<com.spring.boot.dbmodel.oracle.OrdersO> orders = null;
		try {
			orders = orderServiceO.getAllOrders();
		} catch (Exception e) {
			log.error("getAllOrder - Exception " + e.getMessage());
			return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>>(HttpStatus.EXPECTATION_FAILED);
		}
		log.info("getAllOrder - end");
		return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllDeptsO", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.oracle.DeptO>> getAllDepts() {	
		log.info("getAllOrder - Start");
		List<com.spring.boot.dbmodel.oracle.DeptO> depts = null;
		try {
			depts = deptServiceO.getAllDepts();
		} catch (Exception e) {
			log.error("getAllOrder - Exception " + e.getMessage());
			return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.DeptO>>(HttpStatus.EXPECTATION_FAILED);
		}
		log.info("getAllOrder - end");
		return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.DeptO>>(depts, HttpStatus.OK);
	}
}
