/**
 * 
 */
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Rahil_Khan
 *
 */
public class UserService {

	@Autowired
	 private GreetingService greetingService;
	    
	    public UserService(GreetingService greetingService) {
	        this.greetingService = greetingService;
	    }

	    public String getUserName(String id) {
	        String name = greetingService.getUserName(id);
	        System.out.println("\t name : " + name);
	        return name;
	    }
}
