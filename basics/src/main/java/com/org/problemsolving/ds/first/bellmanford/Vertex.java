package com.org.problemsolving.ds.first.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	
	private boolean visited;
	
	private double distance = Double.MAX_VALUE;
	
	private Vertex previousVertex;
	
	private List<Edge> adjancies;

	public Vertex(String name) {
		this.name = name;
	    this.adjancies = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getAdjancies() {
		return adjancies;
	}

	public void setAdjancies(List<Edge> adjancies) {
		this.adjancies = adjancies;
	}
	
	public void addNeighbour(Edge e) {
		this.adjancies.add(e);
	}
}


