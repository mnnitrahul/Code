package tree;

public class PrintNodeKDist {
	public PrintNodeKDist() {
		
	}
	public void printKDistDown(BinaryTree node, int k) {
		if (node == null) {
			return;
		}
		if (k == 0 ) {
			System.out.println(node.getData());
			return;
		}
		printKDistDown(node.getLeft(), k-1);
		printKDistDown(node.getRight(), k-1);
	}
	public int printKDist(BinaryTree root, BinaryTree node, int level) {
		if (root == null) {
			return -1;
		}
		if (root.equals(node)) {
			printKDistDown(node, level);
			return 1;
		}
		int ret = printKDist(root.getLeft(), node, level);
		if (ret != -1) {
			if (ret == level) {
				System.out.println(root.getData());
			} else {
				int k = level - ret-1;
				if (k > -1) {
					printKDistDown(root.getRight(), k);
				}
			}
			return ret+1;
		}
		ret = printKDist(root.getRight(), node, level);
		if (ret != -1) {
			if (ret ==level) {
				System.out.println(root.getData());
			} else {
				int k = level - ret - 1;
				if (k > -1) {
					printKDistDown(root.getLeft(), k);					
				}
			}
			return ret + 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		PrintNodeKDist printNodeKDist = new PrintNodeKDist();
		BinaryTree one = new BinaryTree(20);
		BinaryTree two = new BinaryTree(8);
		BinaryTree three = new BinaryTree(22);
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(12);
		BinaryTree six = new BinaryTree(10);
		BinaryTree seven = new BinaryTree(14);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		five.setLeft(six);
		five.setRight(seven);
		printNodeKDist.printKDist(one, one, 1);

	}
}
