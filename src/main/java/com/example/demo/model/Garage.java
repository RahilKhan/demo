/**
 * 
 */
package com.example.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rahil_Khan
 *
 */
public class Garage {

	private final Logger logger = LoggerFactory.getLogger(Garage.class);

	public void openDoor() {
		logger.info("Garage door opened");
	}
}
