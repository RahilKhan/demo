package com.example.demo.designpattern.solid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rahil_Khan
 *
 */
public class SUV implements Vehicle {

	private final Logger LOG = LoggerFactory.getLogger(SUV.class);

	private Engine engine;

	public SUV(Engine engine) {
		this.engine = engine;
	}

	@Override
	public void turnOnEngine() {
		engine.on();
	}

	@Override
	public void accelerate() {
		engine.accelarate();
	}

	public void stopSUV() {
		LOG.info("SUV applied break");
	}
}
