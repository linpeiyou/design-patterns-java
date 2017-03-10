package com.peige.beverage;

import com.peige.base.Beverage;

/**
 * 浓缩咖啡
 */
public class Espresso extends Beverage {
	
	public Espresso() {
		this.description = "Espresso";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}
	
}
