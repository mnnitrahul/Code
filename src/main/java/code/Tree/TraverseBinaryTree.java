package tree;

public class TraverseBinaryTree {
	public TraverseBinaryTree() {
		
	}
	public static void main(String[] args ) {
		BinaryTree one = new BinaryTree(1);
		BinaryTree two = new BinaryTree(2);
		BinaryTree three = new BinaryTree(3);
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(5);
		BinaryTree six = new BinaryTree(6);
		BinaryTree seven = new BinaryTree(7);
		BinaryTree eight = new BinaryTree(8);
		one.setLeft(three);
		one.setRight(two);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		six.setRight(eight);
		one.levelOrderTraverse();
	}
}
