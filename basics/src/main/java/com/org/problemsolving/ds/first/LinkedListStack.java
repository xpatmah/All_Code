package com.org.problemsolving.ds.first;

import com.org.domain.first.Node;

public class LinkedListStack<T> {

	private Node<T> start;
	
	public LinkedListStack() {
		// TODO Auto-generated constructor stub
	}
	
	public void push(T info) {
		if(start==null) {
			start = new Node<T>();
			start.setInfo(info);
			start.setNext(null);
		}else {
		   Node<T> node = new Node<T>();
		   node.setInfo(info);
		   node.setNext(start);
		   start = node;
		}		
	}
	
	public Node<T> find(T info) {
		if(start==null) {
			return null;
		}
		else {
			Node<T> tempNode = start;
			while(tempNode !=null) {
				if(tempNode.getInfo().equals(info)) {
					return tempNode;
				}
				tempNode = tempNode.getNext();
			}
			return null;
		}
	}
	
	public Node<T> peek() {
		if(start==null) {
			return null;
		}
		else {
			return start;
		}
	}
	
	public Node<T> pop() {
		if(start==null) {
			return null;
		}
		else {
			Node<T> node = start.getNext();
			start.setNext(null);
			Node<T> tempNode = start;
			start = node;
			return tempNode;
		}
	}
}
