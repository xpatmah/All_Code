package com.org.problemsolving.ds.first.algo;

public class App {
	
	public static void main(String[] args) {
		
		Vertex vertA = new Vertex("A");
		Vertex vertB = new Vertex("B");
		Vertex vertC = new Vertex("C");
		
		vertA.addNeighbour(new Edge(1, vertA, vertB));
		vertA.addNeighbour(new Edge(3, vertA, vertC));
		vertB.addNeighbour(new Edge(1, vertB, vertC));
		
		DijkstraAlgo alog = new DijkstraAlgo();
		
		alog.computePath(vertA);

	    alog.getSortestPath(vertC).stream().forEach(e -> System.out.println(e.getName()));
		
	}

}
