package com.peige.flybehavior;

/**
 * 使用火箭飞行
 * 
 * @author peige
 */
public class FlyRocketPowered implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm flying with a rocket!");
	}

}
