package com.spring.boot.designpattern.factorybuild;

import org.springframework.stereotype.Component;


@Component
public class FaxNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Sending Fax: " + message);
    }
}