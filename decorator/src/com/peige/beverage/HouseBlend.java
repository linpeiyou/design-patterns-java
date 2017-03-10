package com.peige.beverage;

import com.peige.base.Beverage;

/**
 * 综合咖啡 
 */
public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		this.description = "House Blend Coffee";
	}

	@Override
	public double cost() {
		return 0.89;
	}

}
