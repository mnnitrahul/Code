package graph.Graph2;

public class GraphEdge {
	private int endNode;
	private int weight;
	public GraphEdge(int endNode, int weight) {
		this.endNode = endNode;
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public int getEndNode() {
		return endNode;
	}
}
