package com.peige.duck;

import com.peige.flybehavior.FlyNoWay;
import com.peige.quackbehavior.Squeak;

public class RubberDuck extends Duck {

	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}

	@Override
	public void display() {
		System.out.println("I'm a rubber duck");
	}

}
