package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.exception.BusinessException;
import com.spring.boot.pojo.Tnx;
import com.spring.boot.service.mysql.tnx.Tnx1Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/mysql")
public class TnxMngController {

	@Autowired
	private Tnx1Service tnx1Service;

	@PostMapping(value = "/updateTnxs", headers = "Accept=application/json")
	public ResponseEntity<String> updateAllTnx(@RequestBody Tnx tnx) throws BusinessException{

		log.info("updateAllTnx - Start");
		try {
				tnx1Service.updateAllTnxs(tnx);
		} catch (Exception e) {
			log.error("updateAllTnx - Exception " +e.getMessage());
			throw new BusinessException(e.getMessage());
		}
		log.info("updateAllTnx - end");
		return new ResponseEntity<Void>(HttpStatus.OK)
				.ofNullable("updateAllTnx Successfully ....");
	}

}
