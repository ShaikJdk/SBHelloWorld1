package com.spring.boot.aop.journaling;

import java.util.List;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.dbmodel.mysql.Journaling;
import com.spring.boot.exception.BusinessException;
import com.spring.boot.repository.mysql.JournalingRepository;
import com.spring.boot.repository.mysql.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Aspect
public class HBJournlingAdvice {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	JournalingRepository journalingRepository;

	@Around("execution(* com.spring.boot.controller.HBController.postOrder(..))")
	public Object journalPostOrder(ProceedingJoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();
		com.spring.boot.pojo.Order orderBefore = (com.spring.boot.pojo.Order) args[0];
		
		ObjectMapper mapper = new ObjectMapper();
		String journalId = UUID.randomUUID().toString();
		String journalData = mapper.writeValueAsString(orderBefore);
		Journaling journalingBefore = new Journaling(journalId, journalData);
		journalingRepository.save(journalingBefore);
		
		Object proceed = joinPoint.proceed();

		com.spring.boot.dbmodel.mysql.OrdersM orderAfter = orderRepository.findByOrderId((Integer) orderBefore.getOrderId());
		Journaling journalingAfter = new Journaling(UUID.randomUUID().toString(),
				mapper.writeValueAsString(orderAfter));
		journalingRepository.save(journalingAfter);
		
		return proceed;
	}
	
	@Before("execution(* com.spring.boot.controller.HBController.deleteOrder(..))")
	public void journaDeleteOrder(JoinPoint joinPoint) throws Throwable {

		Object[] args = joinPoint.getArgs();
		int orderId = (int) args[0];
	
		String journalId = UUID.randomUUID().toString();
		String journalData = "Order Id is to be deleted " + orderId;
		Journaling journalingBefore = new Journaling(journalId, journalData);
		journalingRepository.save(journalingBefore);
		
	}
	
	@AfterThrowing(value="execution(* com.spring.boot.controller.HBController.deleteOrder(..))", throwing = "exec")
	public void journaDeleteOrder(JoinPoint joinPoint, final BusinessException exec) throws Throwable {
		String journalId = UUID.randomUUID().toString();
		Journaling journalingData= new Journaling(journalId, exec.getMessage());
		journalingRepository.save(journalingData);
		
	}
	
	@AfterReturning(pointcut = "execution(* com.spring.boot.controller.HBController.getAllOrder(..))", returning="response")
	public void journaGetAllOrder(JoinPoint joinPoint, ResponseEntity<List<com.spring.boot.dbmodel.mysql.OrdersM>> response) throws Throwable {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String journalId = UUID.randomUUID().toString();
		String journalData = mapper.writeValueAsString(response.getBody());
		Journaling journalingBefore = new Journaling(journalId, journalData);
		journalingRepository.save(journalingBefore);
		
	}

}
