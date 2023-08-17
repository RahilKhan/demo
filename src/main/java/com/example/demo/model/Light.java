package com.example.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rahil_Khan
 *
 */
public class Light {
	private final Logger logger = LoggerFactory.getLogger(Light.class);

	public void on() {
		logger.info("Light is switched on");
	}

	public void off() {
		logger.info("Light is switched off");
	}

}
