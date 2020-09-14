package com.skilldistillery.jetsproject;

public class FighterPlane extends Jet implements TakeoffAttempt {

	public FighterPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public boolean takeoff() {
		boolean success = false;
		int chance = (int) (Math.random()*10);
		if (chance % 3 != 0) {
			success = true;
		}
		return success;
	}
}
