package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApplication {
	private AirField af = new AirField();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		while (true) {
			app.launch();
			int userChoice = app.ValidateInt("== Choice: ");
			switch (userChoice) {
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
			case 5:
				System.out.println();
				app.LoadAllCargoJets();
				System.out.println();
				break;
			case 6:
				System.out.println();
				app.Attack();
				System.out.println();
				break;
			case 7:
				System.out.println();
				app.Recon();
				System.out.println();
				break;
			case 8:
				System.out.println();
				app.AirStrike();
				System.out.println();
				break;
			case 9:
				System.out.println();
				app.addJet();
				System.out.println();
				break;
			case 10:
				System.out.println();
				app.DeleteJet();
				System.out.println();
				break;
			case 11:
				System.out.println("Thanks for checking out our jets!");
				System.exit(0);
			default:
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
		System.out.println("==      7. Reconnaissance                ==");
		System.out.println("==      8. AirStrike                     ==");
		System.out.println("==      9. Add a Jet to Fleet            ==");
		System.out.println("==      10. Remove a Jet From Fleet      ==");
		System.out.println("==      11. Quit                         ==");
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
	
	public void AirStrike() {
		for (Jet jet : af.getList()) {
			if(jet instanceof AirToGroundCombat) {
				System.out.println(jet.getModel());
				System.out.println("-----------------");				
				((AirToGroundCombat) jet).Attack();
			}
		}
	}

	public Jet GetFastestJet() {
		Jet fastestJet = null;
		double fastestSpeed = 0;
		for (int i = 0; i < af.getList().size() - 1; i++) {
			double jetSpeed = af.getJet(i).getSpeed();
			if (jetSpeed > fastestSpeed) {
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
			if (distance > LongestDistance) {
				LongestDistance = distance;
				LongestJet = af.getJet(i);
			}
		}
		return LongestJet;
	}

	public void LoadAllCargoJets() {
		for (int i = 0; i < af.getList().size(); i++) {
			if (af.getJet(i) instanceof CargoJet) {
				System.out.println(af.getJet(i).getModel());
				((CargoJet) af.getJet(i)).LoadCargo();
				System.out.println("--------------------");
			}
		}
	}

	public void Attack() {
		for (int i = 0; i < af.getList().size(); i++) {
			if (af.getJet(i) instanceof FighterJet) {
				System.out.println(af.getJet(i).getModel());
				((FighterJet) af.getJet(i)).DogFight();
				System.out.println("--------------------");
			}
		}
	}

	public void addJet() {
		String model = "";
		double speed = 0;
		int range = 0;
		long price = 0;
		Jet jet = null;
		do {
			System.out.println("===========================================");
			System.out.println("==      1. Fighter Jet                   ==");
			System.out.println("==      2. Cargo Jet                     ==");
			System.out.println("==      3. Surveillance Jet              ==");
			System.out.println("==      4. Air to Ground Attack Jet      ==");
			System.out.println("==      5. Exit                          ==");
			System.out.println("===========================================");
			int userChoice = ValidateInt("== Choice: ");
			sc.nextLine();
			switch (userChoice) {
			case 1:
				System.out.print("Model: ");
				model = sc.nextLine();
				speed = ValidateDouble("Speed: ");
				range = ValidateInt("Range: ");
				price = ValidatePrice("Price: ");
				jet = new FighterJet(model, speed, range, price, "Air Speriority Fighter");
				break;
			case 2:
				System.out.print("Model: ");
				model = sc.nextLine();
				speed = ValidateDouble("Speed: ");
				range = ValidateInt("Range: ");
				price = ValidatePrice("Price: ");
				jet = new CargoJet(model, speed, range, price, "Cargo");
				break;
			case 3:
				System.out.print("Model: ");
				model = sc.nextLine();
				speed = ValidateDouble("Speed: ");
				range = ValidateInt("Range: ");
				price = ValidatePrice("Price: ");
				jet = new SurveillancePlane(model, speed, range, price, "Surveillance");
				break;
			case 4:
				System.out.print("Model: ");
				model = sc.nextLine();
				speed = ValidateDouble("Speed: ");
				range = ValidateInt("Range: ");
				price = ValidatePrice("Price: ");
				jet = new AirToGroundCombat(model, speed, range, price, "Air to Ground Combat");
				break;
			case 5:
				return;
			default:
				System.out.println("NOT A VALID OPTION");
			}

			af.addJet(jet);

		} while (true);
	}

	public int ValidateInt(String prompt) {
		int userNum;
		while (true) {
			System.out.print(prompt);
			try {
				userNum = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Invalid amount(Must be a number).");
				System.out.println();
				sc.nextLine();
			}
		}
		return userNum;
	}

	public double ValidateDouble(String prompt) {
		double userNum;
		while (true) {
			System.out.print(prompt);
			try {
				userNum = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Invalid amount(Must be a number).");
				System.out.println();
				sc.nextLine();
			}
		}
		return userNum;
	}

	public long ValidatePrice(String prompt) {
		long userNum;
		while (true) {
			System.out.print(prompt);
			try {
				userNum = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Invalid amount(Must be a number).");
				System.out.println();
				sc.nextLine();
			}
		}
		return userNum;
	}

	public void DeleteJet() {
		int userChoice = 0;
		for (int i = 0; i < af.getList().size(); i++) {
			System.out.println(i + 1 + " - " + af.getJet(i).getModel());
		}
		
		while(true) {
			userChoice = ValidateInt("Select which jet to remove");
			if(userChoice <= 0 || userChoice > af.getList().size()) {
				System.out.println("Not a valid option");
			} else {
				af.getList().remove(userChoice - 1);
				return;
			}
		}
	}
	
	public void Recon() {
		for (Jet jet : af.getList()) {
			if (jet instanceof SurveillancePlane) {
				System.out.println(jet.getModel());
				System.out.println("-----------------");
				((SurveillancePlane) jet).Survey();
			}
		}
	}

}
