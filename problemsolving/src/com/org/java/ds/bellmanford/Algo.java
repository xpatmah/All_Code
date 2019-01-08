package com.org.java.ds.bellmanford;

import java.util.ArrayList;
import java.util.List;

public class Algo {
	
	public static void main(String[] args) {
		
		List<Vertex> vertexList = new ArrayList<>();
		
		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));
		
		List<Edge> edgeList = new ArrayList<>();
		
		edgeList.add(new Edge(1 , vertexList.get(0) , vertexList.get(1)));
		edgeList.add(new Edge(10 , vertexList.get(0) , vertexList.get(2)));
		edgeList.add(new Edge(1 , vertexList.get(1) , vertexList.get(2)));
		
		BellmanFordAlgo bellmanford = new BellmanFordAlgo(edgeList, vertexList);
		
		bellmanford.bellmanFord(vertexList.get(0));
		
		bellmanford.getPathToTargetVertex(vertexList.get(2));
		
	}
}
