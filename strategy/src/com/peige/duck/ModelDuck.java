package com.peige.duck;

import com.peige.flybehavior.FlyNoWay;
import com.peige.quackbehavior.Quack;

/**
 * 模型鸭
 * 
 * @author peige
 */
public class ModelDuck extends Duck {
	
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}

}
