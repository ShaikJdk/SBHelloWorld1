package com.spring.boot.aop.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class SBHWLoggingAdvice {
	
	@Around("execution(* com.spring.boot.controller.*.*(..))")
	public Object measureHBExecutionTime(ProceedingJoinPoint joinPoint)throws Throwable {
		
		StopWatch watch = new StopWatch();
		watch.start();
		
		Object proceed = joinPoint.proceed();
		
		watch.stop();
		
		log.info("Time taken to execute : " + watch.getLastTaskTimeMillis() + "ms");
		return proceed;
	}
}
