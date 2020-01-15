package com.org.multithreading.first.impl;

public class Account {
	
	private int initialAmount = 10000;
	
	public void withDraw(int amount) {
		initialAmount -=amount;
	}
	
	public void Deposit(int amount) {
		initialAmount += amount;
	}
	
	public int getAmount() {
		return initialAmount;
	}
	
    	
}
