package com.skilldistillery.jets;

public class JetImpl extends Jet{
	String type;
	
	public JetImpl(String model, double speed, int range, long price, String _type) {
		super(model, speed, range, price);
		type = _type;
	}
	
}
