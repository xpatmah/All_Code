package com.org.domain.ds;


public class Vertex {
	
	private String name;
	
	private Node node;
	
	public Vertex(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}	
}
