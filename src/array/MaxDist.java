package array; /**
 * 	- http://leetcode.com/2011/05/a-distance-maximizing-problem.html
 */

import java.util.Stack;

public class MaxDist {

	class element {
		int i;
		int n;
		public element(int i, int n) {
			this.i = i;
			this.n = n;
		}
		@Override
		public String toString() {
			return i + " " + n ;
		};
	}
	public int getDist(int[] arr) {
		int result = 0;
		int start = 0;
		int end = 0;
		Stack<element> stack = new Stack<element>();
		stack.push(new element(0, arr[0]));
		for (int i = 1;i < arr.length; ++i) {
			if (arr[i] < stack.peek().n) {
				stack.push(new element(i, arr[i]));
			}
		}
		System.out.println(stack);
		for (int i = arr.length-1;i >=0; --i) {
			if (arr[i] <= stack.peek().n) {
				continue;
			}
			while(!stack.empty() && stack.peek().n <arr[i] ) {
				if (result < (i-stack.peek().i)) {
					result = i-stack.peek().i;
					start = stack.peek().i;
					end = i;
				}
				stack.pop();
			}
			if (stack.empty()) {
				System.out.println(start + " " + end);
				return result;
			}
		}
		System.out.println(start + " " + end);
		return result;
	}
	
	public static void main(String[] args) {
		MaxDist maxDist = new MaxDist();
		int[] arr = {4, 3, 5, 2, 1, 3, 10, 3};
		System.out.println(maxDist.getDist(arr));
	}
}
