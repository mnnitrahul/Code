package tree;


public class Distance2Nodes {
	public Distance2Nodes() {
	}
	public int findDistance(BinaryTree root, BinaryTree first, BinaryTree second) {
		WrapInt left = new WrapInt();
		WrapInt right = new WrapInt();
		WrapInt dist = new WrapInt();
		BinaryTree res = findDistance(root, first, second, 0, left, right, dist);
		if (res == first ) {
			dist.value = findLevel(first, second, 0);
		} else if (res == second) {
			dist.value = findLevel(second, first, 0);
		}
		return dist.value;
	}
	private int findLevel(BinaryTree start, BinaryTree end, int level) {
		if (start == null) {
			return -1;
		}
		if (start == end) {
			return level;
		}
		int l = findLevel(start.getLeft(), end, level+1);
		if (l > -1) {
			return l;
		}
		l = findLevel(start.getRight(), end, level+1);
		return l;
	}
	private BinaryTree findDistance(BinaryTree root, BinaryTree first, BinaryTree second, int index, WrapInt leftDist, WrapInt rightDist, WrapInt dist) {
		if (root == null) {
			return null;
		}
		if (root.equals(first)) {
			leftDist.value = index;
			return root;
		}
		if (root.equals(second)) {
			rightDist.value = index;
			return root;
		}
		BinaryTree left = findDistance(root.getLeft(), first, second, index+1, leftDist, rightDist, dist);
		BinaryTree right = findDistance(root.getRight(), first, second, index+1, leftDist, rightDist, dist);
		if (left!= null && right!= null) {
			dist.value =  leftDist.value + rightDist.value - (2*index);
			return root;
		}
		if (left!= null) {
			return left;
		}
		if (right!= null) {
			return right;
		}
		
		return null;
	}
	

	public static void main(String[] args) {
		Distance2Nodes distance2Nodes = new Distance2Nodes();
		BinaryTree one = new BinaryTree(1);
		BinaryTree two = new BinaryTree(2);
		BinaryTree three = new BinaryTree(3);
		BinaryTree four = new BinaryTree(4);
		BinaryTree five = new BinaryTree(5);
		BinaryTree six = new BinaryTree(6);
		BinaryTree seven = new BinaryTree(7);
		BinaryTree eight = new BinaryTree(8);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		six.setRight(eight);
		int result = distance2Nodes.findDistance(one, five, eight);
		System.out.println("distance is " + result);
	}
}
