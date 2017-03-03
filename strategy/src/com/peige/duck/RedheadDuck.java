package com.peige.duck;

import com.peige.flybehavior.FlyWithWings;
import com.peige.quackbehavior.Quack;

/**
 * 红头鸭
 *
 * @author peige
 */
public class RedheadDuck extends Duck {
	
	public RedheadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I'm a reahead duck");
	}

}
