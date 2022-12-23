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
public class PetrolEngine implements Engine {
	private final Logger log = LoggerFactory.getLogger(Engine.class);

	@Override
	public void on() {
		log.info("SUV turned on");
	}
	
	@Override
	public void accelarate() {
		log.info("SUV accelates on Highway");
	}
}
