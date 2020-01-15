package com.org.java.ds.bellmanford;

import java.util.List;

public class BellmanFordAlgo {

	private List<Edge> edgeList;
	
	private List<Vertex> vertexList;

	public BellmanFordAlgo(List<Edge> edgeList, List<Vertex> vertexList) {
		this.edgeList = edgeList;
		this.vertexList = vertexList;
	}

	public void bellmanFord(Vertex sourceVertex) {
		
		sourceVertex.setDistance(0);
		
		for(int i=0 ; i < vertexList.size()-1;i++) {
			
			for(Edge e  : this.edgeList) {
				
				if(e.getStartVertex().getDistance() == Double.MAX_VALUE) {
					continue;
				}
				
				double newDistancer = e.getStartVertex().getDistance()+e.getWeight();
				
				if(newDistancer < e.getTargetVertex().getDistance()) {
					e.getTargetVertex().setDistance(newDistancer);
					e.getTargetVertex().setPreviousVertex(e.getStartVertex());
				}
			}
		}
		
		for(Edge e : this.edgeList) {
			if(e.getStartVertex().getDistance()!=Double.MAX_VALUE) {
				if(hasCycle(e)) {
					System.out.println("There is negative cycle detected...");
					return;
				}  
			}
		}
		
	}

	private boolean hasCycle(Edge e) {
		return e.getStartVertex().getDistance()+e.getWeight() < e.getTargetVertex().getDistance();
	}
	
	public void getPathToTargetVertex(Vertex targetVertex){
		
		if(targetVertex.getDistance()==Double.MAX_VALUE) {
			System.out.println("There is no path");
		}
		
		Vertex actualVertex = targetVertex;
		
		while(actualVertex.getPreviousVertex()!=null) {
			System.out.println(actualVertex.getName());
			actualVertex = actualVertex.getPreviousVertex();
		}
		System.out.println(actualVertex.getName());
	}
	
}
