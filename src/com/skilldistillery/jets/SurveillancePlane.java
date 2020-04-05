package com.skilldistillery.jets;

public class SurveillancePlane extends Jet implements Surveillance{
	private String type;
	
	public SurveillancePlane(String _model, double _speed, int _range, long _price, String _type) {
		super(_model, _speed, _range, _price);		
		type = _type;
	}
	
	@Override
	public void Survey() {
		System.out.println("You can run, but you can't hide!");
	}
	
	@Override
	public void fly() {
		System.out.println("Type: " + type + "\nModel: " + super.getModel() + "\nMax Speed " + super.getSpeed()+ " MPH (Mach " + String.format("%.1f", super.SpeedInMach()) + " )\nMax Range: " + super.getRange() 
				+ " Miles\nEndurance: " + super.getFlightTime() + " Hrs\nPrice: " + super.getPrice());
	}
}
