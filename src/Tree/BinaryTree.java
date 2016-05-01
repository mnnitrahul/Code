package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	BinaryTree left;
	BinaryTree right;
	int data;
	public BinaryTree(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	public void setLeft(BinaryTree tree) {
		left = tree;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public void setRight(BinaryTree tree) {
		right = tree;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void levelOrderTraverse() {
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.add(this);
		while(!queue.isEmpty()) {
			BinaryTree node = queue.poll();
			System.out.println("value is " + node.getData());
			if ( node.getLeft()!= null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}
}
