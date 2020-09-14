package com.skilldistillery.jetsproject;

import java.util.Scanner;

public class JetsApplication {

	private AirField airfield;
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.launch();
	}

	public JetsApplication() {
	}

	private void launch() {
		airfield = new AirField();
		boolean run = true;
		while (run) {
			run = displayUserMenu(run);
		}
		System.out.println("Good byyyeeeeee");
	}

	private boolean displayUserMenu(boolean run) {
		System.out.println("Make a selection.");
		System.out.println("1: List Fleet");
		System.out.println("2: Fly All Jets");
		System.out.println("3: Fly A Jet");
		System.out.println("4: View Fastest Jet");
		System.out.println("5: View Jet With Longest Range");
		System.out.println("6: Load All Cargo Jets");
		System.out.println("7: Dogfight!");
		System.out.println("8: Add A Jet");
		System.out.println("9: Remove A Jet");
		System.out.println("10: Quit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			airfield.listJets();
			break;
		case 2:
			airfield.flyJets();
			break;
		case 3:
			airfield.flyAJet(scanner);
			break;
		case 4:
			airfield.fastestJet();
			break;
		case 5:
			airfield.longestRange();
			break;
		case 6:
			airfield.loadAllCargo();
			break;
		case 7:
			airfield.fight();
			break;
		case 8:
			airfield.addJet(scanner);
			break;
		case 9:
			airfield.removeJet(scanner);
			break;
		case 10:
			run = false;
			break;
		default:
			System.out.println("That was not a valid option");
		}
		return run;
	}

}
