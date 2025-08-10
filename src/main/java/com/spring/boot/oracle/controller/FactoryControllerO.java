package com.spring.boot.oracle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.designpattern.factorybuild.NotificationFactoryProvider;

@RestController
@RequestMapping("/notify")
public class FactoryControllerO {
	
	@Autowired
	private NotificationFactoryProvider notificationFactoryProvider;

    @GetMapping
    public ResponseEntity<String> sendNotification(@RequestParam String type, @RequestParam String message) {
    	com.spring.boot.designpattern.factorybuild.Notification notification =
    			notificationFactoryProvider.getFactory(type).createNotification();
        
        notification.notifyUser(message);
        return ResponseEntity.ok("Notification sent via: " + type.toUpperCase());
    }
}