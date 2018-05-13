package com.org.multithread.impl;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountRunnable {

	Account acc1 = new Account();
	Account acc2 = new Account();
	
	Lock ac1 = new ReentrantLock();
	Lock ac2 = new ReentrantLock();
	
	private void tryLock(Lock ac1, Lock ac2) {
		while(true) {
			boolean isFirstLock =false;
			boolean isSecondLock =false;
			
			 isFirstLock = ac1.tryLock();
			 isSecondLock = ac2.tryLock();
			 if(isFirstLock && isSecondLock) {
					return ;
				}else {
					if(isFirstLock) {
						ac1.unlock();
					}
					if(isSecondLock) {
						ac2.unlock();
					}
				}
			 try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void transfer(Account acc1  , Account acc2 , int amount) {
		acc1.withDraw(amount);
		acc2.Deposit(amount);
	}
	
	public void firstThread() {
		
		Random ran = new Random();
		for(int i = 0 ; i< 10;i++) {	
			tryLock(ac1,ac2);
				try {
					transfer(acc1, acc2, ran.nextInt(100));
				}finally {
					ac1.unlock();
					ac2.unlock();
				}
		}
	}
	
	public void secodThread() {

		Random ran = new Random();
		for(int i = 0 ; i< 10;i++) {	
			tryLock(ac2,ac1);
				try {
					transfer(acc2, acc1, ran.nextInt(100));
				}finally {
					ac1.unlock();
					ac2.unlock();
				}
			}
	}
	
	public void totalAmount() {
		System.out.println(acc1.getAmount()+acc2.getAmount());
	}
	
}
