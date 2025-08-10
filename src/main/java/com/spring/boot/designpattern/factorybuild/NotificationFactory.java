package com.spring.boot.designpattern.factorybuild;

public interface NotificationFactory {
	Notification createNotification();
	String getType();
}