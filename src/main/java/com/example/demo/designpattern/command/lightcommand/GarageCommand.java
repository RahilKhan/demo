package com.example.demo.designpattern.command;

import com.example.demo.model.Garage;

/**
 * @author Rahil_Khan
 *
 */
public class GarageCommand implements Command {

	Garage garage;

	public GarageCommand(Garage garage) {
		this.garage = garage;
	}

	@Override
	public void execute() {
		garage.openDoor();
	}
}
