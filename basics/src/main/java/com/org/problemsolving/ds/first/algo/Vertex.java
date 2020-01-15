package com.org.problemsolving.ds.first.algo;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

	private String name;
	
	private List<Edge> adjancyList;
	
	private boolean visited;
	
	private double distance = Double.MAX_VALUE;
	
	private Vertex predecessor;
	

	public Vertex(String name) {
		this.name = name;
		this.adjancyList = new ArrayList<>();
	}
	
    public void addNeighbour(Edge e) {
    	this.adjancyList.add(e);
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

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Edge> getAdjancyList() {
		return adjancyList;
	}

	public void setAdjancyList(List<Edge> adjancyList) {
		this.adjancyList = adjancyList;
	}

	@Override
	public int compareTo(Vertex o) {
		return Double.compare(this.distance, o.distance);
	}
	
	
}
