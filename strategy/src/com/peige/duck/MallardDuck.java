package com.peige.duck;

import com.peige.flybehavior.FlyWithWings;
import com.peige.quackbehavior.Quack;

/**
 * 绿头鸭
 * 
 * @author peige
 */
public class MallardDuck extends Duck {

	public MallardDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
	
	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}

}
