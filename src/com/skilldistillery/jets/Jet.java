package com.skilldistillery.jets;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private String price;
	
	public Jet() {
		
	}
	
	public Jet(String _model, double _speed, int _range, String _price) {
		model = _model;
		speed = _speed;
		range = _range;
		price = _price;
	}
	
	public void setModel(String _model) {
		model = _model;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setSpeed(int _speed) {
		speed = _speed;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setRange(int _range) {
		range = _range;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setPrice(String _price) {
		price = _price;
	}
	
	public String getPrice() {
		return price;
	}
	
	private String getFlightTime() {
		return (String.format("%.1f", (range / speed)));
	}
	
	public void fly() {
		System.out.println("Model: " + model + "\nMax Speed " + speed + " MPH\nMax Range: " + range + " miles\nEndurance: " + getFlightTime() + " Hrs\nPrice: " + price);
	}
	
}
