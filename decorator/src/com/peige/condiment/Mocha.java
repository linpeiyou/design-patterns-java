package com.peige.condiment;

import com.peige.base.Beverage;
import com.peige.base.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return 0.2 + beverage.cost();
	}
}
