package com.skilldistillery.jets;

public class CargoJet extends Jet implements Cargo{
	private String type;
	
	public CargoJet(String _model, double _speed, int _range, long _price, String _type) {
		super(_model, _speed, _range, _price);
		type = _type;
		
	}
	
	public void LoadCargo() {
		System.out.println("All cargo laoded and ready for transport!");
	}
	
	@Override
	public void fly() {
		System.out.println("Type: " + type + "\nModel: " + super.getModel() + "\nMax Speed " + super.getSpeed()+ " MPH (Mach " + String.format("%.1f", super.SpeedInMach()) + " )\nMax Range: " + super.getRange() 
				+ " Miles\nEndurance: " + super.getFlightTime() + " Hrs\nPrice: " + super.getPrice());
	}
}
