package com.spring.boot.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dbmodel.oracle.compositekey.OrderCompositeKeyEntitiyO;
import com.spring.boot.service.oracle.CompositeKeyServiceO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/oracle")
public class OracleCompositeKeyControllerO {
	
	@Autowired
	private CompositeKeyServiceO serviceO; 
	
	@PostMapping(value = "/saveCompositeKeyOrder", headers = "Accept=application/json")
	public ResponseEntity<OrderCompositeKeyEntitiyO> getEmployeeO(
			@RequestBody OrderCompositeKeyEntitiyO order){
		OrderCompositeKeyEntitiyO ordRes = null;
		try {
			ordRes = serviceO.saveOrder(order);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<OrderCompositeKeyEntitiyO>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<OrderCompositeKeyEntitiyO>(ordRes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getCompositeKeyOrderById", headers = "Accept=application/json")
	public ResponseEntity<OrderCompositeKeyEntitiyO> getCompositeKeyOrderById(
			@RequestParam Integer oid, @RequestParam String oname){
		OrderCompositeKeyEntitiyO ordRes = null;
		try {
			ordRes = serviceO.findOrderById(oid, oname);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<OrderCompositeKeyEntitiyO>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<OrderCompositeKeyEntitiyO>(ordRes, HttpStatus.OK);
	}
	
}
