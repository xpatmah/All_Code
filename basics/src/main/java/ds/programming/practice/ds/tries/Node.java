package com.org.java.ds.tries;

import java.util.HashSet;
import java.util.Set;

public class Node {

	private Character ch;
	
	private Set<Node> children = new HashSet<>();

	public Node(Character ch) {
		this.ch = ch;
	}
	
	public Character getCh() {
		return ch;
	}

	public void setCh(Character ch) {
		this.ch = ch;
	}

	public Set<Node> getChildren() {
		return children;
	}

	public void setChildren(Set<Node> children) {
		this.children = children;
	}
	
}
