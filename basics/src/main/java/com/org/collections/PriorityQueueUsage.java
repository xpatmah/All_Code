package com.org.collections;

import java.util.PriorityQueue;

public class PriorityQueueUsage {

	public static void main(String[] args){
		
		PriorityQueue<Person> per = new PriorityQueue<Person>();

		Person p1 = new Person(45 , "ram");
		Person p2 = new Person( 56, "shyam");
		Person p3 = new Person(90, "ram");
		Person p4 = new Person(34 , "ram");
		Person p5 = new Person(45 , "ram");
		Person p6 = new Person(12 , "ram");
		Person p7 = new Person(78, "ram");
		
		
		
		per.add(p1);
		per.add(p2);
		per.add(p3);
		per.add(p4);
		per.add(p5);
		per.add(p6);
		per.add(p7);
		
		while(!per.isEmpty()){
			System.out.println(per.remove().id);
		}
		
		
	}
	
	
	
}
