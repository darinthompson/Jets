package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet;

	public AirField() {
		fleet = new ArrayList<>();
		run();
	}

	public void addJet(Jet jet) {
		fleet.add(jet);
	}

	public List<Jet> getList() {
		return fleet;
	}

	public void run() {
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("Jets.txt"));
			String line;
			while ((line = bufIn.readLine()) != null) { // reads all the lines in the text
			String[] jetInfo = line.split(",");
				String type = jetInfo[0];
				int speed = (Integer.parseInt(jetInfo[1].trim()));
				int range = (Integer.parseInt(jetInfo[2].trim()));
				String price = jetInfo[3];
				Jet jet = new JetImpl(type, speed, range, price);
				addJet(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (bufIn != null) {
				try {
					bufIn.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}

}
