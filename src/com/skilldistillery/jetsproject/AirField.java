package com.skilldistillery.jetsproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AirField {

	private ArrayList<Jet> jets = new ArrayList<Jet>();

	public AirField() {

	}

	public void addJet() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.text"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] fields = line.split(",");
				Jet jet = new CargoPlane(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]),
						Long.parseLong(fields[4]));
				jets.add(jet);
			}

		} catch (IOException e) {
			System.err.println(e);
		}

	}
	
	public void removeJet() {
		jets.remove(jets.size()-1);
	}
	
	public void listJets() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}
}
