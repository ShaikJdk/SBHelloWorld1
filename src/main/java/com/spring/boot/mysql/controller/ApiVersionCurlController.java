package com.spring.boot.mysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mysql/curl")
public class ApiVersionCurlController {

	@RequestMapping(produces = "application/vnd.order.app-v1+json")
	String getOrdersV1() {
		return "version=1";
	}
	
	@RequestMapping(produces = "application/vnd.order.app-v2+json")
	String getOrdersV2() {
		return "version=2";
	}

//	curl -X GET http://localhost:2004/springboot/mysql/getAllOrder \ -H "Content-Type: application/json" \ -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdWJidSIsImlhdCI6MTc1NDIxNjYyMCwiZXhwIjoxNzU0MjE3MDUyfQ.9Qoe2nOyeWCqO7Jc8x31dLt0nQ0dJREwo5FtXNB9Bp0"

//	curl (short for Client URL) is a command-line tool used to make HTTP requests. 
//	In real-time or real-world development, it’s used for testing, automation, 
//	and debugging APIs and web services — especially REST APIs.
// Developers use curl to test endpoints without needing a browser or Postman.

	
//	1. Testing REST APIs (during development)	
//	curl -X GET http://localhost:8080/api/employee
// so that developers can do Quickly testing a GET or POST API during Spring Boot development.


//  2. Sending JSON payload in POST requests	 ( Simulate frontend requests or test request body parsing.)
// curl -X POST http://localhost:8080/api/employee \
//    -H "Content-Type: application/json" \
//    -d '{"name":"John","role":"Developer"}'
	
// 3.  Using Authorization Headers (JWT, Basic Auth, etc.)
//	curl -H "Authorization: Bearer <JWT_TOKEN>" http://localhost:8080/api/secure
	
// 4.  Testing API Versioning via Accept Header (Validate version-specific responses (as in your versioning example).)
//	curl -H "Accept: application/vnd.company.app-v2+json" http://localhost:8080/api/employee
	
	
//	5. Automating API Tests in Shell Scripts (Continuous integration (CI) and health-check automation.)
//	You can put multiple curl commands in .sh scripts to automate test cases or deployments.
	
//	#!/bin/bash
//	curl -X GET http://localhost:8080/health
//	curl -X GET http://localhost:8080/api/data
	

//6. Uploading files	(Testing file upload APIs without a frontend.)
//	curl -F "file=@/path/to/file.jpg" http://localhost:8080/upload
	
//7. Interacting with Cloud/Web Services (Accessing or automating GitHub, AWS, or any RESTful third-party service.)
//curl -u username:password https://api.github.com/user/repos
	
//8.	Debugging SSL Issues
//
//	curl -v https://your-https-api.com
//	Use Case: Check SSL/TLS certificates, response headers, etc.	
}
