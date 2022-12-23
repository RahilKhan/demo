package com.example.demo.designpattern.command;

import com.example.demo.model.Garage;
import com.example.demo.model.Light;

/**
 * @author Rahil_Khan
 * Main class to test Command pattern
 */
public class RemoteControlClient {

	public static void main(String[] args) {
		Light light = new Light();
		LightCommand lightCmd = new LightCommand(light);
		SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
		simpleRemoteControl.setCommand(lightCmd);
		simpleRemoteControl.exectue();
		
		Garage garage = new Garage();
		GarageCommand garageCommand = new GarageCommand(garage);
		simpleRemoteControl.setCommand(garageCommand);
		simpleRemoteControl.exectue();
		
	}

}
