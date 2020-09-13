package com.skilldistillery.jetsproject;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(getModel() + " is being loaded...");
		System.out.println("Uh...yeah everything was loaded. But it was uh... Bob who finished. I only did the first part.");
	}

	

}
