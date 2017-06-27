package com.peige.pattern;

/**
 * 抽象状态类
 * @author peige
 *
 */
abstract public class AccountState {

	protected Account account;
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public abstract void computeInterest();
	public abstract void stateCheck();
	
}
