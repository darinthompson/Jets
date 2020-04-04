package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private AirField af = new AirField();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {	
		JetsApplication app = new JetsApplication();
		while(true) {
			app.launch();
			System.out.print("== choice: ");
			int userChoice = sc.nextInt();
			switch(userChoice) {
			case 1:
				System.out.println();
				app.ListFleet();
				System.out.println();
				break;
			case 2:
				System.out.println();
				app.FlyJets();
				System.out.println();
				break;
			case 3:
				System.out.println();
				System.out.println("------- THE FASTEST JET --------");
				System.out.println();
				app.GetFastestJet().fly();
				System.out.println();
				break;
			case 4:
				System.out.println();
				System.out.println("------- LONGEST RANGE ----------");
				System.out.println();
				app.GetLongestFlyingJet().fly();
				System.out.println();
				break;
			default :
				System.out.println("Invalid Option");
			}
		}
		
	}

	public void launch() {
		PrintMenu();
	}
	
	public void PrintMenu() {
		
		System.out.println("===========================================");
		System.out.println("==      1. List Fleet                    ==");
		System.out.println("==      2. Fly All Jets                  ==");
		System.out.println("==      3. View Fastest Plane            ==");
		System.out.println("==      4. View Jet With Longest Range   ==");
		System.out.println("==      5. Load All Cargo Jets           ==");
		System.out.println("==      6. DOGFIGHT!                     ==");
		System.out.println("==      7. Add a Jet to Fleet            ==");
		System.out.println("==      8. Remove a Jet From Fleet       ==");
		System.out.println("==      9. Quit                          ==");
		System.out.println("===========================================");
	}
	
	public void ListFleet() {
		for (Jet jet : af.getList()) {
			System.out.println(jet.toString());
			System.out.println("-----------------");
		}
	}
	
	public void FlyJets() {
		for (Jet jet : af.getList()) {
			jet.fly();
			System.out.println("-----------------");
		}
	}
	
	public Jet GetFastestJet() {
		Jet fastestJet = null;
		double fastestSpeed = 0;
		for(int i = 0; i < af.getList().size() - 1; i++) {
			double jetSpeed = af.getJet(i).getSpeed();
			if( jetSpeed > fastestSpeed) {
				fastestSpeed = jetSpeed;
				fastestJet = af.getJet(i);
			}
		}
		return fastestJet;
	}
	
	public Jet GetLongestFlyingJet() {
		Jet LongestJet = null;
		double LongestDistance = 0;
		for (int i = 0; i < af.getList().size(); i++) {
			double distance = af.getJet(i).getRange();
			if(distance > LongestDistance) {
				LongestDistance = distance;
				LongestJet = af.getJet(i);
			}
		}
		return LongestJet;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
