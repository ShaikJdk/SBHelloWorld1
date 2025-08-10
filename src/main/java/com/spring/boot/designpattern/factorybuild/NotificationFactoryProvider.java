package com.spring.boot.designpattern.factorybuild;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactoryProvider {
	
	
	 private  Map<String, NotificationFactory> factoryMap = new HashMap<>();
	 
	 @Autowired
	 public NotificationFactoryProvider(List<NotificationFactory> factories) {
		 
		 for (NotificationFactory factory : factories) {
	            factoryMap.put(factory.getType().toLowerCase(), factory);
	        }
	 }
	    public NotificationFactory getFactory(String type) {
	        NotificationFactory factory = factoryMap.get(type.toLowerCase());
	        if (factory == null) {
	            throw new IllegalArgumentException("No factory found for type: " + type);
	        }
	        return factory;
	    }    
}
