package com.spring.boot.aop.exception.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.spring.boot.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = {"com.spring.boot.controller"})
public class ExceptionAdviceController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest req){
		log.error(e.getMessage());
		HashMap<String, Object> pathVal = (HashMap) req.getAttribute("org.springframework.web.servlet.View.pathVariables",0);
		return new ResponseEntity<Object>(e.getMessage() + " " + (null != pathVal ? pathVal.get("orderId") : "")  , HttpStatus.BAD_REQUEST);
	}
}
