package com.org.java.dijkastra.algo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	public void computePath(Vertex sourceVertex) {
		
		sourceVertex.setDistance(0);
		
		PriorityQueue<Vertex> prirityQueue = new PriorityQueue<>();
		
		prirityQueue.add(sourceVertex);
		
		while(!prirityQueue.isEmpty()) {
			
			Vertex actualVertex = prirityQueue.poll();
			
			for(Edge edge : actualVertex.getAdjancyList()) {
				
				Vertex v = edge.getTargetVertex();
				
				double newDistance = edge.getWeight() + actualVertex.getDistance();
				if(!v.isVisited()) {
					if(newDistance < v.getDistance()) {
						prirityQueue.remove(v);
						v.setPredecessor(actualVertex);
						v.setDistance(newDistance);
						prirityQueue.add(v);
					}
				}
			}
			actualVertex.setVisited(true);	
		}
	}
	
	public List<Vertex> getSortestPath(Vertex targetVertex){
		
		List<Vertex> vertexList = new LinkedList<>();
		
		while(targetVertex!=null) {
			vertexList.add(targetVertex);
			targetVertex = targetVertex.getPredecessor();
		}
		
		 Collections.reverse(vertexList);
		 
		 return vertexList;
		
		
		
	}
	
}
