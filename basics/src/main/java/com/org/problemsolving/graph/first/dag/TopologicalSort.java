package com.org.problemsolving.graph.first.dag;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	private Stack<Vertex> stack;
	
	public TopologicalSort() {
		this.stack =new Stack<>();
	}
	
	public void makeTopologicalSort(List<Vertex> vertexList){
		
		for(Vertex ver : vertexList) {
			if(!ver.isVisited()) {
				dfs(ver);
			}
		}
	}

	private void dfs(Vertex ver){
		for(Edge e : ver.getAdjancies()) {
			if(!e.getTargetVertex().isVisited()) {
				e.getTargetVertex().setVisited(true);
				dfs(e.getTargetVertex());
			}
		}
		this.stack.push(ver);
	}
	
	
	public Stack<Vertex> getTopologicalOrder(){
		Collections.reverse(this.stack);
		return this.stack;
	}
	
	
}
