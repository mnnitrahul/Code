package tree;

public class LCA {
	public BinaryTree findLCA(BinaryTree root, BinaryTree node1, BinaryTree node2) {
		if (root == null) {
			return null;
		}
		if (root.getData() == node1.getData() || root.getData() == node2.getData()) {
			return root;
		}
		BinaryTree left = findLCA(root.getLeft(), node1, node2);
		BinaryTree right = findLCA(root.getRight(), node1, node2);
		if (left != null && right!= null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}
		return null;
	}
	public static void main(String[] args) {
		LCA lca = new LCA();
		BinaryTree root = new BinaryTree(3);
		BinaryTree node1 = new BinaryTree(5);
		BinaryTree node2 = new BinaryTree(1);
		root.setLeft(node1);
		root.setRight(node2);
		BinaryTree node3 = new BinaryTree(6);
		BinaryTree node4 = new BinaryTree(2);
		node1.setLeft(node3);
		node1.setRight(node4);
		BinaryTree node5 = new BinaryTree(0);
		BinaryTree node6 = new BinaryTree(8);
		node2.setLeft(node5);
		node2.setRight(node6);
		BinaryTree node7 = new BinaryTree(7);
		BinaryTree node8 = new BinaryTree(4);
		node4.setLeft(node7);
		node4.setRight(node8);
		BinaryTree result = lca.findLCA(root, node3, node8);
		System.out.println(result.getData());
		
		
	}
}
