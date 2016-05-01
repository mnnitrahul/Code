package graph.Graph2;

import java.util.*;

public class Graph {
	private ArrayList<GraphNode> graphNodes;
	public Graph(int count) {
		this.graphNodes = new ArrayList<GraphNode>(count);
		for (int i = 0;i<count;++i) {
			GraphNode node = new GraphNode();
			graphNodes.add(node);
		}
	}
	public GraphNode getGraphNode(int i) {
		return graphNodes.get(i);
	}
	public void TopologicalSort() {
		ArrayList<Boolean> visited = new ArrayList<Boolean>(graphNodes.size());
		Stack<Integer> s = new Stack<Integer>();
		for (int i=0;i<graphNodes.size();++i) {
			visited.add(false);
		}
		for (int i = 0;i < graphNodes.size();++i) {
			if (!visited.get(i)) {
				visited.set(i, true);
				TopologicalSortUtil(s, visited, i);
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!s.empty()) {
			result.add(s.pop());
		}
		System.out.println(Arrays.toString(result.toArray()));
	}
	private void TopologicalSortUtil(Stack<Integer>s,  ArrayList<Boolean> visited, int nodeId) {
		ArrayList<GraphEdge> list = graphNodes.get(nodeId).getAdjacencyList();
		for (GraphEdge graphEdge : list) {
			int id = graphEdge.getEndNode();
			if (!visited.get(id)) {
				visited.set(id, true);
				TopologicalSortUtil(s, visited, id);
			}
		}
		s.add(nodeId);
	}
	
	public void DFS() {
		ArrayList<Boolean> visited = new ArrayList<Boolean>(graphNodes.size());
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i=0;i<graphNodes.size();++i) {
			visited.add(false);
		}
		for (int i = 0;i < graphNodes.size();++i) {
			if (visited.get(i) == false) {
				visited.set(i, true);
				DFSUtil(result, visited, i);
			}
		}
		System.out.println("DFS is " + Arrays.toString(result.toArray()));
	}
	
	private void DFSUtil(ArrayList<Integer> result, ArrayList<Boolean> visited, int nodeId) {
		ArrayList<GraphEdge> list = graphNodes.get(nodeId).getAdjacencyList();
		for (GraphEdge g : list) {
			int id = g.getEndNode();
			if (!visited.get(id)) {
				visited.set(id,  true);
				DFSUtil(result, visited, id);
			}
		}
		result.add(nodeId);
	}
	
	public void BFS() {
		ArrayList<Boolean> visited = new ArrayList<Boolean>(graphNodes.size());
		ArrayList<Integer> result = new ArrayList<Integer>(graphNodes.size());
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0;i<graphNodes.size();++i) {
			visited.add(false);
		}
		for (int i = 0; i< graphNodes.size();++i) {
			if (!visited.get(i)) {
				visited.set(i, true);
				q.add(i);
				BFSUtil(result, q, visited);
			}
		}
		System.out.println("BFS Array is " + Arrays.toString(result.toArray()));
	}
	private void BFSUtil(ArrayList<Integer> result, Queue<Integer> q, ArrayList<Boolean> visited) {
		while (!q.isEmpty()) {
			int nodeId = q.poll();
			result.add(nodeId);
			ArrayList<GraphEdge> edges = graphNodes.get(nodeId).getAdjacencyList();
			for (GraphEdge edge: edges) {
				int id = edge.getEndNode();
				if (!visited.get(id)) {
					visited.set(id, true);
					q.add(id);
				}
			}
		
		}		
	}
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.getGraphNode(5).addEdge(2, 0);
		g.getGraphNode(0).addEdge(2, 0);
		g.getGraphNode(0).addEdge(5, 0);
		g.getGraphNode(4).addEdge(0, 0);
		g.getGraphNode(4).addEdge(1, 0);
		g.getGraphNode(2).addEdge(3, 0);
		g.getGraphNode(3).addEdge(1, 0);
		
		g.TopologicalSort();
		g.DFS();
		g.BFS();
	}
}
