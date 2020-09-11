package com.skilldistillery.jetsproject;

public abstract class Jet {
	private String model;
	private double speed;
	private double range;
	private double price;
	
	public Jet(String model, double speed, double range, double price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	
	public Jet() {
	}
	
	public void fly() {
		System.out.println(toString());
		System.out.println(flightTime());
	}
	
	public String flightTime() {
		double flightTime = range/speed;
		return "Flight time=" + flightTime + " hours.";
	}
	
	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
