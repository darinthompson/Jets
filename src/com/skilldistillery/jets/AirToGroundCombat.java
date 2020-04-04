package com.skilldistillery.jets;

public class AirToGroundCombat extends Jet implements AirToGround {
	private String type;
	public AirToGroundCombat(String _model, double _speed, int _range, long _price, String _type) {
		super(_model, _speed, _range, _price);		
		type = _type;
	}
	
	@Override
	public void Attack() {
		System.out.println("Coming in Hot!!!");
	}
	
	@Override
	public void fly() {
		System.out.println("Type: " + type + "\nModel: " + super.getModel() + "\nMax Speed " + super.getSpeed()+ " MPH\nMax Range: " + super.getRange() 
				+ " Miles\nEndurance: " + super.getFlightTime() + " Hrs\nPrice: " + super.getPrice());
	}
}
