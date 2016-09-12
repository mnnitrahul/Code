package tree;

public class TreeDiameter {
	public int getDiameter(BinaryTree root, WrapInt distance ) {
		if (root == null) {
			return 0;
		}
		int left = getDiameter(root.getLeft(), distance);
		int right = getDiameter(root.getRight(), distance);
		if ((left + right +1) > distance.value ) {
			distance.value = left + right + 1;
			System.out.println("new max with center " + root.getData() + " left dist " + left + " right value " + right);
		}
		int max = left;
		if (max < right) {
			max = right;
		}
		return max+1;
	}
	public static void main(String[] args) {
		TreeDiameter treeDiameter = new TreeDiameter();
		WrapInt diameter = new WrapInt();
		diameter.value = 0;
		BinaryTree root = new BinaryTree(1);
		BinaryTree node2 = new BinaryTree(2);
		BinaryTree node3 = new BinaryTree(3);
		BinaryTree node4 = new BinaryTree(4);
		BinaryTree node5 = new BinaryTree(5);
		BinaryTree node6 = new BinaryTree(6);
		BinaryTree node7 = new BinaryTree(7);
		BinaryTree node8 = new BinaryTree(8);
		BinaryTree node9 = new BinaryTree(9);
		BinaryTree node10 = new BinaryTree(10);
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node3.setLeft(node5);
		node4.setLeft(node6);
		node6.setLeft(node8);
		node5.setRight(node7);
		node7.setRight(node9);
		treeDiameter.getDiameter(root, diameter);
		System.out.println("result is " + diameter.value);
		
		
	}
}
