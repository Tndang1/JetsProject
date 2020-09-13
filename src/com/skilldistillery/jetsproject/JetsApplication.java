package com.skilldistillery.jetsproject;

import java.util.Scanner;

public class JetsApplication {
	
	private AirField airfield;
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.launch();
	}
	
	public JetsApplication () {
	}
	
	
	private void launch() {
		airfield = new AirField();
		boolean run = true;
		while (run) {
		displayUserMenu(run);
		}
		System.out.println("Good byyyeeeeee");
	}
	
	private boolean displayUserMenu(boolean run) {
		System.out.println("Make a selection.");
		System.out.println("1: List Fleet\n2: Fly All Jets\n3: View Fastest Jet"
				+ "\n4: View Jet With Longest Range\n5: Load All Cargo Jets\n6: Dogfight!\n7: "
				+ "Add A Jet To The Fleet\n8: Remove A Jet\n9: Quit");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:
//		List fleet
			airfield.listJets();
		break;
		case 2:
//		Fly all jets
			break;
		case 3:
//		View fastest jet
			break;
		case 4:
//		View jet with longest range
			break;
		case 5:
//		Load all Cargo Jets
			break;
		case 6:
//		Dogfight!
			break;
		case 7:
//		Add a jet to Fleet
		airfield.addJet();
		break;
		case 8:
//		Remove a jet from Fleet
		airfield.removeJet();
		break;
		case 9:
//		Quit
		run = false;
		default:
			System.out.println("That was not a valid option");
		}
		return run;
	}

}

