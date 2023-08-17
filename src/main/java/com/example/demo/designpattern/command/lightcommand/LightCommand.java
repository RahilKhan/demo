/**
 * 
 */
package com.example.demo.designpattern.command.lightcommand;

import com.example.demo.designpattern.command.Command;
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

	@Override
	public void unExecute(){light.off();}

}
