package com.org.domain.first;

import com.org.kruskal.Node;

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
