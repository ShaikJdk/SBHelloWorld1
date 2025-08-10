package com.spring.boot.designpattern.factorybuild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
 class EmailNotificationFactory implements NotificationFactory {
	 
	 @Autowired
	 private EmailNotification emailNotification;
    @Override
    public Notification createNotification() {
        return emailNotification;
    }
	@Override
	public String getType() {
		return "EMAIL";
	}
    
}
