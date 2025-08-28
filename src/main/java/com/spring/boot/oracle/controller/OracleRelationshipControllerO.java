package com.spring.boot.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dbmodel.oracle.relationship.EmployeeO;
import com.spring.boot.service.oracle.EmployeeServiceO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/oracle")
public class OracleRelationshipControllerO {
	
	@Autowired
	private EmployeeServiceO employeeServiceO; 
	
	@PostMapping(value = "/saveEmployeeO", headers = "Accept=application/json")
	public ResponseEntity<EmployeeO> getEmployeeO(
			@RequestBody EmployeeO emp){
		EmployeeO empRes = null;
		try {
			empRes = employeeServiceO.saveEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<EmployeeO>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<EmployeeO>(empRes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmployeeO", 
	        produces = MediaType.APPLICATION_JSON_VALUE  )
	public ResponseEntity<EmployeeO> getEmployeeO(
			@RequestParam Integer empId){
		EmployeeO empRes = null;
		try {
			empRes = employeeServiceO.getEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<EmployeeO>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<EmployeeO>(empRes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getEmployeesO", headers = "Accept=application/json")
	public ResponseEntity<List<EmployeeO>> getEmployeesO() {
		List<EmployeeO> empRes = null;
		try {
			empRes = employeeServiceO.getEmployees();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<EmployeeO>>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<List<EmployeeO>>(empRes, HttpStatus.OK);
	}
	
}
