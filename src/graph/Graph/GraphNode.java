package graph.Graph;

import java.util.ArrayList;

/**
 * Ideally Graph Node should contain ArrayList of Graph Node
 * @author agarwalr
 *
 */
public class GraphNode {
	private ArrayList<GraphNode> edges;
	private int id;
	public GraphNode(int id) {
		edges = new ArrayList<GraphNode>();
		this.id = id;
	}
	public void addEdge(GraphNode edge) {
		edges.add(edge);
	}
	public ArrayList<GraphNode> getAllEdges() {
		return edges;
	}
	public int getId() {
		return id;
	}
}
