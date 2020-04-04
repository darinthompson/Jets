package com.skilldistillery.jets;

public class FighterJet extends Jet implements AirSuperiority{
	private String type;
	
	public FighterJet() {
		
	}
	
	public FighterJet(String _model,double _speed, int _range, long _price, String _type) {
		super(_model, _speed, _range, _price);
		setType(_type);
	}
	
	public void DogFight() {
		System.out.println("Locked on target!");
	}

	public String getType() {
		return type;
	}

	public void setType(String _type) {
		type = _type;
	}
	
	@Override
	public void fly() {
		System.out.println("Type: " + type + "\nModel: " + super.getModel() + "\nMax Speed " + super.getSpeed()+ " MPH\nMax Range: " + super.getRange() 
				+ " Miles\nEndurance: " + super.getFlightTime() + " Hrs\nPrice: " + super.getPrice());
	}
}
