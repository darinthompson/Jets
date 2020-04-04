package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private AirField af = new AirField();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
		while(true) {
			app.run();
			System.out.print("== choice: ");
			int userChoice = sc.nextInt();
			switch(userChoice) {
			case 2:
				System.out.println();
				app.FlyJets();
				System.out.println();
				break;
			default :
				System.out.println("Invalid Option");
			}
		}
		
	}

	public void run() {
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
	
	public void FlyJets() {
		for (Jet jet : af.getList()) {
			jet.fly();
			System.out.println("-----------------");
		}
	}
}
