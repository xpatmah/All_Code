package com.java.dynamic.practice;

public class Node<T> {

	private T info;

	private Node<T> next;
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	
	
}
