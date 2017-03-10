package com.peige.beverage;

import com.peige.base.Beverage;

/**
 * 深度烘焙 
 */
public class DarkRoast extends Beverage {

	public DarkRoast() {
		this.description = "Dark Roast Coffee";
	}
	
	@Override
	public double cost() {
		return 0.99;
	}
}
