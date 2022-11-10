package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	public String greet() {
		return "Hello, World";
	}

	public String getUserName(String id) {
		System.out.println("\t id : " + id);
		return "Real user name";
	}
}
