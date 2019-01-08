package com.java.dynamic.practice;

import java.util.Random;

public class CircularLinkedList {           
	public  static Node getCicularLinedList(int no){
		
		Node rootNode = null;
		
		Node  lastNode = null;
		
		Random random  = new Random();
		
		for(int i=0 ; i < no ; i++) {
			Node node = new Node();
			node.setInfo(random.nextInt(100));
			if(rootNode == null) {
				rootNode = node;
				lastNode = rootNode;
			}else {
				lastNode.setNext(node);
				lastNode = node;
			}
		}
		lastNode.setNext(rootNode);
		
		return rootNode;
	}
	
	public static void main(String[] args) {
		
		Node node = getCicularLinedList(10);
		
		Node temp = node.getNext();
		System.out.print(node.getInfo()+"  ");
		while(temp!=node) {
			System.out.print(temp.getInfo()+"  ");
			temp = temp.getNext();
		}
	}
}
