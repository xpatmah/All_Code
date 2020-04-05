package com.org.problemsolving.graph.first.dag;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class AcyclicShortestPath {

	public void shortestPath(List<Vertex> vertexList, Vertex source, Vertex target) {

		source.setDistance(0);

		TopologicalSort sort = new TopologicalSort();
		sort.makeTopologicalSort(vertexList);

		Stack<Vertex> topologicalOrder = sort.getTopologicalOrder();

		for (Vertex ver : topologicalOrder) {

			for (Edge e : ver.getAdjancies()) {

				Vertex s = e.getStartVertex();

				Vertex d = e.getTargetVertex();

				double newDistance = s.getDistance() + e.getWeight();

				if (newDistance < d.getDistance()) {
					d.setDistance(newDistance);
					d.setPreviousVertex(s);
				}
			}

		}

		if (target.getDistance() == Double.MAX_VALUE) {
			System.out.println("There is no path");
		} else {
			System.out.println("Target vertex SortestPath" + target.getDistance());
		}
	}

	public List<Vertex> getSortestPath(Vertex targetVertex) {

		List<Vertex> vertexList = new LinkedList<>();

		while (targetVertex != null) {
			vertexList.add(targetVertex);
			targetVertex = targetVertex.getPreviousVertex();
		}

		Collections.reverse(vertexList);

		return vertexList;

	}

}
