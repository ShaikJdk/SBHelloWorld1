package com.spring.boot.designpattern.factorybuild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class SMSNotificationFactory implements NotificationFactory {
	 @Autowired
	 private SMSNotification smsNotification;
	 
    @Override
    public Notification createNotification() {
        return smsNotification;
    }
    
    @Override
	public String getType() {
		return "SMS";
	}
}
