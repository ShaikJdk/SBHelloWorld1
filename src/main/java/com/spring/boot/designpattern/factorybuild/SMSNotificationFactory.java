package com.spring.boot.designpattern.factorybuild;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class FaxNotificationFactory implements NotificationFactory {
	 
	 @Autowired
	 private FaxNotification faxNotification;

	 @Override
    public Notification createNotification() {
        return faxNotification;
    }
	 
	 @Override
		public String getType() {
			return "FAX";
		}
}
