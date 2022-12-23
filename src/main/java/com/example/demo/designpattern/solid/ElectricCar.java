/**
 * 
 */
package com.example.demo.designpattern.solid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rahil_Khan
 *
 */
public class ElectricCar implements Vehicle{

	private final Logger log = LoggerFactory.getLogger(ElectricCar.class);
	
	@Override
	public void turnOnEngine() {
		log.info("Electric car does not have engine");
		throw new AssertionError("I don't have an engine!");
	}

	@Override
	public void accelerate() {
		log.info("Electric car accelarate on highway");
	}

}
