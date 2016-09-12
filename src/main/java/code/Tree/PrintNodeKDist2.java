/**
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 */

package tree;

public class PrintNodeKDist2 {
	public void printKDistDown(BinaryTree root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.println(root.getData());
			return;
		}
		printKDistDown(root.getLeft(), k-1);
		printKDistDown(root.getRight(), k-1);
	}
	public int printKDist(BinaryTree root, BinaryTree node, int k) {
		if (root == null) {
			return -1;
		}
		if (root == node) {
			printKDistDown(root, k);
			return 1;
		}
		int dl = printKDist(root.getLeft(), node, k);
		if (dl > -1) {
			if (dl == k) {
				System.out.println(root.getData());
			}
			printKDistDown(root.getRight(), k-dl-1);
			return dl+1;
		}
		int dr = printKDist(root.getRight(), node, k);
		if (dr > -1) {
			if (dr == k) {
				System.out.println(root.getData());
			}
			printKDistDown(root.getLeft(), k-dr-1);
			return dr+1;
		}
		return -1;
	}
	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(20);
		BinaryTree root2 = new BinaryTree(1);
		root2.setLeft(root);
		BinaryTree node1 = new BinaryTree(8);
		BinaryTree node2 = new BinaryTree(22);
		root.setLeft(node1);
		root.setRight(node2);
		BinaryTree node3 = new BinaryTree(4);
		BinaryTree node4 = new BinaryTree(12);
		node1.setLeft(node3);
		node1.setRight(node4);
		BinaryTree node5 = new BinaryTree(10);
		BinaryTree node6 = new BinaryTree(14);
		node4.setLeft(node5);
		node4.setRight(node6);
		PrintNodeKDist2 printNodeKDist2 = new PrintNodeKDist2();
		printNodeKDist2.printKDist(root2, node1, 2);
	}
}
