package com.org.problemsolving.ds.first.algo;

public class Edge {

	private double weight;
	
	private Vertex startingVertex;
	
	private Vertex targetVertex;

	public Edge(double weight, Vertex startingVertex, Vertex targetVertex) {
		super();
		this.weight = weight;
		this.startingVertex = startingVertex;
		this.targetVertex = targetVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getStartingVertex() {
		return startingVertex;
	}

	public void setStartingVertex(Vertex startingVertex) {
		this.startingVertex = startingVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}
	
}
