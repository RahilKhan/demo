/**
 * 
 */
package com.example.demo.designpattern.command;

import com.example.demo.model.Light;

/**
 * @author Rahil_Khan
 *
 */
public class LightCommand implements Command {

	Light light;
	
	public LightCommand(Light light){
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
	}

}
