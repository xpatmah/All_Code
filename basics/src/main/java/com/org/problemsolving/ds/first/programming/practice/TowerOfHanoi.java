package com.org.problemsolving.ds.first.programming.practice;

public class TowerOfHanoi {

	public static void main(String[] args) {
		TowerOfHanoi hanoi = new TowerOfHanoi();
		hanoi.movedisk(3, 's', 'd', 't');
	}
	
	public void movedisk(int n , char s , char d , char t) {
		if(n==1){
			System.out.println("Move disk "+n+ " from "+ s + " to " + d);
		}else {
			movedisk(n-1, s, t, d);
			System.out.println("Move disk" +n+" from "+s+" to "+d);
			movedisk(n-1, t, d, s);
		}
		
		
	}
	
	
}
