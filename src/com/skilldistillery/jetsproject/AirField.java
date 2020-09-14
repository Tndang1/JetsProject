package com.skilldistillery.jetsproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> jets  = new ArrayList<Jet>();
	String line;
	private boolean firstRun = true;

	public AirField() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.text"))) {
			Jet jet;
			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields[0].contentEquals("CargoPlane")) {
					jet = new CargoPlane(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
							Long.parseLong(fields[4]));
				} else if (fields[0].contentEquals("PaperPlane")) {
					jet = new PaperPlane(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
							Long.parseLong(fields[4]));
				} else {
					jet = new JetsImpl(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
							Long.parseLong(fields[4]));
				}
				jets.add(jet);	
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public void fastestJet() {
		Jet faster = null;
		double speed = 0;
		for (Jet jet : jets) {
			if (jet.getSpeed() > speed) {
			speed = jet.getSpeed();
			faster = jet;
			}
		}
		System.out.println("Plane ID " + (jets.indexOf(faster) + 1) + ": " + faster);
		
	}
	
	public void longestRange() {
		Jet longRange = null;
		int range = 0;
		for (Jet jet : jets) {
			if (jet.getRange() > range) {
			range = jet.getRange();
			longRange = jet;
			}
		}
		System.out.println("Plane ID " + (jets.indexOf(longRange) + 1) + ": " + longRange);
		
	}

	public void addJet(Scanner kb) {
		Jet add = null;
		System.out.println("What type of jet is this? 1: Jet, 2: Cargo, or 3: Paper?");
		int type = kb.nextInt();
		System.out.println("What is the model?");
		String model = kb.next();
		System.out.println("How fast is it?");
		double speed = kb.nextDouble();
		System.out.println("How far can it fly?");
		int range = kb.nextInt();
		System.out.println("How much did it cost?");
		long price = kb.nextLong();
		switch (type) {
		case 1:
			add = new JetsImpl(model, speed, range, price);
			break;
		case 2:
			add = new CargoPlane(model, speed, range, price);
			break;
		case 3:
			add = new PaperPlane(model, speed, range, price);
			((PaperPlane) add).foldPlane();
			break;
		}
		jets.add(add);
	}
	
	public void removeJet(Scanner kb) {
		listJets();
		System.out.println("Please enter the number of the plane you would like to remove:");
		jets.remove(kb.nextInt() - 1);
	}
	
	public void listJets() {
		for (Jet jet : jets) {
			if(jet instanceof PaperPlane && firstRun == true) {
				((PaperPlane) jet).foldPlane();
			}
			System.out.println("Plane ID " + (jets.indexOf(jet) + 1) + ": " + jet);
		}
		firstRun = false;
	}
	
	public void flyJets() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}
	
	public void loadAllCargo() {
		for (Jet jet : jets) {
			if(jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}
	
	public void  fight() {
		System.out.println("A harrier is taking off from a carrier!");
		int chance = (int)(Math.random() * 10);
		if (chance % 3 == 0 || jets.size() == 0) {
			System.out.println("Uh-oh, somebody forgot to get all the cleaning media off of the flight deck!");
			System.out.println("The harrier engines were destroyed before it could lift-off! Somebody is going to have a baaaad day.");
		} else {
			System.out.println("The harrier took off, and is hunting down a plane!");
			int victim = (int)(Math.random() * jets.size());
			System.out.println(jets.get(victim) + " is being attacked!");
			System.out.println(jets.get(victim) + " is going down!");
			jets.remove(victim);
		}
		
	}
}
