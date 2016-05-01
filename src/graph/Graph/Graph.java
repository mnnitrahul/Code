package graph.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * Modify below code
 * 1- if a came before b then add dependency of b -> a
 * 2- in Graph instead of graphNodes use Map of char to GraphNode and a list of all chars
 * 3- in main compare 2 string and find 2 char. for each char
 * 4- check if node exist in GraphNode map
 * 5- Create Node add it in GraphNode map and char list
 * 6- use Map for isVisited
 * 7- iterate over char list
 * 
 * @author agarwalr
 *
 */

public class Graph {
	private ArrayList<GraphNode> graphNodes;
	public Graph() {
		graphNodes = new ArrayList<GraphNode>();
	}
	public void printBFS() {
		int size = graphNodes.size();
		boolean[] isVisited = new boolean[size];
		ArrayList<GraphNode> result = new ArrayList<GraphNode>();
		Queue<GraphNode> q = new ArrayDeque<GraphNode>();
		for (int i = 0 ; i< size;i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				q.add(graphNodes.get(i));
				BFSUtil(q, result, isVisited);
			}
		}
		System.out.print("BFS Result is ");
		for (GraphNode graphNode : result) {
			System.out.print(graphNode.getId() + " ");
		}
		System.out.println();
	}
	private void BFSUtil(Queue<GraphNode>q, ArrayList<GraphNode> result, boolean[] isVisited) {
		while(!q.isEmpty()) {
			GraphNode node = q.poll();
			result.add(node);
			ArrayList<GraphNode> list = node.getAllEdges();
			for (GraphNode graphNode : list) {
				if (!isVisited[graphNode.getId()]) {
					isVisited[graphNode.getId()] = true;
					q.add(graphNode);
				}
			}
			
		}
		
	}
	
	public void printDFS() {
		int size = graphNodes.size();
		boolean[] isVisited = new boolean[size];
		ArrayList<GraphNode> result = new ArrayList<GraphNode>();
		for (int i = 0 ; i< size;i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				DFSUtil(result, isVisited, graphNodes.get(i));
			}
		}
		System.out.print("DFS result is ");
		for (GraphNode graphNode : result) {
			System.out.print(graphNode.getId() + " ");
		}
		System.out.println();

	}
	private void DFSUtil(ArrayList<GraphNode> result, boolean[] isVisited, GraphNode rootGraphNode) {
		ArrayList<GraphNode> list = rootGraphNode.getAllEdges();
		result.add(rootGraphNode);
		for (GraphNode graphNode : list) {
			if (!isVisited[graphNode.getId()]) {
				isVisited[graphNode.getId()] = true;
				DFSUtil(result, isVisited, graphNode);
			}
		}
		
	}
	
	
	/**
	 * Corrected version 
	 * a->b means a is dependent on b and b should be printed before a
	 * in below implementatin change stack with linked list
	 * 
	 */

	
	public void printTopologicalSort() {
		int size = graphNodes.size();
		boolean[] isVisited = new boolean[size];
		List<GraphNode> result = new ArrayList<GraphNode>();

		
		for (int i = 0 ; i< size;i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				TopoUtil(result, isVisited, graphNodes.get(i));
			}
		}
		System.out.print("Topological Sort result is ");
		for (GraphNode graphNode : result) {
			System.out.print(graphNode.getId() + " ");
		}
		System.out.println();

	}
	
	private void TopoUtil(List<GraphNode> result, boolean[] isVisited, GraphNode rootGraphNode) {
		ArrayList<GraphNode> list = rootGraphNode.getAllEdges();
		for (GraphNode graphNode : list) {
			if (!isVisited[graphNode.getId()]) {
				isVisited[graphNode.getId()] = true;
				TopoUtil(result, isVisited, graphNode);
			}
		}
		result.add(rootGraphNode);
		
	}

	public static void  main(String[] args) {
		Graph g = new Graph();
		GraphNode g0 = new GraphNode(0);
		GraphNode g1 = new GraphNode(1);
		GraphNode g2 = new GraphNode(2);
		GraphNode g3 = new GraphNode(3);
		GraphNode g4 = new GraphNode(4);
		GraphNode g5 = new GraphNode(5);
		g5.addEdge(g2);
		g0.addEdge(g2);
		g0.addEdge(g5);
		g4.addEdge(g0);
		g4.addEdge(g1);
		g2.addEdge(g3);
		g3.addEdge(g1);
		g.graphNodes.add(g0);
		g.graphNodes.add(g1);
		g.graphNodes.add(g2);
		g.graphNodes.add(g3);
		g.graphNodes.add(g4);
		g.graphNodes.add(g5);
		g.printBFS();
		g.printDFS();
		g.printTopologicalSort();
	}
}
