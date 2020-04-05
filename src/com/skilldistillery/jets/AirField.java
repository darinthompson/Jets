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

	public Jet getJet(int index) {
		return fleet.get(index);
	}

	public void run() {
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("Jets.txt"));
			String line;
			while ((line = bufIn.readLine()) != null) { // reads all the lines in the text
				Jet jet;
				String[] jetInfo = line.split(",");
				String model = jetInfo[0];
				int speed = (Integer.parseInt(jetInfo[1].trim()));
				int range = (Integer.parseInt(jetInfo[2].trim()));
				String type = jetInfo[4].trim();
				long price = (Long.parseLong(jetInfo[3].trim()));
				if (type.equals("Air to Ground Combat")) {
					jet = new AirToGroundCombat(model, speed, range, price, type);
				} else if (type.equals("Air Superiority Fighter")) {
					jet = new FighterJet(model, speed, range, price, type);
				} else if (type.equals("Surveillance")) {
					jet = new SurveillancePlane(model, speed, range, price, type);
				} else if (type.equals("Cargo")) {
					jet = new CargoJet(model, speed, range, price, type);
				} else {
					jet = new JetImpl(model, speed, range, price, type);
				}
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
