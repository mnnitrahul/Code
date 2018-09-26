package graph.Graph2;

import java.util.ArrayList;

public class GraphNode {
	private ArrayList<GraphEdge> adjacentList;
	public GraphNode() {
		adjacentList = new ArrayList<GraphEdge>();
	}
	public void addEdge(int i, int weight) {
		GraphEdge edge = new GraphEdge(i, weight);
		adjacentList.add(edge);
	}
	public ArrayList<GraphEdge> getAdjacencyList() {
		return adjacentList;
	}
}
