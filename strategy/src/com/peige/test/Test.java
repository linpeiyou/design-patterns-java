package com.peige.test;

import com.peige.duck.Duck;
import com.peige.duck.MallardDuck;
import com.peige.duck.ModelDuck;
import com.peige.duck.RedheadDuck;
import com.peige.duck.RubberDuck;
import com.peige.flybehavior.FlyRocketPowered;

public class Test {

	public static void main(String[] args) {
		Duck duck1 = new MallardDuck();
		duck1.performFly();
		duck1.performQuack();
		duck1.display();
		System.out.println();
		
		Duck duck2 = new RedheadDuck();
		duck2.performFly();
		duck2.performQuack();
		duck2.display();
		System.out.println();
		
		Duck duck3 = new RubberDuck();
		duck3.performFly();
		duck3.performQuack();
		duck3.display();
		System.out.println();
		
		Duck duck4 = new ModelDuck();
		duck4.performFly();
		duck4.performQuack();
		duck4.display();
		
		duck4.setFlyBehavior(new FlyRocketPowered());
		duck4.performFly();
	}
	
}
