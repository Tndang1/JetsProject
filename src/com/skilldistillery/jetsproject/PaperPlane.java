package com.skilldistillery.jetsproject;

public class PaperPlane extends Jet implements PaperPlaneFold {

	public PaperPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void foldPlane() {
		System.out.println("Paper plane has been folded!");
	}
}
