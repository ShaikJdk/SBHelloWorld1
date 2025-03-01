package com.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dbmodel.Users;
import com.spring.boot.service.UserAuthenticateService;
import com.spring.boot.service.UsersService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SBSecurityController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private UserAuthenticateService userAuthenticateService;
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrf(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf"); 
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<Users> registerUser(@RequestBody Users user) {
		Users savedUser = usersService.registerUser(user);
		return new ResponseEntity<Users>(savedUser, HttpStatus.OK); 
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Users user) {
		String savedUser = userAuthenticateService.verifyUser(user);
		return new ResponseEntity<String>(savedUser, HttpStatus.OK); 
	}
}
