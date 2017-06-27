package com.peige.nopattern;

public class Account2 {

	private String state;	// 状态
	private int balance;	// 余额
	
	// 存款操作
	public void deposit() {
		// 存款
		stateCheck();
	}
	
	// 取款操作
	public void withdraw() {
		if(state.equalsIgnoreCase("NormalState") || state.equalsIgnoreCase("OverdraftState")) {
			// 取款
			stateCheck();
		}
		else {
			// 取款受限
		}
	}
	
	// 计算利息操作
	public void computeInterest() {
		if(state.equalsIgnoreCase("NormalState") || state.equalsIgnoreCase("RestrictedState")) {
			// 计算利息
		}
	}
	
	public void stateCheck() {
		if(balance >= 0) {
			state = "NormalState";
		}
		else if(balance > -2000 && balance < 0) {
			state = "OverdraftState";
		}
		else if(balance == -2000) {
			state = "RestrictedState";
		}
		else if(balance < -2000) {
			// 操作受限
		}
	}
	
}












