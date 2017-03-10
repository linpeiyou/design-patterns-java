package com.peige.condiment;

import com.peige.base.Beverage;
import com.peige.base.CondimentDecorator;

public class Whip extends CondimentDecorator {

	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.1;
	}
}
