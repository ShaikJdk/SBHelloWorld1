package com.spring.boot.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dbmodel.oracle.OrdersO;
import com.spring.boot.dbmodel.oracle.VersionO;
import com.spring.boot.pojo.PurchaseDetails;
import com.spring.boot.service.oracle.DeptServiceO;
import com.spring.boot.service.oracle.EmployeeServiceO;
import com.spring.boot.service.oracle.OrderServiceO;
import com.spring.boot.service.oracle.PurchaseServiceO;
import com.spring.boot.service.oracle.VersionServiceO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/oracle")
public class OracleControllerO {
	
	@Autowired
	private OrderServiceO orderServiceO;
	
	@Autowired
	private DeptServiceO deptServiceO;
	
	@Autowired
	private PurchaseServiceO purchaseServiceO;
	
	@Autowired
	private EmployeeServiceO employeeServiceO;
	
	@Autowired
	private VersionServiceO versionServiceO; 
	
	@GetMapping(value = "/getAllOrdersO", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>> getAllOrder() {
		
		log.info("getAllOrder - Start");
		List<com.spring.boot.dbmodel.oracle.OrdersO> orders = null;
		try {
			orders = orderServiceO.getAllOrders();
			System.out.println(orders);
		} catch (Exception e) {
			log.error("getAllOrder - Exception " + e.getMessage());
			return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>>(HttpStatus.EXPECTATION_FAILED);
		}
		log.info("getAllOrder - end");
		return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>>(orders, HttpStatus.OK);
	}
	
	@PostMapping(value = "/createOrderO", headers = "Accept=application/json")
	public ResponseEntity<com.spring.boot.dbmodel.oracle.OrdersO> createOrder(
			@RequestBody OrdersO req) {
		
		log.info("getAllOrder - Start");
		com.spring.boot.dbmodel.oracle.OrdersO order = null;
		try {
			order = orderServiceO.createOrder(req);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getAllOrder - Exception " + e.getMessage());
			return new ResponseEntity<com.spring.boot.dbmodel.oracle.OrdersO>(HttpStatus.EXPECTATION_FAILED);
		}
		log.info("getAllOrder - end");
		return new ResponseEntity<com.spring.boot.dbmodel.oracle.OrdersO>(order, HttpStatus.OK);
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
	
	@GetMapping(value = "/getPurchaseProductDetails", headers = "Accept=application/json")
	public ResponseEntity<com.spring.boot.pojo.PurchaseDetails> getPurchaseProductDetails(
			@RequestParam String prodType, @RequestParam int qunatity) {

		PurchaseDetails purchaseDetails = null;
		try {
			purchaseDetails = purchaseServiceO.getPurchesDetails(prodType,qunatity);
		} catch (Exception e) {
			return new ResponseEntity<com.spring.boot.pojo.PurchaseDetails>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<com.spring.boot.pojo.PurchaseDetails>(purchaseDetails, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOrdersByType/{orderType}", headers = "Accept=application/json")
	public ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>> getOrdersByType(
			@PathVariable("orderType") String orderType){
		List<com.spring.boot.dbmodel.oracle.OrdersO> orders = null;
		try {
			orders = orderServiceO.getOrdersByType(orderType);
//			orders = orderServiceO.getOrdersByTypeByAnnotations(orderType);		// plsql function cant be called by @NamedStoredProcedureQuery
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<com.spring.boot.dbmodel.oracle.OrdersO>>(orders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getPurchaseDetailsO", headers = "Accept=application/json")
	public ResponseEntity<com.spring.boot.dbmodel.oracle.PurchaseDetails> getPurchaseDetailsO(
			@RequestParam String tnxId, @RequestParam String tnxType){
		com.spring.boot.dbmodel.oracle.PurchaseDetails purchaseDetails = null;
		try {
			purchaseDetails = purchaseServiceO.getPurchaseDetailsO(tnxId, tnxType);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<com.spring.boot.dbmodel.oracle.PurchaseDetails>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<com.spring.boot.dbmodel.oracle.PurchaseDetails>(purchaseDetails, HttpStatus.OK);
	}
	
	@PostMapping(value = "/putVersion", headers = "Accept=application/json")
	public ResponseEntity<VersionO> putVersion(
			@RequestBody VersionO req){
		VersionO v = null;
		try {
			v = versionServiceO.putVersion(req);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<VersionO>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<VersionO>(v, HttpStatus.OK);
	}
	
	@GetMapping(value = "/updateVersion")
	public ResponseEntity<VersionO> updateVersion(
			@RequestParam String vid, @RequestParam String vname){
		VersionO v = null;
		try {
			v =versionServiceO.updateVersion(vid, vname);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<VersionO>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<VersionO>(v, HttpStatus.OK);
	}
	
}
