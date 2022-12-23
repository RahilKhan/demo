package com.example.demo.designpattern.solid;

public class LiskovSubstitution {
	public static void main(String... args) {

		Vehicle vehicle = new SUV(new PetrolEngine());
		vehicle.turnOnEngine();
		vehicle.accelerate();

		SUV suv = new SUV(new PetrolEngine());
		suv.stopSUV();

		/* This substitution breaks Liskov Substitution principle */
		Vehicle elexVehicle = new ElectricCar();
		elexVehicle.turnOnEngine();
		elexVehicle.accelerate();
	}
}
