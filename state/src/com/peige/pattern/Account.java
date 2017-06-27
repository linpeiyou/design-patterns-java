package com.peige.pattern;

public class Account {
	
	private AccountState 	state;		// 状态
	private String 			owner;		// 开户名 
	private double 			balance = 0;// 账户余额
	
	// constructor: init owner and balance
	public Account(String owner, double initBalance) {
		this.owner = owner;
		this.balance = initBalance;
		this.state = new NormalState(this);
		System.out.println(this.owner + "开户，初始金额为：" + this.balance);
		System.out.println("--------------------------------------------------");
	}
	
	// 存款
	public void deposit(double amount) {
		System.out.println(this.owner + "存款" + amount);
		state.deposit(amount);
		System.out.println("现在余额为：" + this.balance);
		System.out.println("现在账户状态为：" + this.state.getClass().getSimpleName());
		System.out.println("--------------------------------------------------");
	}
	
	// 取款
	public void withdraw(double amount) {
		System.out.println(this.owner + "取款" + amount);
		state.withdraw(amount);
		System.out.println("现在余额为：" + this.balance);
		System.out.println("现在账户状态为：" + this.state.getClass().getSimpleName());
		System.out.println("--------------------------------------------------");		
	}
	
	// 计算利息
	public void computeInterest() {
		state.computeInterest();
		System.out.println("--------------------------------------------------");		
	}
	

	public AccountState getState() {
		return state;
	}

	public void setState(AccountState state) {
		this.state = state;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
