package com.peige.pattern;

public class Client {
	
	public static void main(String[] args) {
		
		Account account = new Account("peige", 0.0);
		
		account.deposit(1000);
		account.withdraw(2000);
		account.deposit(4000);
		account.computeInterest();
		account.withdraw(6000);
		account.computeInterest();
		
	}

}
